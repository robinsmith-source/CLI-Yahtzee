package org.example.Game;

import java.util.Random;

/**
 * Dice Class for the 5 dice instances.
 */
public class Dice {
    private int faceValue;

    /**
     * Default Dice constructor that assigns the default Value (0) to faceValue variable.
     */
    public Dice() {
        this.faceValue = 0;
    }

    /**
     * Private Setter Method for faceValue Variable. Mainly used by roll Method.
     * @param faceValue Face value
     */
    private void setFaceValue(final int faceValue) {
        this.faceValue = faceValue;
    }

    /**
     * Default Getter Method for faceValue Variable.
     * @return Face value
     */
    public int getFaceValue() {
        return faceValue;
    }

    /**
     * Method to roll a die (Random Value [1;7[ will be assigned to faceValue Variable via setFaceValue Method).
     * @param dice Die/Dice to be rolled
     */
    public static void roll(Dice[] dice) {
        for (final Dice d : dice) {
            d.setFaceValue((new Random().nextInt(1, 7)));
        }
    }

    /**
     * Method to sum all Dice faceValues.
     * @param dice Dice to be summed up
     * @return sum
     */
    public static int sumFaces(Dice[] dice) {
        int sum = 0;
        for (final Dice d : dice) {
            sum += d.getFaceValue();
        }
        return sum;
    }
}
