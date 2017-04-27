package com.aparamonov.algostructure.sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by AVParamonov on 05.04.17.
 */
public class MergesortTest {

    private int[] numbers;
    private final static int SIZE = 10000000;
    private final static int MAX = 100;
    private Mergesort mergesort;

    @Before
    public void setUp() {
        mergesort = new Mergesort();
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testNull() {
        mergesort.sort(null);
    }

    @Test
    public void testEmpty() {
        mergesort.sort(new int[0]);
    }

    @Test
    public void testOneElement() {
        int[] test = new int[1];
        test[0] = 5;
        mergesort.sort(test);
    }

    @Test
    public void testDuplicated() {
        int[] test = { 3, 3, 4, 6, 5, 6, 4, 7, 7, 4, 6, 7, 5, 5, 3 };
        mergesort.sort(test);

        assertTrue(isSorted(test));
    }

    @Test
    public void testMergesort() {
        System.out.println("Sorting an array of integers of size: " + SIZE);
        long startTime = System.currentTimeMillis();

        mergesort.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Mergesort took: " + elapsedTime);

        assertTrue(isSorted(numbers));
    }

    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
