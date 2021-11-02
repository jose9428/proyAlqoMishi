package com.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.modelo.Adopcion;
import com.springboot.repository.AdopcionRepository;
import com.springboot.service.AdopcionService;

@Service
public class AdopcionServiceImpl implements AdopcionService {

	@Autowired
	private AdopcionRepository adopcionRepository;

	@Override
	public List<Adopcion> listarTodo() {
		return (List<Adopcion>) adopcionRepository.findAll();
	}

	@Override
	public void guardar(Adopcion adopcion) {
		adopcionRepository.save(adopcion);
		
	}
	
	
}
