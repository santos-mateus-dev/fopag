package br.com.servirdev.fopag.controller;

import br.com.servirdev.fopag.funcionario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarFuncionario(@RequestBody @Valid DadosCadastroFuncionario dados, UriComponentsBuilder uriBuilder){
        var funcionario = new Funcionario(dados);
        repository.save(funcionario);

        var uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoFuncionario(funcionario));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemFuncionario>> listarFuncionario(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemFuncionario::new);
        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarFuncionario(@RequestBody @Valid DadosAtualizacaoFuncionario dados){
        var funcionario = repository.getReferenceById(dados.id());
        funcionario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativarFuncionario(@PathVariable Long id){
        var funcionario = repository.getReferenceById(id);
        funcionario.inativar();

        return ResponseEntity.noContent().build();
    }
}
