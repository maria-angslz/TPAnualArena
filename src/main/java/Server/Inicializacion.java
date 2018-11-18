package Server;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.Estudiante;
import model.TipoCalificacion;
import model.AsignacionDeTarea;

public class Inicializacion {
	static String estudiante;
	static String asignaciones;
	
	public static void initialize() {
		//Creacion de asignaciones
		
		AsignacionDeTarea tareaConceptual = new AsignacionDeTarea("TareaClase", TipoCalificacion.CONCEPTUAL);
 		AsignacionDeTarea tareaNumerica = new AsignacionDeTarea("Parcial", TipoCalificacion.NUMERICA);
 		
 		List<AsignacionDeTarea> tareasLean = new ArrayList<AsignacionDeTarea>();
 		tareasLean.add(tareaConceptual);
 		tareasLean.add(tareaNumerica);
 		tareasLean.add(tareaConceptual);
 		
 		//aca paso estudiante sin lista de asignaciones
 		Estudiante unEstudiante = new Estudiante("Leandro Ventura", 2345, "lventura", new ArrayList<AsignacionDeTarea>());
		
		Gson gson = new Gson();
		estudiante = gson.toJson(unEstudiante);
		asignaciones = gson.toJson(tareasLean);
	}
	
	public static void setEstudiante(String unEstudiante) {
		estudiante = unEstudiante;
	}
}
