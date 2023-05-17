package codingchica.sorting.bigo.logarithmic;

import static codingchica.sorting.util.IndexUtils.getMidPoint;

import codingchica.sorting.util.CompareToObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * An implementation of merge sort.
 */
public class MergeSort {

    /**
     * Example merge sort implementation.
     *
     * @param arrayToSort The array to sort, in-place.  Will be modified.
     * @param <T>         The class that is being utilized for the generic implementation.
     * @return The same array that is being sorted, just for convenience.
     */
    public static <T extends Comparable> T[] sort(T[] arrayToSort) {
        if (arrayToSort != null && arrayToSort.length > 1) {
            int leftIndex = 0;
            int rightIndex = arrayToSort.length - 1;
            int middleIndex = getMidPoint(leftIndex, rightIndex);

            sort(arrayToSort, leftIndex, middleIndex);
            sort(arrayToSort, middleIndex + 1, rightIndex);
            merge(arrayToSort, leftIndex, middleIndex, rightIndex);
        }
        return arrayToSort;
    }

    /**
     * Sort a particular sub-section of the larger array, in-place.
     *
     * @param arrayToSort The array to sort/modify.
     * @param leftIndex   The left-most index of the section to sort.
     * @param rightIndex  The right-most index of the section to sort.
     * @param <T>         The class that is being utilized for the generic implementation.
     */
    static <T extends Comparable> void sort(T[] arrayToSort, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = getMidPoint(leftIndex, rightIndex);

            sort(arrayToSort, leftIndex, middleIndex);
            sort(arrayToSort, middleIndex + 1, rightIndex);
            merge(arrayToSort, leftIndex, middleIndex, rightIndex);
        }
    }

    /**
     * Merge two already-sorted sections of the array into a larger, unified section.
     *
     * @param arrayToSort The array containing partitions are being merged together into a sorted section.  Modified in-place.
     * @param leftIndex   The left-most index of the array for the two sorted subsections being merged together.
     * @param middleIndex The index that divides the left and right sorted subsections being merged together.
     * @param rightIndex  The right-most index of the array for the second sorted subsection being merged together.
     * @param <T>         The class that is being utilized for the generic implementation.
     */
    private static <T extends Comparable> void merge(T[] arrayToSort, int leftIndex, int middleIndex, int rightIndex) {
        List<T> tempLeft = new ArrayList<>(middleIndex - leftIndex);
        List<T> tempRight = new ArrayList<>(rightIndex - middleIndex);

        IntStream.range(leftIndex /* inclusive */, middleIndex + 1 /* exclusive */).forEachOrdered(index -> tempLeft.add(arrayToSort[index]));
        IntStream.range(middleIndex + 1 /* inclusive */, rightIndex + 1 /* exclusive */).forEachOrdered(index -> tempRight.add(arrayToSort[index]));

        int tempLeftIndex = 0;
        int tempRightIndex = 0;
        int index = leftIndex;

        // Combine the two halves until one is empty
        while (tempLeftIndex < tempLeft.size() && tempRightIndex < tempRight.size()) {
            T leftValue = tempLeft.get(tempLeftIndex);
            T rightValue = tempRight.get(tempRightIndex);

            if (CompareToObjects.compareToWithNulls(leftValue, rightValue) < 0) {
                arrayToSort[index] = leftValue;
                tempLeftIndex++;
            } else {
                arrayToSort[index] = rightValue;
                tempRightIndex++;
            }
            index++;
        }

        // Fill in the rest of the left, if that's what remains
        index = fillArrayFromList(arrayToSort, index, tempLeft, tempLeftIndex);
        fillArrayFromList(arrayToSort, index, tempRight, tempRightIndex);
    }

    /**
     * Fill the array's elements from a list of elements.
     *
     * @param arrayToSort            The array to populate with the elements.
     * @param startingFromArrayIndex The left-most index of the array to populate with elements from the list.
     * @param tempList               The list of elements to fill in the array.
     * @param startingFromListIndex  The starting index in the list of elements - from where we want to start consuming the elements (left-most).
     * @param <T>                    The class that is being utilized for the generic implementation.
     * @return The next index of the array that might be populated with values.
     */
    static <T extends Comparable> int fillArrayFromList(T[] arrayToSort, int startingFromArrayIndex, List<T> tempList, int startingFromListIndex) {
        int currentTempListIndex = startingFromListIndex;
        int currentArrayIndex = startingFromArrayIndex;

        if (arrayToSort != null && tempList != null) {
            while (currentArrayIndex < arrayToSort.length && currentTempListIndex < tempList.size()) {
                arrayToSort[currentArrayIndex] = tempList.get(currentTempListIndex++);
                currentArrayIndex++;
            }
        }
        return currentArrayIndex;
    }
}
