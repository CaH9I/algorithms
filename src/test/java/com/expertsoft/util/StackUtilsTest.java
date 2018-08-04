package com.expertsoft.util;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackUtilsTest {

    @Test
    public void reverse() {
        var word = List.of('l', 'i', 'm', 'b', 'o');

        var reverseWord = StackUtils.reverse(word);

        assertEquals(List.of('o', 'b', 'm', 'i', 'l'), reverseWord);
    }

    @Test
    public void checkBrackets() {
        assertFalse(StackUtils.checkBrackets("a{b(c}d)e"));
        assertFalse(StackUtils.checkBrackets("a[b{c}d]e}"));
        assertFalse(StackUtils.checkBrackets("a{b(c)"));
        assertTrue(StackUtils.checkBrackets("no brackets"));
        assertTrue(StackUtils.checkBrackets("    public static boolean checkBrackets(String s) {" +
                "        Stack<Character> stack = new Stack<>();" +
                "        for (Character c : s.toCharArray()) {" +
                "            if (BRACKETS.keySet().contains(c)) {" +
                "                stack.push(c);" +
                "            } else if (BRACKETS.values().contains(c)) {" +
                "                if (stack.isEmpty()) {" +
                "                    return false;" +
                "                }" +
                "                Character ch = stack.pop();" +
                "                if (!BRACKETS.get(ch).equals(c)) {" +
                "                    return false;" +
                "                }" +
                "            }" +
                "        }" +
                "        return stack.isEmpty();" +
                "    }"));
    }
}
