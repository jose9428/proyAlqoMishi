package com.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.modelo.Animal;
import com.springboot.repository.AnimalRepository;
import com.springboot.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalRepository animalRepository;
	
	@Override
	public List<Animal> listarTodo() {
		return (List<Animal>) animalRepository.findAll();
	}

	@Override
	public void guardar(Animal animal) {
		animalRepository.save(animal);
		
	}

	@Override
	public Optional<Animal> buscarId(Integer id) {
		return animalRepository.findById(id);
	}

	@Override
	public void borrar(int id) {
		animalRepository.deleteById(id);
		
	}

	@Override
	public Animal detalleBuscarPorId(Integer id) {
		return animalRepository.findById(id).orElse(null);
	}

	@Override
	public Optional<Animal> listarPorEspecie(int esp) {
		return animalRepository.listaProcedure(esp);
	}

	

	/*@Override
	public Optional<Animal> listarPorEspecie(int esp) {
		
	}*/
	


	

}
