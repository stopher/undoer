package no.egde.undoer;


import javax.ws.rs.GET;
import javax.ws.rs.Path;


import org.springframework.stereotype.Component;
import no.egde.undoer.Service;

@Path("/db")
@Component
public class Endpoint {

    private final Service service;

    public Endpoint(Service service) {
        this.service = service;
    }

    @GET
    @Path("/init")
    public String init() {
        System.out.println("message");
        this.service.initDb();
        return "initialized";
    }

    @GET
    @Path("/dyreste")
    public String dyreste() {
        System.out.println("message2");
        return this.service.dyresteBolig().toString();
    }

}