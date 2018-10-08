package model;

import com.sun.jersey.api.client.ClientResponse;

import RequestService.RequestService;
import main.Decodificador;
import model.repositories.Repositorios;

public class Inicializacion {
	
	public static void initialize() {
		//Obtencion Alumnos De Memoria
		/*
		CalificacionConceptual concepMB = new CalificacionConceptual("MB");
		CalificacionNumerica numSeis = new CalificacionNumerica(6);
		
		List<Calificacion> calificacionesConcep = new ArrayList<Calificacion>();
		calificacionesConcep.add(concepMB);
		
		List<Calificacion> calificacionesNum = new ArrayList<Calificacion>();
		calificacionesNum.add(numSeis);
		
		AsignacionDeTarea tareaMB = new AsignacionDeTarea("TareaClase",calificacionesConcep, TipoCalificacion.CONCEPTUAL);
		AsignacionDeTarea tareaSeis = new AsignacionDeTarea("Parcial",calificacionesNum, TipoCalificacion.NUMERICA);
		
		List<AsignacionDeTarea> tareasMaria = new ArrayList<AsignacionDeTarea>();
		tareasMaria.add(tareaMB);
		tareasMaria.add(tareaSeis);
		
		List<AsignacionDeTarea> tareasLean = new ArrayList<AsignacionDeTarea>();
		tareasLean.add(tareaSeis);
		tareasLean.add(tareaMB);
		tareasLean.add(tareaMB);
		
		Estudiante maria = new Estudiante("Maria Lopez", 1234, "malopez", tareasMaria);
		Estudiante lean = new Estudiante("Leandro Ventura", 2345, "lventura", tareasLean);
		
		Repositorios.estudiantes.agregar(maria);
		Repositorios.estudiantes.agregar(lean);
		*/
		
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
		
		Repositorios.estudiantes.agregar(estudiantito);
	}

}
