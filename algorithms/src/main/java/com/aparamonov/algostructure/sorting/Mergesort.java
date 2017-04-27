package com.aparamonov.algostructure.sorting;

/**
 * Created by AVParamonov on 05.04.17.
 */
public class Mergesort {
    private int[] numbers;
    private int[] temp;

    public void sort(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        numbers = values;
        temp = new int[values.length];
        mergesort(0, values.length - 1);
    }

    private void mergesort(int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergesort(left, middle);
            mergesort(middle + 1, right);
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        System.arraycopy(numbers, left, temp, left, right + 1 - left);

        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (temp[i] <= temp[j]) {
                numbers[k] = temp[i];
                i++;
            } else {
                numbers[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = temp[i];
            k++;
            i++;
        }
    }

}
