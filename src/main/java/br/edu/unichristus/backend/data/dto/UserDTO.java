package br.edu.unichristus.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	
	private Long id;
	
	private String produto;
	private String quantidade;
	private String fornecedor;
	private String descricao;
	
}
