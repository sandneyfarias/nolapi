package br.edu.cesmac.nolapi.repository;

import br.edu.cesmac.nolapi.domain.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Long> {

}
