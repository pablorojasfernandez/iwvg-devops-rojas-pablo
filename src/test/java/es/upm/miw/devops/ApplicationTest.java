package es.upm.miw.devops;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ApplicationTest {

    @Test
    void contextLoads() {
        // Verifica que el contexto arranca correctamente
        assertThat(true).isTrue();
    }

    @Test
    void mainRuns() {
        // Simplemente comprobamos que no lanza excepciones
        Application.main(new String[] {});
        assertThat(true).isTrue();
    }

}
