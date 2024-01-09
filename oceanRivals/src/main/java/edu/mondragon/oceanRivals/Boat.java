package edu.mondragon.oceanRivals;


public class Boat {
    private int id;
    private int size;
    private int health;
    private boolean sunk;
    private int x; // X-coordinate on the game board
    private int y; // Y-coordinate on the game board
    private char direction; // 'h' (horizontal) or 'v' (vertical)

    public Boat(int id, int size, char direction) {
        this.id = id;
        this.size = size;
        this.health = size;
        this.sunk = false;
        this.x = -1; // Initialize coordinates to -1 (not on the board)
        this.y = -1;
        this.direction = direction;
    }


    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public int getHealth() {
        return health;
    }

    public boolean isSunk() {
        return sunk;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setSize(int size) {
        this.size = size;
    }


    public void setHealth(int health) {
        this.health = health;
    }


    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }


    public void setX(int x) {
        this.x = x;
    }


    public void setY(int y) {
        this.y = y;
    }


    public void setDirection(char direction) {
        this.direction = direction;
    }


    public void placeOnBoard(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void receiveAttack() {
        if (!sunk) {
            health--;
            if (health == 0) {
                sunk = true;
                System.out.println("Boat #" + id + " has been sunk!");
            }
        }
    }

    //sesion 3
    public void repair() {
        if (!sunk) {
            health = size;
            System.out.println("Boat #" + id + " has been repaired and is now at full health.");
        }
    }

    public void move(int deltaX, int deltaY) {
        if (x != -1 && y != -1) {
            x += deltaX;
            y += deltaY;
        }
    }

    public void rotate() {
        if (!sunk) {
            direction = (direction == 'h') ? 'v' : 'h';
        }
    }

    public boolean isFullHealthy() {
        return !sunk && health == size;
    }

    public String getStatus() {
        if (sunk) {
            return "Boat #" + id + " is sunk.";
        } else if (health == size) {
            return "Boat #" + id + " is at full health.";
        } else {
            return "Boat #" + id + " has been hit. Health: " + health + "/" + size;
        }
    }
}
