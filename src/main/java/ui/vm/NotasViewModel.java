package ui.vm;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.AsignacionDeTarea;
import model.Estudiante;
import model.repositories.Repositorios;

@Observable
public class NotasViewModel {
	private List<Estudiante> estudiantes;
	private Estudiante estudianteSeleccionado;
	private List<AsignacionDeTarea> asignacionesDeTareas = new ArrayList<AsignacionDeTarea>();
	private AsignacionDeTarea asignacionSeleccionada;

	public NotasViewModel() {
		estudiantes = Repositorios.estudiantes.get();
	}

	public Estudiante getestudianteSeleccionado() {
		return estudianteSeleccionado;
	}

	public void setestudianteSeleccionado(Estudiante unEstudiante) {
		estudianteSeleccionado = unEstudiante;
	}

	public List<Estudiante> getestudiantes() {
		return estudiantes;
	}
	
	public void cargarAsignacionesDeTareas() {
		if(!(estudianteSeleccionado == null)) {
			setAsignacionesDeTareas(estudianteSeleccionado.getAsignacionesDeTareas());
		}
	}
	
	public void cargarModificacionesDeEstudiantes(String nombreYApellidoMod, String legajoMod, String usuarioGithubMod) {
		estudianteSeleccionado.setNombreYApellido(nombreYApellidoMod);
		estudianteSeleccionado.setLegajo(Integer.parseInt(legajoMod));
		estudianteSeleccionado.setUsuarioGithub(usuarioGithubMod);
	}

	public List<AsignacionDeTarea> getAsignacionesDeTareas() {
		return asignacionesDeTareas;
	}

	public void setAsignacionesDeTareas(List<AsignacionDeTarea> asignacionesDeTareas) {
		this.asignacionesDeTareas = asignacionesDeTareas;
	}

	public AsignacionDeTarea getAsignacionSeleccionada() {
		return asignacionSeleccionada;
	}

	public void setAsignacionSeleccionada(AsignacionDeTarea asignacionSeleccionada) {
		this.asignacionSeleccionada = asignacionSeleccionada;
	}

}
