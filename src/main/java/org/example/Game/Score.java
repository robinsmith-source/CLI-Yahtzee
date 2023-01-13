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
     *
     * @param dice Dice Array
     */
    public Score(Dice[] dice) {
        this.dice = dice;
    }

    /**
     * Default Getter Method for combinationNames Variable. This Method is called from the Player Class.
     *
     * @return Combination Names
     */
    public static String[] getCombinationNames() {
        return combinationNames;
    }

    /**
     * Default Getter Method for playerScores Variable. This Method is called from the Player Class.
     *
     * @return A Players Combination Scores
     */
    public int[] getPlayerScores() {
        return playerScores;
    }


    /**
     * Method to calculate the score of a player.
     *
     * @return A Players Final Score
     */
    public int getPlayerFinalScore() {
        int sumOfScores = 0, bonus = 0;
        for (int i = 0; i < 6; i++) {
            if (this.playerScores[i] != -1) {
                sumOfScores += this.playerScores[i];
            }
        }
        if (sumOfScores >= 63) {
            bonus += 35;
        }
        for (int i = 6; i < playerScores.length; i++) {
            if (this.playerScores[i] != -1) {
                sumOfScores += this.playerScores[i];
            }
        }
        return sumOfScores + bonus;

    }

    /**
     * Method to get all possible Scores from all valid combinations which can be scored by a player with his current Dice.
     * Was implemented as private, but was changed to public for easier JUnit Testing
     *
     * @return Array with the possible scores for each dice combination.
     * <ol start="0">
     *     <li>Aces -> Count of 1s</li>
     *     <li>Twos -> Count of 2s</li>
     *     <li>Threes -> Count of 3s</li>
     *     <li>Fours -> Counts of 4s</li>
     *     <li>Fives -> Counts of 5s</li>
     *     <li>Sixes -> Counts of 6s</li>
     *     <li>3 Of a Kind -> Sum of all dice</li>
     *     <li>4 Of a Kind -> Sum of all dice</li>
     *     <li>Full House -> 25</li>
     *     <li>Sm. Straight -> 30</li>
     *     <li>Lg. Straight -> 40</li>
     *     <li>Yahtzee -> 50</li>
     *     <li>Chance -> Sum of all dice</li>
     *     </ol>
     */
    public int[] possibleCombinationsScores() {
        //Upper Section
        int[] combinations = new int[combinationNames.length];
        if (isAces() && this.playerScores[0] == 0) combinations[0] = sortNumbers()[0];
        if (isTwos() && this.playerScores[1] == 0) combinations[1] = 2 * sortNumbers()[1];
        if (isThrees() && this.playerScores[2] == 0) combinations[2] = 3 * sortNumbers()[2];
        if (isFours() && this.playerScores[3] == 0) combinations[3] = 4 * sortNumbers()[3];
        if (isFives() && this.playerScores[4] == 0) combinations[4] = 5 * sortNumbers()[4];
        if (isSixes() && this.playerScores[5] == 0) combinations[5] = 6 * sortNumbers()[5];

        //Lower Section
        if (is3OfAKind() && this.playerScores[6] == 0) combinations[6] = sumOfDice();
        if (is4OfAKind() && this.playerScores[7] == 0) combinations[7] = sumOfDice();
        if (isFullHouse() && this.playerScores[8] == 0) combinations[8] = 25;
        if (isSmStraight() && this.playerScores[9] == 0) combinations[9] = 30;
        if (isLgStraight() && this.playerScores[10] == 0) combinations[10] = 40;
        if (isYahtzee() && this.playerScores[11] == 0) combinations[11] = 50;
        if (isChance()) combinations[12] = sumOfDice();

        return combinations;
    }

    /**
     * Method to get a String of all possible combinations with the Score that can be scored with setting it.
     *
     * @return A String of all possible combinations with the Score that can be scored with setting it.
     */
    public String possibleCombinationsScoresToString() {

        String output = "";
        for (int i = 0; i < combinationNames.length; i++) {
            if (possibleCombinationsScores()[i] > 0) {
                output += String.format(" %2d | %-12s -> %2d pt/s\n", i + 1, combinationNames[i], possibleCombinationsScores()[i]);
            }
        }
        return output;
    }

    /**
     * Method to set the score of a combination on a players' scorecard.
     * @see #possibleCombinationsScores() for checking which combinations are avaliable.
     *
     * @param indexOfCombination Index of the combination + 1
     */
    public void setOnCombination(int indexOfCombination) {
        if (playerScores[indexOfCombination - 1] == 0 && possibleCombinationsScores()[indexOfCombination - 1] == 0) {
            playerScores[indexOfCombination - 1] = -1;
        } else {
            if (playerScores[indexOfCombination - 1] == 0) {
                playerScores[indexOfCombination - 1] = possibleCombinationsScores()[indexOfCombination - 1];
            }
        }
    }

    /**
     * Method to check if a player has already scored on a specific combination.
     * @param indexOfCombination Index of the combination + 1
     *
     * @return True if the combination is already scored, false if not.
     */
    public boolean isCombinationScored(int indexOfCombination) {
        return playerScores[indexOfCombination - 1] != 0;
    }

    /**
     * Method to check if the combination "Aces" is valid.
     *
     * @return True if the combination "Aces" is valid, otherwise false.
     */
    private boolean isAces() {
        return sortNumbers()[0] >= 1;
    }

    /**
     * Method to check if the combination "Twos" is valid.
     *
     * @return True if the combination "Twos" is valid, otherwise false.
     */
    private boolean isTwos() {
        return sortNumbers()[1] >= 1;
    }

    /**
     * Method to check if the combination "Threes" is valid.
     *
     * @return True if the combination "Threes" is valid, otherwise false.
     */
    private boolean isThrees() {
        return sortNumbers()[2] >= 1;
    }

    /**
     * Method to check if the combination "Fours" is valid.
     *
     * @return True if the combination "Fours" is valid, otherwise false.
     */
    private boolean isFours() {
        return sortNumbers()[3] >= 1;
    }

    /**
     * Method to check if the combination "Fives" is valid.
     *
     * @return True if the combination "Fives" is valid, otherwise false.
     */
    private boolean isFives() {
        return sortNumbers()[4] >= 1;
    }

    /**
     * Method to check if the combination "Sixes" is valid.
     *
     * @return True if the combination "Sixes" is valid, otherwise false.
     */
    private boolean isSixes() {
        return sortNumbers()[5] >= 1;
    }

    /**
     * Method to check if the combination "3 Of a Kind" is valid.
     *
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
     *
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
     *
     * @return True if the combination "Full House" is valid, otherwise false.
     */
    private boolean isFullHouse() {
        int[] amountSortedDice = Arrays.copyOf(sortNumbers(), sortNumbers().length);
        Arrays.sort(amountSortedDice);
        return amountSortedDice[4] == 2 && amountSortedDice[5] == 3;
    }

    /**
     * Method to check if the combination "Small Straight" is valid.
     *
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
     *
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
     *
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
     *
     * @return True if the combination "Chance" is valid, otherwise false.
     */
    private boolean isChance() {
        return playerScores[12] == 0;
    }

    /**
     * Method to sort the dice by their face values.
     *
     * @return An array of the sorted dice.
     */
    private int[] sortNumbers() {
        int[] sortedDiceNumbers = new int[6];
        for (final Dice d : this.dice) {
            sortedDiceNumbers[d.getFaceValue() - 1]++;
        }
        return sortedDiceNumbers;
    }

    /**
     * Method to calculate the sum of all dice face values.
     *
     * @return Sum of all dice face values.
     */
    private int sumOfDice() {
        int sum = 0;
        for (final Dice d : this.dice) {
            sum += d.getFaceValue();
        }
        return sum;
    }
}

