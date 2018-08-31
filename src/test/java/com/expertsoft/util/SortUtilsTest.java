package com.expertsoft.util;

import com.expertsoft.matcher.ArrayIsSorted;
import org.junit.Test;

import java.util.Random;

import static java.util.Comparator.naturalOrder;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SortUtilsTest {

    @Test
    public void bubbleSort() {
        Long[] array = {9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L};

        SortUtils.bubbleSort(array, naturalOrder());

        assertThat(array, new ArrayIsSorted<>());
    }

    @Test
    public void selectSort() {
        Long[] array = {9L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L};

        SortUtils.selectSort(array, naturalOrder());

        assertThat(array, new ArrayIsSorted<>());
    }

    @Test
    public void insertSort() {
        Long[] array = {9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L};

        SortUtils.insertSort(array, naturalOrder());

        assertThat(array, new ArrayIsSorted<>());
    }

    @Test
    public void mergeSort() {
        Long[] randomArray = new Random().longs(1000000).boxed().toArray(Long[]::new);

        assertThat(SortUtils.mergeSort(randomArray), new ArrayIsSorted<>());
        assertThat(SortUtils.mergeSort(new Long[] {3L, -5L, 4L, 2L, 8L, 9L, 0L, -4L, 4L}), is(new Long[] {-5L, -4L, 0L, 2L, 3L, 4L, 4L, 8L, 9L}));
    }
}