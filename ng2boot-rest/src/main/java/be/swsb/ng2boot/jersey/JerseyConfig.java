package be.swsb.ng2boot.jersey;


import be.swsb.ng2boot.smurf.SmurfResourceBase;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(SmurfResourceBase.class);
    }
}