package codingchica.search;

import codingchica.sorting.util.IndexUtils;

/**
 * An example of a recursive implementation of binary search in an array of ints.
 */
public class BinarySearch {
    /**
     * In reality, in a production environment, I would not suggest spending the time to implement this directly.
     * Rather, using an existing library implementation with the desired performance is a much better choice when available.
     *
     * @param arrayToSearch   The array to search.  This must be sorted.
     * @param lowerBoundIndex The lower bound/index of the sub-array to search.  To begin, this should be set to 0.
     * @param upperBoundIndex The upper bound/index of the sub-array to search.  To begin, this should be set to length-1.
     * @param valueToFind     The value to find in the sorted array.
     * @return Returns -1 if there was an issue with the inputs or the value was not found.  Otherwise, the return value will be the index of the element found.
     * @see java.util.Arrays#binarySearch(int[], int, int, int)
     */
    public static int searchInSortedArray(int[] arrayToSearch, int lowerBoundIndex, int upperBoundIndex, int valueToFind) {
        int matchingIndex = -1;
        if (arrayToSearch == null || arrayToSearch.length == 0) {
            return matchingIndex;
        }
        if (lowerBoundIndex < 0) {
            throw new IllegalArgumentException(String.format("lowerBoundIndex should not be negative: %s", lowerBoundIndex));
        }
        if (upperBoundIndex < 0) {
            throw new IllegalArgumentException(String.format("upperBoundIndex should not be negative: %s", upperBoundIndex));
        }
        if (upperBoundIndex >= arrayToSearch.length) {
            throw new IllegalArgumentException(String.format("upperBoundIndex (%s) should be less than array length (%s)", upperBoundIndex, arrayToSearch.length));
        }
        if (lowerBoundIndex > upperBoundIndex) {
            throw new IllegalArgumentException(String.format("upperBoundIndex (%s) should not be less than lowerBoundIndex (%s)", upperBoundIndex, lowerBoundIndex));
        }

        int midPoint = IndexUtils.getMidPoint(lowerBoundIndex, upperBoundIndex);
        int valueAtMidpoint = arrayToSearch[midPoint];

        if (valueAtMidpoint == valueToFind) {
            matchingIndex = midPoint;
        } else if (valueToFind < valueAtMidpoint) {
            if (midPoint == upperBoundIndex) {
                midPoint--;
            }
            if (lowerBoundIndex <= midPoint) {
                matchingIndex = searchInSortedArray(arrayToSearch, lowerBoundIndex, midPoint, valueToFind);
            }
        } else {
            if (midPoint == lowerBoundIndex) {
                midPoint++;
            }
            if (midPoint <= upperBoundIndex) {
                matchingIndex = searchInSortedArray(arrayToSearch, midPoint, upperBoundIndex, valueToFind);
            }
        }
        return matchingIndex;
    }
}
