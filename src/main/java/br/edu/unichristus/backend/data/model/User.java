package br.edu.unichristus.backend.data.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String produto;
	private String quantidade;
	private String descricao;
	@Column(unique = true)
	private String fornecedor;
	
	
	public User() {
		
	}
	
	public User(Long id, String produto, String quantidade, String fornecedor, String descricao) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.fornecedor = fornecedor;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, produto, quantidade, fornecedor, descricao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(quantidade, other.quantidade) && Objects.equals(id, other.id) && Objects.equals(fornecedor, other.fornecedor)
				&& Objects.equals(produto, other.produto) && Objects.equals(descricao, other.descricao);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", produto=" + produto + ", fornecedor=" + fornecedor + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ "]";
	}
	
	
	
	

}
