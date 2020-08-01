package edu.uncc.cci.algods;

public class Main {

    public static void main(String[] args) {
        String[] text = new String[10];
        String[] pattern = new String[10];

        text[0] = "Hi! My name is Ankit Pandita.";
        pattern[0] = "Ankit";

        text[1] = "Jinraj is cooking.";
        pattern[1] = "cook";

        text[2] = "Avajit is talking";
        pattern[2] = "BOABAB";

        text[3] = "Jim saw me in a barbershop";
        pattern[3] = "barber";

        text[4] = "BARD LOVES BANANAS";
        pattern[4] = "BANANA";

        text[5] = "bess new about baobabs";
        pattern[5] = "baobab";

        text[6] = "ABABEABABAABABABAEABABACBDHDSDKWABABATWI";
        pattern[6] = "ABABACB";

        text[7] = "AAAABBABABBBBABBBBBBBABBBBABABBBBAAABABABABABABAA";
        pattern[7] = "BBBBABBBB";

        text[8] = "I went for a run";
        pattern[8] = "run";

        text[9] = "Merry Christmas and A Very Happy New Year";
        pattern[9] = "Christmas";

        for (int i = 0; i < text.length; i++) {
            System.out.println("Text: " + text[i]);
            System.out.println("Pattern: " + pattern[i]);
            System.out.println();

            BruteForce bruteForce = new BruteForce();
            int[] resultArray = bruteForce.naiveAlgo(text[i], pattern[i]);
            int bruteForceResult = resultArray[0];
            int comparisonCountBruteForce = resultArray[1];
            System.out.println("Brute-Force algorithm");
            System.out.println(bruteForceResult == -1 ? "No match found" : "Match start index: " + bruteForceResult);
            System.out.println("Number of comparisons: " + comparisonCountBruteForce);
            System.out.println();

            BMHorspool bmHorspool = new BMHorspool();
            resultArray = bmHorspool.horspoolAlgo(text[i], pattern[i]);
            int horspoolResult = resultArray[0];
            int comparisonCountHorsepool = resultArray[1];
            System.out.println("Boyer-Moore-Horspool algorithm");
            System.out.println(horspoolResult == -1 ? "No match found" : "Match start index: " + horspoolResult);
            System.out.println("Number of comparisons: " + comparisonCountHorsepool);
            System.out.println();

            KnuthMorrisPratt knuthMorrisPratt = new KnuthMorrisPratt();
            resultArray = knuthMorrisPratt.kmpAlgo(text[i], pattern[i]);
            int kmpResult = resultArray[0];
            int comparisonCountKMP = resultArray[1];
            System.out.println("Knuth-Morris-Pratt algorithm");
            System.out.println(kmpResult == -1 ? "No match found" : "Match start index: " + kmpResult);
            System.out.println("Number of comparisons: " + comparisonCountKMP);
            System.out.println("-----------------------------------------------------");
            System.out.println();
        }
    }
}
