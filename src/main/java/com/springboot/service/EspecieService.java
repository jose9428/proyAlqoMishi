package com.springboot.service;

import java.util.List;
import java.util.Optional;

import com.springboot.modelo.Especie;

public interface EspecieService {
	public List<Especie>listarTodo();
	public void guardar(Especie especie);
	public Optional<Especie>buscarId(Integer id);
	public void borrar(int id);
	

}
