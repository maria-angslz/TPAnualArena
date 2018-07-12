package model;

import java.util.ArrayList;
import java.util.List;

import model.repositories.Repositorios;

public class Fixture {
	
	public static void initialize() {
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
		
	}

}
