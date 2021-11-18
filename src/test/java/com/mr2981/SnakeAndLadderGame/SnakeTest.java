package com.mr2981.SnakeAndLadderGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mr2981.SnakeAndLadderGame.entity.Snake;
import com.mr2981.SnakeAndLadderGame.entity.Tile;

public class SnakeTest {
	 private Snake snake;

	    @BeforeAll
	    public void setup() {
	        snake = new Snake(23);
	    }

	    @Test
	    public void itShouldInitializeEndBox() {
	        Tile endBox = snake.getEndTile();
	        System.out.println(endBox.getPosition());
	        Assertions.assertTrue( endBox.getPosition() < 20);
	        Assertions.assertTrue(endBox.getPosition() > 0);
	    }
}
