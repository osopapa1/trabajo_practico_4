package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;

@Controller
public class AlumnoController {
	
	@Autowired
	Alumno nuevoAlumno = new Alumno();
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista formAlumno
		ModelAndView modelView = new ModelAndView("formAlumno");
		//agrega el objeto
		modelView.addObject("nuevoAlumno", new Alumno());
		modelView.addObject("flag", false);
		return modelView;
	}
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno (@ModelAttribute("nuevoAlumno") Alumno alumnoAguardar) {
		
		//guardar
		ListadoAlumnos.AgregarAlumno(alumnoAguardar);
		
		//vista listaDeAlumnos
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		
		modelView.addObject("listadoAlumnos", ListadoAlumnos.ListarAlumnos());
		return modelView;

	}
	
	@GetMapping("/borrarAlumno/{dni}")
	public ModelAndView borrarAlumnoDeListado(@PathVariable(name="dni") String dni) {
		//borrar alumno
		ListadoAlumnos.EliminarAlumno(dni);
		
		//mostrar nueva lista
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.ListarAlumnos());
		return modelView;
	}
	
	@GetMapping("/modificarAlumno/{dni}")
	public ModelAndView modificarAlumno(@PathVariable(name="dni") String dni) {
		//alumno a modificar
		Alumno alumnoAmodificar = ListadoAlumnos.buscarAlumnoPorDni(dni);
		
		//mostrar nueva lista
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", alumnoAmodificar);
		modelView.addObject("flag", true);
		return modelView;
	}
	
	@PostMapping("/modificarAlumno")
	public ModelAndView actualizarAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoModificado) {
		
		//modificar el alumno
		ListadoAlumnos.ModificarUnAlumno(alumnoModificado);
		
		//mostrar listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.ListarAlumnos());	
		return modelView;		
	}
	
	@GetMapping("/alumnos")
	public ModelAndView mostrarAlumnos() {
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		//Mostrar listado
		modelView.addObject("listadoAlumnos", ListadoAlumnos.ListarAlumnos());
		return modelView;
	}
}
