package com.example.demo.neetcode.top150;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/*
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

Example 1:

Input: nums = [1, 2, 3, 3]

Output: true

Example 2:

Input: nums = [1, 2, 3, 4]

Output: false
 */
class HasDuplicateTest {

    private HasDuplicate hasDuplicate;

    @BeforeEach
    void setup() {
        hasDuplicate = new HasDuplicate();
    }

    @ParameterizedTest
    @EnumSource(TestCase.class)
    public void test(TestCase testCase) {
        // when
        var result = hasDuplicate.hasDuplicate(testCase.input);

        // then
        assertThat(result).isEqualTo(testCase.output);
    }

    enum TestCase {
        CASE_1(array(1, 2, 3, 3), true),
        CASE_2(array(1, 2, 3, 4), false);

        private final int[] input;
        private final boolean output;

        TestCase(int[] input, boolean output) {
            this.input = input;
            this.output = output;
        }

        private static int[] array(int... values) {
            return values;
        }
    }

}