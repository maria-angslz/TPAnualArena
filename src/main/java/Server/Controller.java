package Server;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Estudiante;
import model.repositories.Repositorios;
import spark.Request;
import spark.Response;
import spark.Spark;

public class Controller {
	static Security securityService = new Security("god");
	
	public static String actualizarEstudiante(Request req, Response res) {
		autenticacion(req);
		
		JsonObject jsonObject = new JsonParser().parse(req.body()).getAsJsonObject();
		
		String nombreYApellido = jsonObject.get("first_name").getAsString() + " " + jsonObject.get("last_name").getAsString(); 
		int legajo = jsonObject.get("code").getAsInt();
		String usuario = jsonObject.get("github_user").getAsString(); 
		
		Estudiante estudianteAModificar = Repositorios.estudiantes.get().get(0);
		estudianteAModificar.setLegajo(legajo);
		estudianteAModificar.setNombreYApellido(nombreYApellido);
		estudianteAModificar.setUsuarioGithub(usuario);
		return "Estudiante modificado con exito!";
	}
	
	public static String datosEstudiante(Request req, Response res) {
		autenticacion(req);
		
		JsonObject object = new JsonObject();
		object.addProperty("code", 123456);
		object.addProperty("first_name", "Leandro");
		object.addProperty("last_name", "Ventura");
		object.addProperty("github_user", "leandroventura");
		
		return object.toString();
	}
	
	public static String asignacionesEstudiante(Request req, Response res) {
		autenticacion(req);
		
		JsonArray grades = new JsonArray();
		
		JsonObject assignment1 = new JsonObject();
		assignment1.addProperty("id", 1);
		assignment1.addProperty("title", "Primer Parcial");
		assignment1.addProperty("Description", "Descripcion");
		assignment1.add("grades", grades);
		
		JsonArray assignments = new JsonArray();
		assignments.add(assignment1);
		assignments.add(assignment1);
		
		JsonObject asignaciones = new JsonObject();
		asignaciones.add("assignments", assignments);
		
		return asignaciones.toString();
	}
	
	public static void autenticacion(Request req) {
		try {
			securityService.user(req.headers("Authorization").replace("Bearer ", ""));
		} catch (Exception e) {
			Spark.halt(401, "Error, estudiante no autenticado");
		}
	}

}
