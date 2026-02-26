package com.betacom.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.CategoriaDTOReq;
import com.betacom.dto.output.CategoriaDTORes;
import com.betacom.models.Categoria;
import com.betacom.repository.CategoriaRepository;
import com.betacom.services.interfaces.InterfaceCategoriaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@AllArgsConstructor
@Service
public class CategoriaServiceImpl implements InterfaceCategoriaService{
	
	
	private final CategoriaRepository categoriaRepo;
	
	
	@Override
	public List<CategoriaDTORes> list() throws Exception {
		log.debug("list");
		
		List<Categoria> categorie = categoriaRepo.findAll();
		
		return categorie.stream().map(
				(c) -> CategoriaDTORes.builder()
				.idCategoria(c.getIdCategoria())
				.categoria(c.getCategoria())
				.build()
				).collect(Collectors.toList());
	
	}

	@Override
	public void create(CategoriaDTOReq request) throws Exception {
		log.debug("create {}", request);
		
		Categoria categoria = new Categoria();
		try {
			categoria.setCategoria(request.getCategoria().toUpperCase().trim());
			categoriaRepo.save(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Freno non valido " + e.getMessage());
		}
		
	
		
	}

	@Override
	public void update(CategoriaDTOReq request) throws Exception {
		log.debug("update {}", request);
		
		Categoria categoria = categoriaRepo.findById(request.getIdCategoria()).orElseThrow(() -> new Exception("Categoria non presente in DB"));
		
		if(request.getCategoria() != null)
			categoria.setCategoria(request.getCategoria());
		
		categoriaRepo.save(categoria);
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		
		Categoria categoria = categoriaRepo.findById(id).orElseThrow(() -> new Exception("Categoria non presente in DB"));

		categoriaRepo.delete(categoria);
		
	}

}
