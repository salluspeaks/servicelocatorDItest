import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.servlet.ServletProperties;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.Application;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.servlets.Servlets;
import io.dropwizard.setup.Environment;


public class TestService extends Application<TestConfiguration> {

	@Override
	public void run(final TestConfiguration configuration, Environment environment)
			throws Exception {
		final ObjectMapper mapper =Jackson.newObjectMapper();
		ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
		ServiceLocatorUtilities.bind(locator, new AbstractBinder() {
			
			@Override
			protected void configure() {
				bind(configuration).named("configuration");
				bind(mapper).named("mapper");
				bind(InterfaceImpl.class).named("interface").to(new TypeLiteral<InterfaceTest>() {
				});
				
			}
		});
		environment.jersey().register(TestResource.class);
		environment.getApplicationContext().getAttributes().setAttribute(ServletProperties.SERVICE_LOCATOR, locator);
		
		
	}
	
	public static void main(String args[]) throws Exception{
		new TestService().run(args);
	}

}
