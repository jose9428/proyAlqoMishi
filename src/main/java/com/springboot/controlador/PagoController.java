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

import com.springboot.modelo.Pago;
import com.springboot.service.PagoService;

@Controller
public class PagoController {
	@Autowired
	private PagoService pagoService;
	
	@GetMapping("/listarPago")
	public String listarPago(Model modelo) {
		List<Pago>lista=pagoService.listarTodo();
		modelo.addAttribute("listadopago",lista);
		modelo.addAttribute("titulo", "Lista de Metodos de Pago");
		return "metodoPago-listar";
	}
	
	@GetMapping("/nuevoPago")
	public String nuevoPago(Model modelo) {
		modelo.addAttribute("pago", new Pago());
		modelo.addAttribute("titulo","Agregar Nuevo Metodo de Pago");
		return "metodoPago-agregar";
	}
	
	@PostMapping("/guardarPago")
	public String guardarPago(@ModelAttribute Pago pago) {
		pagoService.guardar(pago);
		System.out.println("Metodo de Pago guardado con Exito!!");
		return "redirect:/listarPago";
		
	}
	@GetMapping("/editarPago/{id}")
	public String editarPago(@PathVariable int id, Model modelo) {
		Optional<Pago>lista =pagoService.buscarId(id);
		modelo.addAttribute("titulo", "Editar Metodo de Pago");
		modelo.addAttribute("pago",lista);
		return "metodoPago-agregar";
	}
	@GetMapping("/borrarPago/{id}")
	public String borrarPago(@PathVariable int id) {
		pagoService.borrar(id);
		return "redirect:/listarPago";
	}

}
