package br.com.servirdev.fopag.funcionario;

import br.com.servirdev.fopag.endereco.DadosEndereco;
import br.com.servirdev.fopag.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "funcionarios")
@Entity(name = "Funcionario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String pis;
    private String email;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    private Integer salario;
    private LocalDate admissao;

    @Embedded
    private Endereco endereco;

    public Funcionario(DadosCadastroFuncionario dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
        this.pis = dados.pis();
        this.email = dados.email();
        this.cargo = dados.cargo();
        this.salario = dados.salario();
        this.admissao = dados.admissao();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoFuncionario dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }

        if (dados.cargo() != null){
            this.cargo = dados.cargo();
        }

        if (dados.salario() != null){
            this.salario = dados.salario();
        }

        if (dados.admissao() != null){
            this.admissao = dados.admissao();
        }

        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
}
