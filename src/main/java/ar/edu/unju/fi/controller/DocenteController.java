package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista formDocente
		ModelAndView modelView = new ModelAndView("formDocente");
		//agrega el objeto
		modelView.addObject(new Docente());
		return modelView;
	}
}
