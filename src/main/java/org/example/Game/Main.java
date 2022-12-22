package org.example.Game;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Bernd");
        Dice[] dice = {new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};
        Dice[] diceClone = Arrays.copyOfRange(dice,0, 1);

        System.out.println(p1.getName());
        Dice.roll(diceClone);

        System.out.println("1. Dice Value " + dice[0].getFaceValue());
        System.out.println("2. Dice Value " + dice[1].getFaceValue());
        System.out.println("3. Dice Value " + dice[2].getFaceValue());
        System.out.println("4. Dice Value " + dice[3].getFaceValue());
        System.out.println("5. Dice Value " + dice[4].getFaceValue());

        System.out.println(Dice.sumFaces(dice));
    }
}