package br.edu.unichristus.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.backend.data.dto.EstoqueDTO;
import br.edu.unichristus.backend.data.dto.EstoqueLowDTO;
import br.edu.unichristus.backend.data.model.Estoque;
import br.edu.unichristus.backend.service.EstoqueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueService service;
	
	@Operation(summary = "Cadastrar estoque | role: [ADMIN]", 
			tags = "Estoque", description = "Possibilita "
					+ "cadastrar um estoque a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Estoque retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	
	@PostMapping
	public EstoqueLowDTO save(@RequestBody EstoqueDTO estoque) {
		return service.save(estoque);
	}
	
	@Operation(summary = "Ver todos estoques | role: [ADMIN]", 
			tags = "Estoque", description = "Possibilita "
					+ "ver todos os estoque a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Estoque retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping("/all")
	public List<EstoqueLowDTO> listAll(){
		return service.listAll();
	}
	
	@Operation(summary = "Buscar estoque | role: [ADMIN]", 
			tags = "Estoque", description = "Possibilita "
					+ "buscar um estoque a "
					+ "partir do ID de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Estoque retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping
	public Estoque findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	@Operation(summary = "Editar estoque | role: [ADMIN]", 
			tags = "Estoque", description = "Possibilita "
					+ "editar um estoque a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Estoque atualizado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PutMapping
	public EstoqueLowDTO update(@RequestBody EstoqueDTO estoque) {
		return service.save(estoque);
	}
	
	@Operation(summary = "Excluir estoque | role: [ADMIN]", 
			tags = "Estoque", description = "Possibilita "
					+ "excluir um estoque a "
					+ "partir do ID de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Estoque excluído com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@DeleteMapping("/{id}")
		public void delete(@PathVariable("id") Long id) {
			service.delete(id);
		
	}
	
	
}
