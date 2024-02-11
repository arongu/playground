package aron.backend.jersey;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

// this class uses the magic of @Inject to get hold of the service locator
// then it enables the immediate scope
// https://stackoverflow.com/questions/29289245/immediate-annotation-use-in-jersey2
public class ServiceLocatorConfig implements Feature {
    @Inject
    public ServiceLocatorConfig( final ServiceLocator locator ) {
        // additional config can be added here
        ServiceLocatorUtilities.enableImmediateScope(locator);
    }

    @Override
    public boolean configure( final FeatureContext context ) {
        return false;
    }
}
