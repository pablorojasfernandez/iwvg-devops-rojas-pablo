package es.upm.miw.devops.rest.exceptionshandler;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import static org.assertj.core.api.Assertions.assertThat;

class ApiExceptionHandlerTest {

    private final ApiExceptionHandler handler = new ApiExceptionHandler();

    @Test
    void testNoResourceFoundRequestWithNoResourceFoundException() {
        ErrorMessage errorMessage = handler.noResourceFoundRequest(
                new NoResourceFoundException(HttpMethod.GET, "/invalid")
        );

        assertThat(errorMessage.getError()).isEqualTo("RuntimeException");
        assertThat(errorMessage.getMessage())
                .contains("Ruta no encontrada");
        assertThat(errorMessage.getCode()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void testNoResourceFoundRequestWithResponseStatusException() {
        ErrorMessage errorMessage = handler.noResourceFoundRequest(
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found")
        );

        assertThat(errorMessage.getError()).isEqualTo("RuntimeException");
        assertThat(errorMessage.getMessage())
                .contains("Ruta no encontrada");
        assertThat(errorMessage.getCode()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void testGenericExceptionHandler() {
        ErrorMessage errorMessage = handler.exception(new Exception("Any error"));

        assertThat(errorMessage.getError()).isEqualTo("RuntimeException");
        assertThat(errorMessage.getMessage()).isEqualTo("ERROR");
        assertThat(errorMessage.getCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
