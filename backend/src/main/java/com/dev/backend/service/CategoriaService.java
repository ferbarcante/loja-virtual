package com.dev.backend.service;

import com.dev.backend.entities.Categoria;
import com.dev.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria){
        categoria.setDataCriacao(new Date());
        Categoria catNovo = categoriaRepository.save(categoria);
        return catNovo;
    }

    public Categoria atualizar(Categoria categoria){
        categoria.setDataAtualizacao(new Date());
        return categoriaRepository.save(categoria);
    }

    public void deletar(long id){
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }
}
