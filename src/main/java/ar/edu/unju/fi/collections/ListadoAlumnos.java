package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumnos {
public static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	//Listar alumnos
	public static List <Alumno> ListarAlumnos (){
		return alumnos;
	}
	
	//Buscar un alumno por su dni
	public static Alumno buscarAlumnoPorDni (String Dni) {
		for(Alumno a: alumnos) {
			if (a.getDni().equals(Dni)){
				return a;
			}
		}
		return null;
	}
	
	//Agregar un alumno
	public static void AgregarAlumno(Alumno a) {
		alumnos.add(a);
	}
	
	//Modificar un alumno
	public static void ModificarUnAlumno(Alumno alumnoModificado) {
		for(int i=0;i<alumnos.size();i++) {
			Alumno alumno = alumnos.get(i);
			if(alumno.getDni().equals(alumnoModificado.getDni())) {
				alumnos.set(i, alumnoModificado);
				break;
			}
		}
	}
	
	//Eliminar un alumno
	public static void EliminarAlumno(String Dni) {
		alumnos.removeIf(alumno -> alumno.getDni().equals(Dni));
	}
}
