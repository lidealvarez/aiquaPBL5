package edu.mondragon.oceanRivals;

import java.util.Random;

public class Tsunami {
    private int strength;

    public Tsunami(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void impactBoat(Boat boat) {
        if (!boat.isSunk()) {
            int damage = calculateDamage();
            boat.setHealth(Math.max(0, boat.getHealth() - damage));
    
            if (boat.getHealth() == 0) {
                boat.setSunk(true);
                System.out.println("Boat #" + boat.getId() + " has been sunk by the tsunami!");
            } else {
                System.out.println("Boat #" + boat.getId() + " has been damaged by the tsunami. Health: " + boat.getHealth());
            }
        }
    }
    
    

    public int calculateDamage() {
        Random random = new Random();
        return random.nextInt(strength) + 1;
    }

    public String getDescription() {
        return "A tsunami with strength " + strength + " is approaching!";
    }
  
   
}