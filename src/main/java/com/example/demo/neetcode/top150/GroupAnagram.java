package com.example.demo.neetcode.top150;

import java.util.*;

/*
Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: strs = ["act","pots","tops","cat","stop","hat"]

Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
Example 2:

Input: strs = ["x"]

Output: [["x"]]
Example 3:

Input: strs = [""]

Output: [[""]]
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] wordCount;
        Map<Integer, List<String>> result = new HashMap<>();

        for (String string: strs) {
            wordCount = new int[128];
            for (int i = 0; i < string.length(); i++) {
                char code = string.charAt(i);
                wordCount[code] = wordCount[code] + 1;
            }
            int hashCode = Arrays.hashCode(wordCount);
            result.computeIfAbsent(hashCode, (key) -> new ArrayList<>());
            result.compute(hashCode, (key, value) -> {
                value.add(string);
                return value;
            });
        }

        return new ArrayList<>(result.values());
    }
}
