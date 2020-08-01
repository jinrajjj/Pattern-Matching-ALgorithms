package edu.uncc.cci.algods;

public class BruteForce {
    public int[] naiveAlgo(String text, String pattern) {
        int comparisionCount = 0;
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int count = 0;
            for (int j = 0; j < pattern.length(); j++) {
                comparisionCount++;
                if (text.charAt(i + j) == pattern.charAt(j))
                    count++;
                else break;
            }
            if (count == pattern.length())
                return new int[]{i, comparisionCount};
        }
        return new int[]{-1, comparisionCount};
    }
}
