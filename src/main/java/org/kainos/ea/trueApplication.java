package org.kainos.ea;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.kainos.ea.resources.ClientController;
import org.kainos.ea.resources.DeliveryEmployeeController;
import org.kainos.ea.resources.SalesEmployeeController;

public class trueApplication extends Application<trueConfiguration> {

    public static void main(final String[] args) throws Exception {
        new trueApplication().run(args);
    }

    @Override
    public String getName() {
        return "week2_project";
    }

    @Override
    public void initialize(final Bootstrap<trueConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<trueConfiguration>(){
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(trueConfiguration configuration)
            {
                return configuration.getSwagger();
            }
        });
    }
    @Override
    public void run(final trueConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new DeliveryEmployeeController());
        environment.jersey().register(new ClientController());
        environment.jersey().register(new SalesEmployeeController());
    }
}