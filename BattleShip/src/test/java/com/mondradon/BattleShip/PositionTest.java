package com.mondradon.BattleShip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

	@Test
	public void testGetAndSetPosX() {
		Position positionX= new Position();
		positionX.setPosX(9);
		assertEquals(9, positionX.getPosX());
		
	}
	@Test
	public void testGetAndSetPosY() {
		Position positionY= new Position();
		positionY.setPosY(9);
		assertEquals(9, positionY.getPosY());
		
	}

}
