package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Materia;

public class ListadoMaterias {
public static List<Materia> materias = new ArrayList<Materia>();
	
	//Listar materias
	public static List <Materia> ListarMaterias (){
		return materias;
	}
	
	//Buscar una materia por su codigo
	public static Materia buscarMateriaaPorCodigo (String Codigo) {
		for(Materia m: materias) {
			if (m.getCodigo().equals(Codigo)){
				return m;
			}
		}
		return null;
	}
	
	//Agregar una materia
	public static void AgregarMateria(Materia m) {
		materias.add(m);
	}
	
	//Modificar una materia
	public static void ModificarUnaMateria(Materia materiaModificada) {
		for(int i=0;i<materias.size();i++) {
			Materia materia = materias.get(i);
			if(materia.getCodigo().equals(materiaModificada.getCodigo())) {
				materias.set(i, materiaModificada);
				break;
			}
		}
	}
	
	//Eliminar una materia
	public static void EliminarMateria(String Codigo) {
		materias.removeIf(materia -> materia.getCodigo().equals(Codigo));
	}
}
