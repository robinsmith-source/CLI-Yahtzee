package org.example.Game;

public class Score {
    private final Dice[] dice;

    private static String[] combinationNames = {"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes", "Three Of a Kind", "Four Of a Kind"};

    private int[] playerScores = new int[13];


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

    private int[] possibleCombinationsScoresUpperSection() {
        int[] combinations = new int[combinationNames.length];
        if (isAces()) combinations[0] = sortNumbers()[0];
        if (isTwos()) combinations[1] = 2 * sortNumbers()[1];
        if (isThrees()) combinations[2] = 3 * sortNumbers()[2];
        if (isFours()) combinations[3] = 4 * sortNumbers()[3];
        if (isFives()) combinations[4] = 5 * sortNumbers()[4];
        if (isSixes()) combinations[5] = 6 * sortNumbers()[5];

        return combinations;
    }

    public String possibleCombinationsScoresToString() {
        String output = "";

        for (int i = 0; i < combinationNames.length; i++) {
            if (possibleCombinationsScoresUpperSection()[i] > 0 && playerScores[i] == 0) {
                output += String.format("%2d | %-6s : %2d Points\n", i + 1, combinationNames[i], possibleCombinationsScoresUpperSection()[i]);
            }
        }
        return output;
    }

    public void setOnCombination(int indexOfCombination) {
        if (indexOfCombination <= combinationNames.length && playerScores[indexOfCombination - 1] == 0) {
            playerScores[indexOfCombination - 1] = possibleCombinationsScoresUpperSection()[indexOfCombination - 1];
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


    private boolean isThreeOfAKind() {
        boolean output = false;
        for (final int i : sortNumbers()) {
            output = i >= 3;
        }
        return output;
    }

    private boolean isFourOfAKind() {
        boolean output = false;
        for (final int i : sortNumbers()) {
            output = i >= 4;
        }
        return output;
    }


    /**
     * Helper method
     *
     * @return Ordered count of numbers rolled.
     */
    private int[] sortNumbers() {
        int countOne = 0, countTwo = 0, numberThree = 0, countFour = 0, countFive = 0, countSix = 0;
        for (Dice d : this.dice) {
            switch (d.getFaceValue()) {
                case 1 -> countOne++;
                case 2 -> countTwo++;
                case 3 -> numberThree++;
                case 4 -> countFour++;
                case 5 -> countFive++;
                case 6 -> countSix++;
            }
        }
        return new int[]{countOne, countTwo, numberThree, countFour, countFive, countSix};
    }
}

