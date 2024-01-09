package com.mondradon.BattleShip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SharkTest {
	
	String[][] initialTestLayout = {
            { ".", "@", "x" },
            { ".", ".", "." },
            { ".", ".", "." }
    };
	@Test
    public void testSharkLayout() {
        Shark shark = new Shark();

        shark.setLayout(new Layout(2, 2, initialTestLayout));

        assertEquals(new Layout(2, 2, initialTestLayout).getDimensionX(), shark.getLayout().getDimensionX());
        assertEquals(new Layout(2, 2, initialTestLayout).getDimensionY(), shark.getLayout().getDimensionY());
        assertEquals(new Layout(2, 2, initialTestLayout).getLayout(), shark.getLayout().getLayout());
    }

}
