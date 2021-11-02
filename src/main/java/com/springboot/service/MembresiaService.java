package com.springboot.service;

import java.util.List;
import java.util.Optional;

import com.springboot.modelo.Membresia;

public interface MembresiaService {

	public List<Membresia>listarMembTodos();
	public void guardarMemb(Membresia membresia);
	public Optional<Membresia>buscarMembId(Integer id);
	public void borrarMemb(int id);
	public Membresia detalleBuscarPorId(Integer id);
	
}
