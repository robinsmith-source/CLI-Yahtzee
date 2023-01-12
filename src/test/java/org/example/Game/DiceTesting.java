package org.example.Game;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test Class for the Dice Class.
 */
public class DiceTesting {
    /**
     * Test if the initial face value of the Dice is correct.
     * @see Dice#Dice()
     */
    @Test
    public void initialDiceTest() {
        Dice d = new Dice();
        Assert.assertEquals(0, d.getFaceValue());
    }

    /**
     * Test if the dice roll works correctly.
     * @see Dice#roll(Dice...)
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
