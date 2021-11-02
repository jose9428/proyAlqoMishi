package com.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.modelo.Adoptante;
import com.springboot.repository.AdoptanteRepository;
import com.springboot.service.AdoptanteService;

@Service
public class AdoptanteServiceImpl implements AdoptanteService {

	@Autowired 
	private AdoptanteRepository adoptanteRepository;
	
	@Override
	public List<Adoptante> listarTodo() {
		return (List<Adoptante>) adoptanteRepository.findAll();
	}

	@Override
	public void guardarAdop(Adoptante adoptante) {
		adoptanteRepository.save(adoptante);
		
	}
	
	public Adoptante guardar(Adoptante adoptante) {
		return adoptanteRepository.save(adoptante);
		
	}

}
