package com.example.demo.neetcode.top150;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: s = "racecar", t = "carrace"

Output: true
Example 2:

Input: s = "jar", t = "jam"

Output: false
Constraints:

s and t consist of lowercase English letters.
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> characterOccurrences = new HashMap<>();
        if (s.length() != t.length()) return false;

        traverseString(s, characterOccurrences, 1);
        traverseString(t, characterOccurrences, -1);

        return  characterOccurrences.isEmpty();
    }

    private static void traverseString(String input, Map<Character, Integer> characterOccurrences, int counterUpdate) {
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            characterOccurrences.merge(character, counterUpdate, (currentValue, increment) -> {
                int remainingOccurrences = currentValue + increment;
                if (remainingOccurrences == 0) return null;
                return remainingOccurrences;
            });
        }
    }
}
