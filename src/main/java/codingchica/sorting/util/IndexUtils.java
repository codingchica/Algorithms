package codingchica.sorting.util;

public class IndexUtils {

    /**
     * Determine the mid-point between two indices.
     *
     * @param leftIndex  The left-most / smaller index value.
     * @param rightIndex The right-most / larger index value.
     * @return The mid-point between the two indices.
     */
    public static int getMidPoint(int leftIndex, int rightIndex) {
        if (rightIndex < leftIndex) {
            throw new IllegalArgumentException(String.format("RightIndex (%s) must not be less than leftIndex (%s)", rightIndex, leftIndex));
        }
        int middleIndex = leftIndex;
        if (rightIndex > leftIndex + 1) {
            middleIndex = leftIndex + ((rightIndex - leftIndex) / 2);
        }
        return middleIndex;
    }
}
