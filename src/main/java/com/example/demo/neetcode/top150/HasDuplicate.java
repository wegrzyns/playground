package com.example.demo.neetcode.top150;

import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

Example 1:

Input: nums = [1, 2, 3, 3]

Output: true

Example 2:

Input: nums = [1, 2, 3, 4]

Output: false
 */
public class HasDuplicate {

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int number: nums) {
            if (numbers.contains(number)) return true;
            numbers.add(number);
        }

        return false;
    }
}
