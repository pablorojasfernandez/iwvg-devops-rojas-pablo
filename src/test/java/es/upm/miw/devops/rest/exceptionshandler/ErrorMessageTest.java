package es.upm.miw.devops.rest.exceptionshandler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorMessageTest {

    @Test
    void testConstructorAndGetters() {
        Exception exception = new IllegalArgumentException("Invalid argument");
        int code = 400;

        ErrorMessage errorMessage = new ErrorMessage(exception, code);

        assertThat(errorMessage.getError()).isEqualTo("IllegalArgumentException");
        assertThat(errorMessage.getMessage()).isEqualTo("Invalid argument");
        assertThat(errorMessage.getCode()).isEqualTo(400);
    }

    @Test
    void testToStringContainsFields() {
        Exception exception = new NullPointerException("Null value");
        int code = 500;

        ErrorMessage errorMessage = new ErrorMessage(exception, code);
        String result = errorMessage.toString();

        assertThat(result)
                .contains("error='NullPointerException'")
                .contains("message='Null value'")
                .contains("code=500");
    }
}
