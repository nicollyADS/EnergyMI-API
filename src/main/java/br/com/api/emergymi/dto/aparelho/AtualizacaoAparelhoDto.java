package br.com.api.emergymi.dto.aparelho;

public record AtualizacaoAparelhoDto(
        String nome,
        String tipo,
        Integer watts
) {
}
