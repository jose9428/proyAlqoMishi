package com.springboot.service;

import java.util.List;

import com.springboot.modelo.Adoptante;

public interface AdoptanteService {
	public List<Adoptante>listarTodo();
	public void guardarAdop(Adoptante adoptante);
	public Adoptante guardar(Adoptante adoptante);
}
