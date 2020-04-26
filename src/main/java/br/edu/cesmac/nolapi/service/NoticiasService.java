package br.edu.cesmac.nolapi.service;

import br.edu.cesmac.nolapi.domain.Noticia;
import br.edu.cesmac.nolapi.repository.NoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiasService {

	@Autowired
	private NoticiasRepository noticiasRespository;

	public Noticia salvar(Noticia noticia) {
		Noticia noticiaCriada = noticiasRespository.save(noticia);
		return noticiaCriada;
	}

	public Noticia atualizar(Noticia noticia) {
		Noticia noticiaAtualizada = noticiasRespository.save(noticia);
		return noticiaAtualizada;
	}

	public void deletarPorId(Long id) throws Exception {
		Noticia noticiaExclusao = noticiasRespository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));

		noticiasRespository.deleteById(id);
	}

	public Noticia buscarPorId(Long id) throws Exception {
		return noticiasRespository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Noticia> listar() {
		return noticiasRespository.findAll();
	}

}
