package org.example.Game;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test Class for the Score Class.
 */
public class ScoreTesting {
    /**
     * Test if the possibleCombinationsScores Method returns the correct array.
     * Array has to be filled with the expected scores for each dice combination.
     *
     <ol start="0">
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
     <ol start="0">
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
}
