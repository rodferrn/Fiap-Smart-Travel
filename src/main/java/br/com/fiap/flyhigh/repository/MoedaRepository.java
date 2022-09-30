package br.com.fiap.flyhigh.repository;

import br.com.fiap.flyhigh.model.Moeda;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoedaRepository extends JpaRepository<Moeda, Integer> {

    List<Moeda> findByNome(String prod);

    List<Moeda> findByBlockchain(boolean blockchain);

    List<Moeda> findByNomeAndBlockchain(String prod, boolean blockchain);

    List<Moeda> findByPrecoGreaterThan(double preco);
}
