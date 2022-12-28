package org.example.Game;

import java.util.Arrays;

/**
 * Score Class for the score instances. This class is used to calculate the score of a player. It is also used to check if a combination is valid.
 */
public class Score {
    /**
     * Dice Array for the 5 dice instances.
     */
    private final Dice[] dice;

    /**
     * Combination Names for the Scorecard.
     */
    private static final String[] combinationNames = {"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes", "3 Of a Kind", "4 Of a Kind", "Full House", "Sm. Straight", "Lg. Straight", "Yahtzee", "Chance"};

    /**
     * A Players combination Scores for the Scorecard.
     */
    private final int[] playerScores = new int[13];

    /**
     * Default Score Constructor that assigns a Players dice Array to dice variable. This Constructor is called from the Player Class.
     * @param dice Dice Array
     */
    public Score(Dice[] dice) {
        this.dice = dice;
    }

    /**
     * Default Getter Method for combinationNames Variable. This Method is called from the Player Class.
     * @return Combination Names
     */
    public static String[] getCombinationNames() {
        return combinationNames;
    }

    /**
     * Default Getter Method for playerScores Variable. This Method is called from the Player Class.
     * @return A Players Combination Scores
     */
    public int[] getPlayerScores() {
        return playerScores;
    }

    /**
     * Method to calculate the score of a player.
     * @return A Players possible combinations with the Score that can be scored with setting it.
     */
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
            for (int i = 0; i < sortNumbers().length; i++) {
                if (sortNumbers()[i] >= 3) combinations[6] = 3 * (i + 1);
            }
        }
        if (is4OfAKind()) {
            for (int i = 0; i < sortNumbers().length; i++) {
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

    /**
     * Method to get a String of all possible combinations with the Score that can be scored with setting it.
     * @return A String of all possible combinations with the Score that can be scored with setting it.
     */
    public String possibleCombinationsScoresToString() {
        String output = "";
        for (int i = 0; i < combinationNames.length; i++) {
            if (possibleCombinationsScores()[i] > 0 && playerScores[i] == 0) {
                output += String.format(" %2d | %-12s -> %2d pt/s\n", i + 1, combinationNames[i], possibleCombinationsScores()[i]);
            }
        }
        return output;
    }

    /**
     * Method to set a combination to a score.
     * @param indexOfCombination Index of the combination + 1
     */
    public void setOnCombination(int indexOfCombination) {
        if (indexOfCombination <= combinationNames.length && playerScores[indexOfCombination - 1] == 0) {
            playerScores[indexOfCombination - 1] = possibleCombinationsScores()[indexOfCombination - 1];
        }
    }

    /**
     * Method to check if the combination "Aces" is valid.
     * @return True if the combination "Aces" is valid, otherwise false.
     */
    private boolean isAces() {
        return sortNumbers()[0] >= 1;
    }

    /**
     * Method to check if the combination "Twos" is valid.
     * @return True if the combination "Twos" is valid, otherwise false.
     */
    private boolean isTwos() {
        return sortNumbers()[1] >= 1;
    }

    /**
     * Method to check if the combination "Threes" is valid.
     * @return True if the combination "Threes" is valid, otherwise false.
     */
    private boolean isThrees() {
        return sortNumbers()[2] >= 1;
    }

    /**
     * Method to check if the combination "Fours" is valid.
     * @return True if the combination "Fours" is valid, otherwise false.
     */
    private boolean isFours() {
        return sortNumbers()[3] >= 1;
    }

    /**
     * Method to check if the combination "Fives" is valid.
     * @return True if the combination "Fives" is valid, otherwise false.
     */
    private boolean isFives() {
        return sortNumbers()[4] >= 1;
    }

    /**
     * Method to check if the combination "Sixes" is valid.
     * @return True if the combination "Sixes" is valid, otherwise false.
     */
    private boolean isSixes() {
        return sortNumbers()[5] >= 1;
    }

    /**
     * Method to check if the combination "3 Of a Kind" is valid.
     * @return True if the combination "3 Of a Kind" is valid, otherwise false.
     */
    private boolean is3OfAKind() {
        for (final int i : sortNumbers()) {
            if (i >= 3) return true;
        }
        return false;
    }


    /**
     * Method to check if the combination "4 Of a Kind" is valid.
     * @return True if the combination "4 Of a Kind" is valid, otherwise false.
     */
    private boolean is4OfAKind() {
        for (final int i : sortNumbers()) {
            if (i >= 4) return true;
        }
        return false;
    }

    /**
     * Method to check if the combination "Full House" is valid.
     * @return True if the combination "Full House" is valid, otherwise false.
     */
    private boolean isFullHouse() {
        int[] amountSortedDice = Arrays.copyOf(sortNumbers(), sortNumbers().length);
        Arrays.sort(amountSortedDice);
        return amountSortedDice[4] == 2 && amountSortedDice[5] == 3;
    }

    /**
     * Method to check if the combination "Small Straight" is valid.
     * @return True if the combination "Small Straight" is valid, otherwise false.
     */
    private boolean isSmStraight() {
        for (int i = 0; i < 3; i++) {
            if (sortNumbers()[i] >= 1 && sortNumbers()[i + 1] >= 1 && sortNumbers()[i + 2] >= 1 && sortNumbers()[i + 3] >= 1)
                return true;
        }
        return false;
    }

    /**
     * Method to check if the combination "Large Straight" is valid.
     * @return True if the combination "Large Straight" is valid, otherwise false.
     */
    private boolean isLgStraight() {
        for (int i = 0; i < 2; i++) {
            if (sortNumbers()[i] >= 1 && sortNumbers()[i + 1] >= 1 && sortNumbers()[i + 2] >= 1 && sortNumbers()[i + 3] >= 1 && sortNumbers()[i + 4] >= 1)
                return true;
        }
        return false;
    }

    /**
     * Method to check if the combination "Yahtzee" is valid.
     * @return True if the combination "Yahtzee" is valid, otherwise false.
     */
    private boolean isYahtzee() {
        for (final int i : sortNumbers()) {
            if (i == 5) return true;
        }
        return false;
    }

    /**
     * Method to check if the combination "Chance" is valid.
     * @return True if the combination "Chance" is valid, otherwise false.
     */
    private boolean isChance() {
        return playerScores[12] == 0;
    }


    /**
     * Method to sort the dice by their face values.
     * @return An array of the sorted dice.
     */
    private int[] sortNumbers() {
        int[] sortedDiceNumbers = new int[6];
        for (final Dice d : this.dice) {
            sortedDiceNumbers[d.getFaceValue() - 1]++;
        }
        return sortedDiceNumbers;
    }
}

