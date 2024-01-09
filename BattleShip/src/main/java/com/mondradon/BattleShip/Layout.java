package com.mondradon.BattleShip;

public class Layout {

    int dimensionX;
    int dimensionY;
    String[][] layout;

    public int getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

    public String[][] getLayout() {
        return layout;
    }

    public void setLayout(String[][] layout) {
        this.layout = layout;
    }

    public Layout(int dimensionX, int dimensionY) {

        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        layout = createLayout(dimensionX, dimensionY);
    }
    public Layout(int dimensionX, int dimensionY, String [][] layout) {

        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.layout = layout;
    }

    public Layout(){
    }
	
	public void placeXAtPosition(Position position) {
        int x = position.getPosX();
        int y = position.getPosY();
        layout[y][x] = "x";
    }
	public void placeArrobaAtPosition(Position position) {
        int x = position.getPosX();
        int y = position.getPosY();
        layout[y][x] = "@";
    }



    public String[][] createLayout(int layoutX, int layoutY) {
		String[][] layout = new String[layoutY][layoutX];

		for (int i = 0; i < layoutY; i++) {
			for (int j = 0; j < layoutX; j++) {
				layout[i][j] = ".";
			}
		}

		return layout;
	}

	public static void displayLayout(String[][] layout) {
		for (int i = 0; i < layout.length; i++) {
			for (int j = 0; j < layout[i].length; j++) {
				System.out.print(layout[i][j]);
			}
			System.out.println();
		}
	}

    public String exploreLayout(Position position)
    {
        int x = position.getPosX();
        int y = position.getPosY();
        String layoutPos = layout[x][y];
        return layoutPos;
    }

    public void comparePosition(Position position){

        String layoutPos = exploreLayout(position);

        if (layoutPos.equals(".")) {
            System.out.println("There is water at this position");
        }
        if (layoutPos.equals("x")) {
            System.out.println("You asked for this pos before");
            placeXAtPosition(position);
        }
        if (layoutPos.equals("@")) {
            System.out.println("Boat is touched");
            placeArrobaAtPosition(position);
        }

    }

}
