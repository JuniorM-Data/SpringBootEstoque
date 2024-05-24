package br.edu.unichristus.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

