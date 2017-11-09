package no.egde.undoer;

import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(Endpoint.class);
        register(ReverseEndpoint.class);
        register(AnotherEndpoint.class);
    }

}