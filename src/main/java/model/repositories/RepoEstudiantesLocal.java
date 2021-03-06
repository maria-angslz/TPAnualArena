package model.repositories;

import java.util.ArrayList;
import java.util.List;

import model.Estudiante;

public class RepoEstudiantesLocal {
	protected List<Estudiante> lista = new ArrayList<>();
	private static RepoEstudiantesLocal instancia;

	public static RepoEstudiantesLocal getInstance() {
		if (instancia == null) {
			instancia = new RepoEstudiantesLocal();
		}
		return instancia;
	}
	
	public List<Estudiante> get() {
		return lista;
	}

	public void agregar(Estudiante unEstudiante) {
		lista.add(unEstudiante);
	}

	public void quitar(Estudiante unEstudiante) {
		lista.remove(unEstudiante);
	}

	public void addAll(List<Estudiante> unaListaEstudiantes) {
		lista.addAll(unaListaEstudiantes);
	}

	public void reset() {
		lista.clear();
	}
}
