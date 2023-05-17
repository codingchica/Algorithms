package codingchica.sorting.util;

/** Utility class to safely compare objects, which may be null. **/
public class CompareToObjects {

    /**
     * Compares two values, with nulls bubbled to the right/end.
     *
     * @param leftValue  The left value to compare.  Can be null.
     * @param rightValue The right value to compare.  Can be null.
     * @param <T>        The class that is being utilized for the generic implementation.
     * @return A int value that represents whether the left value is less than (negative), equal to (zero) or greater than (positive) the right value.
     */
    public static <T extends Comparable> int compareToWithNulls(T leftValue, T rightValue) {
        return compareToWithNulls(leftValue, rightValue, true);
    }

    /**
     * Compares two values, with nulls bubbled to the right/end.
     *
     * @param leftValue    The left value to compare.  Can be null.
     * @param rightValue   The right value to compare.  Can be null.
     * @param nullsToRight Whether nulls should be placed on the right-side of the non-null values.
     * @param <T>          The class that is being utilized for the generic implementation.
     * @return A int value that represents whether the left value is less than (negative), equal to (zero) or greater than (positive) the right value.
     */
    public static <T extends Comparable> int compareToWithNulls(T leftValue, T rightValue, boolean nullsToRight) {
        int multiplier = -1;
        if (nullsToRight) {
            multiplier = 1;
        }
        int comparison = -1 * multiplier;
        if (leftValue == null) {
            comparison = multiplier;
        } else if (rightValue != null) {
            comparison = leftValue.compareTo(rightValue);
        }
        return comparison;
    }
}
