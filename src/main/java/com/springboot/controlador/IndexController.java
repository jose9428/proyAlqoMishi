package com.springboot.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.modelo.*;
import com.springboot.service.*;

@Controller
public class IndexController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private EnvioService envioService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/nosotros")
    public String about() {
        return "nosotros";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    /*
	 * PROVISIONAL
	 * */
    @GetMapping("/registro")
    public String registroadop(Model modelo , @RequestParam("id") int id) {

        Optional<Animal> a = animalService.buscarId(id);
        List<Envio> metodo = envioService.listarTodo();
        if (a.isPresent()) {
            Adopcion obj = new Adopcion();
            obj.setAnimal(a.get());
            modelo.addAttribute("adopcion", obj);
            modelo.addAttribute("metodo", metodo);
            return "adopcion-registro";

        } else {
            return "redirect:/CatalogoAnimal";
        }
    }

    /*
	 @GetMapping("/registro/{id}")
	public String registroadop(@PathVariable("id") int id , Model modelo) {
		Optional<Animal> a = animalService.buscarId(id);
		if(a.isPresent()) {
			Adopcion obj = new Adopcion();
			obj.setAnimal(a.get());
			modelo.addAttribute("adopcion",obj);
			return "adopcion-registro";
			
		}else {
			return "redirect:/CatalogoAnimal";
		}
	}
     */
}
