package ar.edu.unju.fi.model;

import ar.edu.unju.fi.constantes.Modalidad;

public class Materia {
	private String codigo;
	private String nombre;
	private String curso;
	private byte cantHoras;
	private Modalidad modalidad;
	private Docente docente;
	private Carrera carrera;
	
	public Materia() {
		super();
	}

	public Materia(String codigo, String nombre, String curso, byte cantHoras, Modalidad modalidad, Docente docente,
			Carrera carrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantHoras = cantHoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public byte getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(byte cantHoras) {
		this.cantHoras = cantHoras;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
}
