package main;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.AsignacionDeTarea;
import model.Calificacion;
import model.CalificacionConceptual;
import model.Estudiante;
import model.TipoCalificacion;

public class Decodificador {
	
	public Estudiante estudiante(String responseEstudiante, String responseAsignaciones) {
		JsonObject jsonObject = new JsonParser().parse(responseEstudiante).getAsJsonObject();
		
		String nombreYApellido = jsonObject.get("first_name").getAsString() + " " + jsonObject.get("last_name").getAsString(); 
		int legajo = jsonObject.get("code").getAsInt();
		String usuario = jsonObject.get("github_user").getAsString(); 
		
		return new Estudiante(nombreYApellido, legajo, usuario, this.asignaciones(responseAsignaciones));
	}
	
	public List<AsignacionDeTarea> asignaciones(String response) {
		
		JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
		JsonArray jsonArrayAsignaciones = jsonObject.getAsJsonArray("assignments");
		
		List<AsignacionDeTarea> tareas = new ArrayList<AsignacionDeTarea>();
		
		for (JsonElement asignacion : jsonArrayAsignaciones) {
		    JsonObject objetoJson = asignacion.getAsJsonObject();
		    String nombreTarea = objetoJson.get("title").getAsString();
		    List<Calificacion> calificaciones = this.obtenerListaCalificaciones(objetoJson.getAsJsonArray("grades"));
		    tareas.add( new AsignacionDeTarea(nombreTarea, calificaciones, TipoCalificacion.CONCEPTUAL) );
		}
		return tareas;
	}
	
	public List<Calificacion> obtenerListaCalificaciones(JsonArray grades){
		
        List<Calificacion> calificaciones = new ArrayList<Calificacion>();
        for (JsonElement grade : grades) {
        	calificaciones.add(new CalificacionConceptual(grade.getAsString()));
        }
        
        return calificaciones;
	}

}
