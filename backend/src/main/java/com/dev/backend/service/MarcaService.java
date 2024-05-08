package com.dev.backend.service;

import com.dev.backend.entities.Marca;
import com.dev.backend.repository.EstadoRepository;
import com.dev.backend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarTodos(){
        return marcaRepository.findAll();
    }

    public Marca inserir(Marca marca){
        marca.setDataCriacao(new Date());
        Marca marcaNovo = marcaRepository.save(marca);
        return marcaNovo;
    }

    public Marca atualizar(Marca marca){
        marca.setDataAtualizacao(new Date());
        return marcaRepository.save(marca);
    }

    public void excluir(long id){
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }
}
