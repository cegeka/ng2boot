package be.swsb.ng2boot.jaxrs.test;

import org.assertj.core.api.Assertions;

import javax.ws.rs.core.Response;

public class ResponseAssertions extends Assertions {

    public static ResponseAssert assertThat(Response actual) {
        return ResponseAssert.assertThat(actual);
    }
}
