import org.example.Game.Dice;
import org.example.Game.Player;
import org.junit.Assert;
import org.junit.Test;

public class ScoreTesting {
    @Test
    public void possibleCombinationsScoresTest() {
        //"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes", "3 Of a Kind", "4 Of a Kind", "Full House", "Sm. Straight", "Lg. Straight", "Yahtzee", "Chance"
        Player p = new Player("Test");
        p.getDice()[0].setFaceValue(3);
        p.getDice()[1].setFaceValue(3);
        p.getDice()[2].setFaceValue(3);
        p.getDice()[3].setFaceValue(3);
        p.getDice()[4].setFaceValue(3);

        Assert.assertArrayEquals(new int[]{0,0,15,0,0,0,9,12,0,0,0,50,15},p.score.possibleCombinationsScores());
    }
}
