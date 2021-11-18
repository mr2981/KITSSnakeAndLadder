package com.mr2981.SnakeAndLadderGame.entity;

import java.util.List;
import java.util.Objects;

public class Player {

	private final String player_name;
	private Tile currPosition = new Tile(1);

	public Player(String player_name) {
		this.player_name = player_name;
	}

	private Player(Player other) {
		this.player_name = other.player_name;
		this.currPosition = other.currPosition;
	}

	public static Player copyInstance(Player player) {
		return new Player(player);

	}

	private boolean hasNotStarted() {
		return currPosition.getPosition() == 1;
	}

	public String getplayer_name() {
		return player_name;
	}

	public Tile getCurrPosition() {
		return currPosition;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Player))
			return false;
		Player player = (Player) o;
		return Objects.equals(getplayer_name(), player.getplayer_name())
				&& Objects.equals(getCurrPosition(), player.getCurrPosition());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getplayer_name(), getCurrPosition());
	}

	public Tile rollDice(Dice dice, List<Tile> tiles) {

		System.out.println(this.getplayer_name() + " rolls. Dice State: " + dice.getDiceState());
		if (hasNotStarted() && this.currPosition.getPosition() < 100) {

			int nextPosition = this.currPosition.getPosition() + dice.getDiceState();

			if (nextPosition < 100)
				this.currPosition = tiles.get(nextPosition).getEndTile().getPosition() > 100 ? this.currPosition
						: tiles.get(nextPosition).getEndTile();
		}
		return this.currPosition;
	}

}
