package com.mondradon.BattleShip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {
  

	@Test
	public void testGetAndSetpuntuazioaPlayer1() {
		Game gamePuntuazioaPlayer1= new Game();
		gamePuntuazioaPlayer1.setPuntuazioaPlayer1(2);
		assertEquals(2, gamePuntuazioaPlayer1.getPuntuazioaPlayer1());	
	}
	@Test
	public void testGetAndSetpuntuazioaPlayer2() {
		Game gamePuntuazioaPlayer2= new Game();
		gamePuntuazioaPlayer2.setPuntuazioaPlayer2(3);
		assertEquals(3, gamePuntuazioaPlayer2.getPuntuazioaPlayer2());	
	}
	
	

}
