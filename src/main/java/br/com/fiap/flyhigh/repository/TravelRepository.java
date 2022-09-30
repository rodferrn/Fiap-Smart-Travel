package br.com.fiap.flyhigh.repository;

import br.com.fiap.flyhigh.model.Moeda;
import br.com.fiap.flyhigh.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Integer>  {

    List<Travel> findByUsuario (String user);

    List<Travel> findByOrigem (String orig);

    List<Travel> findByDestino (String dest);

    List<Travel> findByMoeda (Moeda moeda);

}
