package com.mr2981.SnakeAndLadderGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mr2981.SnakeAndLadderGame.entity.Dice;
import com.mr2981.SnakeAndLadderGame.entity.GameBoard;
import com.mr2981.SnakeAndLadderGame.entity.Player;
import com.mr2981.SnakeAndLadderGame.entity.Tile;

public class PlayerTest {
	private Player player;
	private Dice dice;
	private GameBoard gameBoard;

	@BeforeEach
	public void setup() {
		gameBoard = GameBoard.newInstance();
		gameBoard.initGameBoard();
		player = new Player("Player1");
		dice = new Dice();
	}

	
	@Test // given player rolls first time
	public void playerRollsTheDiceForTheFirstTimeAndScore3() {
		// when
		Assertions.assertTrue(player.getCurrPosition().getPosition() == 1);

		dice.setDiceState(3);
		Tile nextPosition = player.rollDice(dice, gameBoard.get());
		// then
		Assertions.assertTrue(nextPosition.getPosition() == 4);
	}
	@Test // given player rolls second time he scored 4 
	public void playerRollsTheDiceForTheSecondTimeAndScore4() {
		// when
		Assertions.assertTrue(player.getCurrPosition().getPosition() == 4);

		dice.setDiceState(4);
		Tile nextPosition = player.rollDice(dice, gameBoard.get());
		// then
		Assertions.assertTrue(nextPosition.getPosition() == 8);
	}
}
