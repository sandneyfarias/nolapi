package br.edu.cesmac.nolapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cesmac.nolapi.domain.Editoria;
import br.edu.cesmac.nolapi.repository.EditoriasRepository;

@Service
public class EditoriasService {

	@Autowired
	private EditoriasRepository editoriasRepository;

	public Editoria salvar(Editoria editoria) {
		Editoria editoriaCriada = editoriasRepository.save(editoria);
		return editoriaCriada;
	}

	public Editoria atualizar(Editoria editoria) {
		Editoria editoriaAtualizada = editoriasRepository.save(editoria);
		return editoriaAtualizada;
	}

	public void deletarPorId(Long id) throws Exception {
		Editoria editoriaExclusao = editoriasRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));

		editoriasRepository.deleteById(id);
	}

	public Editoria buscarPorId(Long id) throws Exception {
		return editoriasRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Editoria> listar() {
		return editoriasRepository.findAll();
	}

}
