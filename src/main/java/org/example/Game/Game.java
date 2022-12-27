package org.example.Game;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static int currentPlayerIndex = 0;
    private static final Player[] players = {new Player("Gomme"), new Player("Trolololol"), new Player("Gommemode")};
    private static final Dice[] dice = {new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};
    private static final Scanner scan = new Scanner(System.in);

    /**
     * Method to test a Methods function.
     */
    public static void demoTest() {
        while (true) {
            Dice.roll(currentPlayer().getDice());

            /*
            System.out.println("1. Dice Value " + currentPlayer().getDice()[0].getFaceValue());
            System.out.println("2. Dice Value " + currentPlayer().getDice()[1].getFaceValue());
            System.out.println("3. Dice Value " + currentPlayer().getDice()[2].getFaceValue());
            System.out.println("4. Dice Value " + currentPlayer().getDice()[3].getFaceValue());
            System.out.println("5. Dice Value " + currentPlayer().getDice()[4].getFaceValue());
*/

            //    System.out.println(Arrays.toString(players[0].score.sortNumbers()));
            System.out.println(Dice.showDice(currentPlayer().getDice()));


            System.out.println(currentPlayer().score.possibleCombinationsScoresToString());
            System.out.print("Choose a category to score: ");
            currentPlayer().score.setOnCombination(scan.nextInt());
            System.out.println(currentPlayer().getScore());

        }
    }

    /**
     * Gameplay Method
     */
    public static void play() {

    }

    /**
     * Method to reroll Dice (2nd and 3rd roll)
     */
    private static void rerollDice() {
        for (int i = 0; i < 2; i++) {
            System.out.println("möchtest du Würfel 1 nocheinmal würfeln? dann schreibe 1");

            int eins_zweiterwürfel = scan.nextInt();
            System.out.println("möchtest du Würfel 2 nocheinmal würfeln? dann schreibe 1");
            int zwei_zweiterwürfel = scan.nextInt();
            System.out.println("möchtest du Würfel 3 nocheinmal würfeln? dann schreibe 1");
            int drei_zweiterwürfel = scan.nextInt();
            System.out.println("möchtest du Würfel 4 nocheinmal würfeln? dann schreibe 1");
            int vier_zweiterwürfel = scan.nextInt();
            System.out.println("möchtest du Würfel 5 nocheinmal würfeln? dann schreibe 1");
            int fünf_zweiterwürfel = scan.nextInt();


            if (1 == eins_zweiterwürfel) {
                Dice.roll(dice[0]);
                System.out.println("1. Dice Value " + dice[0].getFaceValue());
            }
            if (1 == zwei_zweiterwürfel) {
                Dice.roll(dice[1]);
                System.out.println("2. Dice Value " + dice[1].getFaceValue());
            }
            if (1 == drei_zweiterwürfel) {
                Dice.roll(dice[2]);
                System.out.println("3. Dice Value " + dice[2].getFaceValue());
            }
            if (1 == vier_zweiterwürfel) {
                Dice.roll(dice[3]);
                System.out.println("4. Dice Value " + dice[3].getFaceValue());
            }
            if (1 == fünf_zweiterwürfel) {
                Dice.roll(dice[4]);
                System.out.println("5. Dice Value " + dice[4].getFaceValue());
            }

            System.out.println(Dice.showDice(dice));
        }
    }

    /**
     * Method to get the next Player Object.
     */
    private static void nextPlayer() {
        if (players.length - 1 == currentPlayerIndex) {
            currentPlayerIndex = 0;
        } else {
            currentPlayerIndex++;
        }
    }

    /**
     * Method to get the current Player Object.
     *
     * @return Player Object with the current turn.
     */
    public static Player currentPlayer() {
        return players[currentPlayerIndex];
    }
}