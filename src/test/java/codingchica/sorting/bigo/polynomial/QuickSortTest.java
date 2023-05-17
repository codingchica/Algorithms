package codingchica.sorting.bigo.polynomial;

import codingchica.sorting.util.CompareToObjects;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/** Unit tests for the codingchica.sorting.bigo.polynomial.QuickSort class */
public class QuickSortTest {

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
            QuickSort result = new QuickSort();

            // Validation
            assertNotNull(result);
        }
    }

    /**
     * Unit tests for the sort method.
     */
    @Nested
    public class SortTest {
        @Test
        void sort_whenArrayNull_thenNoExceptionThrown() {
            // Setup

            // Execution
            Integer[] result = QuickSort.sort(null);

            // Validation
            assertNull(result);
        }

        @Test
        void sort_whenArrayEmpty_thenUnmodified() {
            // Setup
            Integer[] expectedResult = new Integer[]{};
            Integer[] arrayToSort = new Integer[]{};

            // Execution
            Integer[] result = QuickSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedResult,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedResult), Arrays.asList(result)));
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {"123", "abcd"})
        void sort_whenArraySingleValue_thenUnmodified(String value) {
            // Setup
            String[] expectedResult = new String[]{value};
            String[] arrayToSort = new String[]{value};

            // Execution
            String[] result = QuickSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedResult,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedResult), Arrays.asList(result)));
        }

        @Test
        void sort_whenReversed_thenSorted() {
            // Setup
            Integer[] expectedResult = new Integer[]{1, 2, 3};
            Integer[] arrayToSort = new Integer[]{3, 2, 1};

            // Execution
            Integer[] result = QuickSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedResult,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedResult), Arrays.asList(result)));
        }

        @Test
        void sort_whenAlreadySorted_thenUnchanged() {
            // Setup
            Integer[] expectedResult = new Integer[]{1, 2, 3, 4, 5, 6};
            Integer[] arrayToSort = new Integer[]{1, 2, 3, 4, 5, 6};

            // Execution
            Integer[] result = QuickSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedResult,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedResult), Arrays.asList(result)));
        }

        @Test
        void sort_whenUnsorted_thenSortedCorrectly() {
            // Setup
            Integer[] arrayToSort = new Integer[]{25, 100, -5, 80, -60, 2000};
            Integer[] expectedResult = new Integer[]{-60, -5, 25, 80, 100, 2000};

            // Execution
            Integer[] result = QuickSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedResult,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedResult), Arrays.asList(result)));
        }


        @Test
        void sort_whenNullsAtBeginning_thenNullsAtEnd() {
            // Setup
            Integer[] arrayToSort = new Integer[]{null, null, 5, 4, 3, 2, 1};
            Integer[] expectedResult = new Integer[]{1, 2, 3, 4, 5, null, null};

            // Execution
            Integer[] result = QuickSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedResult,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedResult), Arrays.asList(result)));
        }


        @Test
        void sort_whenNullsAtEnd_thenNullsStayAtEnd() {
            // Setup
            Integer[] arrayToSort = new Integer[]{5, 4, 3, 2, 1, null, null};
            Integer[] expectedResult = new Integer[]{1, 2, 3, 4, 5, null, null};

            // Execution
            Integer[] result = QuickSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedResult,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedResult), Arrays.asList(result)));
        }


        @Test
        void sort_whenNullsInMiddle_thenNullsMoveToEnd() {
            // Setup
            Integer[] arrayToSort = new Integer[]{5, null, 4, 3, null, 2, 1,};
            Integer[] expectedResult = new Integer[]{1, 2, 3, 4, 5, null, null};

            // Execution
            Integer[] result = QuickSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedResult,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedResult), Arrays.asList(result)));
        }
    }
}
