package edu.uncc.cci.algods;

public class KnuthMorrisPratt {
    public int[] kmpAlgo(String text, String pattern) {
        int[] failureTable = generateFailureTable(pattern);
        int j = 0;
        int comparisionCount = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                comparisionCount++;
                j = failureTable[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                comparisionCount++;
                j++;
                if (j == pattern.length())
                    return new int[]{i - (j - 1), comparisionCount};
            } else
                comparisionCount++;
        }
        return new int[]{-1, comparisionCount};
    }

    public int[] generateFailureTable(String pattern) {
        int patternLength = pattern.length();
        int[] failureTable = new int[patternLength];
        failureTable[0] = 0;
        for (int i = 1; i < patternLength; i++) {
            int k = failureTable[i - 1];
            while (k > 0 && pattern.charAt(i) != pattern.charAt(k))
                k = failureTable[k - 1];
            if (pattern.charAt(i) == pattern.charAt(k))
                k++;
            failureTable[i] = k;
        }
        return failureTable;
    }
}
