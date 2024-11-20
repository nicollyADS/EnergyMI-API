package br.com.api.emergymi.dto.consumo;

import jakarta.persistence.Column;

public record AtualizacaoConsumoDto(
       String data,
       Integer numero,
       Integer custo,
       String observacoes
) {
}
