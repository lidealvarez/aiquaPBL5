package edu.mondragon.oceanRivals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private Board ownBoard;
    private Board opponentBoard;
    private List<Boat> boats;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.boats = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Boat> getBoats() {
        return boats;
    }

    public void setBoats(List<Boat> boats) {
        this.boats = boats;
    }

    public boolean hasLost() {
        for (Boat boat : boats) {
            if (!boat.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public int getRowFromLetter(char row) {
        if (row >= 'A' && row <= 'J') {
            return row - 'A';
        } else {
            throw new IllegalArgumentException("Invalid row letter. Must be between A and J.");
        }
    }

   /*  public void addBoat(int size) {
        int tries = 0;
        while (tries < 3) {
            int id = boats.size() + 1;
            Boat newBoat = new Boat(id, size, 'h'); // 'h' is the default direction

            // Ask for the coordinates of the boat
            Scanner scanner = new Scanner(System.in);
            int[] coords = askForCoordinates(scanner);
            newBoat.setX(coords[0]);
            newBoat.setY(coords[1]);

            // Ask for the direction of the boat
            System.out.println("Enter the direction of the boat (h for horizontal, v for vertical): ");
            String direction = scanner.nextLine().toLowerCase();
            if (direction.equals("h")) {
                newBoat.setDirection('h');
            } else if (direction.equals("v")) {
                newBoat.setDirection('v');
            } else {
                System.out.println("Invalid direction. Please enter h or v.");
                continue;
            }

            if (ownBoard.canBeBoatPlaced(newBoat)) {
                boats.add(newBoat);
                return;
            } else {
                System.out.println("Unable to place a boat of size " + size + ". Trying again...");
                tries++;
            }
        }
        System.out.println("Failed to place a boat of size " + size + " after 3 attempts.");
    }*/

    public void askForCoordinatesAndPosition(int size) {
        int id = boats.size() + 1;
        Boat newBoat = new Boat(id, size, 'h'); // 'h' is the default direction

        // Ask for the coordinates of the boat
        Scanner scanner = new Scanner(System.in);
        int[] coords = askForCoordinates(scanner);
        newBoat.setX(coords[0]);
        newBoat.setY(coords[1]);

        // Ask for the direction of the boat
        System.out.println("Enter the direction of the boat (h for horizontal, v for vertical): ");
        String direction = scanner.nextLine().toLowerCase();
        if (direction.equals("h")) {
            newBoat.setDirection('h');
        } else if (direction.equals("v")) {
            newBoat.setDirection('v');
        } else {
            System.out.println("Invalid direction. Please enter h or v.");
            return;
        }

        addBoat(newBoat);
    }

    public void addBoat(Boat newBoat) {
        int tries = 0;
        while (tries < 3) {
            if (ownBoard.canBeBoatPlaced(newBoat)) {
                boats.add(newBoat);
                return;
            } else {
                System.out.println("Unable to place a boat of size " + newBoat.getSize() + ". Trying again...");
                return;
            }
        }
    }

    int[] askForCoordinates(Scanner scanner) {
        System.out.println(name + ", type the coordinates for the boat: ");

        String input = scanner.nextLine().toUpperCase(); // Expecting input like "A1"
        char rowLetter = input.charAt(0); // This will be 'A', 'B', 'C', etc.
        int row = getRowFromLetter(rowLetter); // This function converts 'A' to 0, 'B' to 1, etc.

        // The rest of the input string should be the column number
        int col = Integer.parseInt(input.substring(1)) - 1; // Subtract 1 to align with 0-indexed arrays

        return new int[] { row, col };
    }

    /*
     * public boolean makeGuess(Board rivalBoard) {
     * Scanner scanner = new Scanner(System.in);
     * boolean hit = false;
     * do {
     * int[] coordinates = askForCoordinates(scanner);
     * int x = coordinates[0];
     * int y = coordinates[1];
     * 
     * hit = opponentBoard.makeGuess(x, y); // Assume this method returns true if a
     * boat is hit
     * //
     * if (hit) {
     * System.out.println("It's a hit!");
     * addScore(1);
     * } else {
     * System.out.println("You missed.");
     * }
     * } while (hit); // If it's a hit, the loop continues for the player to guess
     * again
     * 
     * return !hit; // Return true if the player missed, indicating that it's the
     * next player's turn
     * }
     */

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative");
        }
        this.score += points;
    }

    public Board getOwnBoard() {
        return ownBoard;
    }

    public void setOwnBoard(Board ownBoard) {
        this.ownBoard = ownBoard;
    }

    public Board getOpponentBoard() {
        return opponentBoard;
    }

    public void setOpponentBoard(Board opponentBoard) {
        this.opponentBoard = opponentBoard;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', score=" + score + "}";
    }

    public void addBoat(Integer size) {
    }
}
