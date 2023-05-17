package codingchica.sorting.bigo.polynomial;

import codingchica.sorting.util.CompareToObjects;
import codingchica.sorting.util.IndexUtils;

/**
 * An implementation of the quick sort algorithm with worst-case n^2 time.
 */
public class QuickSort {

    /**
     * Sort the provided array using the quick sort algorithm.
     *
     * @param arrayToSort The array to sort.
     * @param <T>         The class that is being utilized for the generic implementation.
     * @return The same array that is being sorted, just for convenience.
     */
    public static <T extends Comparable> T[] sort(T[] arrayToSort) {
        int lowIndex = 0;
        int highIndex = 0;
        if (arrayToSort != null) {
            highIndex = arrayToSort.length - 1;
        }

        sort(arrayToSort, lowIndex, highIndex);
        return arrayToSort;
    }
    /**
     * Sort the sub-section of the array, between the two index values provided, inclusively.
     *
     * @param arrayToSort The array to sort.
     * @param lowIndex    The left-most/smallest index value to sort, inclusive.
     * @param highIndex   The right-most/largest index value to sort, inclusive.
     */
    private static <T extends Comparable> void sort(T[] arrayToSort, int lowIndex, int highIndex) {
        int lastIndexSmaller = lowIndex - 1;
        T tempValue;
        if (arrayToSort != null) {
            if (lowIndex < highIndex) {
                // By choosing the end of the array as the partition, the time complexity O(n^2)
                // Will have to loop over the entire array multiple times
                T partitionValue = arrayToSort[highIndex];

                for (int currentIndex = lowIndex; currentIndex < highIndex; currentIndex++) {
                    T currentValue = arrayToSort[currentIndex];

                    // Current value <= pivot value
                    if (CompareToObjects.compareToWithNulls(currentValue, partitionValue) <= 0) {
                        lastIndexSmaller++;
                        if (lastIndexSmaller < currentIndex) {
                            tempValue = arrayToSort[currentIndex];
                            arrayToSort[currentIndex] = arrayToSort[lastIndexSmaller];
                            arrayToSort[lastIndexSmaller] = tempValue;
                        }
                    }
                }

                // Put the partition value in the right place
                lastIndexSmaller++;
                tempValue = arrayToSort[highIndex];
                arrayToSort[highIndex] = arrayToSort[lastIndexSmaller];
                arrayToSort[lastIndexSmaller] = tempValue;

                // Recurse and sort the newly sectioned data
                sort(arrayToSort, lowIndex, lastIndexSmaller - 1);
                sort(arrayToSort, lastIndexSmaller + 1, highIndex);
            }
        }
    }
}
