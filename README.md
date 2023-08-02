# Yahtzee Game
Welcome to the Yahtzee Game! This is a classic dice game where players roll five dice in an attempt to score points in different categories. The game is implemented in Java and can be played on the command line.

## How to Play
1. You can start the game by running following command in your console. Make sure, you are in the same folder!
```console
java -jar SD1_Project_Yahtzee.jar
```

2. Type in the player names seperated by a comma and press enter. For example, if you want to play with two players named 'Player 1' and 'Player 2', you would enter `Player 1, Player 2` in the command prompt.

3. Roll the dice by entering the dice numbers in the command prompt. You can either roll a single or multiple dice or skip the roll by entering `skip`.

4. After you have rolled, select which dice you would like to set on a combination by entering the corresponding combination number (1-13) in the command prompt. If there are no valid combinations, you have to choose an unset combination to cancel it.

5. The game ends when all categories on the scorecard have been filled. The player with the highest total score wins.

## Scoring
### The categories on the scorecard include:

1. Ones: The total number of ones rolled.
2. Twos: The total number of twos rolled.
3. Threes: The total number of threes rolled.
4. Fours: The total number of fours rolled.
5. Fives: The total number of fives rolled.
6. Sixes: The total number of sixes rolled.
7. Three of a Kind: The sum of all dice if there are three or more of the same number.
8. Four of a Kind: The sum of all dice if there are four or more of the same number.
9. Full House: 25 points if there are three of one number and two of another.
10. Small Straight: 30 points if there are four sequential numbers.
11. Large Straight: 40 points if there are five sequential numbers.
12. Yahtzee: 50 points if all five dice are the same number.
13. Chance: The sum of all dice.

## Features
- Open Limit player support
- User can roll the dice up to three times in a turn
- User can select which dice to keep and which to roll again
- User can select a category on the scorecard to score their roll

## Requirements
- Java environment
- To run the game, compile and run the Yahtzee.java file in your Java environment.

## Contributing
If you would like to contribute to this project, please fork the repository and submit a pull request with your changes.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Contact
If you have any questions or issues, please contact robinsmith-source on Github.

## Enjoy the Game!
I hope you have fun playing Yahtzee!
