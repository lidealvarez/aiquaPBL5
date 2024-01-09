package edu.mondragon.oceanRivals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;

    public Game() {
        player1 = new Player("One");
        player2 = new Player("Two");
    }

    public Player changePlayer(boolean change, Player currentPlayer) {
        Player nextPlayer;

        if (!change) {
            if (currentPlayer.equals(player1)) {
                nextPlayer = player2;
            } else {
                nextPlayer = player1;
            }
        } else {
            nextPlayer = currentPlayer;
        }

        return nextPlayer;
    }

    public void createPlayer(Player player) {
        String name = null;

        while (name == null) {
            name = askString("Player name: ");
            if (name == null) {
                System.out.println("You didn't write the name!");
            }
        }

        // player = new Player(name);
    }

    public String askString(String sentence) {
        Scanner scanner = new Scanner(System.in);
        String string = null;

        System.out.print(sentence);
        string = scanner.nextLine();

        return string;
    }

    public void placePlayerBoats(Player currentPlayer) {
        List <Integer> sizes = Arrays.asList(3, 3, 4, 4, 5);
        for (Integer size : sizes) {
            currentPlayer.addBoat(size);
        }

    }

    public void printGameStart() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("************GAME STARTS************");
    }

    public void game() {
        
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void printScores() {
        System.out.println("Player One (" + player1.getName() + ") Score: " + player1.getScore());
        System.out.println("Player Two (" + player2.getName() + ") Score: " + player2.getScore());
    }

    public void printEndGame() {
        if (player1.getScore() > player2.getScore()) {
            System.out.println("Player One (" + player1.getName() + ") wins!");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println("Player Two (" + player2.getName() + ") wins!");
        } else {
            System.out.println("It's a tie! Both players have the same score.");
        }
    }

    public Player getRival(Player currentPlayer) {
        Player nextPlayer;

        if (currentPlayer.equals(player1)) {
            nextPlayer = player2;
        } else {
            nextPlayer = player1;
        }

        return nextPlayer;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.game();
    }
}
