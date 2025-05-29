package br.com.servirdev.fopag.domain.funcionario;

import java.time.LocalDate;

public record DadosListagemFuncionario(Long id, String nome, String cpf, Cargo cargo, LocalDate admissao) {
    public DadosListagemFuncionario(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getCargo(), funcionario.getAdmissao());
    }
}
