package merge_sort;

import java.util.Arrays;

public class CountingInversions {
    private int count = 0;

    public int getCount() {
        return this.count;
    }

    /**
     * Modified merge sort algorithm to count the number of pairs(i, j) such that:
     * array[i] > array[j] and i < j.
     * @param array the array to find the number of inversions.
     * @param first index of lower bound of the array.
     * @param last index of upper bound of the array.
     *
     * Sorts the array using merge sort and modifies the count of inversions made.
     * */
    public void countInversions(int[] array, int first, int last) {
        if (last <= first)
            return;

        int mid = (first + last) / 2;
        countInversions(array, first, mid);
        countInversions(array, mid + 1, last);
        modifiedMergeSort(array, first, mid, last);
    }

    private void modifiedMergeSort(int[] array, int first, int mid, int last) {
        int size1 = mid - first + 1;
        int size2 = last - mid;

        int[] left = new int[size1];
        int[] right = new int[size2];

        for (int i = 0; i < size1; i++)
            left[i] = array[first + i];
        for (int i = 0; i < size2; i++)
            right[i] = array[mid + 1 + i];

        int i = 0, j = 0, k = first;
        while (i < size1 && j < size2) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            }
            else {
                this.count += size1 - i;
                array[k++] = right[j++];
            }
        }
        while (i < size1)
            array[k++] = left[i++];
        while (j < size2)
            array[k++] = right[j++];
    }
}
