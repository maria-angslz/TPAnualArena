package model;

public class CalificacionNumerica implements Calificacion{
	double nota;
	
	public CalificacionNumerica(double nota) {
		this.nota = nota;
	}
	
	public boolean aprobada() {
		return nota >= 6;
	}
	
	public TipoCalificacion tipoCalificacion() {
		return TipoCalificacion.NUMERICA;
	}
	
	public String nota() {
		return String.valueOf(nota);
	}
}
