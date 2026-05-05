package com.example.sorting;

public class SortingUtility {

    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        // TODO implement Gnome Sort here
        if (a == null || a.length < 2) {
            return;
        }

        int index = 1;

        while (index < a.length) {

            if (index == 0 || a[index].compareTo(a[index - 1]) >= 0) {
                index++;
            } else {
                swap(a, index, index - 1);
                index--;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {
// TODO implement Cocktail Shaker Sort here
        if (a == null || a.length < 2) {
            return;
        }

        boolean swapped = true;
        int start = 0;
        int end = a.length - 1;

        while (swapped) {

            swapped = false;

            for (int i = start; i < end; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;
            end--;

            for (int i = end; i > start; i--) {
                if (a[i].compareTo(a[i - 1]) < 0) {
                    swap(a, i, i - 1);
                    swapped = true;
                }
            }

            start++;
        }
    }


    public static <T extends Comparable<T>> void shellSort(T[] a) {

        // Shell Sort
        int n = a.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                T temp = a[i];
                int j = i;

                while (j >= gap && a[j - gap].compareTo(temp) > 0) {
                    a[j] = a[j - gap];
                    j -= gap;
                }

                a[j] = temp;
            }
        }
    }


    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}





