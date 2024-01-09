package edu.mondragon.oceanRivals;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

class GameTest {

  boolean change;
  Player currentPlayer;
  Player expectedPlayer;
  static Game game = new Game();

  @Test
  void testChangePlayer1to1() {
    boolean change = true;
    Player currentPlayer = game.getPlayer1();
    Player expectedPlayer = game.getPlayer1();
    assertEquals(game.changePlayer(change, currentPlayer), expectedPlayer);
  }

  @Test
  void testChangePlayer1to2() {
    boolean change = false;
    Player currentPlayer = game.getPlayer1();
    Player expectedPlayer = game.getPlayer2();
    assertEquals(game.changePlayer(change, currentPlayer), expectedPlayer);
  }

  @Test
  void testChangePlayer2to1() {
    boolean change = false;
    Player currentPlayer = game.getPlayer2();
    Player expectedPlayer = game.getPlayer1();
    assertEquals(game.changePlayer(change, currentPlayer), expectedPlayer);
  }

  @Test
  void testGetAndSetPlayer1() {
    Game testGame = new Game();
    Player testPlayer = new Player("Test player 1");
    testGame.setPlayer1(testPlayer);
    assertEquals(testPlayer, testGame.getPlayer1());
  }

  @Test
  void testGetAndSetPlayer2() {
    Game testGame = new Game();
    Player testPlayer = new Player("Test player 2");
    testGame.setPlayer2(testPlayer);
    assertEquals(testPlayer, testGame.getPlayer2());
  }

  @Test
  void testCreatePlayer() {
    String expectedName = "Unai";
    Player player = new Player(expectedName);
    System.setIn(new ByteArrayInputStream(expectedName.getBytes()));
    game.createPlayer(player);
    assertEquals(expectedName, player.getName());
  }

  @Test
  void testAskString() {
    String sentence = "Player name: ";
    String expected = "Unai";
    System.setIn(new ByteArrayInputStream(expected.getBytes()));
    String actual = game.askString(sentence);
    assertEquals(expected, actual);
  }

  public void testGetRival() {
    Game testGame = new Game();
    Player player1 = new Player("Player 1");
    Player player2 = new Player("Player 2");
    testGame.setPlayer1(player1);
    testGame.setPlayer2(player2);

    // Verifica que el rival de player1 sea player2
    Player rival1 = testGame.getRival(player1);
    assertEquals(player2, rival1);

    // Verifica que el rival de player2 sea player1
    Player rival2 = testGame.getRival(player2);
    assertEquals(player1, rival2);
  }

}
