package com.example.demo.neetcode.top150;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
    // ... your code
    return encoded_string;
}
Machine 2 (receiver) has the function:

vector<string> decode(string s) {
    //... your code
    return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

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

Constraints:

0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains any possible characters out of 256 valid ASCII characters.

Follow up: Could you write a generalized algorithm to work on any possible set of characters?
 */
public class EncodeDecodeString {

    public String encode(List<String> strs) {
        return strs.stream().map(text -> {
            if (text.isEmpty()) return "empty";
            byte[] bytes = text.getBytes();
            return Base64.getEncoder().encodeToString(bytes);
        }).collect(Collectors.joining(";"));
    }

    public List<String> decode(String str) {
        return Arrays.stream(str.split(";"))
                .filter(text -> !text.isEmpty())
                .map(base64 -> {
                    if (base64.equals("empty")) return "";
                    byte[] bytes = Base64.getDecoder().decode(base64);
                    return new String(bytes);
                })
                .toList();
    }
}
