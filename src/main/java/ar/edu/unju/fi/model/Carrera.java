package ar.edu.unju.fi.model;

public class Carrera {
	private String codigo;
	private String nombre;
	private byte cantDeAños;
	private String estado;
	
	public Carrera(String codigo, String nombre, byte cantDeAños, String estado) {
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


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}