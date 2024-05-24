package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.dto.FornecedorDTO;
import br.edu.unichristus.backend.data.dto.FornecedorLowDTO;
import br.edu.unichristus.backend.data.model.Fornecedor;
import br.edu.unichristus.backend.dozer.DozerConverter;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.FornecedorRepository;

@Service
public class FornecedorService {
	@Autowired
    private FornecedorRepository repository;
	
	public FornecedorLowDTO save(FornecedorDTO fornecedorDTO) {
		var fornModel = DozerConverter.parseObject(fornecedorDTO, Fornecedor.class);
		if(fornModel.getNome().length() > 100) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.fornecedor.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}

		
		var fornSaved = repository.save(fornModel);
		
		var FornecedorLowDTO = DozerConverter.parseObject(fornSaved, FornecedorLowDTO.class);
		
		return FornecedorLowDTO;
	}
	
	public List<FornecedorLowDTO> listAll(){
		var listFornDTO = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listFornDTO, FornecedorLowDTO.class);
		
		return listConverted;
	}
	
	public Fornecedor findById(Long id) {
		var fornecedor = repository.findById(id);
		if(fornecedor.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.produto.notfound.exception",
					"O fornecedor com o ID informada, não foi encontrado."
					);
		}
		return fornecedor.get();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
