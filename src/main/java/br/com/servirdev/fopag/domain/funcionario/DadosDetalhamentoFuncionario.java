package br.com.servirdev.fopag.domain.funcionario;

import br.com.servirdev.fopag.domain.endereco.Endereco;

import java.time.LocalDate;

public record DadosDetalhamentoFuncionario(Long id, String nome, String cpf, LocalDate dataNascimento, String pis, String email, Cargo cargo, Integer salario, LocalDate admissao, Endereco endereco ) {

    public DadosDetalhamentoFuncionario(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getDataNascimento(), funcionario.getPis(), funcionario.getEmail(), funcionario.getCargo(), funcionario.getSalario(), funcionario.getAdmissao(), funcionario.getEndereco());
    }
}
