package codingchica.search;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BinarySearch class.
 */
class BinarySearchTest {
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
            BinarySearch result = new BinarySearch();

            // Validation
            assertNotNull(result);
        }
    }

    @Nested
    public class SearchInSortedArrayTest {

        @Test
        void searchInSortedArray_whenArrayNull_thenReturnsNotFound() {
            // Setup

            // Execution
            int result = BinarySearch.searchInSortedArray(null, 0, 0, 0);

            // Validation
            assertEquals(-1, result);
        }

        @Test
        void searchInSortedArray_whenArrayEmpty_thenReturnsNotFound() {
            // Setup

            // Execution
            int result = BinarySearch.searchInSortedArray(new int[]{}, 0, 0, 0);

            // Validation
            assertEquals(-1, result);
        }

        @ParameterizedTest
        @ValueSource(ints = {-90, -60, -1, 1, 7, 12, 20, 100})
        void searchInSortedArray_whenValueNotFound_thenReturnsNotFound(int valueToFind) {
            // Setup
            int[] arrayToSearch = new int[]{-80, -50, 0, 2, 10, 15, 25};

            // Execution
            int result = BinarySearch.searchInSortedArray(arrayToSearch, 0, arrayToSearch.length - 1, valueToFind);

            // Validation
            assertEquals(-1, result);
        }

        @ParameterizedTest
        @ValueSource(ints = {-80, -50, 0, 1, 10, 15, 25})
        void searchInSortedArray_whenArrayOdd_thenEachElementIsFound(int valueToFind) {
            // Setup
            int[] arrayToSearch = new int[]{-80, -50, 0, 1, 10, 15, 25};
            // In a real project, I'd just use this library, instead of coding my own.
            int expectedIndex = Arrays.binarySearch(arrayToSearch, 0, arrayToSearch.length, valueToFind);
            assertNotEquals(-1, expectedIndex, "expectedIndex");

            // Execution
            int result = BinarySearch.searchInSortedArray(arrayToSearch, 0, arrayToSearch.length - 1, valueToFind);

            // Validation
            assertEquals(expectedIndex, result, "result");
        }

        @ParameterizedTest
        @ValueSource(ints = {-80, -50, 0, 1, 10, 15, 25, 50})
        void searchInSortedArray_whenArrayEven_thenEachElementIsFound(int valueToFind) {
            // Setup
            int[] arrayToSearch = new int[]{-80, -50, 0, 1, 10, 15, 25, 50};
            // In a real project, I'd just use this library, instead of coding my own.
            int expectedIndex = Arrays.binarySearch(arrayToSearch, 0, arrayToSearch.length, valueToFind);
            assertNotEquals(-1, expectedIndex, "expectedIndex");

            // Execution
            int result = BinarySearch.searchInSortedArray(arrayToSearch, 0, arrayToSearch.length - 1, valueToFind);

            // Validation
            assertEquals(expectedIndex, result, "result");
        }

        @Test
        void searchInSortedArray_whenLowerBoundTooLow_thenExceptionThrown() {
            // Setup
            int[] arrayToSearch = new int[]{-80, -50, 0, 1, 10, 15, 25, 50};

            // Execution
            Executable executable = ()-> BinarySearch.searchInSortedArray(arrayToSearch, -1, arrayToSearch.length - 1, 50);

            // Validation
            Exception exception = assertThrows(IllegalArgumentException.class, executable);
            assertEquals("lowerBoundIndex should not be negative: -1", exception.getMessage());
        }

        @Test
        void searchInSortedArray_whenUpperBoundTooHigh_thenExceptionThrown() {
            // Setup
            int[] arrayToSearch = new int[]{-80, -50, 0, 1, 10, 15, 25, 50};

            // Execution
            Executable executable = ()-> BinarySearch.searchInSortedArray(arrayToSearch, 0, arrayToSearch.length, 50);

            // Validation
            Exception exception = assertThrows(IllegalArgumentException.class, executable);
            assertEquals("upperBoundIndex (8) should be less than array length (8)", exception.getMessage());
        }

        @Test
        void searchInSortedArray_whenLowerAndUpperBoundsReversed_thenExceptionThrown() {
            // Setup
            int[] arrayToSearch = new int[]{-80, -50, 0, 1, 10, 15, 25, 50};

            // Execution
            Executable executable = ()-> BinarySearch.searchInSortedArray(arrayToSearch, arrayToSearch.length-1, 0, 50);

            // Validation
            Exception exception = assertThrows(IllegalArgumentException.class, executable);
            assertEquals("upperBoundIndex (0) should not be less than lowerBoundIndex (7)", exception.getMessage());
        }


        @Test
        void searchInSortedArray_whenUpperBoundIndexNegative_thenExceptionThrown() {
            // Setup
            int[] arrayToSearch = new int[]{-80, -50, 0, 1, 10, 15, 25, 50};

            // Execution
            Executable executable = ()-> BinarySearch.searchInSortedArray(arrayToSearch, arrayToSearch.length-1, -1, 50);

            // Validation
            Exception exception = assertThrows(IllegalArgumentException.class, executable);
            assertEquals("upperBoundIndex should not be negative: -1", exception.getMessage());
        }
    }
}