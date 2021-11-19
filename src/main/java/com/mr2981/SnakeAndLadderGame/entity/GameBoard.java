package com.mr2981.SnakeAndLadderGame.entity;

import java.util.*;

import org.springframework.stereotype.Component;

public class GameBoard {
	 private int totalPlayers;
	    private List<Player> players;
	    private List<Player> winningPlayers;
	    private int playerTurn = 0;
	    private Dice dice;
	    private List<Tile> gameBoard;

	    private GameBoard() {
	        winningPlayers = new ArrayList<>();
	    }

	    public static GameBoard newInstance() {
	        return new GameBoard();
	    }

	    public boolean initPlayers(Player... players) {
	        this.players = new ArrayList<>(Arrays.asList(players));
	        totalPlayers = players.length;
	        return true;
	    }

	    public List<Player> getPlayers() {
	        return Collections.unmodifiableList(players);
	    }

	    public boolean initDice(Dice dice) {
	        this.dice = dice;
	        return true;
	    }

	    public Dice getDice() {
	        return Dice.copyInstance(this.dice);
	    }

	    public boolean initGameBoard() {
	        List<Integer> snakePosition = Arrays.asList(23, 13, 56, 99, 27);
	        List<Integer> ladderPosition = Arrays.asList(7, 19, 25, 80, 33, 73, 50);
	        List<Tile> gameBoard = new ArrayList<>();

	        for (int index=0; index <= 100; index++) {
	            if (snakePosition.contains(index)) {
	                gameBoard.add(index, new Snake(index));
	            }

	            else if (ladderPosition.contains(index)) {
	                gameBoard.add(index, new Ladder(index));
	            }

	            else {
	                gameBoard.add(index, new Tile(index));
	            }
	        }
	        this.gameBoard = gameBoard;
	        return true;
	    }

	    public List<Tile> get() {
	        return Collections.unmodifiableList(this.gameBoard);
	    }

	    public Player play() {
	        Player currPlayer = players.get(playerTurn);
	        dice.setDiceState(dice.roll());
	        Tile Tile = currPlayer.rollDice(dice, gameBoard);
	        System.out.println("Player turn: " + currPlayer.getplayer_name());
	        System.out.println("Player Position: " + currPlayer.getCurrPosition().getPosition());
	        if (Tile.getPosition() == 100) {
	            winningPlayers.add(currPlayer);
	            players.remove(playerTurn);
	        }
	        identifyNextPlayer();
	        return currPlayer;
	    }

	    private void identifyNextPlayer() {
	        if ( (playerTurn + 1) >= players.size())
	            playerTurn = 0;
	        else
	            playerTurn++;
	    }

	    public int getPlayerTurn() {
	        int newPlayerTurn = playerTurn;
	        return newPlayerTurn;
	    }

}
