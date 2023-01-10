package org.example.Game;

import java.util.Scanner;

/**
 * Game Class for the Yahtzee Game.
 */
public class Game {
    /**
     * Current player index.
     */
    private int currentPlayerIndex = 0;


    /**
     * Player Array for the player instances.
     */
    private final Player[] players;

    //Dice Array for old rerollDice() Method. (Not used anymore)
    private static final Dice[] dice = {new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};

    /**
     * Scanner Instance for the Game.
     */
    private static final Scanner scan = new Scanner(System.in);

    /**
     * Default Game constructor.
     */
    public Game(Player[] players) {
       this.players = players;
    }

    /**
     * Method to test gameplay functionality.
     */
    public void demoTest() {
        while (true) {
            Dice.roll(currentPlayer().getDice());


            System.out.println(Dice.showDice(currentPlayer().getDice()));


            System.out.println(currentPlayer().score.possibleCombinationsScoresToString());
            System.out.print("Choose a category to score: ");

            currentPlayer().score.setOnCombination(scan.nextInt());

            System.out.println(currentPlayer().getScorecard());

        }
    }

    /**
     * Method to play the game.
     */
    public void play() {
        for (int i = 0; i < 13; i++) {
            //10 characters Playername length.
            System.out.printf("""
                    +~~~~~~~~~~~~~~~~~~~~~~~~~~~~+
                    | It's %-17s     |
                    +~~~~~~~~~~~~~~~~~~~~~~~~~~~~+
                    """, currentPlayer().getName() + "s turn.");
            System.out.println(currentPlayer().getScorecard());
            Dice.roll(currentPlayer().getDice());
            System.out.println(Dice.showDice(currentPlayer().getDice()));

            System.out.println(currentPlayer().score.possibleCombinationsScoresToString());

            //TODO reroll

            int indexOfCombination;
            do {
                System.out.print("Choose a category to score: ");
                indexOfCombination = scan.nextInt();
            } while (indexOfCombination < 1 || indexOfCombination > 13 || currentPlayer().score.isCombinationSet(indexOfCombination));
            currentPlayer().score.setOnCombination(indexOfCombination);

            nextPlayer();
        }
        //Example
        for (final Player player : players) {
            System.out.println(player.getName() + "s Final Score: " + player.score.getPlayerFinalScore());
        }
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
    private void nextPlayer() {
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
    private Player currentPlayer() {
        return players[currentPlayerIndex];
    }
}