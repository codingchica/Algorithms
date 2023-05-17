package codingchica.sorting.bigo.polynomial;

import codingchica.sorting.util.CompareToObjects;

/**
 * An implementation of bubble sort.
 */
public class BubbleSort {
    /**
     * Example bubble sort implementation.
     * Time complexity: O(n^2) - The inner loop happens once for every item in the outer loop.<br />
     * Space complexity:  O(1) - the array is modified in-place and returned for convenience.
     *
     * @param arrayToSort The array that should be sorted - in place.
     * @param <T>         The class that is being utilized for the generic implementation.
     * @return The same array that is being sorted, just for convenience.
     */
    public static <T extends Comparable> T[] sort(T[] arrayToSort) {
        if (arrayToSort != null) {
            for (int outerIndex = 0; outerIndex < arrayToSort.length; outerIndex++) {
                for (int innerIndex = 1; innerIndex < arrayToSort.length - outerIndex; innerIndex++) {
                    T lastValue = arrayToSort[innerIndex - 1];
                    T currentValue = arrayToSort[innerIndex];

                    if (CompareToObjects.compareToWithNulls(lastValue, currentValue) > 0) {
                        arrayToSort[innerIndex] = lastValue;
                        arrayToSort[innerIndex - 1] = currentValue;
                    }
                }
            }
        }
        return arrayToSort;
    }
}
