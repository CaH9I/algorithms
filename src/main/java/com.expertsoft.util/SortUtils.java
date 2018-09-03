package com.expertsoft.util;

import java.util.Arrays;
import java.util.Comparator;

public class SortUtils {

    public static <T> void bubbleSort(T[] a, Comparator<T> comparator) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (comparator.compare(a[j + 1], a[j]) < 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static <T> void selectSort(T[] a, Comparator<T> comparator) {
        for (int i = 0; i < a.length - 1; i++) {

            int k = i;

            for (int j = i + 1; j < a.length; j++) {
                if (comparator.compare(a[j], a[k]) < 0) {
                    k = j;
                }
            }

            T temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }
    }

    public static <T> void insertSort(T[] a, Comparator<T> comparator) {
        for (int i = 1; i < a.length; i++) {

            T element = a[i];
            int j;

            for (j = i; j > 0; j--) {
                if (comparator.compare(element, a[j - 1]) < 0) {
                    a[j] = a[j - 1];
                } else {
                    break;
                }
            }

            a[j] = element;
        }
    }

    public static Long[] mergeSort(Long[] a) {
        if (a.length > 1) {
            int mid = a.length / 2;
            Long[] left = mergeSort(Arrays.copyOfRange(a, 0, mid));
            Long[] right = mergeSort(Arrays.copyOfRange(a, mid, a.length));
            return merge(left, right);
        }

        return a;
    }

    private static Long[] merge(Long[] left, Long[] right) {
        Long[] result = new Long[left.length + right.length];
        int i = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while ((leftIndex < left.length) && (rightIndex < right.length)) {
            result[i++] = left[leftIndex] < right[rightIndex]
                    ? left[leftIndex++]
                    : right[rightIndex++];
        }

        while (leftIndex < left.length) {
            result[i++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            result[i++] = right[rightIndex++];
        }

        return result;
    }

    public static void quickSort(Long[] a, int p, int q) {
        if (p < q) {
            int m = partition(a, p, q);
            quickSort(a, p, m - 1);
            quickSort(a, m + 1, q);
        }
    }

    private static int partition(Long[] a, int p, int q) {
        int start = p;
        for (int i = p; i < q; i++) {
            if (a[i] <= a[q]) {
                swap(a, i, start++);
            }
        }
        swap(a, start, q);
        return start;
    }

    private static void swap(Long[] a, int i, int j) {
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}