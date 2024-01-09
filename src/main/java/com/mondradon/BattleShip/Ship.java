package com.mondradon.BattleShip;

public class Ship {

    int size;
    Position firstPoint;
    Position secondPoint;
    boolean sunken;
    
    public Ship() {

    }
    
    public Ship(int size, Position firstPoint, Position secondPoint) {
    	sunken = false;
        this.size = size;
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Position getFirstPoint() {
		return firstPoint;
	}

	public void setFirstPoint(Position firstPoint) {
		this.firstPoint = firstPoint;
	}

	public Position getSecondPoint() {
		return secondPoint;
	}

	public void setSecondPoint(Position secondPoint) {
		this.secondPoint = secondPoint;
	}

	public boolean getSunken() {
		return sunken;
	}

	public void setSunken(boolean sunken) {
		this.sunken = sunken;
	}

    
}
