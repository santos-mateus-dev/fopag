package br.com.servirdev.fopag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/folha")
public class PagamentoController {

    @Autowired
    private FolhaPagamento folhaService;

    @PostMapping
    public ResponseEntity FolhaPagamento gerarFolha(@RequestBody Fuincionario funcionario){
        return folhaService.gerarFolha(funcionario);
    }

}
