package org.example.Game;



/**
 * Player Class for the player instances.
 */
public class Player {
    /**
     * Name of the Player.
     */
    private final String name;

    /**
     * Score Instance for the Player.
     */
    public final Score score;

    /**
     * Dice Array for the 5 dice instances.
     */
    private final Dice[] dice;

    /**
     * Default Player constructor that assigns the default Value (0) to faceValue variable.
     *
     * @param name Player Name
     */
    public Player(final String name) {
        this.name = name;
        this.dice = new Dice[]{new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};
        this.score = new Score(this.getDice());
    }

    /**
     * Default Getter Method for name Variable.
     *
     * @return Player Name
     */
    public String getName() {
        return name;
    }

    /**
     * Default Getter Method for a Players Score
     *
     * @return Score of the Player
     */
    public String getScorecard() {
        String output = "+----------------------------+";
        output += String.format("\n| Scorecard from %-11s |\n+----------------------------+\n", this.getName()+".");
        for (int i = 0; i < Score.getCombinationNames().length; i++) {

            if (this.score.getPlayerScores()[i] == -1) {
                output += String.format("| %2d | %-15s ##  X |\n", i + 1, Score.getCombinationNames()[i]);
            } else {
                output += String.format("| %2d | %-15s -> %2d |\n", i + 1, Score.getCombinationNames()[i], this.score.getPlayerScores()[i]);
            }
        }
        output += String.format("+----------------------------+\n| Total Score:%14d |\n+----------------------------+\n", this.score.getPlayerFinalScore());
        return output;
    }

    /**
     * Default Getter Method for dice Variable.
     *
     * @return Dice Array
     */
    public Dice[] getDice() {
        return this.dice;
    }
}
