package Server;

import spark.Spark;

public class Router {
	public static void configure() {
		
		Spark.put("/student", Controller::actualizarEstudiante);
		Spark.get("/student", Controller::datosEstudiante);
		Spark.get("/student/assignments", Controller::asignacionesEstudiante);

	}
}
