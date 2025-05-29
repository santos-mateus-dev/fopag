package br.com.servirdev.fopag.domain.funcionario;

import br.com.servirdev.fopag.domain.endereco.DadosEndereco;
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
