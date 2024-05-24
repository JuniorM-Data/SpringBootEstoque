package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.dto.EstoqueDTO;
import br.edu.unichristus.backend.data.dto.EstoqueLowDTO;
import br.edu.unichristus.backend.data.model.Estoque;
import br.edu.unichristus.backend.dozer.DozerConverter;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository repository;
	
	public EstoqueLowDTO save(EstoqueDTO estoqueDTO) {
    	var prodEstoq = DozerConverter.parseObject(estoqueDTO, Estoque.class);
		if(prodEstoq.getNome().length() > 60) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.user.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
        var estoqSaved = repository.save(prodEstoq);
        
        var EstoqueLowDTO = DozerConverter.parseObject(estoqSaved, EstoqueLowDTO.class);
        
        return EstoqueLowDTO;
    }
	
	public List<EstoqueLowDTO> listAll(){
		var listEstoqueDTO = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listEstoqueDTO, EstoqueLowDTO.class);
		
		return listConverted;
	}
	
	public Estoque findById(Long id) {
		var estoque = repository.findById(id);
		if(estoque.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.produto.notfound.exception",
					"O Estoque com o ID informado, não foi encontrado."
					);
		}
		return estoque.get();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
