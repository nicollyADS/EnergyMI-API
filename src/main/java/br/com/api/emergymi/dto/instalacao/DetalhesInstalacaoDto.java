package br.com.api.emergymi.dto.instalacao;

import br.com.api.emergymi.model.Instalacao;

public record DetalhesInstalacaoDto(
        Long id,
        String estado,
        String cidade,
        String bairro,
        String rua,
        Integer endereco,
        String observacoes) {

    public DetalhesInstalacaoDto(Instalacao instalacao) {
        this(
                instalacao.getId(),
                instalacao.getEstado(),
                instalacao.getCidade(),
                instalacao.getBairro(),
                instalacao.getRua(),
                instalacao.getEndereco(),
                instalacao.getObservacoes()
        );
    }
}
