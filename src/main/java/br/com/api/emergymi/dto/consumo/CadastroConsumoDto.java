package br.com.api.emergymi.dto.consumo;

public record CadastroConsumoDto(
        String data,
        Integer numero,
        Integer custo,
        String observacoes
) {
}
