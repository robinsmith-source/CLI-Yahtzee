package org.example.Game;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);

        final Player[] players = {new Player("Gomme"), new Player("Trolololol"), new Player("Gommemode")};
        final Dice[] dice = {new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};

        Dice.roll(dice);

        System.out.println("1. Dice Value " + dice[0].getFaceValue());
        System.out.println("2. Dice Value " + dice[1].getFaceValue());
        System.out.println("3. Dice Value " + dice[2].getFaceValue());
        System.out.println("4. Dice Value " + dice[3].getFaceValue());
        System.out.println("5. Dice Value " + dice[4].getFaceValue());
        System.out.println(Dice.showDice(dice));

        System.out.println("Sum of all 5 Dice: " + Dice.sumFaces(dice));


        for(int i = 0; i < 2; i++) {
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
            System.out.println("Sum of all 5 Dice: " + Dice.sumFaces(dice));
        }






    }
}