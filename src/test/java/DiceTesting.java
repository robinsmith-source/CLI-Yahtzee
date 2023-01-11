import org.example.Game.Dice;
import org.junit.Assert;
import org.junit.Test;

public class DiceTesting {
    /**
     * Test if the initial face value of the Dice is correct.
     */
    @Test
    public void initialDiceTest() {
        Dice d = new Dice();
        Assert.assertEquals(0, d.getFaceValue());
    }

    /**
     * Test if the dice roll works correctly.
     */
    @Test
    public void rollDiceTest() {
        Dice d = new Dice();
        Assert.assertEquals(0, d.getFaceValue());
        for (int i = 0; i < 100; i++) {
        Dice.roll(d);
        Assert.assertTrue(d.getFaceValue() >= 1 && d.getFaceValue() <= 6);
        }
    }
}
