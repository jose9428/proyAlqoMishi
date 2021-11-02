package com.springboot.service;

import java.util.List;
import java.util.Optional;

import com.springboot.modelo.Pago;

public interface PagoService {
	public List<Pago>listarTodo();
	public void guardar(Pago pago);
	public Optional<Pago>buscarId(Integer id);
	public void borrar(int id);

}
