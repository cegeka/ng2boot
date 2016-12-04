package be.swsb.ng2boot.smurf;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

import static be.swsb.ng2boot.jaxrs.test.ResponseAssertions.assertThat;
import static java.time.LocalDate.now;
import static javax.ws.rs.core.Response.Status.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SmurfResourceBaseIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private SmurfRepository repo;

    private SmurfResource smurfResource;

    @Before
    public void setUp() {
        repo.deleteAll();

        String baseUrl = "http://localhost:" + port;
        WebTarget webTarget = JerseyClientBuilder.newClient().target(baseUrl);
        smurfResource = WebResourceFactory.newResource(SmurfResource.class, webTarget);
    }

    @Test
    public void all() {
        LocalDate creationDate = now();
        Smurf smurf = repo.save(SmurfTestBuilder.aDefaultSmurf().withCreationDate(creationDate).build());

        SmurfR expectedSmurf = SmurfRTestBuilder.aSmurfR()
                .withName(SmurfTestBuilder.NAME)
                .withCreationDate(creationDate)
                .withId(smurf.getId())
                .build();

        Response response = smurfResource.all();

        assertThat(response).hasStatus(OK);
        assertThat(response.readEntity(SmurfR[].class)).containsOnly(expectedSmurf);
    }

}