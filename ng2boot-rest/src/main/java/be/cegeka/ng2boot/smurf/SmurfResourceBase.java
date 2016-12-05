package be.cegeka.ng2boot.smurf;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

import static be.cegeka.ng2boot.smurf.SmurfResource.SMURF_BASE_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Produces(APPLICATION_JSON_UTF8_VALUE)
@Path(SMURF_BASE_URL)
public class SmurfResourceBase implements SmurfResource {

    @Inject
    private SmurfRepository smurfRepository;

    @Override
    @GET
    public Response all() {
        List<SmurfR> logs = smurfRepository.findAll()
                .stream()
                .map(SmurfAssembler::toRepresentation)
                .collect(Collectors.toList());
        return Response.ok(logs).build();
    }
}
