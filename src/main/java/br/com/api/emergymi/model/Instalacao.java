package br.com.api.emergymi.model;

import br.com.api.emergymi.dto.instalacao.AtualizacaoInstalacaoDto;
import br.com.api.emergymi.dto.instalacao.CadastroInstalacaoDto;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_emi_instalacao")
@EntityListeners(AuditingEntityListener.class)
public class Instalacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instalacao_seq")
    @SequenceGenerator(name = "instalacao_seq", sequenceName = "seq_emi_instalacao", allocationSize = 1)
    @Column(name = "id_instalacao", length = 9, nullable = false, updatable = false)
    private Long id;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "cidade", length = 100, nullable = false)
    private String cidade;

    @Column(name = "bairro", length = 100, nullable = false)
    private String bairro;

    @Column(name = "rua", length = 200, nullable = false)
    private String rua;

    @Column(name = "endereco_numero", nullable = false)
    private Integer endereco;

    @Column(name = "observacoes", length = 500)
    private String observacoes;

    public Instalacao(CadastroInstalacaoDto dto) {
        this.estado = dto.estado();
        this.cidade = dto.cidade();
        this.bairro = dto.bairro();
        this.rua = dto.rua();
        this.endereco = dto.endereco();
        this.observacoes = dto.observacoes();
    }

    public void atualizarInformacoesInstalacao(AtualizacaoInstalacaoDto dto) {
        if (dto.estado() != null)
            this.estado = dto.estado();
        if (dto.cidade() != null)
            this.cidade = dto.cidade();
        if (dto.bairro() != null)
            this.bairro = dto.bairro();
        if (dto.rua() != null)
            this.rua = dto.rua();
        if (dto.endereco() != null)
            this.endereco = dto.endereco();
        if (dto.observacoes() != null)
            this.observacoes = dto.observacoes();
    }
}
