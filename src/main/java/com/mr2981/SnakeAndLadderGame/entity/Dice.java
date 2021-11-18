package com.mr2981.SnakeAndLadderGame.entity;


public class Dice {
	private int diceState;

	public Dice() {
		this.diceState = 0;
	}

	public Dice(int dicestate) {
		this.diceState = diceState;
	}

	private Dice(Dice other) {
		this.diceState = other.diceState;

	}

	public static Dice copyInstance(Dice dice) {
		return new Dice(dice);
	}

	public int getDiceState() {
		return diceState;
	}

	public void setDiceState(int diceState) {
		this.diceState = diceState;
	}

	public int roll() {
		int diceState = (int) (Math.random() * 6 + 1);
		return diceState;
	}
}
