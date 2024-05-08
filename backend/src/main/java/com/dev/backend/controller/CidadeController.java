package com.dev.backend.controller;

import com.dev.backend.entities.Cidade;
import com.dev.backend.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> buscarTodos(){
        return cidadeService.buscarTodos();
    }

    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade cidade){
        return cidadeService.inserir(cidade);
    }

    @PutMapping("/")
    public Cidade alterar(@RequestBody Cidade cidade){
        return cidadeService.alterar(cidade);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") long id){
        cidadeService.excluir(id);
    }

}
