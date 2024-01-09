package com.mondradon.BattleShip;

public class Game {

    Player player1;
    Player player2;
    int puntuazioaPlayer1;
    int puntuazioaPlayer2;

    public Game(Player player1, Player player2, int puntuazioaPlayer1, int puntuazioaPlayer2) {
        this.player1 = player1;
        this.player2 = player2;
        this.puntuazioaPlayer1=puntuazioaPlayer1;
        this.puntuazioaPlayer2=puntuazioaPlayer2;
    }
    public Game() {
    	
    }

	public int getPuntuazioaPlayer1() {
		return puntuazioaPlayer1;
	}

	public void setPuntuazioaPlayer1(int puntuazioaPlayer1) {
		this.puntuazioaPlayer1 = puntuazioaPlayer1;
	}

	public int getPuntuazioaPlayer2() {
		return puntuazioaPlayer2;
	}

	public void setPuntuazioaPlayer2(int puntuazioaPlayer2) {
		this.puntuazioaPlayer2 = puntuazioaPlayer2;
	}



    

}
