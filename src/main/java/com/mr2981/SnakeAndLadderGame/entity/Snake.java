package com.mr2981.SnakeAndLadderGame.entity;


public class Snake extends Tile{
	 private Tile endTile;

	    public Snake(int position) {
	        super(position);
	        int limit = (position / 10) * 10;
	        System.out.println(limit);
	        int endPosition = (int) (Math.random() * limit);
	        endTile = new Tile(endPosition);
	    }

	    @Override
	    public Tile getEndTile() {
	        return this.endTile;
	    }
}
