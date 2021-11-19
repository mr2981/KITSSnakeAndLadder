package com.mr2981.SnakeAndLadderGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mr2981.SnakeAndLadderGame.entity.Ladder;
import com.mr2981.SnakeAndLadderGame.entity.Tile;

public class LadderTest {
	 private Ladder ladder;

	    @BeforeEach
	    public void setup() {
	        ladder = new Ladder(23);
	    }

	    @Test
	    public void itShouldInitializeEndBox() {
	        Tile endBox = ladder.getEndTile();
	        System.out.println(endBox.getPosition());
	        Assertions.assertTrue( endBox.getPosition() > 30);
	        Assertions.assertTrue(endBox.getPosition() < 100);
	    }
}
