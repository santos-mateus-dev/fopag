package br.com.servirdev.fopag.funcionario;

import br.com.servirdev.fopag.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFuncionario(
        @NotNull
        Long id,
        String nome,
        Cargo cargo,
        Integer salario,
        Endereco endereco) {
}
