package br.com.servirdev.fopag.domain.funcionario;

import br.com.servirdev.fopag.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosCadastroFuncionario(

        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotNull
        LocalDate dataNascimento,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String pis,

        @NotBlank
        @Email
        String email,

        @NotNull
        Cargo cargo,

        @NotNull
        Integer salario,

        @NotNull
        LocalDate admissao,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}
