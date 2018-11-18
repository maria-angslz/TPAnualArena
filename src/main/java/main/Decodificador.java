package main;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.AsignacionDeTarea;
import model.Estudiante;

public class Decodificador {
	Gson gson = new Gson();
	
	public Estudiante estudiante(String responseEstudiante, String responseAsignaciones) {
		
		Estudiante estudiante = gson.fromJson(responseEstudiante, Estudiante.class);		 
		
		List<AsignacionDeTarea> tareasLean = gson.fromJson(responseAsignaciones, new TypeToken<List<AsignacionDeTarea>>(){}.getType());
		
		return new Estudiante(estudiante.getNombreYApellido(), estudiante.getLegajo(), estudiante.getUsuarioGithub(), tareasLean);
	}
	
}
