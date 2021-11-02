package com.springboot.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.modelo.Especie;
import com.springboot.service.EspecieService;

@Controller
public class EspecieController {
	@Autowired 
	private EspecieService especieService;
	
	@GetMapping("/listarEspecie")
	public String listarEspecie(Model modelo) {
		List<Especie>lista=especieService.listarTodo();
		modelo.addAttribute("listadoespecie",lista);
		modelo.addAttribute("titulo", "Lista de Especies de Animales");
		return "especie-listar";
	}
	
	@GetMapping("/nuevoEspecie")
	public String nuevoEspecie(Model modelo) {
		modelo.addAttribute("especie", new Especie());
		modelo.addAttribute("titulo", "Agregar Nueva Especie");
		return "especie-agregar";
	}
	
	@PostMapping("/guardarEspecie")
	public String guardarEspecie(@ModelAttribute Especie especie) {
		especieService.guardar(especie);
		System.out.println("Especie guardado con Exito!");
		return "redirect:/listarEspecie";
	}
	
	@GetMapping("/editarEspecie/{id}")
	public String editarEspecie(@PathVariable int id, Model modelo) {
		Optional<Especie>lista = especieService.buscarId(id);
		modelo.addAttribute("titulo", "Editar Especie Animal");
		modelo.addAttribute("especie",lista);
		return "especie-agregar";
	}
	
	@GetMapping("/borrarEspecie/{id}")
	public String borrarEspecie(@PathVariable int id) {
		especieService.borrar(id);
		return "redirect:/listarEspecie";
	}
	

}
