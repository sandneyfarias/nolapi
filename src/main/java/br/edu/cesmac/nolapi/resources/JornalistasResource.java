package br.edu.cesmac.nolapi.resources;

import java.net.URI;
import java.util.List;

import br.edu.cesmac.nolapi.service.JornalistasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.cesmac.nolapi.domain.Jornalista;
import br.edu.cesmac.nolapi.repository.JornalistasRepository;

@RestController
@RequestMapping("/jornalistas")
public class JornalistasResource {

	private JornalistasService jornalistasService;

	public JornalistasResource(JornalistasService jornalistasService) {
		this.jornalistasService = jornalistasService;
	}

	@GetMapping
	public List<Jornalista> listar() {
		return jornalistasService.listar();
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Jornalista jornalista) {
		jornalistasService.salvar(jornalista);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(jornalista.getIdJornalista()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public void alterar(@RequestBody Jornalista jornalista) {
		jornalistasService.atualizar(jornalista);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idJornalista) throws Exception {
		jornalistasService.deletarPorId(idJornalista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Jornalista> buscarPorId(@PathVariable("id") Long idJornalista) throws Exception {
		return ResponseEntity.ok(jornalistasService.buscarPorId(idJornalista));
	}

}
