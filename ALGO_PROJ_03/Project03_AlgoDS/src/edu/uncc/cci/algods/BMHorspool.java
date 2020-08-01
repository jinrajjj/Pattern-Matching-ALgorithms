package edu.uncc.cci.algods;

import java.util.HashMap;

public class BMHorspool {
    public int[] horspoolAlgo(String text, String pattern) {
        HashMap<Character, Integer> shiftTable = new HashMap<>();
        int patternLength = pattern.length();
        for (int i = 0; i < patternLength; i++) {
            if (!shiftTable.containsKey(pattern.charAt(i)))
                shiftTable.put(pattern.charAt(i), patternLength);
        }
        for (int i = 0; i <= patternLength - 2; i++) {
            int charIndex = pattern.lastIndexOf(pattern.charAt(i));
            if (charIndex < patternLength - 1)
                shiftTable.replace(pattern.charAt(i), patternLength - 1 - charIndex);
            else
                shiftTable.replace(pattern.charAt(i), patternLength - 1 - i);
        }
        int i = patternLength - 1;
        int comparisionCount = 0;
        while (i < text.length()) {
            int k = 0;
            while (k < patternLength) {
                if (text.charAt(i - k) == pattern.charAt(patternLength - 1 - k)) {
                    comparisionCount++;
                    k++;
                    if (k == patternLength)
                        return new int[]{i - patternLength + 1, comparisionCount};
                } else {
                    comparisionCount++;
                    if (shiftTable.containsKey(text.charAt(i)))
                        i = i + shiftTable.get(text.charAt(i));
                    else i = i + patternLength;
                    break;
                }
            }
        }
        return new int[]{-1, comparisionCount};
    }
}
