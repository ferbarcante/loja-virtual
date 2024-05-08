package com.dev.backend.controller;

import com.dev.backend.entities.Categoria;
import com.dev.backend.entities.Marca;
import com.dev.backend.service.CategoriaService;
import org.aspectj.weaver.bcel.BcelCflowStackFieldAdder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> buscarTodos(){
        return categoriaService.buscarTodos();
    }

    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria categoria){
        return categoriaService.inserir(categoria);
    }

    @PutMapping("/")
    public Categoria atualizar(@RequestBody Categoria categoria){
        return categoriaService.atualizar(categoria);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") long id){
        categoriaService.deletar(id);
    }
}
