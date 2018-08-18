package model;

import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Estudiante {
	public String nombreYApellido;
	public int legajo;
	public String usuarioGithub;
	public List<AsignacionDeTarea> asignacionesDeTareas;
	
	public Estudiante(String nombreYApellido, int legajo, String usuarioGithub, List<AsignacionDeTarea> asignacionesDeTareas) {
		this.nombreYApellido = nombreYApellido;
		this.legajo = legajo;
		this.usuarioGithub = usuarioGithub;
		this.asignacionesDeTareas = asignacionesDeTareas;
	}
	
	@Override
	public String toString() {
		return nombreYApellido;
	}
	
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getUsuarioGithub() {
		return usuarioGithub;
	}
	public void setUsuarioGithub(String usuarioGithub) {
		this.usuarioGithub = usuarioGithub;
	}
	public List<AsignacionDeTarea> getAsignacionesDeTareas() {
		return asignacionesDeTareas;
	}
	public void setAsignacionesDeTareas(List<AsignacionDeTarea> asignacionesDeTareas) {
		this.asignacionesDeTareas = asignacionesDeTareas;
	}

}
