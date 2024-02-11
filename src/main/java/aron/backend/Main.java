package aron.backend;

import aron.backend.jersey.JerseyResourceConfig;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

import java.net.URI;

public class Main {
    public static void main( final String[] args )
    throws Exception {
        final JerseyResourceConfig resourceConfig = new JerseyResourceConfig();
        final Server server = JettyHttpContainerFactory.createServer(
                URI.create("http://localhost:8080"), resourceConfig
        );

        server.start();
    }
}
