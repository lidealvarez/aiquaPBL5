package com.mondradon.BattleShip;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {

    public PlayerTest() {
    }
    
    @Test
	public void testGetterAndSetterNumTries(){
		Player player = new Player();
		player.setNumTries(5);
		assertEquals(player.numTries, player.getNumTries());
	}

}

    @Test
    public void testGetterSetterIzena(){
        Player player = new Player();
        player.setIzena("Julen");
        assertEquals("Julen", player.getIzena());
    }

    @Test
    public void testGetterSetterLayout(){
        Player player = new Player();
        Layout layout = new Layout(4, 5);
        player.setLayout(layout);
        assertEquals(layout, player.getLayout());
    }

    @Test
    public void testGetterSetterShip1(){
        Player player = new Player();
        Position firstPosition = new Position(1, 2);
        Position secondPosition = new Position(1, 1);
        Ship ship1 = new Ship(1, firstPosition, secondPosition);
        player.setShip1(ship1);
        assertEquals(ship1, player.getShip1());
    }

    @Test
    public void testGetterSetterShip2(){
        Player player = new Player();
        Position firstPosition = new Position(5, 4);
        Position secondPosition = new Position(5, 6);
        Ship ship2 = new Ship(2, firstPosition, secondPosition);
        player.setShip1(ship2);
        assertEquals(ship2, player.getShip1());
    }

    @Test
    public void testGetterSetterShip3(){
        Player player = new Player();
        Position firstPosition = new Position(6, 9);
        Position secondPosition = new Position(6, 6);
        Ship ship3 = new Ship(3, firstPosition, secondPosition);
        player.setShip1(ship3);
        assertEquals(ship3, player.getShip1());
    }

    	@Test
	void testAtackTrue() {
		System.out.println("Not yet implemented");
	}
	
	
	@Test
	void testAtackFalse() {
		System.out.println("Not yet implemented");
	}



}
