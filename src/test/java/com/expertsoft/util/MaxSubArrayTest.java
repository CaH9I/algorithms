package com.expertsoft.util;

import org.junit.Test;

import static com.expertsoft.util.MaxSubArray.MaxSubArrayData;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaxSubArrayTest {

    @Test
    public void maxSubArrayN2() {
        assertThat(MaxSubArray.maxSubArrayN2(new long[] {20, -3, 2, -4}), is(new long[] {20}));
        assertThat(MaxSubArray.maxSubArrayN2(new long[] {2, -3, 20, -4}), is(new long[] {20}));
        assertThat(MaxSubArray.maxSubArrayN2(new long[] {2, -3, -1, 40}), is(new long[] {40}));

        assertThat(MaxSubArray.maxSubArrayN2(new long[] {5, -3, -1, 40}), is(new long[] {5, -3, -1, 40}));
        assertThat(MaxSubArray.maxSubArrayN2(new long[] {5, -3, 4, -1}), is(new long[] {5, -3, 4}));
    }

    @Test
    public void maxSubArrayNLogN() {
        assertThat(MaxSubArray.maxSubArrayNLogN(new long[] {20, -3, 2, -4}), is(MaxSubArrayData.of(new long[] {20, -3, 2, -4},0, 0, 20)));
        assertThat(MaxSubArray.maxSubArrayNLogN(new long[] {2, -3, 20, -4}), is(MaxSubArrayData.of(new long[] {2, -3, 20, -4}, 2, 2, 20)));
        assertThat(MaxSubArray.maxSubArrayNLogN(new long[] {2, -3, -1, 40}), is(MaxSubArrayData.of(new long[] {2, -3, -1, 40}, 3, 3, 40)));

        assertThat(MaxSubArray.maxSubArrayNLogN(new long[] {5, -3, -1, 40}), is(MaxSubArrayData.of(new long[] {5, -3, -1, 40}, 0, 3, 41)));
        assertThat(MaxSubArray.maxSubArrayNLogN(new long[] {5, -3, 4, -1}), is(MaxSubArrayData.of(new long[] {5, -3, 4, -1}, 0, 2, 6)));
    }

}
