package codingchica.sorting.bigo.logarithmic;

import codingchica.sorting.bigo.polynomial.BubbleSort;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the MergeSort class.
 */
public class MergeSortTest {

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
            MergeSort result = new MergeSort();

            // Validation
            assertNotNull(result);
        }
    }

    /**
     * Unit tests for the sort method.
     *
     * @see MergeSort#sort(Comparable[])
     */
    @Nested
    public class SortOneArgTests {
        /**
         * Ensure that no exception is thrown when null is provided.
         */
        @Test
        void sort_whenNull_thenNoExceptionThrown() {
            // Setup

            // Execution
            String[] result = MergeSort.sort(null);

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
            String[] result = MergeSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertNotNull(result, "not null");
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
            Integer[] result = MergeSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(expectedArray, result);
        }

        /**
         * Ensure that an already sorted array is unmodified.
         */
        @Test
        void sort_whenAlreadySorted_thenSameReturned() {
            // Setup
            Integer[] arrayToSort = new Integer[]{1, 2};
            Integer[] expectedArray = new Integer[]{1, 2};

            // Execution
            Integer[] result = MergeSort.sort(arrayToSort);

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
        void sort_whenContainsNullAtEnd_thenNullStaysAtEnd() {
            // Setup
            Integer[] arrayToSort = new Integer[]{1, 5, null};
            Integer[] expectedArray = new Integer[]{1, 5, null};

            // Execution
            Integer[] result = MergeSort.sort(arrayToSort);

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
            Integer[] result = MergeSort.sort(arrayToSort);

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
            Integer[] result = MergeSort.sort(arrayToSort);

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
        @ValueSource(ints = {/*100000, 10, 100, 5, 3, */ 2})
        void sort_whenReversed_thenOrderReversed(int arraySize) {
            // Setup
            Integer[] arrayToSort = new Integer[arraySize];
            Integer[] expectedArray = new Integer[arraySize];
            IntStream.range(1, arraySize + 1).forEachOrdered((value -> {
                expectedArray[value - 1] = value;
                arrayToSort[arraySize - value] = value;
            }));

            // Execution
            Integer[] result = MergeSort.sort(arrayToSort);

            // Validation
            assertSame(arrayToSort, result);
            assertArrayEquals(
                    expectedArray,
                    result,
                    String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedArray), Arrays.asList(result)));
        }
    }

    /**
     * Unit tests for the sort method.
     *
     * @see MergeSort#sort(Comparable[], int, int) 
     */
    @Nested
    public class SortThreeArgsTest {

        /**
         * Ensure that an array provided in reverse order is mirrored into the correct ordering.
         */
        @Test
        void sortReversedElements_whenCalledWithTheSameIndex_thenNoChange() {
            // Setup
            Integer[] arrayToSort = new Integer[10];
            Integer[] expectedArray = new Integer[arrayToSort.length];
            IntStream.range(0, arrayToSort.length).forEachOrdered((value -> {
                expectedArray[arrayToSort.length - 1 - value] = value;
                arrayToSort[arrayToSort.length - 1 - value] = value;
            }));

            IntStream.range(0, arrayToSort.length).forEachOrdered(value -> {
                // Execution
                MergeSort.sort(arrayToSort, value, value);

                // Validation
                assertArrayEquals(
                        expectedArray,
                        arrayToSort,
                        String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedArray), Arrays.asList(arrayToSort)));
            });
        }

        /**
         * Ensure that an array provided in reverse order is mirrored into the correct ordering.
         */
        @Test
        void sortReversedElements_whenCalledWithTheNextIndex_thenExpectedChange() {
            // Setup
            Integer[] arrayToSort = new Integer[]{3, 2, 1};
            Integer[] expectedArray = new Integer[]{2, 3, 1};

            IntStream.range(0, arrayToSort.length).forEachOrdered(value -> {
                // Execution
                MergeSort.sort(arrayToSort, 0, 1);

                // Validation
                assertArrayEquals(
                        expectedArray,
                        arrayToSort,
                        String.format("Expected:%n%s%nbut got:%n%s%n", Arrays.asList(expectedArray), Arrays.asList(arrayToSort)));
            });
        }
    }

    /**
     * Unit tests for the fillArrayFromList method.
     *
     * @see MergeSort#fillArrayFromList(Comparable[], int, List, int) 
     */
    @Nested
    public class FillArrayFromListTest {
        @Test
        void fillArrayFromList_whenArrayToSortNull_thenNoException() {
            // Setup

            // Execution
            int result = MergeSort.fillArrayFromList(null, 1, new ArrayList<>(), 1);

            // Validation
            assertEquals(1, result);
        }

        @Test
        void fillArrayFromList_whenTempListNull_thenNoException() {
            // Setup

            // Execution
            int result = MergeSort.fillArrayFromList(new String[]{}, 1, null, 1);

            // Validation
            assertEquals(1, result);
        }
    }
}