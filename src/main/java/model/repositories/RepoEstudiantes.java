package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Estudiante;

public class RepoEstudiantes {
	protected List<Estudiante> lista = new LinkedList<>();
	/*
	private static RepoEstudiantes instancia;

	public static RepoEstudiantes getInstance() {
		if (instancia == null) {
			instancia = new RepoEstudiantes();
		}
		return instancia;
	}
	*/
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
