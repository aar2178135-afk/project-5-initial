package com.example.sorting;

public class SortingUtility {

    // =========================
    // Part A: Gnome Sort
    // =========================
    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        // TODO implement Gnome Sort here

        int pos = 0;

        while (pos < a.length) {
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos = pos + 1;
            } else {
                swap(a, pos, pos - 1);
                pos = pos - 1;
            }
        }
    }

    // =========================
    // Part B: Cocktail Shaker Sort
    // =========================
    public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {
        // TODO implement Cocktail Shaker Sort here

        boolean swapped;

        do {
            swapped = false;

            // forward pass
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;

            // backward pass
            for (int i = a.length - 2; i >= 0; i--) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

        } while (swapped);
    }

    // =========================
    // Part C: Shell Sort (Ciura Sequence)
    // =========================
    public static <T extends Comparable<T>> void shellSort(T[] a) {
        // TODO implement Shell Sort here

        int n = a.length;

        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

        for (int gap : gaps) {

            for (int i = gap; i < n; i++) {

                T temp = a[i];
                int j;

                for (j = i; j >= gap && a[j - gap].compareTo(temp) > 0; j -= gap) {
                    a[j] = a[j - gap];
                }

                a[j] = temp;
            }
        }
    }

    // =========================
    // Swap helper (provided)
    // =========================
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}


