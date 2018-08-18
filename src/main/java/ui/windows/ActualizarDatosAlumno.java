package ui.windows;

import org.uqbar.arena.layout.ColumnLayout;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ui.vm.NotasViewModel;

public class ActualizarDatosAlumno extends Dialog<NotasViewModel>{

	public ActualizarDatosAlumno(WindowOwner owner, NotasViewModel notasModel) {
		super(owner, notasModel);
	}
	
	TextBox nombre;
	TextBox legajo;
	TextBox usuario;

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Actualizacion datos de alumnos");
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Legajo:");
		legajo = new TextBox(form);
		legajo.bindValueToProperty("nuevoEstudiante.legajo");
		
		
		new Label(form).setText("Nombre y apellido:");
		nombre = new TextBox(form);
		nombre.bindValueToProperty("nuevoEstudiante.nombreYApellido");
		
		new Label(form).setText("Usuario Github");
		usuario = new TextBox(form);
		usuario.bindValueToProperty("nuevoEstudiante.usuarioGithub");
		
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Guardar").onClick(this::guardarDatosEstudiante);
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
	
	void guardarDatosEstudiante() {
		getModelObject().guardarNuevoEstudiante();
		this.cancel();
	}
	
}
