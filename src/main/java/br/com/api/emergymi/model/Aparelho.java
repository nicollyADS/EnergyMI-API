package br.com.api.emergymi.model;

import br.com.api.emergymi.dto.aparelho.AtualizacaoAparelhoDto;
import br.com.api.emergymi.dto.aparelho.CadastroAparelhoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_emi_aparelho")
@EntityListeners(AuditingEntityListener.class)
public class Aparelho {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aparelho_seq")
    @SequenceGenerator(name = "aparelho_seq", sequenceName = "seq_emi_aparelho", allocationSize = 1)
    @Column(name = "id_aparelho", length = 9, nullable = false, updatable = false)
    private Long id;

    @Column(name = "nome_aparelho", length = 100, nullable = false)
    private String nome;

    @Column(name = "tipo_aparelho", length = 50, nullable = false)
    private String tipo;

    @Column(name = "watts_aparelho", nullable = false)
    private Integer watts;

    public Aparelho(CadastroAparelhoDto dto) {
        this.nome = dto.nome();
        this.tipo = dto.tipo();
        this.watts = dto.watts();
    }

    public void atualizarInformacoesAparelho(AtualizacaoAparelhoDto dto) {
        if (dto.nome() != null)
            this.nome = dto.nome();
        if (dto.tipo() != null)
            this.tipo = dto.tipo();
        if (dto.watts() != null)
            this.watts = dto.watts();
    }
}