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
    void testIsProper() {
        Fraction proper = new Fraction(2, 5);
        Fraction improper = new Fraction(7, 3);

        assertThat(proper.isProper()).isTrue();
        assertThat(improper.isProper()).isFalse();
    }

    @Test
    void testIsImproper() {
        Fraction proper = new Fraction(2, 5);
        Fraction improper = new Fraction(7, 3);

        assertThat(proper.isImproper()).isFalse();
        assertThat(improper.isImproper()).isTrue();
    }

    @Test
    void testIsEquivalent() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 5);

        assertThat(f1.isEquivalent(f2)).isTrue();
        assertThat(f1.isEquivalent(f3)).isFalse();
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);

        Fraction result = f1.add(f2);

        assertThat(result.getNumerator()).isEqualTo(5);
        assertThat(result.getDenominator()).isEqualTo(6);
    }

    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);

        Fraction result = f1.multiply(f2);

        assertThat(result.getNumerator()).isEqualTo(6);
        assertThat(result.getDenominator()).isEqualTo(12);
    }

    @Test
    void testDivide() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);

        Fraction result = f1.divide(f2);

        assertThat(result.getNumerator()).isEqualTo(8);
        assertThat(result.getDenominator()).isEqualTo(9);
    }

    @Test
    void testDivideByZeroNumeratorFractionThrows() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(0, 5);

        assertThatThrownBy(() -> f1.divide(f2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Cannot divide by a fraction with numerator 0");
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(5, 6);

        assertThat(fraction.toString())
                .hasToString("Fraction{numerator=5, denominator=6}");
    }

    @Test
    void testConstructorDenominatorZeroThrows() {
        assertThatThrownBy(() -> new Fraction(3, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Denominator cannot be zero");
    }

    @Test
    void testSetDenominatorZeroThrows() {
        Fraction fraction = new Fraction(1, 2);

        assertThatThrownBy(() -> fraction.setDenominator(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Denominator cannot be zero");
    }
}