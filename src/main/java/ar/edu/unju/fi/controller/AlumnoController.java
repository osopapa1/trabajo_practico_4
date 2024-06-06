package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista formAlumno
		ModelAndView modelView = new ModelAndView("formAlumno");
		//agrega el objeto
		modelView.addObject(new Alumno());
		return modelView;
	}
}
