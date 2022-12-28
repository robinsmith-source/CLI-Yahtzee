package org.example.Game;

import java.util.Arrays;

public class Score {
    private final Dice[] dice;

    private static final String[] combinationNames = {"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes", "3 Of a Kind", "4 Of a Kind", "Full House", "Sm. Straight", "Lg. Straight", "Yahtzee", "Chance"};

    private final int[] playerScores = new int[13];


    /**
     * Constructor for Score Object. Driven by Player Object
     *
     * @param dice Array with Dice Objects
     */
    public Score(Dice[] dice) {
        this.dice = dice;
    }

    public static String[] getCombinationNames() {
        return combinationNames;
    }

    /**
     * Getter Method for a players score.
     *
     * @return Player Score.
     */
    public int[] getPlayerScores() {
        return playerScores;
    }

    private int[] possibleCombinationsScores() {
        //Upper Section
        int[] combinations = new int[combinationNames.length];
        if (isAces()) combinations[0] = sortNumbers()[0];
        if (isTwos()) combinations[1] = 2 * sortNumbers()[1];
        if (isThrees()) combinations[2] = 3 * sortNumbers()[2];
        if (isFours()) combinations[3] = 4 * sortNumbers()[3];
        if (isFives()) combinations[4] = 5 * sortNumbers()[4];
        if (isSixes()) combinations[5] = 6 * sortNumbers()[5];

        //LowerSection
        if (is3OfAKind()) {
            for (int i = 0; i < 6; i++) {
                if (sortNumbers()[i] >= 3) combinations[6] = 3 * (i + 1);
            }
        }
        if (is4OfAKind()) {
            for (int i = 0; i < 6; i++) {
                if (sortNumbers()[i] >= 4) combinations[7] = 4 * (i + 1);
            }
        }
        if (isFullHouse()) combinations[8] = 25;
        if (isSmStraight()) combinations[9] = 30;
        if (isLgStraight()) combinations[10] = 40;
        if (isYahtzee()) combinations[11] = 50;
        if (isChance()) {
            int sum = 0;
            for (final Dice d : dice) {
                sum += d.getFaceValue();
            }
            combinations[12] = sum;
        }

        return combinations;
    }

    public String possibleCombinationsScoresToString() {
        String output = "";
        for (int i = 0; i < combinationNames.length; i++) {
            if (possibleCombinationsScores()[i] > 0 && playerScores[i] == 0) {
                output += String.format(" %2d | %-12s -> %2d pt/s\n", i + 1, combinationNames[i], possibleCombinationsScores()[i]);
            }
        }
        return output;
    }

    public void setOnCombination(int indexOfCombination) {
        if (indexOfCombination <= combinationNames.length && playerScores[indexOfCombination - 1] == 0) {
            playerScores[indexOfCombination - 1] = possibleCombinationsScores()[indexOfCombination - 1];
        }
    }


    private boolean isAces() {
        return sortNumbers()[0] >= 1;
    }

    private boolean isTwos() {
        return sortNumbers()[1] >= 1;
    }

    private boolean isThrees() {
        return sortNumbers()[2] >= 1;
    }

    private boolean isFours() {
        return sortNumbers()[3] >= 1;
    }

    private boolean isFives() {
        return sortNumbers()[4] >= 1;
    }

    private boolean isSixes() {
        return sortNumbers()[5] >= 1;
    }

    private boolean is3OfAKind() {
        for (final int i : sortNumbers()) {
            if (i >= 3) return true;
        }
        return false;
    }

    private boolean is4OfAKind() {
        for (final int i : sortNumbers()) {
            if (i >= 4) return true;
        }
        return false;
    }

    private boolean isFullHouse() {
        int[] amountSortedDice = Arrays.copyOf(sortNumbers(), 6);
        Arrays.sort(amountSortedDice);
        return amountSortedDice[4] == 2 && amountSortedDice[5] == 3;
    }

    private boolean isSmStraight() {
        for (int i = 0; i < 3; i++) {
            if (sortNumbers()[i] >= 1 && sortNumbers()[i + 1] >= 1 && sortNumbers()[i + 2] >= 1 && sortNumbers()[i + 3] >= 1)
                return true;
        }
        return false;
    }

    private boolean isLgStraight() {
        for (int i = 0; i < 2; i++) {
            if (sortNumbers()[i] >= 1 && sortNumbers()[i + 1] >= 1 && sortNumbers()[i + 2] >= 1 && sortNumbers()[i + 3] >= 1 && sortNumbers()[i + 4] >= 1)
                return true;
        }
        return false;
    }

    private boolean isYahtzee() {
        for (final int i : sortNumbers()) {
            if (i == 5) return true;
        }
        return false;
    }

    private boolean isChance() {
        return playerScores[12] == 0;
    }


    /**
     * Helper method
     *
     * @return Ordered count of numbers rolled.
     */
    private int[] sortNumbers() {
        int[] sortedDiceNumbers = new int[6];
        for (final Dice d : this.dice) {
            sortedDiceNumbers[d.getFaceValue() - 1]++;
        }
        return sortedDiceNumbers;
    }
}

