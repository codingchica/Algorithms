package codingchica.sorting.bigo.polynomial;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BubbleSort class.
 */
public class BubbleSortTest {

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
            BubbleSort result = new BubbleSort();

            // Validation
            assertNotNull(result);
        }
    }

    /**
     * Unit tests for the sort method.
     *
     * @see BubbleSort#sort(Comparable[])
     */
    @Nested
    public class SortTest {
        /**
         * Ensure that no exception is thrown when null is provided.
         */
        @Test
        void sort_whenNull_thenNoExceptionThrown() {
            // Setup

            // Execution
            String[] result = BubbleSort.sort(null);

            // Validation
            assertNull(result);
        }

        /**
         * Ensure that an empty array is returned when an empty array is provided.
         */
        @Test
        void sort_whenEmptyArray_SameReturned() {
            // Setup
            String[] arrayToSort = new String[]{};

            // Execution
            String[] result = BubbleSort.sort(arrayToSort);

            // Validation
            assertNotNull(result, "not null");
            assertSame(arrayToSort, result);
            assertEquals(0, result.length, "size");
        }

        /**
         * Ensure that the same value is returned as the output when a single item array is provided.
         */
        @Test
        void sort_whenSingletonArray_thenSameReturned() {
            // Setup
            Integer[] arrayToSort = new Integer[]{1};
            Integer[] expectedArray = new Integer[]{1};

            // Execution
            Integer[] result = BubbleSort.sort(arrayToSort);

            // Validation
            assertArrayEquals(
                    expectedArray,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedArray), Arrays.asList(result)));
        }

        /**
         * Ensure that an already sorted array is unmodified.
         */
        @Test
        void sort_whenAlreadySorted_thenSameReturned() {
            // Setup
            Integer[] arrayToSort = new Integer[]{1, 2, 3};
            Integer[] expectedArray = new Integer[]{1, 2, 3};

            // Execution
            Integer[] result = BubbleSort.sort(arrayToSort);

            // Validation
            assertArrayEquals(
                    expectedArray,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedArray), Arrays.asList(result)));
        }

        /**
         * Ensure that null values are sorted after all of the other values.
         */
        @Test
        void sort_whenContainsNullAtEnd_thenNullStaysAtEnd() {
            // Setup
            Integer[] arrayToSort = new Integer[]{1, 5, null};
            Integer[] expectedArray = new Integer[]{1, 5, null};

            // Execution
            Integer[] result = BubbleSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedArray,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedArray), Arrays.asList(result)));
        }

        /**
         * Ensure that null values are sorted after all of the other values.
         */
        @Test
        void sort_whenContainsNullAtBeginning_thenNullMovedToEnd() {
            // Setup
            Integer[] arrayToSort = new Integer[]{null, 1, 5};
            Integer[] expectedArray = new Integer[]{1, 5, null};

            // Execution
            Integer[] result = BubbleSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedArray,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedArray), Arrays.asList(result)));
        }

        /**
         * Ensure that null values are sorted after all of the other values.
         */
        @Test
        void sort_whenContainsNullInMiddle_thenNullMovedToEnd() {
            // Setup
            Integer[] arrayToSort = new Integer[]{1, null, null, 5};
            Integer[] expectedArray = new Integer[]{1, 5, null, null};

            // Execution
            Integer[] result = BubbleSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedArray,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedArray), Arrays.asList(result)));
        }

        /**
         * Ensure that an array provided in reverse order is mirrored into the correct ordering.
         */
        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2})
        void sort_whenReversed_thenOrderReversed(int arraySize) {
            // Setup
            Integer[] arrayToSort = new Integer[arraySize];
            Integer[] expectedArray = new Integer[arraySize];
            IntStream.range(1, arraySize + 1).forEachOrdered((value -> {
                expectedArray[value - 1] = value;
                arrayToSort[arraySize - value] = value;
            }));

            // Execution
            Integer[] result = BubbleSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedArray,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedArray), Arrays.asList(result)));
        }
    }
}