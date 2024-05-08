package com.dev.backend.service;

import com.dev.backend.entities.Categoria;
import com.dev.backend.entities.Produto;
import com.dev.backend.entities.ProdutoImagens;
import com.dev.backend.repository.CategoriaRepository;
import com.dev.backend.repository.ProdutoImagensRepository;
import com.dev.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoImagensService {

    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> buscarTodos(){
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file){
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens objeto = new ProdutoImagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename(); //salvando img na pasta
                Path caminho = Paths
                        .get("c:/Imagens/" + nomeImagem );
                Files.write(caminho, bytes);
                objeto.setNome(nomeImagem);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        objeto.setProduto(produto);
        objeto.setDataCriacao(new Date());
        objeto = produtoImagensRepository.save(objeto); //salvando no bd as info da img

        return objeto;
    }

    public ProdutoImagens atualizar(ProdutoImagens produtoImagens){
        produtoImagens.setDataAtualizacao(new Date());
        return produtoImagensRepository.save(produtoImagens);
    }

    public void deletar(long id){
        ProdutoImagens prodImagens = produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(prodImagens);
    }
}
