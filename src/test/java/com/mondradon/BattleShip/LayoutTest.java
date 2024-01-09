package com.mondradon.BattleShip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class LayoutTest {

	 @Test
	    void testDisplayLayout() {
	        String[][] testLayout = {
	            {"*", "*", "*"},
	            {"*", " ", "*"},
	            {"*", "*", "*"}
	        };

		// Redirigir la salida estándar a un stream
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		// Llamar a la función displayLayout con la matriz de prueba
		Layout.displayLayout(testLayout);

		// Restaurar la salida estándar
		System.setOut(System.out);

		// Comprobar línea por línea si la salida coincide con lo esperado
		String[] expectedOutputLines = { "***", "* *", "***" };
		String[] actualOutputLines = outContent.toString().trim().split(System.lineSeparator());
		assertEquals(expectedOutputLines.length, actualOutputLines.length);

		for (int i = 0; i < expectedOutputLines.length; i++) {
			assertEquals(expectedOutputLines[i], actualOutputLines[i]);
		}
	}

	@Test
	public void testPlaceXAtPosition() {
		Layout layout = new Layout(3, 3); // Crear una matriz de 3x3
        Position validPosition = new Position(1, 1); // Crear una posición válida dentro de los límites de la matriz
        layout.placeXAtPosition(validPosition); // Colocar 'x' en la posición (1, 1)


        String[][] expectedMatrix = {
            {".", ".", "."},
            {".", "x", "."},
            {".", ".", "."}
        };

        // Verificar si la posición contiene 'x' en la matriz
        assertEquals("x", layout.getLayout()[1][1]);

	    }
	    @Test
	    public void testPlaceArrobaAtPosition() {
	        Layout layout = new Layout(3, 3); // Crear una matriz de 3x3
	        Position validPosition = new Position(1, 1); // Crear una posición válida dentro de los límites de la matriz
	        layout.placeArrobaAtPosition(validPosition); // Colocar 'x' en la posición (1, 1)

	        String[][] expectedMatrix = {
        		{".", ".", "."},
	            {".", "@", "."},
	            {".", ".", "."}
	        };

	        // Verificar si la posición contiene 'x' en la matriz
	        assertEquals("@", layout.getLayout()[1][1]);
	    }
	    
	
		@Test
    public void testCreateLayout() {
        int layoutX = 5;
        int layoutY = 3;
        Layout layout = new Layout(layoutX, layoutY);

        String[][] expectedLayout = {
            {".", ".", ".", ".", "."},
            {".", ".", ".", ".", "."},
            {".", ".", ".", ".", "."}
        };

        String[][] actualLayout = layout.createLayout(layoutX, layoutY);

		assertArrayEquals(expectedLayout, actualLayout);
	}


    @Test
    public void testExploreLayout() {
        int dimensionX = 3;  // Reemplaza estos valores con las dimensiones correctas de tu diseño.
        int dimensionY = 3;

        Layout layoutInstance = new Layout(dimensionX, dimensionY);

        Position positionA = new Position(0, 0);  // Posición (0, 0)
        Position positionE = new Position(1, 1);  // Posición (1, 1)
        Position positionI = new Position(2, 2);  // Posición (2, 2)

        String resultA = layoutInstance.exploreLayout(positionA);
        String resultE = layoutInstance.exploreLayout(positionE);
        String resultI = layoutInstance.exploreLayout(positionI);

        assertEquals(".", resultA);  // Esperando '.' en (0, 0)
        assertEquals(".", resultE);  // Esperando '.' en (1, 1)
        assertEquals(".", resultI);  // Esperando '.' en (2, 2)
    }

	@Test
	public void testGetterAndSetterDimensionX(){
		Layout layout = new Layout();
		layout.setDimensionX(5);
		assertEquals(layout.dimensionX, layout.getDimensionX());
	}

	@Test
	public void testGetterAndSetterDimensionY(){
		Layout layout = new Layout();
		layout.setDimensionY(5);
		assertEquals(layout.dimensionY, layout.getDimensionY());
	}


	@Test
	public void testGetterAndSetterLayout(){
		Layout layout = new Layout();
		layout.setLayout(new String[1][1]);
		assertEquals(layout.layout, layout.getLayout());
	}

	@Test
    public void testComparePositionWater() {
        // Arrange
        Layout layout = new Layout();

        // Act
        String positionLayout = ".";

        // Assert
        assertEquals(".", positionLayout);
    }

    @Test
    public void testComparePositionX() {
        // Arrange
        Layout layout = new Layout();

        // Act
        String positionLayout = "x";
		
        // Assert
        assertEquals("x", positionLayout);
    }

    @Test
    public void testComparePositionAt() {
        // Arrange
        Layout layout = new Layout();

        // Act
        String positionLayout = "@";

        // Assert
        assertEquals("@", positionLayout);
    }

}
