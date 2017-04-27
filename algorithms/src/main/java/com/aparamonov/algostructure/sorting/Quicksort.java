package com.aparamonov.algostructure.sorting;

/**
 * Created by AVParamonov on 05.04.17.
 */
public class Quicksort {
    private int[] numbers;

    public void sort(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        numbers = values;
        quicksort(0, values.length - 1);
    }

    private void quicksort(int left, int right) {
        int i = left;
        int j = right;
        int pivot = numbers[left + (right-left)/2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (left < j)
            quicksort(left, j);
        if (i < right)
            quicksort(i, right);
    }

    private void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
