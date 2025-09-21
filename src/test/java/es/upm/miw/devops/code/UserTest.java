package es.upm.miw.devops.code;

import es.upm.miw.devops.code.Fraction;
import es.upm.miw.devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    private User user;
    private Fraction fraction1;
    private Fraction fraction2;

    @BeforeEach
    void setUp() {
        fraction1 = new Fraction();
        fraction2 = new Fraction();
        user = new User("1", "John", "Doe", new ArrayList<>(Arrays.asList(fraction1, fraction2)));
    }

    @Test
    void testDefaultConstructor() {
        User defaultUser = new User();

        assertThat(defaultUser.getFractions())
                .isNotNull()
                .isEmpty();
    }

    @Test
    void testFullConstructor() {
        assertThat(user.getId()).isEqualTo("1");
        assertThat(user.getName()).isEqualTo("John");
        assertThat(user.getFamilyName()).isEqualTo("Doe");
        assertThat(user.getFractions())
                .hasSize(2)
                .containsExactly(fraction1, fraction2);
    }

    @Test
    void testSetName() {
        user.setName("Alice");

        assertThat(user.getName()).isEqualTo("Alice");
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Smith");

        assertThat(user.getFamilyName()).isEqualTo("Smith");
    }

    @Test
    void testSetFractions() {
        user.setFractions(Collections.singletonList(fraction1));

        assertThat(user.getFractions())
                .hasSize(1)
                .containsExactly(fraction1);
    }

    @Test
    void testAddFraction() {
        Fraction newFraction = new Fraction();

        user.addFraction(newFraction);

        assertThat(user.getFractions())
                .hasSize(3)
                .contains(newFraction);
    }

    @Test
    void testFullName() {
        assertThat(user.fullName()).isEqualTo("John Doe");
    }

    @Test
    void testInitials() {
        assertThat(user.initials()).isEqualTo("J.");
    }

    @Test
    void testToString() {
        String toString = user.toString();

        assertThat(toString)
                .startsWith("User{")
                .contains("id='1'")
                .contains("name='John'")
                .contains("familyName='Doe'");
    }
}