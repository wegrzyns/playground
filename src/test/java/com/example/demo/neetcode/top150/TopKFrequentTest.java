package com.example.demo.neetcode.top150;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
Example 1:

Input: nums = [1,2,2,3,3,3], k = 2

Output: [2,3]
Example 2:

Input: nums = [7,7], k = 1

Output: [7]
Constraints:

1 <= nums.length <= 10^4.
-1000 <= nums[i] <= 1000
1 <= k <= number of distinct elements in nums.
 */
class TopKFrequentTest {

    private TopKFrequent topKFrequent;

    @BeforeEach
    public void setup() {
        topKFrequent = new TopKFrequent();
    }

    @ParameterizedTest
    @EnumSource(TestCase.class)
    public void test(TestCase testCase) {
        // given

        // when
        var result = topKFrequent.topKFrequent(testCase.nums, testCase.topK);

        // then
        assertThat(result).containsExactlyInAnyOrder(testCase.result);
    }

    enum TestCase {
        CASE_1(array(1,2,2,3,3,3), 2, array(2,3)),
        CASE_2(array(7,7), 1, array(7));

        private final int[] nums;
        private final int topK;
        private final int[] result;

        TestCase(int[] nums, int topK, int[] result) {
            this.nums = nums;
            this.topK = topK;
            this.result = result;
        }

        private static int[] array(int... values) {
            return values;
        }
    }


}