package Server;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import spark.Request;
import spark.Response;
import spark.Spark;

public class Controller {
	static Security securityService = new Security("god");
	
	public static String actualizarEstudiante(Request req, Response res) {
		autenticacion(req);
		
		JsonObject jsonObject = new JsonParser().parse(req.body()).getAsJsonObject();
		
		String nombre = jsonObject.get("first_name").getAsString(); 
		String apellido = jsonObject.get("last_name").getAsString();
		String legajo = jsonObject.get("code").getAsString();
		String usuario = jsonObject.get("github_user").getAsString(); 
		
		Inicializacion.estudiante.addProperty("first_name", nombre);
		Inicializacion.estudiante.addProperty("last_name", apellido);
		Inicializacion.estudiante.addProperty("code", legajo);
		Inicializacion.estudiante.addProperty("github_user", usuario);
		
		return "Estudiante modificado con exito!";
	}
	
	public static String datosEstudiante(Request req, Response res) {
		autenticacion(req);
		
		return Inicializacion.estudiante.toString();
	}
	
	public static String asignacionesEstudiante(Request req, Response res) {
		autenticacion(req);
		
		return Inicializacion.asignaciones.toString();
	}
	
	public static void autenticacion(Request req) {
		try {
			securityService.user(req.headers("Authorization").replace("Bearer ", ""));
		} catch (Exception e) {
			Spark.halt(401, "Error, estudiante no autenticado");
		}
	}

}
