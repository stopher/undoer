package no.egde.undoer;


import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

@Component
@Path("/reverse2")
public class ReverseEndpoint {

    @GET
    public String reverse(@QueryParam("input") @NotNull String input) {
        return new StringBuilder(input).reverse().toString();
    }

}