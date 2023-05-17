package codingchica.sorting.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IndexUtilsTest {

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
            IndexUtils result = new IndexUtils();

            // Validation
            assertNotNull(result);
        }
    }

    /**
     * Unit tests for the getMidPoint method.
     *
     * @see IndexUtils#getMidPoint(int, int)
     */
    @Nested
    public class GetMidPointTests {
        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void getMidPoint_whenEqual_thenSameReturned(int value) {
            // Setup

            // Execution
            int result = IndexUtils.getMidPoint(value, value);

            // Validation
            assertEquals(value, result);
        }

        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void getMidPoint_whenLeftOneLessThanRight_thenLeftReturned(int value) {
            // Setup

            // Execution
            int result = IndexUtils.getMidPoint(value, value + 1);

            // Validation
            assertEquals(value, result);
        }

        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void getMidPoint_whenLeftOneGreaterThanRight_thenLeftReturned(int value) {
            // Setup
            Random random = new Random();
            int additionalAmount = random.nextInt(1, 100);

            // Execution
            Executable executable = () -> IndexUtils.getMidPoint(value + additionalAmount, value);

            // Validation
            Exception exception = assertThrows(IllegalArgumentException.class, executable);
            assertEquals(String.format("RightIndex (%s) must not be less than leftIndex (%s)", value, value + additionalAmount), exception.getMessage());
        }

        @ParameterizedTest
        @ValueSource(ints = {10000, 10, 100, 5, 3, 2, 1})
        void getMidPoint_whenLeftTwoLessThanRight_thenLeftReturned(int value) {
            // Setup

            // Execution
            int result = IndexUtils.getMidPoint(value, value + 2);

            // Validation
            assertEquals(value + 1, result);
        }
    }
}