package model;

public class CalificacionConceptual implements Calificacion{
	String nota;
	
	public CalificacionConceptual(String nota) {
		this.nota = nota;
	}
	
	public boolean aprobada() {
		return nota.contains("B") || nota.contains("MB") || nota.contains("S");
	}
	
	public TipoCalificacion tipoCalificacion() {
		return TipoCalificacion.CONCEPTUAL;
	}
	
	public String nota() {
		return nota;
	}

}
