package br.edu.cesmac.nolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.cesmac.nolapi.domain.Noticia;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Long> {

}