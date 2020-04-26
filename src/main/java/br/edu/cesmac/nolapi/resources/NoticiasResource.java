package br.edu.cesmac.nolapi.resources;

import br.edu.cesmac.nolapi.domain.Noticia;
import br.edu.cesmac.nolapi.service.NoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/noticias")
public class NoticiasResource {

	@Autowired
	private NoticiasService noticiasService;

	@GetMapping
	public List<Noticia> listar() {
		return noticiasService.listar();
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Noticia noticia) {
		noticiasService.salvar(noticia);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(noticia.getIdNoticia()).toUri();

		return ResponseEntity.created(uri).build();		
	}

	@PutMapping
	public void atualizar(@RequestBody Noticia noticia) {
		noticiasService.atualizar(noticia);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idNoticia) throws Exception {
		noticiasService.deletarPorId(idNoticia);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Noticia> buscarPorId(@PathVariable("id") Long idNoticia) throws Exception {
		return ResponseEntity.ok(noticiasService.buscarPorId(idNoticia));
	}

}
