package edu.mondragon.oceanRivals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoatTest {
    private Boat boat;

    @BeforeEach
    void setUp() {
        boat = new Boat(1, 3, 'h');
    }

    @Test
    void testId() {

        boat.setId(2);
        assertEquals(2, boat.getId());
    }

    @Test
    void testSize() {

        boat.setSize(4);
        assertEquals(4, boat.getSize());
    }

    @Test
    void testHealth() {

        boat.setHealth(2);
        assertEquals(2, boat.getHealth());
    }

    @Test
    void testSunk() {

        boat.setSunk(true);
        assertEquals(true, boat.isSunk());
    }

    @Test
    void testX() {

        boat.setX(5);
        assertEquals(5, boat.getX());
    }

    @Test
    void testY() {

        boat.setY(6);
        assertEquals(6, boat.getY());
    }

    @Test
    void testDirection() {

        boat.setDirection('v');
        assertEquals('v', boat.getDirection());
    }

    @Test
    void testPlaceOnBoard() {

        boat.placeOnBoard(2, 2);

        assertEquals(2, boat.getX());
        assertEquals(2, boat.getY());
    }

    @Test
    void testReceiveAttack() {
        boat.receiveAttack();
        assertEquals(2, boat.getHealth());
        assertFalse(boat.isSunk());

        boat.receiveAttack();
        assertEquals(1, boat.getHealth());
        assertFalse(boat.isSunk());

        boat.receiveAttack();
        assertEquals(0, boat.getHealth());
        assertTrue(boat.isSunk()); 
    }
//sesion 3 
    @Test
    void testRepair() {
           
        assertEquals(boat.getSize(), boat.getHealth());
        assertFalse(boat.isSunk());


        boat.setHealth(3);
        boat.repair();


        assertEquals(boat.getSize(), boat.getHealth());
        assertFalse(boat.isSunk());
    }

    @Test
    void testMove() {
        boat.placeOnBoard(2, 2);
        boat.move(1, -1); 
        assertEquals(3, boat.getX());
        assertEquals(1, boat.getY());
    }

    @Test
    void testRotate() {
        boat.rotate();
        assertEquals('v', boat.getDirection());
        boat.rotate();
        assertEquals('h', boat.getDirection());
    }

    @Test
    void testIsFullHealthy() {
        assertTrue(boat.isFullHealthy());
    }

    @Test
    void testGetStatus() {
        assertEquals("Boat #1 is at full health.", boat.getStatus());
        boat.receiveAttack();
        assertEquals("Boat #1 has been hit. Health: 2/3", boat.getStatus());
        boat.receiveAttack();
        boat.receiveAttack();
        assertEquals("Boat #1 is sunk.", boat.getStatus());
    }
}