package com.dev.backend.controller;

import com.dev.backend.entities.Categoria;
import com.dev.backend.entities.Produto;
import com.dev.backend.entities.ProdutoImagens;
import com.dev.backend.service.ProdutoImagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/produtoImagens")
public class ProdutoImagensController {

    @Autowired
    private ProdutoImagensService produtoImagensService;

    @GetMapping("/")
    public List<ProdutoImagens> buscarTodos(){
        return produtoImagensService.buscarTodos();
    }

    @PostMapping("/")
    public ProdutoImagens inserir(@RequestParam("file") MultipartFile file, @RequestParam("idProduto") Long idProduto){
       //RequestParam é utilizado para pegar uma parâmetro de query da url
        return produtoImagensService.inserir(idProduto, file);
    }

    @PutMapping("/")
    public ProdutoImagens atualizar(@RequestBody ProdutoImagens produtoImagens){
        return produtoImagensService.atualizar(produtoImagens);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") long id){
        produtoImagensService.deletar(id);
    }
}
