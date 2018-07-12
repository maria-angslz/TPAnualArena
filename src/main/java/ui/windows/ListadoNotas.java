package ui.windows;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.AsignacionDeTarea;
import model.Estudiante;
import ui.vm.NotasViewModel;

public class ListadoNotas extends SimpleWindow<NotasViewModel> {
	
	public ListadoNotas(WindowOwner parent) {
		super(parent, new NotasViewModel());
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Buscar").onClick(getModelObject()::cargarAsignacionesDeTareas);
		new Button(actionsPanel).setCaption("ActualizarDatos").onClick(this::AbrirActualizarDatos);
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Lector Notas");
		new Label(mainPanel).setText("Legajo:");
		new Label(mainPanel).bindValueToProperty("estudianteSeleccionado.legajo");
		
		Selector<Estudiante> selectorEstudiantes = new Selector<Estudiante>(mainPanel).allowNull(true);
		selectorEstudiantes.bindItemsToProperty("estudiantes");
		selectorEstudiantes.bindValueToProperty("estudianteSeleccionado");
		
		//selectorEstudiantes.onSelection(getModelObject()::cargarAsignacionesDeTareas);
		
		Table<AsignacionDeTarea> tablaNotas = new Table<AsignacionDeTarea>(mainPanel, AsignacionDeTarea.class);
		tablaNotas.bindItemsToProperty("asignacionesDeTareas");
		tablaNotas.bindValueToProperty("asignacionSeleccionada");
		tablaNotas.setNumberVisibleRows(10);
		tablaNotas.setHeight(1000);
		tablaNotas.setWidth(1000);
		
		/*Column<AsignacionDeTarea> columnaTareaAsignada = new Column<AsignacionDeTarea>(tablaNotas);
		columnaTareaAsignada.setTitle("Tarea asignada");
		columnaTareaAsignada.setFixedSize(100);
		columnaTareaAsignada.bindContentsToProperty("nota");*/
		
		new Column<AsignacionDeTarea>(tablaNotas).setTitle("Tarea asignada").bindContentsToProperty("nombreTarea");
		new Column<AsignacionDeTarea>(tablaNotas).setTitle("Nota").bindContentsToProperty("nota");
		new Column<AsignacionDeTarea>(tablaNotas).setTitle("Aprobado").bindContentsToProperty("aprobada");
	}
	
	
	public void AbrirActualizarDatos() {
		Dialog<?> dialog = new ActualizarDatosAlumno(this, getModelObject());
		dialog.open();
	}
	
}
