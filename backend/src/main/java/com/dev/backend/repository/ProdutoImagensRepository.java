package com.dev.backend.repository;

import com.dev.backend.entities.Categoria;
import com.dev.backend.entities.ProdutoImagens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long> {
}
