package br.edu.unichristus.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import br.edu.unichristus.backend.data.dto.ProdutoDTO;
import br.edu.unichristus.backend.data.dto.ProdutoLowDTO;
import br.edu.unichristus.backend.data.model.Produto;
import br.edu.unichristus.backend.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
    private ProdutoService service;
	
	@Operation(summary = "Cadastrar produto | role: [ADMIN]", 
			tags = "Produto", description = "Possibilita "
					+ "cadastrar um produto a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Produto retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})

    @PostMapping
    public ProdutoLowDTO save(@RequestBody ProdutoDTO produto) {
        return service.save(produto);
    }

	@Operation(summary = "Visualizar todos produtos | role: [ADMIN]", 
			tags = "Produto", description = "Possibilita "
					+ "visualizar todos produtos a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Produtos retornados com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Falha na validação dos dados!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
    @GetMapping("/all")
    public List<ProdutoLowDTO> listAll() {
        return service.listAll();
    }

	@Operation(summary = "Buscar produto | role: [ADMIN]", 
			tags = "Produto", description = "Possibilita "
					+ "buscar um produto a "
					+ "partir do ID de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Produto retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Falha na validação dos dados!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
    @GetMapping
	public Produto findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
    
	@Operation(summary = "alterar produto | role: [ADMIN]", 
			tags = "Produto", description = "Possibilita "
					+ "alterar um produto a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Produto alterado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Falha na validação dos dados!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
    @PutMapping
	public ProdutoLowDTO update(@RequestBody ProdutoDTO produto) {
		return service.save(produto);
	}

	@Operation(summary = "Excluir produto | role: [ADMIN]", 
			tags = "Produto", description = "Possibilita "
					+ "excluir um produto a "
					+ "partir do ID de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Produto excluído com suceso"),
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
