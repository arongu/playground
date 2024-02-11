package aron.backend.jersey;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class JerseyApplicationBinder extends AbstractBinder {
    public JerseyApplicationBinder() {
    }

    @Override
    protected void configure() {
        // REGISTER ALL NON        @Path ANNOTATED CLASSES HERE !!!
        // DO NOT RELY ON          @Singleton or @Immediate !!!
        // THOSE ONLY WORK WELL ON @Path ANNOTATED CLASSES !!!
        // binds and contracts
        // exception
    }
}
