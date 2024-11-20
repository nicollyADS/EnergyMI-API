package br.com.api.emergymi.dto.aparelho;

import br.com.api.emergymi.model.Aparelho;

public record DetalhesAparelhoDto(
        Long id,
        String nome,
        String tipo,
        Integer watts) {

    public DetalhesAparelhoDto(Aparelho aparelho) {
        this(
                aparelho.getId(),
                aparelho.getNome(),
                aparelho.getTipo(),
                aparelho.getWatts()
        );
    }
}
