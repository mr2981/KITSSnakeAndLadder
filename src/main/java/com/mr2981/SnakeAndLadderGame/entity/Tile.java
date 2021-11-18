package com.mr2981.SnakeAndLadderGame.entity;

import java.util.Objects;


public class Tile {
	private final int position;

	public Tile(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public Tile getEndTile() {
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Tile))
			return false;
		Tile Tile = (Tile) o;
		return getPosition() == Tile.getPosition();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPosition());
	}
}
