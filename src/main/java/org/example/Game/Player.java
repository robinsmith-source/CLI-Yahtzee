package org.example.Game;

public class Player {
    private final String name;
    final Score score;
    private final Dice[] dice;


    public Player(final String name) {
        this.name = name;
        this.dice = new Dice[]{new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};
        this.score = new Score(this.getDice());
    }
    public String getName() {
        return name;
    }

    /**
     * Getter Method for a Players Score
     * @return Score of the Player
     */
    public String getScore() {
        String output = String.format("\n Scorecard from %10s.\n+----------------------------+\n", this.getName());
        for (int i = 0; i < Score.getCombinationNames().length; i++) {
            output += String.format("| %-20s -> %2d |\n", Score.getCombinationNames()[i], this.score.getPlayerScores()[i]);
        }
        output += "+----------------------------+\n";
        return output;
    }

    /**
     * Method to gain access over a Players 5 Dice Objects
     * @return Array with Dice Objects
     */
    public Dice[] getDice() {
        return this.dice;
    }
}
