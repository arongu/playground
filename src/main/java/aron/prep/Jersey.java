package aron.prep;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

import java.net.URI;

public class Jersey {
    public static void main( final String[] args )
    throws Exception {
        final String uri    = "http://localhost:8080";
        final Server server = JettyHttpContainerFactory.createServer(URI.create(uri));
        server.start();
    }
}
