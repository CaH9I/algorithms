package com.expertsoft.matcher;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.Comparator;

import static java.lang.String.format;
import static java.util.Comparator.naturalOrder;

public class ArrayIsSorted<T extends Comparable<? super T>> extends TypeSafeMatcher<T[]> {

    private Comparator<T> comparator;

    public ArrayIsSorted() {
        this(naturalOrder());
    }

    public ArrayIsSorted(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(format("sorter by %s", comparator == naturalOrder() ? "natural order" : comparator));
    }

    @Override
    protected boolean matchesSafely(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (comparator.compare(a[i], a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
