package com.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.modelo.Pago;
import com.springboot.repository.PagoRepository;
import com.springboot.service.PagoService;

@Service
public class PagoServiceImpl implements PagoService {
	
	@Autowired
	private PagoRepository pagoRepository;

	@Override
	public List<Pago> listarTodo() {
		return (List<Pago>) pagoRepository.findAll();
	}

	@Override
	public void guardar(Pago pago) {
		pagoRepository.save(pago);
	}

	@Override
	public Optional<Pago> buscarId(Integer id) {
		return pagoRepository.findById(id);
	}

	@Override
	public void borrar(int id) {
		pagoRepository.deleteById(id);
		
	}

}
