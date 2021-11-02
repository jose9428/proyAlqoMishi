package com.springboot.controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.modelo.Animal;
import com.springboot.modelo.Especie;
import com.springboot.service.AnimalService;
import com.springboot.service.EspecieService;

@Controller
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private EspecieService especieService;
	
	@GetMapping("/listarAnimal")
	public String listarAnimal(Model modelo) {
		List<Animal>lista=animalService.listarTodo();
		modelo.addAttribute("listadoanimal", lista);
		modelo.addAttribute("titulo", "Lista de Animales");
		return "animal-listar";
	}
	
	@GetMapping("/nuevoAnimal")
	public String nuevoAnimal(Model modelo) {
		modelo.addAttribute("animal", new Animal());
		List<Especie> listaEspecies  = especieService.listarTodo();
		
		modelo.addAttribute("titulo", "Agregar Nueva Publicación");
		modelo.addAttribute("especies",listaEspecies);
		
		return "animal-agregar";
	}
	
	@PostMapping("/guardarAnimal")
	public String guardarAnimal(@ModelAttribute Animal animal, BindingResult result, Model modelo,
			@RequestParam(name= "file", required = false) MultipartFile imagen,
			RedirectAttributes flash) {
		
		if(!imagen.isEmpty()) {
			// Para que las imagenes se muestren se tiene que dar Refresh a la carpeta catalogo
			
			Path directorioImagenes = Paths.get("src//main//resources//static/Catalogo");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				
				animal.setImagen(imagen.getOriginalFilename());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		animalService.guardar(animal);
		System.out.println("Publicación guardado con exito!");
		flash.addAttribute("success", "Foto subida!!");
		return "redirect:/listarAnimal";
	}
	
	@GetMapping("/detalleAnimal/{id}")
	public String detalleAnimal(@PathVariable int id, Model modelo) {
		Animal lista = null;
		lista = animalService.detalleBuscarPorId(id);
		List<Especie> listaEspecies  = especieService.listarTodo();
		
		modelo.addAttribute("titulo","Detalle del Animal: " + lista.getNombre());
		modelo.addAttribute("animal", lista);
		modelo.addAttribute("especies",listaEspecies);
		return "animal-detalle";
	}
	
	@GetMapping("/editarAnimal/{id}")
	public String editarAnimal(@PathVariable int id, Model modelo) {
		Optional<Animal>lista = animalService.buscarId(id);
		List<Especie> listaEspecies  = especieService.listarTodo();
		
		modelo.addAttribute("titulo","Editar Publicación");
		modelo.addAttribute("animal", lista);
		modelo.addAttribute("especies",listaEspecies);
		return "animal-agregar";
	}
	
	@GetMapping("/borrarAnimal/{id}")
	public String borrarAnimal(@PathVariable int id) {
		animalService.borrar(id);
		return "redirect:/listarAnimal";
	}
	
	
}
