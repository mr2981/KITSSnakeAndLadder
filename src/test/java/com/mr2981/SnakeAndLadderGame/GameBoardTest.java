package com.mr2981.SnakeAndLadderGame;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mr2981.SnakeAndLadderGame.entity.Dice;
import com.mr2981.SnakeAndLadderGame.entity.GameBoard;
import com.mr2981.SnakeAndLadderGame.entity.Ladder;
import com.mr2981.SnakeAndLadderGame.entity.Player;
import com.mr2981.SnakeAndLadderGame.entity.Snake;
import com.mr2981.SnakeAndLadderGame.entity.Tile;

public class GameBoardTest {
	private GameBoard gameBoard;
	private Player player;
	private Dice dice;

	@BeforeAll
	public void setup() {
		gameBoard = GameBoard.newInstance();
		player = new Player("Player1");
		dice = new Dice();
	}

	@Test
	public void itShouldInitializePlayerForTheGame() {
		// given the game is started
		Player player1 = new Player("Player1");

		// when
		boolean isInitialized = gameBoard.initPlayers(player1);

		// then
		Assertions.assertTrue(isInitialized);
		Assertions.assertTrue(player1.getCurrPosition().getPosition() == 1);
		Assertions.assertFalse(gameBoard.getPlayers().isEmpty());
	}

	@Test
	public void itShouldInitializeGameDice() {
		// Given
		Dice dice = new Dice();

		// when
		boolean isInitialized = gameBoard.initDice(dice);

		Assertions.assertTrue(isInitialized);
		Assertions.assertNotNull(gameBoard.getDice());
	}

	@Test // Given the game is started
	public void itShouldInitializeTheSnakesAndLadderGameBoard() {
		int expectedTokenValue =1;
		// When
		boolean isInitialized = gameBoard.initGameBoard();

		// Then
		Assertions.assertTrue(isInitialized);
		Assertions.assertTrue(player.getCurrPosition().getPosition() == expectedTokenValue);
		Assertions.assertEquals(gameBoard.get().size(), 100);
		Assertions.assertEquals(5, gameBoard.get().stream().filter(tile -> tile instanceof Snake).toArray().length);
		Assertions.assertEquals(7, gameBoard.get().stream().filter(tile -> tile instanceof Ladder).toArray().length);
	}

	@Test // given player rolls first time
	public void playerRollsTheDiceForTheFirstTimeAndScore3() {
		int expectedTokenValue =4;
		// when
		Assertions.assertTrue(player.getCurrPosition().getPosition() == 1);
		dice.setDiceState(3);

		Tile nextPosition = player.rollDice(dice, gameBoard.get());
		// then
		Assertions.assertTrue(nextPosition.getPosition() == expectedTokenValue);
	}

	@Test // given player is at 1 and he roll 3 and then 4
	public void playerRollsTheDiceFor3andThen4() {
		// when
		Assertions.assertTrue(player.getCurrPosition().getPosition() == 1);
		dice.setDiceState(3);

		Tile nextPosition = player.rollDice(dice, gameBoard.get());

		dice.setDiceState(4);
		nextPosition = player.rollDice(dice, gameBoard.get());
		// then
		Assertions.assertTrue(nextPosition.getPosition() == 8);
	}

	@Test
	public void playerOneRollsTheDiceAfterGameStared() {
		// given
		gameBoard.initPlayers(new Player("Player1"));
		gameBoard.initDice(new Dice());
		gameBoard.initGameBoard();
		List<Integer> validStates = Arrays.asList(1, 2, 3, 4, 5, 6);
		// when
		Player currPlayer = gameBoard.play();

		// then
		Assertions.assertEquals("Player1", currPlayer.getplayer_name());
		Assertions.assertTrue(validStates.contains(currPlayer.getCurrPosition().getPosition()));

	}

	
	@Test
	public void playerRollDiceAfterGStartNThenScore4() {
		// given
		gameBoard.initPlayers(new Player("Player1"));
		gameBoard.initDice(new Dice());
		gameBoard.initGameBoard();
		List<Integer> validStates = Arrays.asList(1, 2, 3, 4, 5, 6);

		// when
		System.out.println(
				"Player before roll at position :" + gameBoard.getPlayers().get(0).getCurrPosition().getPosition());
		Player currPlayer = gameBoard.play();
		int previousPosition = currPlayer.getCurrPosition().getPosition();
		System.out.println("Player at position :" + previousPosition);

		dice.setDiceState(4);
		Tile nextPosition = currPlayer.rollDice(dice, gameBoard.get());
		// then
		Assertions.assertEquals("Player1", currPlayer.getplayer_name());
		Assertions.assertTrue(nextPosition.getPosition() > previousPosition);
		Assertions.assertTrue(nextPosition.getPosition() <= 100);
	}
}
