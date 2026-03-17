package eru.testing;

public class DIF2Fixed {

    public static int findMin(int[] x) {
        if (x.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int min = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
            }
        }
        return min;
    }

    public static int countEven(int[] x) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int firstDuplicate(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] == x[j]) {
                    return x[i];
                }
            }
        }
        return -1;
    }
}
