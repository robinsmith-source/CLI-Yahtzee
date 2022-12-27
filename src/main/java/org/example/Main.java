package org.example;

public class Main {
    private static final Dice[] dice = {new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};
    public static void main(String[] args) {
        //Game.play();
        Game game1 = new Game();
        game1.demoTest(dice);
    }
    public static Dice[] getDice() {
        return dice;
    }
}
