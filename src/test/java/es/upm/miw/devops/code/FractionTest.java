package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FractionTest {

    @Test
    void testDefaultConstructor() {
        Fraction fraction = new Fraction();

        assertThat(fraction.getNumerator()).isEqualTo(1);
        assertThat(fraction.getDenominator()).isEqualTo(1);
    }

    @Test
    void testConstructorWithParameters() {
        Fraction fraction = new Fraction(3, 4);

        assertThat(fraction.getNumerator()).isEqualTo(3);
        assertThat(fraction.getDenominator()).isEqualTo(4);
    }

    @Test
    void testSetNumerator() {
        Fraction fraction = new Fraction();
        fraction.setNumerator(7);

        assertThat(fraction.getNumerator()).isEqualTo(7);
    }

    @Test
    void testSetDenominator() {
        Fraction fraction = new Fraction();
        fraction.setDenominator(9);

        assertThat(fraction.getDenominator()).isEqualTo(9);
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1, 2);

        assertThat(fraction.decimal())
                .isCloseTo(0.5, within(0.00001));
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(5, 6);

        assertThat(fraction.toString())
                .isEqualTo("Fraction{numerator=5, denominator=6}");
    }
}