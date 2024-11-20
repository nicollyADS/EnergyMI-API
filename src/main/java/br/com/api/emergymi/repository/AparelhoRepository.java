package br.com.api.emergymi.repository;

import br.com.api.emergymi.model.Aparelho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AparelhoRepository extends JpaRepository<Aparelho, Long> {
}
