package com.mondradon.BattleShip;

import java.util.Scanner;

public class Player {

    String izena;
    Layout layout;
    Ship ship1;
    Ship ship2;
    Ship ship3;
    int numTries = 25;
    static Scanner teklatua = new Scanner(System.in);

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

	public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public Ship getShip1() {
        return ship1;
    }

    public void setShip1(Ship ship1) {
        this.ship1 = ship1;
    }

    public Ship getShip2() {
        return ship2;
    }

    public void setShip2(Ship ship2) {
        this.ship2 = ship2;
    }

    public Ship getShip3() {
        return ship3;
    }

    public void setShip3(Ship ship3) {
        this.ship3 = ship3;
    }

    public Player(String izena, Layout layout, Ship ship1, Ship ship2, Ship ship3) {
        this.izena = izena;
        this.layout = layout;
        this.ship1 = ship1;
        this.ship2 = ship2;
        this.ship3 = ship3;
    }

    public Player() {
    }

    // public void atack() {
    /*
     * public Position atack() {
     * 
     * boolean valid = false;
     * 
     * System.out.println("\nIt´s the turn off ("+izena+")");
     * Position positionAtack = BattleShipApplication.createPosition();
     * 
     * valid = BattleShipApplication.verifyPoints(layout, positionAtack);
     * 
     * if(valid){
     * System.out.println("\nvery good position ("+izena+")");
     * }
     * else {
     * System.out.println("\nIt is not a good position, you have wasted your turn ("
     * +izena+")");
     * }
     * 
     * return positionAtack;
     * 
     * }
     */

    public void atack() {

    }

    public int getNumTries() {
        return numTries;
    }

    public void setNumTries(int numTries) {
        this.numTries = numTries;
    }

}
