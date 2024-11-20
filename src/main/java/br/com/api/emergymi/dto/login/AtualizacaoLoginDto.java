package br.com.api.emergymi.dto.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizacaoLoginDto(
        String email,
        String senha

) {

}