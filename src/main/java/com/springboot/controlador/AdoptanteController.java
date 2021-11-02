package com.springboot.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.modelo.Adoptante;
import com.springboot.service.AdoptanteService;

@Controller
public class AdoptanteController {
	@Autowired
	private AdoptanteService adoptanteService;
	
	@GetMapping("/listarAdoptante")
	public String listarAdoptante(Model modelo) {
		List<Adoptante>lista=adoptanteService.listarTodo();
		modelo.addAttribute("listadoadoptante",lista);
		modelo.addAttribute("titulo","Lista de Adoptantes");
		return "adoptante-listar";
	}

}
