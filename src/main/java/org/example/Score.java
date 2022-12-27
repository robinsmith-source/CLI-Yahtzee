package org.example;

public class Score {
    private int score = 0;

    /**
     * Only for testing
     *
     * @param score score to be set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Getter Method for a players score.
     * @return Player Score.
     */
    public int getScore() {
        return this.score;
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
     * @return Ordered count of numbers rolled.
     */
    public int[] sortNumbers() {
        int countOne = 0, countTwo = 0, numberThree = 0, countFour = 0, countFive = 0, countSix = 0;
        for (Dice d: Main.getDice()) {
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

