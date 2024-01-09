package edu.mondragon.oceanRivals;

public class Board {
    private char[][] board;
    private int size;
    
    //To initialize the board
    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    //Prints the board
    public void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "|");
        }
        System.out.println();
    
        for (int i = 0; i < size; i++) {
            System.out.print((char) (i + 65) + "|");
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    System.out.print(" |");
                } else {
                    System.out.print(board[i][j] + "|");
                }
            }
            System.out.println('\n' + "-".repeat(size * 2 + 3));
        }
    }

    //Cleans the board and sets all the values to ' '
    public void cleanBoard() {
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
               board[i][j] = ' ';
            }
        }
    }

    //Checks if the boat can be placed in the board
    public boolean canBeBoatPlaced(Boat boat){
        int boatSize = 0;
        boolean canBePlaced = true;
        while (canBePlaced && boatSize < boat.getSize()) {
            if (boat.getDirection() == 'h') {
                if (board[boat.getX()][boat.getY() + boatSize] != ' ') {
                    canBePlaced = false;
                }
            } else if (boat.getDirection() == 'v') {
                if (board[boat.getX() + boatSize][boat.getY()] != ' ') {
                    canBePlaced = false;
                }
            } else {
                canBePlaced = false;
            }
            boatSize++;
        }
        return canBePlaced;
    }

    //Places the boat in the board
    public void placeBoat(Boat boat){
        if(!canBeBoatPlaced(boat)){
            //throw exception
            throw new ArithmeticException("The boat can't be placed");
        }
        if (boat.getDirection() == 'h') {
            for (int i = 0; i < boat.getSize(); i++) {
                board[boat.getX()][boat.getY() + i] = 'B';
            }
        } else if (boat.getDirection() == 'v') {
            for (int i = 0; i < boat.getSize(); i++) {
                board[boat.getX() + i][boat.getY()] = 'B';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
