package br.com.api.emergymi.repository;

import br.com.api.emergymi.model.Aparelho;
import br.com.api.emergymi.model.Instalacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstalacaoRepository extends JpaRepository<Instalacao, Long> {
}
