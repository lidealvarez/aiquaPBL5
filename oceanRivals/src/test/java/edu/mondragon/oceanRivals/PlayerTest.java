package edu.mondragon.oceanRivals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;;

class PlayerTest {

  private Player player;
  private List<Boat> testBoats;
  private final InputStream originalIn = System.in;
  private Board testBoard;
  private Boat addBoatTest;

  @Mock
  private Board mockOwnBoard;

  @Mock
  private Board mockOpponentBoard;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    player = new Player("TestPlayer");
    testBoats = new ArrayList<>();
    testBoard = new Board(10);
    player.setOwnBoard(testBoard);
    Boat boat1 = new Boat(4, 3, 'h');
    Boat boat2 = new Boat(5, 2, 'h');
    addBoatTest = new Boat(6,2,'h');
    // boat2.setSunk(true);

    testBoats.add(boat1);
    testBoats.add(boat2);

    player.setBoats(testBoats);

    mockOwnBoard = mock(Board.class);
    mockOpponentBoard = mock(Board.class);

    player.setOwnBoard(mockOwnBoard);
    player.setOpponentBoard(mockOpponentBoard);
  }

  @AfterEach
  void restoreSystemInStream() {
    System.setIn(originalIn); // Restore original System.in after tests
  }

  @Test
  void testAskForCoordinates() {
    // Simulate user input "A1\n"
    String simulatedUserInput = "A1\n";
    ByteArrayInputStream bais = new ByteArrayInputStream(simulatedUserInput.getBytes());
    System.setIn(bais);

    // Create a new scanner with the modified System.in
    Scanner scanner = new Scanner(System.in);
    // Since askForCoordinates is private, you need to make it package-private
    int[] coordinates = player.askForCoordinates(scanner);

    // A1 should correspond to [0, 0] after adjusting for 0-index
    int[] expectedCoordinates = { 0, 0 };
    assertArrayEquals(expectedCoordinates, coordinates, "The coordinates should match the input A1.");
  }

  @Test
  void testHasLost_NotAllBoatsSunk() {
    // Not all boats are sunk, so the player should not have lost
    assertFalse(player.hasLost(), "Player should not have lost if not all boats are sunk.");
  }

  @Test
  void testHasLost_AllBoatsSunk() {

    for (Boat boat : testBoats) {
      boat.setSunk(true);
    }

    assertTrue(player.hasLost(), "Player should have lost if all boats are sunk.");
  }

  @Test
  void testGetAndSetBoats() {
    player.setBoats(null);
    // Initially, the player's boat list should be null or empty
    assertTrue(player.getBoats() == null || player.getBoats().isEmpty(),
        "Initially, boats list should be null or empty.");

    // Set the boats using the setter
    player.setBoats(testBoats);

    // Retrieve the boats using the getter
    List<Boat> boats = player.getBoats();

    // Ensure the retrieved list matches what was set
    assertEquals(testBoats, boats, "The retrieved boats list should be the same as the one that was set.");

    // Ensure that it is the same list reference (optional)
    assertTrue(boats == testBoats, "The list reference should be the same for both getting and setting.");
  }

  @Test
  void testGetRowFromLetter_ValidLetters() {
    assertEquals(0, player.getRowFromLetter('A'), "A should correspond to row 0.");
    assertEquals(1, player.getRowFromLetter('B'), "B should correspond to row 1.");
    assertEquals(2, player.getRowFromLetter('C'), "C should correspond to row 2.");
    // Continue for the rest of the valid letters up to 'J'
    assertEquals(9, player.getRowFromLetter('J'), "J should correspond to row 9.");
  }

  @Test
  void testGetRowFromLetter_InvalidLetters() {
    assertThrows(IllegalArgumentException.class, () -> player.getRowFromLetter('K'),
        "Letter K is invalid and should throw an exception.");
    assertThrows(IllegalArgumentException.class, () -> player.getRowFromLetter('Z'),
        "Letter Z is invalid and should throw an exception.");
    // You can also test for lowercase or any other invalid characters
    assertThrows(IllegalArgumentException.class, () -> player.getRowFromLetter('a'),
        "Lowercase a is invalid and should throw an exception.");
  }

  @Test
  void testNameGetterSetter() {
    Player player = new Player("OriginalName");
    assertEquals("OriginalName", player.getName(), "The name should be initially set by the constructor.");

    player.setName("NewName");
    assertEquals("NewName", player.getName(), "The name should be updated by the setter.");
  }

  @Test
  void testScoreGetterSetter() {
    Player player = new Player("TestPlayer");
    assertEquals(0, player.getScore(), "The score should be initially 0.");

    player.setScore(10);
    assertEquals(10, player.getScore(), "The score should be updated by the setter.");
  }

  @Test
  void addScore() {
    Player player = new Player("John");
    player.addScore(10);
    assertEquals(10, player.getScore());
  }

  @Test
  void addNegativeScore() {
    Player player = new Player("John");
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      player.addScore(-5);
    });

    String expectedMessage = "Points cannot be negative";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void testToString() {
    Player player = new Player("John");
    player.addScore(10);
    String expectedString = "Player{name='John', score=10}";
    assertEquals(expectedString, player.toString());
  }

  @Test
  void testOwnBoardGetterSetter() {
    int boardSize = 10;
    Board testBoard = new Board(boardSize);
    player.setOwnBoard(testBoard);
    assertEquals(testBoard, player.getOwnBoard(), "The ownBoard should be the one that was set.");
  }

  @Test
  void testOpponentBoardGetterSetter() {
    int boardSize = 10;
    Board testBoard = new Board(boardSize);
    player.setOpponentBoard(testBoard);
    assertEquals(testBoard, player.getOpponentBoard(), "The opponentBoard should be the one that was set.");
  }

  @Test
  void testAddBoat() {

      player.addBoat(addBoatTest);
      assertEquals(2, player.getBoats().size());
      Boat boat = player.getBoats().get(0);
      assertEquals(3, boat.getSize());
      assertFalse(boat.isSunk());
      assertEquals('h', boat.getDirection());
  }

}
