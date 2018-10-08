package main;
import org.uqbar.arena.windows.Window;

import model.Inicializacion;

import org.uqbar.arena.Application;


import ui.windows.ListadoNotas;

public class LectorNotasApplication extends Application{

	public static void main(String[] args) {
		Inicializacion.initialize();
		new LectorNotasApplication().start();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new ListadoNotas(this);
	}
}
