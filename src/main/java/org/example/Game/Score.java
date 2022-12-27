package org.example.Game;

public class Score {
    private final Dice[] dice;

    private static int[] combinationsScores = {1, 2, 3, 4, 5, 6};
    private static String[] combinationNames = {"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes"};

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

    private int[] possibleCombinationsScoresUpperBlock() {
        int[] combinations = new int[combinationsScores.length];
        if (isAces()) combinations[0] = sortNumbers()[0];
        if (isTwos()) combinations[1] = combinationsScores[1] * sortNumbers()[1];
        if (isThrees()) combinations[2] = combinationsScores[2] * sortNumbers()[2];
        if (isFours()) combinations[3] = combinationsScores[3] * sortNumbers()[3];
        if (isFives()) combinations[4] = combinationsScores[4] * sortNumbers()[4];
        if (isSixes()) combinations[5] = combinationsScores[5] * sortNumbers()[5];

        return combinations;
    }

    public String possibleCombinationsScoresToString() {
        String output = "";

        for (int i = 0; i < combinationsScores.length; i++) {
            if (possibleCombinationsScoresUpperBlock()[i] > 0 && playerScores[i] == 0) {
                output += String.format("%2d | %-6s : %2d Points\n", i + 1, combinationNames[i], possibleCombinationsScoresUpperBlock()[i]);
            }
        }
        return output;
    }

    public void setOnCombination(int indexOfCombination) {
        if (indexOfCombination <= combinationsScores.length && playerScores[indexOfCombination - 1] == 0) {
            playerScores[indexOfCombination - 1] = possibleCombinationsScoresUpperBlock()[indexOfCombination - 1];
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

    /**
     * Helper method for the upper Section.
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

