package es.upm.miw.devops;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatCode;

@SpringBootTest
class ApplicationTest {

    @Test
    void contextLoads() {
        // Verifica que el contexto arranca correctamente
    }

    @Test
    void mainRuns() {
        assertThatCode(() -> Application.main(new String[] {}))
                .doesNotThrowAnyException();
    }

}
