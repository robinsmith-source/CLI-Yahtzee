package org.example.Game;

public class Main {
    public static void main(String[] args) {
        final Player[] players = {new Player("Gomme"), new Player("Trolololol"), new Player("Gommemode")};
        final Dice[] dice = {new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};

        Dice.roll(dice);

        System.out.println("1. Dice Value " + dice[0].getFaceValue());
        System.out.println("2. Dice Value " + dice[1].getFaceValue());
        System.out.println("3. Dice Value " + dice[2].getFaceValue());
        System.out.println("4. Dice Value " + dice[3].getFaceValue());
        System.out.println("5. Dice Value " + dice[4].getFaceValue());

        System.out.println("Sum of all 5 Dice: " + Dice.sumFaces(dice));
    }
}