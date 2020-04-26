package br.edu.cesmac.nolapi.resources;

import java.net.URI;
import java.util.List;

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
import br.edu.cesmac.nolapi.repository.EditoriasRepository;

@RestController
@RequestMapping("/editorias")
public class EditoriasResources {

	@Autowired
	private EditoriasRepository editoriasRepository;

	@GetMapping
	public List<Editoria> listar() {
		return editoriasRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Editoria editoria) {
		editoriasRepository.save(editoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(editoria.getIdEditoria()).toUri();

		return ResponseEntity.created(uri).build();		
	}

	@PutMapping
	public void atualizar(@RequestBody Editoria editoria) {
		editoriasRepository.save(editoria);
	}

	@DeleteMapping
	public void deletar(@RequestBody Editoria editoria) {
		editoriasRepository.delete(editoria);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Editoria> buscarPorId(@PathVariable("id") Long idEditoria) {
		return editoriasRepository.findById(idEditoria).map(editoria -> ResponseEntity.ok(editoria)).orElse(ResponseEntity.notFound().build());
	}

}
		