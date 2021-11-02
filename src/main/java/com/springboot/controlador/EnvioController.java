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

import com.springboot.modelo.Envio;
import com.springboot.service.EnvioService;

@Controller
public class EnvioController {
	@Autowired
	private EnvioService envioService;
	
	@GetMapping("/listarEnvio")
	public String listarEnvio(Model modelo) {
		List<Envio>lista=envioService.listarTodo();
		modelo.addAttribute("listadoenvio",lista);
		modelo.addAttribute("titulo", "Lista de Metodos de Envio");
		return "metodoEnvio-listar";
	}
	
	@GetMapping("/nuevoEnvio")
	public String nuevoEnvio(Model modelo) {
		modelo.addAttribute("envio", new Envio());
		modelo.addAttribute("titulo","Agregar Nuevo Metodo de Envio");
		return "metodoEnvio-agregar";
	}
	
	@PostMapping("/guardarEnvio")
	public String guardarEnvio(@ModelAttribute Envio envio) {
		envioService.guardar(envio);
		System.out.println("Metodo de Envio guardado con Exito!!");
		return "redirect:/listarEnvio";
	}
	
	@GetMapping("/editarEnvio/{id}")
	public String editarEnvio(@PathVariable int id, Model modelo) {
		Optional<Envio>lista = envioService.buscarId(id);
		modelo.addAttribute("titulo", "Editar Metodo de Envio");
		modelo.addAttribute("envio", lista);
		return "metodoEnvio-agregar";
	}
	
	@GetMapping("/borrarEnvio/{id}")
	public String borrarPago(@PathVariable int id) {
		envioService.borrar(id);
		return "redirect:/listarEnvio";
	}

}
