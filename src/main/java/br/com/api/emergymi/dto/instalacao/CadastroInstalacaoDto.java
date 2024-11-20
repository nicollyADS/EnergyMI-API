package br.com.api.emergymi.dto.instalacao;

public record CadastroInstalacaoDto(
        String estado,
        String cidade,
        String bairro,
        String rua,
        Integer endereco,
        String observacoes
) {
}
