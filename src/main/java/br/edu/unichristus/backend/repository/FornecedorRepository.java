package br.edu.unichristus.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unichristus.backend.data.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
