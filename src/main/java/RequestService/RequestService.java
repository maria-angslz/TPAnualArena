package RequestService;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import model.Estudiante;

import javax.ws.rs.core.MediaType;


public class RequestService {
    private Client client;
    private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoxfQ.GDCk-9yZwlADFew9jI551Izq9Dj3SYsCfEL5qcUZYlM";

    //Inicializacion del cliente.
    
    public RequestService() {
        this.client = Client.create();
    }
    
    public ClientResponse obtenerEstudiante() {
    	WebResource webResource = client.resource("http://localhost:9000/student");
    	ClientResponse response = webResource.header("Authorization", "Bearer " + token)
				 .accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    	
    	return response;
    }
    
    public ClientResponse obtenerAsignaciones() {
    	WebResource webResource = client.resource("http://localhost:9000/student/assignments");
    	ClientResponse response = webResource.header("Authorization", "Bearer " + token)
				 .accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    	
    	return response;
    }
    
    public void actualizar(Estudiante estudianteAActualizar) {
    	Gson gson = new Gson();
    	String body = gson.toJson(estudianteAActualizar);
    	
    	WebResource webResource = client.resource("http://localhost:9000/student");
    	ClientResponse response = webResource.header("Authorization", "Bearer " + token)
    			 .accept(MediaType.APPLICATION_JSON).put(ClientResponse.class, body); 
    	

    	String output = response.getEntity(String.class);
        System.out.println("Estudiante modificado: " + output);

    }
}
