package org.example.Game;
import java.util.Scanner;

/**
 * Main class to run (several instances of) the Game.
 */
public class Main {

    /**
     * Main Method to run the Game.
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        //Game Initialization
        Game round1 = new Game(initPlayers());

        //Gameplay
        round1.play();
        //Game.demoTest();
    }

    /**
     * Method to initialize the players for each game instance. A players name will be cut off at 10 characters.
     */
    public static Player[] initPlayers() {
        final Scanner scan = new Scanner(System.in);

        System.out.print("Put in the players names seperated with a ',': ");
        String[] playerNamesArray = scan.nextLine().split(",");
        Player[] players = new Player[playerNamesArray.length];

        for (int i = 0; i < playerNamesArray.length; i++) {
            players[i] = new Player(playerNamesArray[i]);
        }

        return players;
    }
}
