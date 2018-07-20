package com.expertsoft.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import static java.util.Collections.unmodifiableMap;

public class StackUtils {

    private static final Map<Character, Character> BRACKETS;

    static {
        Map<Character, Character> tmp = new HashMap<>();
        tmp.put('(', ')');
        tmp.put('[', ']');
        tmp.put('{', '}');
        tmp.put('<', '>');
        BRACKETS = unmodifiableMap(tmp);
    }

    public static <T> List<T> reverse(List<T> data) {
        Stack<T> stack = new Stack<>();
        data.forEach(stack::push);

        List<T> result = new ArrayList<>();

        while (!stack.empty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static boolean checkBrackets(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (BRACKETS.keySet().contains(c)) {
                stack.push(c);
            } else if (BRACKETS.values().contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character ch = stack.pop();
                if (!BRACKETS.get(ch).equals(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
