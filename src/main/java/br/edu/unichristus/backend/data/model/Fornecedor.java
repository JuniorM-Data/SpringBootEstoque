package br.edu.unichristus.backend.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fornecedor")
public class Fornecedor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, length = 100)
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    @Column(unique = true)
    private String CNPJ;
    
    public Fornecedor() {
    	
    }
    
    public Fornecedor(Long id, String nome, String endereco, String email, String telefone, String CNPJ) {
    	super();
    	this.id = id;
    	this.nome = nome;
    	this.endereco = endereco;
    	this.email = email;
    	this.telefone = telefone;
    	this.CNPJ = CNPJ;
    }
    
    
}
