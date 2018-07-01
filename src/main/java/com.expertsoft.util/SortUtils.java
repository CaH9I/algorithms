package com.expertsoft.util;

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

}