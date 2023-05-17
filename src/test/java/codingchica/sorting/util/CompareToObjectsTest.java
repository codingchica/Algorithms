package codingchica.sorting.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the CompareToObjects class.
 */
class CompareToObjectsTest {

    /**
     * Unit tests for the no-argument constructor.  This isn't really used, since the methods are all static in this
     * utility class, but going ahead for UT code completion.
     */
    @Nested
    public class NoArgConstructorTest {

        @Test
        void constructor_whenInvoked_returnsObject() {
            // Setup

            // Execution
            CompareToObjects result = new CompareToObjects();

            // Validation
            assertNotNull(result);
        }
    }

    /**
     * Enforce that the value provided indicates that the left value is bigger than the right value.
     *
     * @param value The value returned from the compareTo call.
     */
    private void assertComparisonBigger(int value) {
        assertTrue(value > 0, value + " should be positive");
    }

    /**
     * Enforce that the value provided indicates that the left value is smaller than the right value.
     *
     * @param value The value returned from the compareTo call.
     */
    private void assertComparisonSmaller(int value) {
        assertTrue(value < 0, value + " should be negative");
    }

    /**
     * Enforce that the value provided indicates that the left value is equivalent to the right value.
     *
     * @param value The value returned from the compareTo call.
     */
    private void assertComparisonEquals(int value) {
        Assertions.assertEquals(0, value, value + " should be zero");
    }

    /**
     * Unit tests for the compareToWithNulls then the nulls should be sorted to the right.
     *
     * @see CompareToObjects#compareToWithNulls(Comparable, Comparable)
     * @see CompareToObjects#compareToWithNulls(Comparable, Comparable, boolean)
     */
    @Nested
    public class CompareToWithNullsAtRightTest {

        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void compareToNullable_whenLeftValueNull_returnsNegative(int value) {
            // Setup

            // Execution
            int result = CompareToObjects.compareToWithNulls(null, value);

            // Validation
            assertComparisonBigger(result);
        }

        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void compareToNullable_whenRightValueNull_returnsPositive(int value) {
            // Setup

            // Execution
            int result = CompareToObjects.compareToWithNulls(value, null);

            // Validation
            assertComparisonSmaller(result);
        }


        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void compareToNullable_whenSame_returnsZero(int value) {
            // Setup

            // Execution
            int result = CompareToObjects.compareToWithNulls(value, value);

            // Validation
            assertComparisonEquals(result);
        }


        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void compareToNullable_whenRightGreater_returnsPositive(int value) {
            // Setup

            // Execution
            int result = CompareToObjects.compareToWithNulls(value, value + 1);

            // Validation
            assertComparisonSmaller(result);
        }

        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void compareToNullable_whenRightLessThan_returnsNegative(int value) {
            // Setup

            // Execution
            int result = CompareToObjects.compareToWithNulls(value, value - 1);

            // Validation
            assertComparisonBigger(result);
        }
    }

    /**
     * Unit tests for the compareToWithNulls then the nulls should be sorted to the left.
     *
     * @see CompareToObjects#compareToWithNulls(Comparable, Comparable, boolean)
     */
    @Nested
    public class CompareToWithNullsAtLeftTest {

        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void compareToNullable_whenLeftValueNull_returnsNegative(int value) {
            // Setup

            // Execution
            int result = CompareToObjects.compareToWithNulls(null, value, false);

            // Validation
            assertComparisonSmaller(result);
        }

        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void compareToNullable_whenRightValueNull_returnsPositive(int value) {
            // Setup

            // Execution
            int result = CompareToObjects.compareToWithNulls(value, null, false);

            // Validation
            assertComparisonBigger(result);
        }


        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void compareToNullable_whenSame_returnsZero(int value) {
            // Setup

            // Execution
            int result = CompareToObjects.compareToWithNulls(value, value, false);

            // Validation
            assertComparisonEquals(result);
        }


        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void compareToNullable_whenRightGreater_returnsPositive(int value) {
            // Setup

            // Execution
            int result = CompareToObjects.compareToWithNulls(value, value + 1, false);

            // Validation
            assertComparisonSmaller(result);
        }

        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void compareToNullable_whenRightLessThan_returnsNegative(int value) {
            // Setup

            // Execution
            int result = CompareToObjects.compareToWithNulls(value, value - 1, false);

            // Validation
            assertComparisonBigger(result);
        }
    }
}