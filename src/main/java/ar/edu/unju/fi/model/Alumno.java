package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Alumno {
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private LocalDate fechaDeNac;
	private String domicilio;
	private String LU;
	
	public Alumno() {
		super();
	}

	public Alumno(String dni, String nombre, String apellido, String email, String telefono, LocalDate fechaDeNac,
			String domicilio, String lU) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaDeNac = fechaDeNac;
		this.domicilio = domicilio;
		LU = lU;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaDeNac() {
		return fechaDeNac;
	}

	public void setFechaDeNac(LocalDate fechaDeNac) {
		this.fechaDeNac = fechaDeNac;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getLU() {
		return LU;
	}

	public void setLU(String lU) {
		LU = lU;
	}
}
