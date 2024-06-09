package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {
	private String codigo;
	private String nombre;
	private byte cantDeAños;
	private Boolean estado;
	
	
	
	public Carrera() {
		super();
	}


	public Carrera(String codigo, String nombre, byte cantDeAños, Boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantDeAños = cantDeAños;
		this.estado = estado;
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


	public byte getCantDeAños() {
		return cantDeAños;
	}


	public void setCantDeAños(byte cantDeAños) {
		this.cantDeAños = cantDeAños;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
