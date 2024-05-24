package br.edu.unichristus.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
