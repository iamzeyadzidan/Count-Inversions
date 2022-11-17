package merge_sort;

import java.util.Arrays;

public class Runner {
    public static void main (String[] args) {
        int[] array = {1, 5, 9, 20, 30, 2, 3, 6, 7, 25};
        CountingInversions countingInversions = new CountingInversions();
        countingInversions.countInversions(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
        System.out.println("Inversions Count = " + countingInversions.getCount());
    }
}
