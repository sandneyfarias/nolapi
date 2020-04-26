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

import br.edu.cesmac.nolapi.domain.Noticia;
import br.edu.cesmac.nolapi.repository.NoticiasRepository;

@RestController
@RequestMapping("/noticias")
public class NoticiasResource {

	@Autowired
	private NoticiasRepository noticiasRepository;

	@GetMapping
	public List<Noticia> listar() {
		return noticiasRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Noticia noticia) {
		noticiasRepository.save(noticia);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(noticia.getIdNoticia()).toUri();

		return ResponseEntity.created(uri).build();		
	}

	@PutMapping
	public void atualizar(@RequestBody Noticia noticia) {
		noticiasRepository.save(noticia);
	}

	@DeleteMapping
	public void deletar(@RequestBody Noticia noticia) {
		noticiasRepository.delete(noticia);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Noticia> buscarPorId(@PathVariable("id") Long idNoticia) {
		return noticiasRepository.findById(idNoticia).map(noticia -> ResponseEntity.ok(noticia)).orElse(ResponseEntity.notFound().build());
	}

}