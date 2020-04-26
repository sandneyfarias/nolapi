package br.edu.cesmac.nolapi.service;

import br.edu.cesmac.nolapi.domain.Jornalista;
import br.edu.cesmac.nolapi.repository.JornalistasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornalistasService {

	@Autowired
	private JornalistasRepository jornalistasRepository;

	public Jornalista salvar(Jornalista jornalista) {
		Jornalista jornalistaCriado = jornalistasRepository.save(jornalista);
		return jornalistaCriado;
	}

	public Jornalista atualizar(Jornalista jornalista) {
		Jornalista jornalistaAtualizado = jornalistasRepository.save(jornalista);
		return jornalistaAtualizado;
	}

	public void deletarPorId(Long id) throws Exception {
		Jornalista jornalistaExclusao = jornalistasRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));

		jornalistasRepository.deleteById(id);
	}

	public Jornalista buscarPorId(Long id) throws Exception {
		return jornalistasRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Jornalista> listar() {
		return jornalistasRepository.findAll();
	}

}
