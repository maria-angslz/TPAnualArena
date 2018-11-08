package Server;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Inicializacion {
	
	static JsonObject estudiante = new JsonObject();
	static JsonObject asignaciones = new JsonObject();
	
	public static void initialize() {
		generarAsignaciones();
		generarEstudiante();
	}
	
	public static void generarEstudiante() {
		estudiante.addProperty("code", 123456);
		estudiante.addProperty("first_name", "Leandro");
		estudiante.addProperty("last_name", "Ventura");
		estudiante.addProperty("github_user", "leandroventura");
	}
	
	public static void generarAsignaciones() {
		JsonArray grades = new JsonArray();
		
		JsonObject assignment1 = new JsonObject();
		assignment1.addProperty("id", 1);
		assignment1.addProperty("title", "Primer Parcial");
		assignment1.addProperty("Description", "Descripcion");
		assignment1.add("grades", grades);
		
		JsonArray assignments = new JsonArray();
		assignments.add(assignment1);
		assignments.add(assignment1);
		
		asignaciones.add("assignments", assignments);
	}

}
