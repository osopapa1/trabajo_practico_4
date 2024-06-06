package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {
	public static List<Carrera> carreras = new ArrayList<Carrera>();
	
	//Listar carreras
	public static List <Carrera> ListarCarreras (){
		return carreras;
	}
	
	//Buscar una carrera por su codigo
	public static Carrera buscarCarreraPorCodigo (String Codigo) {
		for(Carrera c: carreras) {
			if (c.getCodigo().equals(Codigo)){
				return c;
			}
		}
		return null;
	}
	
	//Agregar una carrera
	public static void AgregarCarrera(Carrera c) {
		//Agregar estado
		c.setEstado(true);
		carreras.add(c);
	}
	
	//Modificar una carrera
	public static void ModificarUnaCarrera(Carrera carreraModificada) {
		for(int i=0;i<carreras.size();i++) {
			Carrera carrera = carreras.get(i);
			if(carrera.getCodigo().equals(carreraModificada.getCodigo())) {
				carreras.set(i, carreraModificada);
				break;
			}
		}
	}
	
	//Eliminar una carrera
	public static void EliminarCarrera(String Codigo) {
		carreras.removeIf(carrera -> carrera.getCodigo().equals(Codigo));
	}
	
	
}
