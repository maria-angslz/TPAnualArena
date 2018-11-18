package Server;

import com.google.gson.Gson;

import model.Estudiante;
import spark.Request;
import spark.Response;
import spark.Spark;

public class Controller {
	static Security securityService = new Security("god");
	
	public static String actualizarEstudiante(Request req, Response res) {
		autenticacion(req);
		
		Gson gson = new Gson();
		Estudiante estudianteModificado = gson.fromJson(req.body(), Estudiante.class);
		
		Estudiante unEstudiante = gson.fromJson(Inicializacion.estudiante, Estudiante.class);	
		
		unEstudiante.setLegajo(estudianteModificado.getLegajo());
		unEstudiante.setNombreYApellido(estudianteModificado.getNombreYApellido());
		unEstudiante.setUsuarioGithub(estudianteModificado.getUsuarioGithub());
		
		Inicializacion.setEstudiante(req.body());
		
		return gson.toJson(unEstudiante);
	}
	
	public static String datosEstudiante(Request req, Response res) {
		autenticacion(req);
		
		return Inicializacion.estudiante;
	}
	
	public static String asignacionesEstudiante(Request req, Response res) {
		autenticacion(req);
		
		return Inicializacion.asignaciones;
	}
	
	public static void autenticacion(Request req) {
		try {
			securityService.user(req.headers("Authorization").replace("Bearer ", ""));
		} catch (Exception e) {
			Spark.halt(401, "Error, estudiante no autenticado");
		}
	}

}
