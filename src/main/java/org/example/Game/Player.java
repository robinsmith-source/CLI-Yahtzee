package org.example.Game;

public class Player {
    private final String name;
    final Score score;



    public Player(final String name) {
        this.name = name;
        this.score = new Score();
    }
    public String getName() {
        return name;
    }

    public String getScore() {
        return String.format("%s hat %s Punkte.",this.getName(),this.score.getScore());
    }

    /**
     * Only for testing
     * @param score score to be set
     */
    public void setScore(int score) {
        this.score.setScore(score);
    }
}
