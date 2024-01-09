package com.mondradon.BattleShip;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

    BattleShipApplication battleShipApplication;

    @Test
    public void testCreatePositionFunction(){
        Position position = new Position(5, 5);
        battleShipApplication.x = 10;
        battleShipApplication.y = 10;
        Position validPosition = battleShipApplication.createPosition();

        assertEquals(validPosition.posX, position.posX);
        assertEquals(validPosition.posY, position.posY);
    }

    @Test
    public void testCreateShip() {
        Ship expectedShip = new Ship(4, new Position(5, 5), new Position(5, 9));
        System.out.println("Enter the first position X=5 and Y = 5");
        System.out.println("Enter the second position X = 5 and Y = 9");
        System.out.println("Enter the ship size = 4");
        Ship ship = battleShipApplication.createShip();
        
        assertEquals(expectedShip.getSize(), ship.getSize());
        assertEquals(expectedShip.getFirstPoint(), ship.getFirstPoint());
        assertEquals(expectedShip.getSecondPoint(), ship.getSecondPoint());
    }

    @Test void testCompareNumbers(){
        assertFalse(BattleShipApplication.compareNumbers(5, 10));
        assertTrue(BattleShipApplication.compareNumbers(10, 5));
    }

    @Test
    public void testAskPosition(){
        Position position = null;
        position = BattleShipApplication.askPosition(position, "first");
        assertNotNull(position);
    }

    @Test
    public void testVerifySize() {
        Position firstPosition = new Position(1, 1);
        Position secondPosition = new Position(4, 5);
        int size = 5;

        boolean result = battleShipApplication.verifySize(size, firstPosition, secondPosition);
        assertFalse(result);

        Position firstPosition2 = new Position(1, 1);
        Position secondPosition2 = new Position(4, 5);
        int size1 = 1;

        boolean result2 = battleShipApplication.verifySize(size1, firstPosition2, secondPosition2);
        assertTrue(result2);
    }

    @Test
    public void testVerifyPosition() {
        assertFalse(BattleShipApplication.verifyPosition(10, 10, 5, 5));
        assertTrue(BattleShipApplication.verifyPosition(5, 5, 10, 10));
    }
}
    

