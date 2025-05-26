package br.com.servirdev.fopag.controller;

import br.com.servirdev.fopag.funcionario.DadosCadastroFuncionario;
import br.com.servirdev.fopag.funcionario.DadosListagemFuncionario;
import br.com.servirdev.fopag.funcionario.Funcionario;
import br.com.servirdev.fopag.funcionario.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarFuncionario(@RequestBody @Valid DadosCadastroFuncionario dados){
        repository.save(new Funcionario(dados));
    }

    @GetMapping
    public Page<DadosListagemFuncionario> listarFuncionario(@PageableDefault(size=10, sort={"admissao"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemFuncionario::new);
    }
}
