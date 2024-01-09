package com.mondradon.BattleShip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ShipTest {

    BattleShipApplication battleShipApplication;
    
	@Test
	void testGetAndSetSize() {
		Ship testShip = new Ship();
		testShip.setSize(14);
		assertEquals(14, testShip.getSize());
	}
	
	@Test
	void testGetAndSetFirstPoint() {

		Ship testShip = new Ship();
		Position position = new Position(10,4);
				
		testShip.setFirstPoint(position);
		assertEquals(position, testShip.getFirstPoint());
	}
	
	@Test
	void testGetAndSetSecondPoin() {
		Ship testShip = new Ship();
		Position position = new Position(15,5);
				
		testShip.setSecondPoint(position);
		assertEquals(position, testShip.getSecondPoint());
	}
	
	@Test
	void testGetAndSetSunken() {
		Ship testShip = new Ship();
		testShip.setSunken(true);
		assertEquals(true, testShip.getSunken());
	}

    @Test
    public void testVerifyPointTrue() {
    	Layout layout = new Layout(10,10);
        Position position = new Position(4, 5);

        boolean result = battleShipApplication.verifyPoints(layout,position);

        assertTrue(result);
    }
    
    @Test
    public void testVerifyPointFalse() {
    	Layout layout = new Layout(10,10);
        Position position = new Position(12, 5);

        boolean result = battleShipApplication.verifyPoints(layout,position);

        assertFalse(result);
        
        
    }
}

