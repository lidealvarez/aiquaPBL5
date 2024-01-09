package edu.mondragon.oceanRivals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mondragon.oceanRivals.Boat;
import edu.mondragon.oceanRivals.Tsunami;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class TsunamiTest {
    private Tsunami tsunami;

    @BeforeEach
    void setUp() {
        tsunami = new Tsunami(5);
    }

    @Test
    void testStrengthOperations() {
        // Comprobación inicial
        assertEquals(5, tsunami.getStrength());

        // Modificación y comprobación
        tsunami.setStrength(8);
        assertEquals(8, tsunami.getStrength());
    }

    @Test
    void testImpactBoat() {
        Boat boat = new Boat(1, 3, 'h');

        tsunami.impactBoat(boat);
        assertTrue(boat.getHealth() >= 0);

        if (boat.getHealth() == 0) {
            assertTrue(boat.isSunk());
            System.out.println("Boat #" + boat.getId() + " has been sunk by the tsunami!");
        } else {
            assertFalse(boat.isSunk());
            System.out
                    .println("Boat #" + boat.getId() + " has been damaged by the tsunami. Health: " + boat.getHealth());
        }
    }

    @Test
    void testCalculateDamage() {
        int damage = tsunami.calculateDamage();
        assertTrue(damage >= 1 && damage <= tsunami.getStrength());
    }

    @Test
    void testGetDescription() {
        assertEquals("A tsunami with strength 5 is approaching!", tsunami.getDescription());
    }

}