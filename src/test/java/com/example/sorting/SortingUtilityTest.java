package com.example.sorting;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class SortingUtilityTest {

    // Reusable helper for all Comparable types
    private <T extends Comparable<T>> void testAllSorts(T[] input, T[] expected) {

        T[] gnome = Arrays.copyOf(input, input.length);
        T[] cocktail = Arrays.copyOf(input, input.length);
        T[] shell = Arrays.copyOf(input, input.length);

        SortingUtility.gnomeSort(gnome);
        SortingUtility.cocktailShakerSort(cocktail);
        SortingUtility.shellSort(shell);

        assertArrayEquals(expected, gnome, "Gnome Sort failed");
        assertArrayEquals(expected, cocktail, "Cocktail Shaker Sort failed");
        assertArrayEquals(expected, shell, "Shell Sort failed");
    }

    // =========================
    // INTEGER TESTS
    // =========================

    @Test
    void testEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        testAllSorts(input, expected);
    }

    @Test
    void testSingleElement() {
        Integer[] input = {5};
        Integer[] expected = {5};
        testAllSorts(input, expected);
    }

    @Test
    void testAlreadySorted() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        testAllSorts(input, expected);
    }

    @Test
    void testReverseSorted() {
        Integer[] input = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};
        testAllSorts(input, expected);
    }

    @Test
    void testDuplicates() {
        Integer[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};
        testAllSorts(input, expected);
    }

    @Test
    void testAllSameElements() {
        Integer[] input = {5, 5, 5, 5, 5};
        Integer[] expected = {5, 5, 5, 5, 5};
        testAllSorts(input, expected);
    }

    @Test
    void testTwoElementsSwapped() {
        Integer[] input = {2, 1};
        Integer[] expected = {1, 2};
        testAllSorts(input, expected);
    }

    @Test
    void testTwoElementsSorted() {
        Integer[] input = {1, 2};
        Integer[] expected = {1, 2};
        testAllSorts(input, expected);
    }

    @Test
    void testRandomOrder() {
        Integer[] input = {64, 34, 25, 12, 22, 11, 90};
        Integer[] expected = {11, 12, 22, 25, 34, 64, 90};
        testAllSorts(input, expected);
    }

    // =========================
    // STRING TESTS
    // =========================

    @Test
    void testStringArray() {
        String[] input = {"zebra", "apple", "mango", "banana"};
        String[] expected = {"apple", "banana", "mango", "zebra"};
        testAllSorts(input, expected);
    }

    @Test
    void testStringCaseSensitivity() {
        String[] input = {"Banana", "apple", "Apple"};
        String[] expected = {"Apple", "Banana", "apple"};
        testAllSorts(input, expected);
    }

    @Test
    void testStringDuplicates() {
        String[] input = {"cat", "dog", "cat", "bird"};
        String[] expected = {"bird", "cat", "cat", "dog"};
        testAllSorts(input, expected);
    }

    // =========================
    // ADDITIONAL EDGE CASES
    // =========================

    @Test
    void testNegativeNumbers() {
        Integer[] input = {-3, -1, -7, 4, 2};
        Integer[] expected = {-7, -3, -1, 2, 4};
        testAllSorts(input, expected);
    }

    @Test
    void testLargeValues() {
        Integer[] input = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE};
        Integer[] expected = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        testAllSorts(input, expected);
    }

    @Test
    void testNearlySortedSingleDisplacement() {
        Integer[] input = {1, 2, 3, 5, 4};
        Integer[] expected = {1, 2, 3, 4, 5};
        testAllSorts(input, expected);
    }

    @Test
    void testAlternatingHighLowPattern() {
        Integer[] input = {1, 100, 2, 99, 3, 98};
        Integer[] expected = {1, 2, 3, 98, 99, 100};
        testAllSorts(input, expected);
    }

    @Test
    void testRandomLargeArray() {
        Integer[] input = new Integer[100];
        Random rand = new Random();

        for (int i = 0; i < input.length; i++) {
            input[i] = rand.nextInt(1000);
        }

        Integer[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);

        testAllSorts(input, expected);
    }
}