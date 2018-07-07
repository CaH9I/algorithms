package com.expertsoft.util;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StackUtilsTest {

    @Test
    public void reverse() {
        List<Character> word = asList('l', 'i', 'm', 'b', 'o');

        List<Character> reverseWord = StackUtils.reverse(word);

        assertEquals(asList('o', 'b', 'm', 'i', 'l'), reverseWord);
    }
}
