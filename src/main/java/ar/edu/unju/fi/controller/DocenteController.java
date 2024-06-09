package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Controller
public class DocenteController {
	
	@Autowired
	Docente nuevoDocente = new Docente();
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista formDocente
		ModelAndView modelView = new ModelAndView("formDocente");
		//agrega el objeto
		modelView.addObject("nuevoDocente", new Docente());
		modelView.addObject("flag", false);
		return modelView;
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente (@ModelAttribute("nuevoDocente") Docente docenteAguardar) {
		
		//guardar
		ListadoDocentes.AgregarDocente(docenteAguardar);
		
		//vista listaDeDocentes
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		
		modelView.addObject("listadoDocentes", ListadoDocentes.ListarDocentes());
		return modelView;

	}
	
	@GetMapping("/borrarDocente/{legajo}")
	public ModelAndView borrarDocenteDeListado(@PathVariable(name="legajo") String legajo) {
		//borrar Docente
		ListadoDocentes.EliminarDocente(legajo);
		
		//mostrar nueva lista
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.ListarDocentes());
		return modelView;
	}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView modificarDocente(@PathVariable(name="legajo") String legajo) {
		//docente a modificar
		Docente docenteAmodificar = ListadoDocentes.buscarDocentePorLegajo(legajo);
		
		//mostrar nueva lista
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", docenteAmodificar);
		modelView.addObject("flag", true);
		return modelView;
	}
	
	@PostMapping("/modificarDocente")
	public ModelAndView actualizarDocente(@ModelAttribute("nuevoDocente") Docente docenteModificado) {
		
		//modificar el docente
		ListadoDocentes.ModificarUnDocente(docenteModificado);
		
		//mostrar listado
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.ListarDocentes());	
		return modelView;		
	}
	
	
	@GetMapping("/docentes")
	public ModelAndView mostrarDocentes() {
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		//Mostrar listado
		modelView.addObject("listadoDocentes", ListadoDocentes.ListarDocentes());
		return modelView;
	}
	
	
}
