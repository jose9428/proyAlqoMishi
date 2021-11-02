package com.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.modelo.Membresia;
import com.springboot.repository.MembresiaRepository;
import com.springboot.service.MembresiaService;

@Service
public class MembresiaServiceImpl implements MembresiaService{
	@Autowired
	private MembresiaRepository membresiaRepository;

	@Override
	public List<Membresia> listarMembTodos() {
		return (List<Membresia>) membresiaRepository.findAll();
	}

	@Override
	public void guardarMemb(Membresia membresia) {
		membresiaRepository.save(membresia);
		
	}

	@Override
	public Optional<Membresia> buscarMembId(Integer id) {
		return membresiaRepository.findById(id);
	}

	@Override
	public void borrarMemb(int id) {
		membresiaRepository.deleteById(null);
		
	}

	@Override
	public Membresia detalleBuscarPorId(Integer id) {
		return membresiaRepository.findById(id).orElse(null);
	}

}
