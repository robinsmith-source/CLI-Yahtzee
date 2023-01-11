package org.example.Game;

import java.util.Random;

/**
 * Dice Class for the 5 dice instances.
 */
public class Dice {
    /**
     *  Face Value of the Dice.
     */
    private int faceValue;

    /**
     * Default Dice constructor that assigns the default Value (0) to faceValue variable.
     */
    public Dice() {
        this.faceValue = 0;
    }

    /**
     * Setter Method for faceValue Variable. Mainly used by roll Method. Public only for Unit Testing
     *
     * @param faceValue Face value
     */
    public void setFaceValue(final int faceValue) {
        this.faceValue = faceValue;
    }

    /**
     * Default Getter Method for faceValue Variable.
     *
     * @return Face Value
     */
    public int getFaceValue() {
        return faceValue;
    }

    /**
     * Method to get a String representation of the Dice.
     * @param dice Dice Array to get the String representation from.
     * @return String representation of the Dice.
     */
    public static String showDice(Dice[] dice) {
        return String.format("""
                +--------+---+---+---+---+---+
                |  Dice  | 1 | 2 | 3 | 4 | 5 |
                +--------+---+---+---+---+---+
                |  Face  | %d | %d | %d | %d | %d |
                +--------+---+---+---+---+---+
                """, dice[0].getFaceValue(), dice[1].getFaceValue(), dice[2].getFaceValue(), dice[3].getFaceValue(), dice[4].getFaceValue());
    }

    /**
     * Method to roll a die (Random Value [1;7[ will be assigned to faceValue Variable via setFaceValue Method).
     * @param dice Die/Dice to be rolled converted to an Array in between the Method.
     */
    public static void roll(Dice... dice) {
        for (final Dice d : dice) {
            d.setFaceValue((new Random().nextInt(1, 7)));
        }
    }


}
