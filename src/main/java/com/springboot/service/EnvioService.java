package com.springboot.service;

import java.util.List;
import java.util.Optional;

import com.springboot.modelo.Envio;

public interface EnvioService {
	public List<Envio>listarTodo();
	public void guardar(Envio envio);
	public Optional<Envio>buscarId(Integer id);
	public void borrar(int id);

}
