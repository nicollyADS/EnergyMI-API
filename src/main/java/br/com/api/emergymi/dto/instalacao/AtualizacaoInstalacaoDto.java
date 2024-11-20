package br.com.api.emergymi.dto.instalacao;

import jakarta.persistence.Column;

public record AtualizacaoInstalacaoDto(
        String estado,
        String cidade,
        String bairro,
        String rua,
        Integer endereco,
        String observacoes
) {
}
