package org.example.Game;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test Class for the Score Class.
 */
public class ScoreTests {
    /**
     * Test if the possibleCombinationsScores Method returns the correct array.
     * Array has to be filled with the expected scores for each dice combination.
     *
     * @see Score#possibleCombinationsScores()
     */
    @Test
    public void possibleCombinationsScoresTest_1() {
        Player p = new Player("Test");

        p.getDice()[0].setFaceValue(3);
        p.getDice()[1].setFaceValue(3);
        p.getDice()[2].setFaceValue(3);
        p.getDice()[3].setFaceValue(3);
        p.getDice()[4].setFaceValue(3);

        Assert.assertArrayEquals(new int[]{0,0,15,0,0,0,15,15,0,0,0,50,15},p.score.possibleCombinationsScores());
    }

    /**
     * Test if the possibleCombinationsScores Method returns the correct array.
     * Array has to be filled with the expected scores for each dice combination.
     *
     * @see Score#possibleCombinationsScores()
     */
    @Test
    public void possibleCombinationsScoresTest_2() {
        Player p = new Player("Test");

        p.getDice()[0].setFaceValue(3);
        p.getDice()[1].setFaceValue(4);
        p.getDice()[2].setFaceValue(1);
        p.getDice()[3].setFaceValue(2);
        p.getDice()[4].setFaceValue(2);

        Assert.assertArrayEquals(new int[]{1,4,3,4,0,0,0,0,0,30,0,0,12},p.score.possibleCombinationsScores());
    }

    /**
     * Test if the possibleCombinationsScores Method returns the correct array.
     * Array has to be filled with the expected scores for each dice combination.
     *
     * @see Score#possibleCombinationsScores()
     */
    @Test
    public void possibleCombinationsScoresTest_3() {
        Player p = new Player("Test");

        p.getDice()[0].setFaceValue(5);
        p.getDice()[1].setFaceValue(5);
        p.getDice()[2].setFaceValue(4);
        p.getDice()[3].setFaceValue(2);
        p.getDice()[4].setFaceValue(1);

        Assert.assertArrayEquals(new int[]{1,2,0,4,10,0,0,0,0,0,0,0,17},p.score.possibleCombinationsScores());
    }

    /**
     * Test if the possibleCombinationsScores Method returns the correct array.
     * Array has to be filled with the expected scores for each dice combination.
     *
     * @see Score#possibleCombinationsScores()
     */
    @Test
    public void possibleCombinationsScoresTest_4() {
        Player p = new Player("Test");

        p.getDice()[0].setFaceValue(2);
        p.getDice()[1].setFaceValue(1);
        p.getDice()[2].setFaceValue(3);
        p.getDice()[3].setFaceValue(5);
        p.getDice()[4].setFaceValue(4);

        Assert.assertArrayEquals(new int[]{1,2,3,4,5,0,0,0,0,30,40,0,15},p.score.possibleCombinationsScores());
    }

    /**
     * Test if the possibleCombinationsScores Method returns the correct array.
     * Array has to be filled with the expected scores for each dice combination.
     *
     * @see Score#possibleCombinationsScores()
     */
    @Test
    public void possibleCombinationsScoresTest_5() {
        Player p = new Player("Test");

        p.getDice()[0].setFaceValue(2);
        p.getDice()[1].setFaceValue(2);
        p.getDice()[2].setFaceValue(2);
        p.getDice()[3].setFaceValue(2);
        p.getDice()[4].setFaceValue(5);

        Assert.assertArrayEquals(new int[]{0,8,0,0,5,0,13,13,0,0,0,0,13},p.score.possibleCombinationsScores());
    }
}
