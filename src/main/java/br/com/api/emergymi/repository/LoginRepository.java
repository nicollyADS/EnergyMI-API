package br.com.api.emergymi.repository;

import br.com.api.emergymi.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
}
