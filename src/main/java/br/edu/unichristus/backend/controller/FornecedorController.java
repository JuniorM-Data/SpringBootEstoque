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

import br.edu.unichristus.backend.data.dto.FornecedorDTO;
import br.edu.unichristus.backend.data.dto.FornecedorLowDTO;
import br.edu.unichristus.backend.data.model.Fornecedor;
import br.edu.unichristus.backend.service.FornecedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {
	
	@Autowired
    private FornecedorService service;
	
	@Operation(summary = "Cadastrar fornecedor | role: [ADMIN]", 
			tags = "Fornecedor", description = "Possibilita "
					+ "cadastrar um fornecedor a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Fornecedor retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Falha na validação dos dados!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	
	@PostMapping
    public FornecedorLowDTO save(@RequestBody FornecedorDTO fornecedor) {
        return service.save(fornecedor);
    }
	
	@Operation(summary = "Visualizar todos fornecedores | role: [ADMIN]", 
			tags = "Fornecedor", description = "Possibilita "
					+ "visualizar todos fornecedores a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Fornecedores retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Falha na validação dos dados!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping("/all")
	public List<FornecedorLowDTO> listAll(){
		return service.listAll();
	}
	
	@Operation(summary = "Busar fornecedor | role: [ADMIN]", 
			tags = "Fornecedor", description = "Possibilita "
					+ "buscar um fornecedor a "
					+ "partir do ID de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Fornecedor retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Falha na validação dos dados!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping
	public Fornecedor findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	@Operation(summary = "Alterar fornecedor | role: [ADMIN]", 
			tags = "Fornecedor", description = "Possibilita "
					+ "alterar um fornecedor a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Fornecedor retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Falha na validação dos dados!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PutMapping
	public FornecedorLowDTO update(@RequestBody FornecedorDTO fornecedor) {
		return service.save(fornecedor);
	}
	
	@Operation(summary = "Excluir fornecedor | role: [ADMIN]", 
			tags = "Fornecedor", description = "Possibilita "
					+ "excluir um fornecedor a "
					+ "partir do ID de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Fornecedor excluído com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Falha na validação dos dados!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
}
