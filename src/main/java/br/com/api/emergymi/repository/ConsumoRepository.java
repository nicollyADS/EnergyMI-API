package br.com.api.emergymi.repository;

import br.com.api.emergymi.model.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
}
