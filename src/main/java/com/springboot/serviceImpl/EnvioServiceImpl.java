package com.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.modelo.Envio;
import com.springboot.repository.EnvioRepository;
import com.springboot.service.EnvioService;

@Service
public class EnvioServiceImpl implements EnvioService{

	@Autowired
	private EnvioRepository envioRepository;
	
	@Override
	public List<Envio> listarTodo() {
		return (List<Envio>) envioRepository.findAll();
	}

	@Override
	public void guardar(Envio envio) {
		envioRepository.save(envio);
		
	}

	@Override
	public Optional<Envio> buscarId(Integer id) {
		return envioRepository.findById(id);
	}

	@Override
	public void borrar(int id) {
		envioRepository.deleteById(id);
		
	}

}
