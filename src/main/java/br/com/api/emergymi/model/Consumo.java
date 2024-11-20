package br.com.api.emergymi.model;

import br.com.api.emergymi.dto.consumo.AtualizacaoConsumoDto;
import br.com.api.emergymi.dto.consumo.CadastroConsumoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_emi_consumo")
@EntityListeners(AuditingEntityListener.class)
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumo_seq")
    @SequenceGenerator(name = "consumo_seq", sequenceName = "seq_emi_consumo", allocationSize = 1)
    @Column(name = "id_consumo", length = 9, nullable = false, updatable = false)
    private Long id;

    @Column(name = "data_consumo", length = 10, nullable = false)
    private String data;

    @Column(name = "numero_consumo", nullable = false)
    private Integer numero;

    @Column(name = "custo_consumo", nullable = false)
    private Integer custo;

    @Column(name = "observacoes_consumo", length = 500)
    private String observacoes;

    public Consumo(CadastroConsumoDto dto) {
        this.data = dto.data();
        this.numero = dto.numero();
        this.custo = dto.custo();
        this.observacoes = dto.observacoes();
    }

    public void atualizarInformacoesConsumo(AtualizacaoConsumoDto dto) {
        if (dto.data() != null)
            this.data = dto.data();
        if (dto.numero() != null)
            this.numero = dto.numero();
        if (dto.custo() != null)
            this.custo = dto.custo();
        if (dto.observacoes() != null)
            this.observacoes = dto.observacoes();
    }
}