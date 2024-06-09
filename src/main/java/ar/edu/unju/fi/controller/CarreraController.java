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
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;

@Controller
public class CarreraController {
	
	@Autowired
	Carrera nuevaCarrera = new Carrera();
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		//vista formCarrera
		ModelAndView modelView = new ModelAndView("formCarrera");
		//agrega el objeto
		modelView.addObject("nuevaCarrera", new Carrera());
		modelView.addObject("flag", false);
		return modelView;
	}
	
	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera (@ModelAttribute("nuevaCarrera") Carrera carreraAguardar) {
		
		//guardar
		ListadoCarreras.AgregarCarrera(carreraAguardar);
		
		//vista listaDeCarreras
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		
		modelView.addObject("listadoCarreras", ListadoCarreras.ListarCarreras());
		return modelView;

	}
	
	@GetMapping("/borrarCarrera/{codigo}")
	public ModelAndView borrarCarreraDeListado(@PathVariable(name="codigo") String codigo) {
		//borrar carrera
		ListadoCarreras.EliminarCarrera(codigo);
		
		//mostrar nueva lista
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.ListarCarreras());
		return modelView;
	}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView modificarCarrera(@PathVariable(name="codigo") String codigo) {
		//carrera a modificar
		Carrera carreraAmodificar = ListadoCarreras.buscarCarreraPorCodigo(codigo);
		
		//mostrar nueva lista
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", carreraAmodificar);
		modelView.addObject("flag", true);
		return modelView;
	}
	
	@PostMapping("/modificarCarrera")
	public ModelAndView actualizarCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraModificada) {
		
		//modificar la carrera
		ListadoCarreras.ModificarUnaCarrera(carreraModificada);
		
		//mostrar listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.ListarCarreras());	
		return modelView;		
	}
	
	@GetMapping("/carreras")
	public ModelAndView mostrarCarreras() {
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		//Mostrar listado
		modelView.addObject("listadoCarreras", ListadoCarreras.ListarCarreras());
		return modelView;
	}
	
}
