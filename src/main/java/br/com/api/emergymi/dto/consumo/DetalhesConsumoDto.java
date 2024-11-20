package br.com.api.emergymi.dto.consumo;

import br.com.api.emergymi.model.Consumo;

public record DetalhesConsumoDto(
        Long id,
        String data,
        Integer numero,
        Integer custo,
        String observacoes) {

    public DetalhesConsumoDto(Consumo consumo) {
        this(
                consumo.getId(),
                consumo.getData(),
                consumo.getNumero(),
                consumo.getCusto(),
                consumo.getObservacoes()
        );
    }
}
