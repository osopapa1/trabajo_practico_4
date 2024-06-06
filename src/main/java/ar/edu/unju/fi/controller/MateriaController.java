package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
				//vista formMateria
				ModelAndView modelView = new ModelAndView("formMateria");
				//agrega el objeto
				modelView.addObject(new Materia());
				return modelView;
	}
}
