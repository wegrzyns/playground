package com.example.demo.neetcode.top150;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
Example 1:

Input: dummy_input = ["Hello","World"]

Output: ["Hello","World"]

Explanation:
Machine 1:
Codec encoder = new Codec();
String msg = encoder.encode(strs);
Machine 1 ---msg---> Machine 2

Machine 2:
Codec decoder = new Codec();
String[] strs = decoder.decode(msg);
Example 2:

Input: dummy_input = [""]

Output: [""]
 */
class EncodeDecodeStringTest {

    private EncodeDecodeString encodeDecodeString;

    @BeforeEach
    public void setup() {
        encodeDecodeString = new EncodeDecodeString();
    }

    @ParameterizedTest
    @EnumSource(TestCase.class)
    public void test(TestCase testCase) {
        // given

        // when
        String medium = encodeDecodeString.encode(testCase.input);
        List<String> decoded = encodeDecodeString.decode(medium);

        // then
        assertThat(decoded).isEqualTo(testCase.input);
    }

    enum TestCase {
        CASE_1(List.of("Hello","World")),
        CASE_2(List.of(""));

        private final List<String> input;

        TestCase(List<String> input) {
            this.input = input;
        }
    }

}