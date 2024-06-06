package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {

public static List<Docente> docentes = new ArrayList<Docente>();
	
	//Listar docentes
	public static List <Docente> ListarDocentes (){
		return docentes;
	}
	
	//Buscar un docente por su codigo
	public static Docente buscarDocentePorLegajo (String Legajo) {
		for(Docente d: docentes) {
			if (d.getLegajo().equals(Legajo)){
				return d;
			}
		}
		return null;
	}
	
	//Agregar un docente
	public static void AgregarDocente(Docente d) {
		docentes.add(d);
	}
	
	//Modificar un docente
	public static void ModificarUnDocente(Docente docenteModificado) {
		for(int i=0;i<docentes.size();i++) {
			Docente docente = docentes.get(i);
			if(docente.getLegajo().equals(docenteModificado.getLegajo())) {
				docentes.set(i, docenteModificado);
				break;
			}
		}
	}
	
	//Eliminar un Docente
	public static void EliminarDocente(String Legajo) {
		docentes.removeIf(docente -> docente.getLegajo().equals(Legajo));
	}
	
}
