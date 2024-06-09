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
import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {
	
	@Autowired
	Materia nuevaMateria = new Materia();
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
				//vista formMateria
				ModelAndView modelView = new ModelAndView("formMateria");
				//agrega el objeto
				modelView.addObject("nuevaMateria", new Materia());
				modelView.addObject("listadoDocentes", ListadoDocentes.ListarDocentes());
				modelView.addObject("listadoCarreras", ListadoCarreras.ListarCarreras());
				modelView.addObject("flag", false);
				return modelView;
	}
	
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria (@ModelAttribute("nuevaMateria") Materia materiaAguardar) {
		
		//guardar
		materiaAguardar.setDocente(ListadoDocentes.buscarDocentePorLegajo(materiaAguardar.getDocente().getLegajo()));
		materiaAguardar.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaAguardar.getCarrera().getCodigo()));
		ListadoMaterias.AgregarMateria(materiaAguardar);
		
		//vista listaDeMaterias
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		
		modelView.addObject("listadoMaterias", ListadoMaterias.ListarMaterias());
		return modelView;

	}
	
	
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView borrarMateriaDeListado(@PathVariable(name="codigo") String codigo) {
		//borrar materia
		ListadoMaterias.EliminarMateria(codigo);
		
		//mostrar nueva lista
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias", ListadoMaterias.ListarMaterias());
		return modelView;
	}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView modificarMateria(@PathVariable(name="codigo") String codigo) {
		//materia a modificar
		Materia materiaAmodificar = ListadoMaterias.buscarMateriaaPorCodigo(codigo);
		
		//mostrar nueva lista
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", materiaAmodificar);
		modelView.addObject("listadoDocentes", ListadoDocentes.ListarDocentes());
		modelView.addObject("listadoCarreras", ListadoCarreras.ListarCarreras());
		modelView.addObject("flag", true);

		return modelView;
	}
	
	@PostMapping("/modificarMateria")
	public ModelAndView actualizarMateria(@ModelAttribute("nuevaMateria") Materia materiaModificada) {
		
		//modificar el docente y la carrera
		materiaModificada.setDocente(ListadoDocentes.buscarDocentePorLegajo(materiaModificada.getDocente().getLegajo()));
		materiaModificada.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaModificada.getCarrera().getCodigo()));
		ListadoMaterias.ModificarUnaMateria(materiaModificada);
		
		//mostrar listado modificado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias", ListadoMaterias.ListarMaterias());	
		return modelView;		
	}
	
	
	@GetMapping("/materias")
	public ModelAndView mostrarMaterias() {
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		//Mostrar listado
		modelView.addObject("listadoMaterias", ListadoMaterias.ListarMaterias());
		return modelView;
	}
}
