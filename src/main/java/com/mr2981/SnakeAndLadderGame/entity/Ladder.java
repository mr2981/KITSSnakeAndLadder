package com.mr2981.SnakeAndLadderGame.entity;

public class Ladder extends Tile {
	 private Tile endTile;

	    public Ladder(int position) {
	        super(position);
	        int limit = ((position / 10) + 1) * 10;
	        System.out.println(limit);
	        int endPosition = ((int) (Math.random() * limit)) + position;
	        endTile = new Tile(endPosition);
	    }

	    @Override
	    public Tile getEndTile() {
	        return endTile;
	    }
}
