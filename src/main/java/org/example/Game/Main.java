package org.example.Game;
import java.util.Scanner;
/**
 * Main class to run (several instances of) the Game.
 */
public class Main {
    private static final Scanner scan = new Scanner(System.in);
    /**
     * Main Method to run the Game.
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        //Game Initialisation
        Game game = new Game(initPlayers());
        //Gameplay
        game.play();
        //Game.demoTest();
    }

    /**
     * Method to initialize the players. Isn't final yet.
     */
    public static Player[] initPlayers() {
        System.out.print("Put in the players names seperated with a ',': ");
        String[] playerNamesArray = scan.nextLine().split(",");
        Player[] players = new Player[playerNamesArray.length];
        for (int i = 0; i < playerNamesArray.length; i++) {
            players[i] = new Player(playerNamesArray[i]);
        }
        return players;
    }
}
