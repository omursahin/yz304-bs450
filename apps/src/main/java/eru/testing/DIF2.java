package eru.testing;

public class DIF2 {

    /*
     *  If x == null throw a NullPointerException.
     *  If x is empty throw an IllegalArgumentException.
     *  Otherwise return the minimum value in x.
     */
    public static int findMin(int[] x) {
        if (x.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int min = 0;
        for (int i = 1; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
            }
        }
        return min;
    }

    /*
     *  If x == null throw a NullPointerException, else return
     *  the number of even elements in x.
     */
    public static int countEven(int[] x) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] % 2 != 1) {
                count++;
            }
        }
        return count;
    }

    /*
     *  If x == null throw a NullPointerException, else return
     *  true if x is sorted in ascending (non-decreasing) order.
     *  An empty array is considered sorted.
     */
    public static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] >= x[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /*
     *  If x == null throw a NullPointerException, else return
     *  the first value that appears more than once in x.
     *  If no duplicates exist, return -1.
     */
    public static int firstDuplicate(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = i; j < x.length; j++) {
                if (x[i] == x[j]) {
                    return x[i];
                }
            }
        }
        return -1;
    }
}
