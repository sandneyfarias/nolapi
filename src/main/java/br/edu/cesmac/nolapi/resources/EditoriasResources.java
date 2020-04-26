package br.edu.cesmac.nolapi.resources;

import java.net.URI;
import java.util.List;

import br.edu.cesmac.nolapi.service.EditoriasService;
import org.springframework.beans.factory.annotation.Autowired;
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

import br.edu.cesmac.nolapi.domain.Editoria;

@RestController
@RequestMapping("/editorias")
public class EditoriasResources {

	@Autowired
	private EditoriasService editoriasService;

	@GetMapping
	public List<Editoria> listar() {
		return editoriasService.listar();
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Editoria editoria) {
		editoriasService.salvar(editoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(editoria.getIdEditoria()).toUri();

		return ResponseEntity.created(uri).build();		
	}

	@PutMapping
	public void atualizar(@RequestBody Editoria editoria) {
		editoriasService.atualizar(editoria);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idEditoria) throws Exception {
		editoriasService.deletarPorId(idEditoria);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Editoria> buscarPorId(@PathVariable("id") Long idEditoria) throws Exception {
		Editoria editoria = editoriasService.buscarPorId(idEditoria);
		return ResponseEntity.ok(editoria);
	}

}
