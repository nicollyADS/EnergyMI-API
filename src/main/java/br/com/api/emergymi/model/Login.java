package br.com.api.emergymi.model;

import br.com.api.emergymi.dto.login.AtualizacaoLoginDto;
import br.com.api.emergymi.dto.login.CadastroLoginDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="tb_emi_login")
@EntityListeners(AuditingEntityListener.class)
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login")
    @SequenceGenerator(name = "login", sequenceName = "seq_emi_login", allocationSize = 1)
    @Column(name="cdLogin", length = 9)
    private Long id;

    @Column(name="dsEmail", length = 70, nullable = false)
    private String email;

    @Column(name="dsSenha", length = 100, nullable = false)
    private String senha;


    public Login(CadastroLoginDto loginDto) {
        email = loginDto.email();
        senha = loginDto.senha();
    }

    public void atualizarInformacoesLogin(AtualizacaoLoginDto dto) {
        if (dto.email() != null)
            email = dto.email();
        if (dto.senha() != null)
            senha = dto.senha();
    }
}