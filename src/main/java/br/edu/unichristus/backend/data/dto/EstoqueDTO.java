package br.edu.unichristus.backend.data.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstoqueDTO {

	private Long id;
	private String nome;
	private String endereco;
	private String categoria;
	private String CNPJ;
}
