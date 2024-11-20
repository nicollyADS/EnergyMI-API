package br.com.api.emergymi.dto.login;

import br.com.api.emergymi.model.Login;

public record DetalhesLoginDto(Long id, String email, String senha) {

    public DetalhesLoginDto(Login login) {
        this(login.getId(), login.getEmail(), login.getSenha());
    }
}