package com.springboot.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.modelo.Adopcion;
import com.springboot.modelo.Adoptante;
import com.springboot.modelo.Animal;
import com.springboot.modelo.Envio;
import com.springboot.service.AdopcionService;
import com.springboot.service.AdoptanteService;
import com.springboot.service.AnimalService;
import com.springboot.service.EnvioService;

@Controller
public class AdopcionController {

    @Autowired
    private AdopcionService adopcionService;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AdoptanteService adoptanteService;

    @Autowired
    private EnvioService envioService;

    @GetMapping("/listarAdopcion")
    public String listarAdoptante(Model modelo) {
        List<Adopcion> lista = adopcionService.listarTodo();
        modelo.addAttribute("listadoadopcion", lista);
        modelo.addAttribute("titulo", "Lista de Adoptantes");
        return "adopcion-listar";
    }

    @GetMapping("/nuevoAdopcion")
    public String nuevoadopcion(Model modelo) {
        modelo.addAttribute("adopcion", new Adopcion());
        modelo.addAttribute("adoptante", new Adoptante());
        List<Envio> listaEnvios = envioService.listarTodo();
        List<Animal> listaAnimal = animalService.listarTodo();
        modelo.addAttribute("envios", listaEnvios);
        modelo.addAttribute("animal", listaAnimal);
        return "adopcion-registro";

    }

    @PostMapping("/guardarAdopcion")
    public String guardaradopcion(Adopcion adopcion) {
    	System.out.println(adopcion.toString());
    	Adoptante adoptante = adoptanteService.guardar(adopcion.getAdoptante());
    	Optional<Animal> animal = animalService.buscarId(adopcion.getAnimal().getIdanimal());
    	
    	adopcion.setAdoptante(adoptante);
    	adopcion.setAnimal(animal.get());

        adopcionService.guardar(adopcion);

        return "redirect:/listarAdopcion";
    }

}
