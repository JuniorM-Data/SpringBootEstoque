package br.edu.unichristus.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import br.edu.unichristus.backend.data.dto.ProdutoDTO;
import br.edu.unichristus.backend.data.dto.ProdutoLowDTO;
import br.edu.unichristus.backend.repository.ProdutoRepository;
import br.edu.unichristus.backend.data.model.Produto;
import br.edu.unichristus.backend.dozer.DozerConverter;
import br.edu.unichristus.backend.exception.CommonsException;

import java.util.List;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoLowDTO save(ProdutoDTO produtoDTO) {
    	var prodModel = DozerConverter.parseObject(produtoDTO, Produto.class);
		if(prodModel.getNome().length() > 100) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.user.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
        var prodSaved = produtoRepository.save(prodModel);
        
        var ProdutoLowDTO = DozerConverter.parseObject(prodSaved, ProdutoLowDTO.class);
        
        return ProdutoLowDTO;
    }

    public List<ProdutoLowDTO> listAll() {
    	var listProdutoDTO = produtoRepository.findAll();
		var listConverted = DozerConverter.parseListObjects(listProdutoDTO, ProdutoLowDTO.class);
		
		return listConverted;
    }

    public Produto findById(Long id) {
		var produto = produtoRepository.findById(id);
		if(produto.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.produto.notfound.exception",
					"O produto com o ID informado, não foi encontrado."
					);
		}
		return produto.get();
	}

    

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}

