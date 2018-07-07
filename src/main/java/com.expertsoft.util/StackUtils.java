package com.expertsoft.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackUtils {

    public static <T> List<T> reverse(List<T> data) {
        Stack<T> stack = new Stack<>();
        data.forEach(stack::push);

        List<T> result = new ArrayList<>();

        while (!stack.empty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
