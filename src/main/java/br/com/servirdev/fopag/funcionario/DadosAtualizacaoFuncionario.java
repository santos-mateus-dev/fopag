package br.com.servirdev.fopag.funcionario;

import br.com.servirdev.fopag.endereco.DadosEndereco;
import br.com.servirdev.fopag.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoFuncionario(
        @NotNull
        Long id,
        String nome,
        Cargo cargo,
        Integer salario,
        LocalDate admissao,
        DadosEndereco endereco) {
}
