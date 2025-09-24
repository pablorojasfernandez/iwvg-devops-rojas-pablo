package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SearchesTest {

    private final Searches searches = new Searches();

    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        List<String> result = searches.findUserFamilyNameByUserNameDistinct("Oscar").toList();

        assertThat(result)
                .hasSize(2)
                .containsExactlyInAnyOrder("Fernandez", "López");
    }

    @Test
    void testFindFractionNumeratorByUserFamilyName() {
        List<Integer> result = searches.findFractionNumeratorByUserFamilyName("Blanco")
                .toList();

        assertThat(result)
                .hasSize(7)
                .containsExactly(2, -1, 2, 4, 0, 0, 0);
    }

    @Test
    void testFindUserFamilyNameByFractionDenominator() {
        List<String> result = searches.findUserFamilyNameByFractionDenominator(1)
                .toList();

        assertThat(result)
                .hasSize(4)
                .containsExactlyInAnyOrder("Fernandez", "Blanco", "Blanco", "Torres");
    }

    // Method 0
    @Test
    void testFindUserFamilyNameInitialByAnyProperFraction() {
        List<String> result = searches.findUserFamilyNameInitialByAnyProperFraction()
                .toList();

        assertThat(result)
                .hasSize(4)
                .containsExactlyInAnyOrder("F", "B", "L", "B");
    }

    // Method 1
    @Test
    void testFindUserIdByAnyProperFraction() {
        List<String> result = searches.findUserIdByAnyProperFraction().toList();

        assertThat(result)
                .hasSize(4)
                .containsExactlyInAnyOrder("1", "2", "3", "5");
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyName() {
        assertThat(searches.findFractionMultiplicationByUserFamilyName("Smith"))
                .isNull();
    }

    @Test
    void testFindFirstFractionDivisionByUserId() {
        assertThat(searches.findFirstFractionDivisionByUserId("u1"))
                .isNull();
    }

    // Method 4
    @Test
    void testFindFirstDecimalFractionByUserName() {
        assertThat(searches.findFirstDecimalFractionByUserName("Oscar"))
                .isEqualTo(0.0);

        assertThat(searches.findFirstDecimalFractionByUserName("Ana"))
                .isEqualTo(2.0);

        assertThat(searches.findFirstDecimalFractionByUserName("NoExiste"))
                .isNull();
    }

    @Test
    void testFindUserIdByAllProperFraction() {
        assertThat(searches.findUserIdByAllProperFraction().toList())
                .isEmpty();
    }

    @Test
    void testFindDecimalImproperFractionByUserName() {
        assertThat(searches.findDecimalImproperFractionByUserName("user1").toList())
                .isEmpty();
    }

    @Test
    void testFindFirstProperFractionByUserId() {
        assertThat(searches.findFirstProperFractionByUserId("u1"))
                .isNull();
    }

    // Method 8
    @Test
    void testFindUserFamilyNameByImproperFraction() {
        List<String> result = searches.findUserFamilyNameByImproperFraction()
                .toList();

        assertThat(result)
                .hasSize(5)
                .containsExactlyInAnyOrder("Fernandez", "Blanco", "López", "Torres", "Torres");
    }

    @Test
    void testFindHighestFraction() {
        assertThat(searches.findHighestFraction())
                .isNull();
    }

    @Test
    void testFindUserNameByAnyImproperFraction() {
        assertThat(searches.findUserNameByAnyImproperFraction().toList())
                .isEmpty();
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertThat(searches.findUserFamilyNameByAllNegativeSignFractionDistinct().toList())
                .isEmpty();
    }

    @Test
    void testFindDecimalFractionByUserName() {
        assertThat(searches.findDecimalFractionByUserName("user1").toList())
                .isEmpty();
    }

    @Test
    void testFindDecimalFractionByNegativeSignFraction() {
        assertThat(searches.findDecimalFractionByNegativeSignFraction().toList())
                .isEmpty();
    }

    @Test
    void testFindFractionAdditionByUserId() {
        assertThat(searches.findFractionAdditionByUserId("u1"))
                .isNull();
    }

    @Test
    void testFindFirstFractionSubtractionByUserName() {
        assertThat(searches.findFirstFractionSubtractionByUserName("user1"))
                .isNull();
    }
}