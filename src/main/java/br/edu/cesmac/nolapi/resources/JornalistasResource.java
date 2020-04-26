package br.edu.cesmac.nolapi.resources;

import java.net.URI;
import java.util.List;

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

	private JornalistasRepository jornalistasRepository;

	public JornalistasResource(JornalistasRepository jornalistasRepository) {
		this.jornalistasRepository = jornalistasRepository;
	}

	@GetMapping
	public List<Jornalista> listar() {
		return jornalistasRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Jornalista jornalista) {
		jornalistasRepository.save(jornalista);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(jornalista.getIdJornalista()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public void alterar(@RequestBody Jornalista jornalista) {
		jornalistasRepository.save(jornalista);
	}

	@DeleteMapping
	public void deletar(@RequestBody Jornalista jornalista) {
		jornalistasRepository.delete(jornalista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Jornalista> buscarPorId(@PathVariable("id") Long idJornalista) {
		return jornalistasRepository.findById(idJornalista).map(jornalista -> ResponseEntity.ok(jornalista))
				.orElse(ResponseEntity.notFound().build());
	}

}
