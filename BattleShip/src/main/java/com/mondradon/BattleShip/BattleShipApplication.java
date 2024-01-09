package com.mondradon.BattleShip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BattleShipApplication {

	static Player player1;
	static Player player2;
	static Game game;
	static Scanner teklatua = new Scanner(System.in);
	static Layout layout;
	static int x;
	static int y;
	static int puntuazioaPlayer1;
	static int puntuazioaPlayer2;

	public BattleShipApplication() {
		x = CreateLayoutX();
		y = CreateLayoutY();
		layout = new Layout(x, y);
		// Layout.displayLayout(layout);
		player1 = CreatePlayer(layout);
		player2 = CreatePlayer(layout);
		game = new Game(player1, player2, puntuazioaPlayer1, puntuazioaPlayer2);
	}

	public static void main(String[] args) {
		SpringApplication.run(BattleShipApplication.class, args);
		BattleShipApplication battle = new BattleShipApplication();
	}

	public static Player CreatePlayer(Layout layout) {
		String name = null;
		Ship ship1 = createShip();
		Ship ship2 = createShip();
		Ship ship3 = createShip();

		System.out.println("What is the first player name:");
		name = teklatua.nextLine();

		return new Player(name, layout, ship1, ship2, ship3);
	}

	public static int CreateLayoutX() {
		int x = 0;
		boolean ok = false;

		while (!ok) {
			System.out.println("X dimensions : ");
			x = teklatua.nextInt();

			ok = compareNumbers(15, x);
		}
		return x;
	}

	public static int CreateLayoutY() {
		int y = 0;
		boolean ok = false;

		while (!ok) {

			System.out.println("Y dimensions: ");
			y = teklatua.nextInt();

			ok = compareNumbers(15, y);
		}
		return y;
	}

	public static boolean compareNumbers(int number1, int number2){
		boolean baiEz = false;
		if(number1 >= number2){
			baiEz = true;
		}
		return baiEz;
	}

	public static Position askPosition(Position position, String number){
		while (position == null) {
			System.out.println("Which is the " + number + " point of the ship? ");
			position = createPosition();
		}
		return position;
	}

	public static Ship createShip() {
		int size = 0;
		Position firstPoint = null;
		Position secondPoint = null;
		boolean verify = true;

		firstPoint = askPosition(firstPoint, "first");
		secondPoint = askPosition(secondPoint, "second");

		while (verify) {
			System.out.println("What is the size of the ship? ");
			size = teklatua.nextInt();

			verify = verifySize(size, firstPoint, secondPoint);
		}

		return new Ship(size, firstPoint, secondPoint);
	}

	public static boolean verifySize(int size, Position firstPosition, Position secondPosition) {
		int deltaX = Math.abs(secondPosition.getPosX() - firstPosition.getPosX());
		int deltaY = Math.abs(secondPosition.getPosY() - firstPosition.getPosY());

		double length = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

		if (size != length) {
			System.out.println(
					"The distance between the positions of the first point and the second point is not the same as the distance you entered");
			return true;
		} else {
			return false;
		}
	}
	
	
	public static boolean verifyPoints(Layout layout, Position position) {
		
		boolean valid = true;
		
		if(position.posX > layout.dimensionX ) {
			valid = false;
		}
		if(position.posY > layout.dimensionY){
			valid = false;
		}
		
		return valid;
	}

	public static Position createPosition() {
		int posX = 0;
		int posY = 0;

		System.out.println("What is X? ");
		posX = teklatua.nextInt();
		System.out.println("What is Y? ");
		posY = teklatua.nextInt();

		if(verifyPosition(posX, posY, x, y)){
			return new Position(posX, posY);
		}else{
			return null;
		}
	}

	public static boolean verifyPosition(int posX, int posY, int x, int y) {
		if (posX > x || posY > y) {
			System.out.println("The position is out of layout");
			return false;
		} else {
			return true;
		}
	}

}
