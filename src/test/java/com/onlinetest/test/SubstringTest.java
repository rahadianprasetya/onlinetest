package com.onlinetest.test;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @Author ian
 * @create 06/02/25 12.09
 */
public class SubstringTest {

    public static int findShortestSubstring(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c); // Collect all unique characters
        }

        int requiredUniqueCount = uniqueChars.size();
        int left = 0, minLength = Integer.MAX_VALUE;
        int[] charCount = new int[256]; // To track character frequencies
        int uniqueFound = 0;

        for (int right = 0; right < s.length(); right++) {
            if (charCount[s.charAt(right)] == 0) {
                uniqueFound++; // New unique character found
            }
            charCount[s.charAt(right)]++;

            while (uniqueFound == requiredUniqueCount) {
                minLength = Math.min(minLength, right - left + 1);

                // Try to shrink the window from the left
                charCount[s.charAt(left)]--;
                if (charCount[s.charAt(left)] == 0) {
                    uniqueFound--; // Lost a unique character
                }
                left++;
            }
        }

        return minLength;
    }
    @Test
    public void runSub(){
        String s = "abc";
        System.out.println(findShortestSubstring(s));
    }
}
