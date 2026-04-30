package com.example.demo.neetcode.top150;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
Example 1:

Input: s = "racecar", t = "carrace"

Output: true
Example 2:

Input: s = "jar", t = "jam"

Output: false
 */
class AnagramTest {

    private Anagram anagram;

    @BeforeEach
    public void setup() {
        anagram = new Anagram();
    }

    @ParameterizedTest
    @EnumSource(TestCase.class)
    public void test(TestCase testCase) {
        // given

        // when
        boolean result = anagram.isAnagram(testCase.string1, testCase.string2);

        // then
        assertThat(result).isEqualTo(testCase.isAnagram);

    }

    enum TestCase {
        CASE_1("racecar", "carrace", true),
        CASE_2("jar", "jam", false);

        private final String string1;
        private final String string2;
        private final boolean isAnagram;

        TestCase(String string1, String string2, boolean isAnagram) {
            this.string1 = string1;
            this.string2 = string2;
            this.isAnagram = isAnagram;
        }
    }

}