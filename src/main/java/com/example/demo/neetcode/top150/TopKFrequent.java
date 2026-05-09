package com.example.demo.neetcode.top150;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an integer array nums and an integer k, return the k most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.

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
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyCount = new HashMap<>();
        int[] result = new int[k];

        for (int number: nums) {
            frequencyCount.merge(number, 1, Integer::sum);
        }

        int i = 0;
        List<Integer> topFrequentNumbers = frequencyCount.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
        for (int topElement: topFrequentNumbers) {
            result[i++] = topElement;
        }
        return result;
    }
}
