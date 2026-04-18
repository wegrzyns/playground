package com.example.demo.leetcode.top100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 */
class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    void setup() {
        twoSum = new TwoSum();
    }

    @ParameterizedTest
    @EnumSource(TestCase.class)
    void twoSum(TestCase testCase) {
        // given
        int[] input = testCase.input;
        int target = testCase.target;

        // when
        var result = twoSum.twoSum(input, target);

        // then
        assertThat(result).containsExactly(testCase.result);
    }

    enum TestCase {
        CASE_1(array(2, 7, 11, 15), 9, array(0, 1)),
        CASE_2(array(3, 2, 4), 6, array(1, 2)),
        CASE_3(array(3, 3), 6, array(0, 1));

        private final int[] input;
        private final int target;
        private final int[] result;

        TestCase(int[] input, int target, int[] result) {
            this.input = input;
            this.target = target;
            this.result = result;
        }

        private static int[] array(int... values) {
            return values;
        }
    }
}