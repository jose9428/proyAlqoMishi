package com.springboot.service;

import java.util.List;
import java.util.Optional;

import com.springboot.modelo.Animal;

public interface AnimalService {
	
	public List<Animal>listarTodo();
	public void guardar(Animal animal);
	public Optional<Animal>buscarId(Integer id);
	public void borrar(int id);
	public Animal detalleBuscarPorId(Integer id);
	public Optional<Animal> listarPorEspecie(int esp);
	

}
