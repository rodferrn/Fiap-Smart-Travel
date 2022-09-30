package br.com.fiap.flyhigh.repository;

import br.com.fiap.flyhigh.model.Categoria;
import br.com.fiap.flyhigh.model.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    List<Categoria> findByNome(String cat);


}
