package com.springboot.service;

import java.util.List;

import com.springboot.modelo.Adopcion;

public interface AdopcionService {

	public List<Adopcion>listarTodo();
	public void guardar(Adopcion adopcion);
}
