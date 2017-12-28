/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaosrising;

import yugioh.chaosrising.card.CardEntity;

import java.util.ArrayList;

/**
 * The Board class is a class that is used to bundle different information about the game. It bundles together the
 * the information about the location of the different things, and the information about the actual game board allowing
 * it to keep track of of where the things are vs the spaces, and other thing etc.
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class Board {
	public static final int DEFAULT_BOARD_WIDTH = 11;
	public static final int DEFAULT_BOARD_HEIGHT = 11;
    private Space[][] boardSpaces;
    private ArrayList<CardEntity> playerOneCardsOnBoard = new ArrayList<CardEntity>();
    private ArrayList<CardEntity> playerTwoCardsOnBoard = new ArrayList<CardEntity>();
    private ArrayList<PlayerEntity> playerEntities = new ArrayList<PlayerEntity>();


    public Board(Space[][] boardSpaces) {
		this.boardSpaces = boardSpaces;
    }

    public void summonCardEntity(int player, CardEntity card) {
		switch (player) {
			case 1:
			//System.out.println("Summoning a card entity for player one.");
			playerOneCardsOnBoard.add(card);
			break;
			case 2:
			//System.out.println("Summoning a card entity for player two.");
			playerTwoCardsOnBoard.add(card);

		}
    }

    // TODO: Convert this to movePlayer(Player, Direction), maybe
    public void movePlayer(int player, Direction movement) {

    }

    // Accessors(Getters)

	/**
	 * Gets a specific Space from the board based off of the provided X coordinate and Y coordinate.
	 * @param xCoordinate The X coordinate
	 * @param yCoordinate The Y coordinate
	 * @return the requested Space object
	 */
	public Space getSpace(int xCoordinate, int yCoordinate) {
		return boardSpaces[xCoordinate][yCoordinate];
	}

	// Mutators (Setters)

	/**
	 * Sets the Space at the provided X and Y coordinate to the provided Space
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param newSpace
	 */
	public void setSpace(Space newSpace, int xCoordinate, int yCoordinate) {
		boardSpaces[xCoordinate][yCoordinate] = newSpace;
	}

	/**
	 * This method is used by the test harness to retrieve a simple Board for testing.
	 * @return Board; returns a simple Board for testing purposes
	 */
	public static Board getTestBoard() {
		Space[][] testSpaceArray = new Space[DEFAULT_BOARD_HEIGHT][DEFAULT_BOARD_WIDTH];
		for (int i =0; i < DEFAULT_BOARD_HEIGHT; i++) {
			for(int j =0; j < DEFAULT_BOARD_WIDTH; j++) {
				testSpaceArray[i][j] = Space.getTestSpace();
			}
		}
    	return new Board(testSpaceArray);
	}

}
