package br.com.servirdev.fopag.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarInformacoes(DadosEndereco dados) {

        if (dados.cep() != null){
            this.cep = dados.cep();
        }

        if (dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }

        if (dados.numero() != null){
            this.numero = dados.numero();
        }

        if (dados.complemento() != null){
            this.complemento = dados.complemento();
        }

        if (dados.bairro() != null){
            this.bairro = dados.bairro();
        }

        if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }

        if (dados.uf() != null){
            this.uf = dados.uf();
        }

    }
}
