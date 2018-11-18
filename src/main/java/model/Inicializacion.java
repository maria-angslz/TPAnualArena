package model;

import com.sun.jersey.api.client.ClientResponse;

import RequestService.RequestService;
import main.Decodificador;
import model.repositories.RepoEstudiantesLocal;

public class Inicializacion {
	
	public static void initialize() {
		
		//Obtener estudiante
		RequestService request = new RequestService();
		ClientResponse respuesta = request.obtenerEstudiante();
		String outputEstudiante = respuesta.getEntity(String.class);
		
		//Obtener Asignaciones
		respuesta = request.obtenerAsignaciones();
		String outputAsignaciones = respuesta.getEntity(String.class);
		
		//Decodificar de JSON a Estudiante
		Decodificador deco = new Decodificador();
		Estudiante estudiantito = deco.estudiante(outputEstudiante, outputAsignaciones);
		
		RepoEstudiantesLocal.getInstance().agregar(estudiantito);
	}

}
