package aron.backend.jersey;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyResourceConfig extends ResourceConfig {
    public JerseyResourceConfig() {
        packages("aron.backend");
        register(ServiceLocatorConfig.class);
        register(JacksonFeature.class);
    }
}
