package RequestService;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import model.Estudiante;

import javax.ws.rs.core.MediaType;


public class RequestService {
    private Client client;
    private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    //Inicializacion del cliente.
    
    public RequestService() {
        this.client = Client.create();
    }
    
    public ClientResponse obtenerEstudiante() {
    	WebResource webResource = client.resource("http://notitas.herokuapp.com/student");
    	ClientResponse response = webResource.header("Authorization", "Bearer " + token)
				 .accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    	
    	return response;
    }
    
    public ClientResponse obtenerAsignaciones() {
    	WebResource webResource = client.resource("http://notitas.herokuapp.com/student/assignments");
    	ClientResponse response = webResource.header("Authorization", "Bearer " + token)
				 .accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    	
    	return response;
    }
    
    public void actualizar(Estudiante estudianteAActualizar) {
    	
    	String[] nombreEstudiante = estudianteAActualizar.getNombreYApellido().split(" ");
    	
    	JsonObject jsonEstudianteNuevo = new JsonObject();
    	jsonEstudianteNuevo.addProperty("code", estudianteAActualizar.getLegajo());
    	jsonEstudianteNuevo.addProperty("first_name", nombreEstudiante[0]);
    	jsonEstudianteNuevo.addProperty("last_name", nombreEstudiante[1]);
    	jsonEstudianteNuevo.addProperty("github_user", estudianteAActualizar.getUsuarioGithub());

    	String body = jsonEstudianteNuevo.toString();
    	
    	WebResource webResource = client.resource("http://notitas.herokuapp.com/student");
    	ClientResponse response = webResource.header("Authorization", "Bearer " + token)
    			 .accept(MediaType.APPLICATION_JSON).put(ClientResponse.class, body); 
    	

    	String output = response.getEntity(String.class);
        System.out.println(output);

    }
}
