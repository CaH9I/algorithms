package com.expertsoft.util;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.max;

public class MaxSubArray {

    static class MaxSubArrayData {
        long[] array;
        int start;
        int end;
        long sum;

        public static MaxSubArrayData of(long[] array, int start, int end, long sum) {
            MaxSubArrayData result = new MaxSubArrayData();
            result.array = array;
            result.start = start;
            result.end = end;
            result.sum = sum;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MaxSubArrayData that = (MaxSubArrayData) o;
            return start == that.start &&
                    end == that.end &&
                    sum == that.sum &&
                    Arrays.equals(array, that.array);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(start, end, sum);
            result = 31 * result + Arrays.hashCode(array);
            return result;
        }

        @Override
        public String toString() {
            return "MaxSubArrayData{" +
                    "array=" + Arrays.toString(array) +
                    ", start=" + start +
                    ", end=" + end +
                    ", sum=" + sum +
                    '}';
        }
    }

    public static long[] maxSubArrayN2(long[] a) {
        int start = 0;
        int end = 0;
        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            long current = 0;
            for (int j = i; j < a.length; j++) {
                current += a[j];
                if (current > maxSum) {
                    maxSum = current;
                    start = i;
                    end = j;
                }
            }
        }
        return Arrays.copyOfRange(a, start, end + 1);
    }

    public static MaxSubArrayData maxSubArrayNLogN(long[] a) {
        if (a.length > 1) {
            int mid = a.length / 2;
            MaxSubArrayData left = maxSubArrayNLogN(Arrays.copyOfRange(a, 0, mid));
            MaxSubArrayData right = maxSubArrayNLogN(Arrays.copyOfRange(a, mid, a.length));
            return maxSubArray(left, right);
        }

        return MaxSubArrayData.of(a, 0, 0, a[0]);
    }

    private static MaxSubArrayData maxSubArray(MaxSubArrayData left, MaxSubArrayData right) {
        long maxLeftSum = left.array[left.array.length - 1];
        int leftIndex = left.array.length - 1;
        long leftSum = 0;
        for (int i = left.array.length - 1; i > left.end; i--) {
            leftSum += left.array[i];

            if (leftSum > maxLeftSum) {
                maxLeftSum = leftSum;
                leftIndex = i;
            }
        }

        if ((left.sum + leftSum) > maxLeftSum) {
            maxLeftSum = left.sum + leftSum;
            leftIndex = left.start;
        }

        long maxRightSum = right.array[0];
        int rightIndex = 0;
        long rightSum = 0;
        for (int i = 0; i < right.start; i++) {
            rightSum += right.array[i];

            if (rightSum > maxRightSum) {
                maxRightSum = rightSum;
                rightIndex = i;
            }
        }

        if ((rightSum + right.sum) > maxRightSum) {
            maxRightSum = rightSum + right.sum;
            rightIndex = right.end;
        }

        MaxSubArrayData result = new MaxSubArrayData();
        result.array = merge(left.array, right.array);
        result.sum = max(max(left.sum, right.sum), maxLeftSum + maxRightSum);

        if (result.sum == left.sum) {
            result.start = left.start;
            result.end = left.end;
        } else if (result.sum == right.sum) {
            result.start = left.array.length + right.start;
            result.end = left.array.length + right.end;
        } else {
            result.start = leftIndex;
            result.end = left.array.length + rightIndex;
        }

        return result;
    }

    private static long[] merge(long[] left, long[] right) {
        long[] result = new long[left.length + right.length];

        System.arraycopy(left, 0, result, 0, left.length);
        System.arraycopy(right, 0, result, left.length, right.length);

        return result;
    }
}
