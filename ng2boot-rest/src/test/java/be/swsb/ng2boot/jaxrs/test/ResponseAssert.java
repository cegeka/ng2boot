package be.swsb.ng2boot.jaxrs.test;

import org.assertj.core.api.AbstractAssert;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Objects;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {

    private ResponseAssert(Response actual, Class<?> selfType) {
        super(actual, selfType);
    }

    @SuppressWarnings("WeakerAccess")
    //public to provide an alternative when conflict with statically imported ResponseAssertions.assertThat
    public static ResponseAssert assertThat(Response actual) {
        return new ResponseAssert(actual, ResponseAssert.class);
    }

    public ResponseAssert hasStatus(Response.StatusType expectedStatus) {
        isNotNull();

        if (!Objects.equals(actual.getStatusInfo(), expectedStatus)) {
            failWithMessage("Expected status code to be <%s> but was <%s>", expectedStatus, actual.getStatusInfo());
        }
        return this;
    }

    public ResponseAssert hasLocation(URI expectedURI) {
        isNotNull();

        if (!Objects.equals(actual.getLocation(), expectedURI)) {
            failWithMessage("Expected location to be <%s> but was <%s>", expectedURI, actual.getLocation());
        }
        return this;
    }

    public ResponseAssert hasLocation() {
        isNotNull();

        if (Objects.isNull(actual.getLocation())) {
            failWithMessage("Expected location not to be null");
        }
        return this;
    }

    public ResponseAssert hasLocationContaining(String expectedContained) {
        hasLocation();

        if (!actual.getLocation().toString().contains(expectedContained)) {
            failWithMessage("Expected location to contain <%s> but was <%s>", expectedContained, actual.getLocation());
        }
        return this;
    }
}
