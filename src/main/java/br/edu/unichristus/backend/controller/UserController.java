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

import br.edu.unichristus.backend.data.dto.UserDTO;
import br.edu.unichristus.backend.data.dto.UserLowDTO;
import br.edu.unichristus.backend.data.model.User;
import br.edu.unichristus.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Operation(summary = "Cadastrar usuário | role: [ADMIN]", 
			tags = "User", description = "Possibilita "
					+ "cadastrar um produto a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Usuário retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PostMapping
	public UserLowDTO save(@RequestBody UserDTO user) {
		return service.save(user);
	}
	
	@PutMapping
	public UserLowDTO update(@RequestBody UserDTO user) {
		return service.save(user);
	}
	
	@GetMapping("/all")
	public List<UserLowDTO> listAll(){
		return service.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@GetMapping
	public User findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	

}
