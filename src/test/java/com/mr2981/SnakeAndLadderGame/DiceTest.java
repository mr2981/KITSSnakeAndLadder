package com.mr2981.SnakeAndLadderGame;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.mr2981.SnakeAndLadderGame.entity.Dice;

public class DiceTest {
	private Dice dice;

    @BeforeEach
    public void setup() {
        dice = new Dice();
    }

    @Test
    public void itShouldRollAndGenerateRandomNumberBetweenOneAndSixIncluded() {
        // given
        // when
        int currRoll = dice.roll();
        List<Integer> validStates = Arrays.asList(1,2,3,4,5,6);

        // then
        Assertions.assertTrue(currRoll > 0);
        Assertions.assertTrue(currRoll < 7);
        Assertions.assertTrue(validStates.contains(currRoll));
    }


}
