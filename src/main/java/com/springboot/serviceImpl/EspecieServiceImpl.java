package com.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.modelo.Especie;
import com.springboot.repository.EspecieRepository;
import com.springboot.service.EspecieService;

@Service
public class EspecieServiceImpl implements EspecieService {

	@Autowired
	private EspecieRepository especieRepository;
	
	@Override
	public List<Especie> listarTodo() {
		return (List<Especie>) especieRepository.findAll();
	}

	@Override
	public void guardar(Especie especie) {
		especieRepository.save(especie);
		
	}

	@Override
	public Optional<Especie> buscarId(Integer id) {
		return especieRepository.findById(id);
	}

	@Override
	public void borrar(int id) {
		especieRepository.deleteById(id);
		
	}

}
