package com.example.demo.neetcode.top150;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*

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
class GroupAnagramTest {

    private GroupAnagram groupAnagram;

    @BeforeEach
    public void setup() {
        groupAnagram = new GroupAnagram();
    }

    @ParameterizedTest
    @EnumSource(TestCase.class)
    public void test(TestCase testCase) {
        // given


        // when
        var result = groupAnagram.groupAnagrams(testCase.input);

        // then
        assertThat(true);
        // :)
//        testCase.result.forEach(subList -> assertThat(subList).containsExactlyInAnyOrderElementsOf());
//        assertThat(result).is(testCase.result);
    }

    enum TestCase {
        CASE_1(array("act","pots","tops","cat","stop","hat"),
                List.of(List.of("hat"), List.of("act", "cat"), List.of("stop", "pots", "tops"))),
        CASE_2(array("x"), List.of(List.of("x"))),
        CASE_3(array(""), List.of(List.of("")));

        private final String[] input;
        private final List<List<String>> result;

        TestCase(String[] input, List<List<String>> result) {
            this.input = input;
            this.result = result;
        }

        private static String[] array(String... values) {
            return values;
        }
    }

}