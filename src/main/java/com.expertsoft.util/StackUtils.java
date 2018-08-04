package com.expertsoft.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StackUtils {

    private static final Map<Character, Character> BRACKETS = Map.of(
            '(', ')',
            '[', ']',
            '{', '}',
            '<', '>');

    public static <T> List<T> reverse(List<T> data) {
        var stack = new Stack<T>();
        data.forEach(stack::push);

        var result = new ArrayList<T>();

        while (!stack.empty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static boolean checkBrackets(String s) {
        var stack = new Stack<Character>();

        for (var c : s.toCharArray()) {
            if (BRACKETS.keySet().contains(c)) {
                stack.push(c);
            } else if (BRACKETS.values().contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                var ch = stack.pop();
                if (!BRACKETS.get(ch).equals(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
