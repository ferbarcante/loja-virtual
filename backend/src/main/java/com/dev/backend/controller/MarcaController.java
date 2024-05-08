package com.dev.backend.controller;

import com.dev.backend.entities.Marca;
import com.dev.backend.repository.MarcaRepository;
import com.dev.backend.service.MarcaService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> buscarTodos(){
        return marcaService.buscarTodos();
    }

    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca){
        return marcaService.inserir(marca);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca){
        return marcaService.atualizar(marca);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") long id){
        marcaService.excluir(id);
    }

}
