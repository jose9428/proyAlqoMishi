package com.springboot.controlador;


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

import com.springboot.modelo.Membresia;
import com.springboot.service.MembresiaService;

@Controller
public class MembresiaController {
	@Autowired
	private MembresiaService membresiaService;
	
	@GetMapping("/PlanMembresias")
	public String membresia() {
		return "membresia-plan";
	}
	
	@GetMapping("/listarMembresia")
	public String listarMembresia(Model modelo) {
		List<Membresia>lista=membresiaService.listarMembTodos();
		modelo.addAttribute("listadomembresia",lista);
		modelo.addAttribute("titulo", "Lista de Membresias");
		return "membresia-listar";
	}
	
	@GetMapping("/nuevoMembresia")
	public String nuevoMembresia(Model modelo) {
		modelo.addAttribute("membresia", new Membresia());
		modelo.addAttribute("titulo", "Agregar nuevo Plan de Membresia");
		return "membresia-agregar";
	}
	
	@PostMapping("/guardarMembresia")
	public String guardarMembresia(@ModelAttribute Membresia membresia, BindingResult result, Model modelo,
			@RequestParam(name="file", required = false) MultipartFile imgmemb,
			RedirectAttributes flash) {
		if(!imgmemb.isEmpty()) {
			Path directorioImg = Paths.get("src//main//resources//static/Catalogo");
			String rutaAbsolutaM = directorioImg.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imgmemb.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsolutaM + "//" + imgmemb.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				
				membresia.setImgmemb(imgmemb.getOriginalFilename());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		membresiaService.guardarMemb(membresia);
		return "redirect:/listarMembresia";
	}
	
	@GetMapping("/mostrarMembresia")
	public String mostrarMembresia(Model modelo) {
		List<Membresia>lista=membresiaService.listarMembTodos();
		
		modelo.addAttribute("titulo", "Membresías");
		modelo.addAttribute("membresia",lista);
		return "membresia-plan";
	}
	
	@GetMapping("/editarMembresia/{id}")
	public String editarMembresia(@PathVariable int id, Model modelo) {
		
		Optional<Membresia>lista = membresiaService.buscarMembId(id);
		modelo.addAttribute("titulo", "Editar Membresia");
		modelo.addAttribute("membresia",lista);
		return "membresia-agregar";
	}
	
	@GetMapping("/borrarMembresia/{id}")
	public String borrarMembresia(@PathVariable int id) {
		membresiaService.borrarMemb(id);
		return "redirect:/listarMembresia";
	}

	

}
