package model;

import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class AsignacionDeTarea {
	private String nombreTarea;
	public TipoCalificacion tipoDeCalificacion;
	private String nota;
	public List<Calificacion> calificaciones;
	private String aprobada;

	public AsignacionDeTarea(String unNombreTarea, List<Calificacion> listaCalif, TipoCalificacion TipoCalif) {
		nombreTarea = unNombreTarea;
		tipoDeCalificacion = TipoCalif;
		calificaciones = listaCalif;
		nota = nota();
		aprobada = valorAprobacion();
	}
	
	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}
	
	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	void agregarCalificacion(Calificacion unaCalif) {
		if(!this.estaAprobada() && unaCalif.tipoCalificacion() == tipoDeCalificacion) {
			calificaciones.add(unaCalif); //agrega una calificacion, solo si no esta aprobada la asignacion, y la nota es del mismo tipo que admite la asignacion
			nota =  nota();
		}
	}
	
	public String getAprobada() {
		return aprobada;
	}

	public void setAprobada(String aprobada) {
		this.aprobada = aprobada;
	}
	
	String valorAprobacion() {
		if(this.estaAprobada()) {
			return "Aprobada";
		} else {
			return "Desaprobada";
		}
	}
	
	boolean estaAprobada() {
		return calificaciones.stream().anyMatch(unaCalif -> unaCalif.aprobada());
	}
	
	String nota() {
		return calificaciones.get(calificaciones.size() - 1).nota();
	}
}
