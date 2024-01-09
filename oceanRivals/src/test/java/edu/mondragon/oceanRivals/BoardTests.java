package edu.mondragon.oceanRivals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BoardTests {

    @Test
    void testBoard() {
        Board board = new Board(10);
        assertNotNull(board);
    }

    @Test
    void testCleanBoard() {
        Board board = new Board(10);
        Boat boat = new Boat(1, 3, 'h');
        boat.setX(0);
        boat.setY(0);
        board.placeBoat(boat);
        assertEquals('B', board.getBoard()[0][0]);
        board.cleanBoard();
        assertEquals(' ', board.getBoard()[0][0]);
    }

    @Test
    void canBeBoatPlacedHorizontal() {
        Board board = new Board(10);
        Boat boat = new Boat(1, 3, 'h');
        boat.placeOnBoard(0, 0);
        assertTrue(board.canBeBoatPlaced(boat));
    }


    @Test
    void canBeBoatPlaceVertical() {
        Board board = new Board(10);
        Boat boat = new Boat(1, 3, 'v');
        boat.placeOnBoard(0, 0);
        assertTrue(board.canBeBoatPlaced(boat));
    }

    @Test
    void CanbeBoatPlacedNotHorizontal() {
        Board board = new Board(10);
        Boat boat = new Boat(1, 3, 'h');
        boat.placeOnBoard(0, 0);
        board.placeBoat(boat);
        Boat boat2 = new Boat(1, 3, 'h');
        boat2.placeOnBoard(0, 0);
        assertFalse(board.canBeBoatPlaced(boat2));
    }

    @Test
    void CanbeBoatPlaceNotVertical(){
        Board board = new Board(10);
        Boat boat = new Boat(1, 3, 'v');
        boat.placeOnBoard(0, 0);
        board.placeBoat(boat);
        Boat boat2 = new Boat(1, 3, 'v');
        boat2.placeOnBoard(0, 0);
        assertFalse(board.canBeBoatPlaced(boat2));
    }

    @Test
    void CanbeBoatPlaceNotUnknown(){
        Board board = new Board(10);
        Boat boat = new Boat(1, 3, 'G');
        boat.placeOnBoard(0, 0);
        assertFalse(board.canBeBoatPlaced(boat));
    }

    @Test
    void testPlaceBoatHorizontal() {
        Board board = new Board(10);
        Boat boat = new Boat(1, 3, 'h');
        boat.placeOnBoard(0, 0);
        board.placeBoat(boat);
        assertEquals('B', board.getBoard()[0][0]);
    }

    @Test
    void testPlaceBoatVertical() {
        Board board = new Board(10);
        Boat boat = new Boat(1, 3, 'v');
        boat.placeOnBoard(0, 0);
        board.placeBoat(boat);
        assertEquals('B', board.getBoard()[0][0]);
    }

    @Test
    void testPlaceBoatUnknown() {
        Board board = new Board(10);
        Boat boat = new Boat(1, 3, 'l');
        boat.placeOnBoard(0, 0);
        
        assertThrows(ArithmeticException.class, () -> board.placeBoat(boat));
    }
    
    
    @Test
    void testPlaceBoatWithoutPlace() {
        Board board = new Board(10);
        char horizontal = 'h';
        Boat boat = new Boat(1, 3, horizontal);
        boat.setDirection('h');
        boat.setX(0);
        boat.setY(0);

        Boat boat2 = new Boat(1, 3, horizontal);
        boat2.setDirection('h');
        boat2.setX(0);
        boat2.setY(0);

        board.placeBoat(boat);
        assertThrows(ArithmeticException.class,()-> board.placeBoat(boat2));
    }

    // @Test
    // void testPrintBoard() {
    //     Board board = new Board(10);
    //     board.printBoard();
    // }

    @Test
    void testGetBoard() {
        Board board = new Board(10);
        assertNotNull(board.getBoard());
    }

    @Test
    void testGetSize() {
        Board board = new Board(10);
        assertEquals(10, board.getSize());
    }

    @Test
    void testSetBoard() {
        Board board = new Board(10);
        char[][] testBoard = new char[10][10];
        board.setBoard(testBoard);
        assertEquals(testBoard,board.getBoard());
    }

    @Test
    void testSetSize() {
        Board board = new Board(10);
        board.setSize(5);
        assertEquals(5, board.getSize());
    }
}
