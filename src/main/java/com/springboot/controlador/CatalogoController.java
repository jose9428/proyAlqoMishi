package com.springboot.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.modelo.Animal;
import com.springboot.modelo.Especie;
import com.springboot.service.AnimalService;
import com.springboot.service.EspecieService;

@Controller
public class CatalogoController {
	@Autowired
	private AnimalService catalogoService;
	
	@Autowired
	private EspecieService especieService;
	
	
	@GetMapping("/CatalogoAnimal")
	public String listarAnimal(Model modelo) {
		List<Animal>lista=catalogoService.listarTodo();
		List<Especie>listaesp=especieService.listarTodo();
		//modelo.addAttribute("buscador", new Animal());
		modelo.addAttribute("especie",listaesp);
		modelo.addAttribute("catalogo", lista);
		modelo.addAttribute("titulo", "Catalogo de Animales");
		return "catalogo-listar";
	}
	
	@GetMapping("/filtrar/{esp}")
	public String filtrarAnimal(@PathVariable int esp, Model modelo) {
		Optional<Animal> lista = catalogoService.listarPorEspecie(esp);
		List<Especie>listaesp=especieService.listarTodo();
		modelo.addAttribute("catalogo", lista);
		modelo.addAttribute("especie",listaesp);
		modelo.addAttribute("titulo", "Filtrar animal por Especie: " );
		
		return "catalogo-buscar";		
	}
	
	
	/*@GetMapping("/buscar")
	public String buscarAnimal(@RequestParam String descripcion, @ModelAttribute("buscador") 
								Animal animal, Model modelo) {
		if(descripcion != null) {
			Animal ani = catalogoService.animalPorDescripcion(descripcion);
			modelo.addAttribute("ani",ani);
		}
		return "catalogo-buscar";
	}*/

}
