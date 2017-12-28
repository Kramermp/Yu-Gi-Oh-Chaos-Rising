/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaos.rising;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class Board {
    private Space[][] boardSpaces = new Space[9][9];
    private ArrayList<CardEntity> playerOneCardsOnBoard = new ArrayList<CardEntity>();
    private ArrayList<CardEntity> playerTwoCardsOnBoard = new ArrayList<CardEntity>();
    private int[] playerOneLocation = {4,0};
    private int[] playerTwoLocation = {4,8};
    
    public Board(Space[][] boardSpaces) {
	this.boardSpaces = boardSpaces;
    }
    
    public Space getSpace(int xCoordinate, int yCoordinate) {
	return boardSpaces[xCoordinate][yCoordinate];
    }
    
    public void setSpace(int xCoordinate, int yCoordinate, Space newSpace) {
	boardSpaces[xCoordinate][yCoordinate] = newSpace;
    }
    
    public int[] getPlayerOneLocation() {
	return this.playerOneLocation;
    }
    
    public int[] getPlayerTwoLocation() {
	return this.playerTwoLocation;
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
    public void movePlayer(int player, Direction movement) {
	int[] possibleLocation = new int[2];
	switch (player) {
	    case 1:
		possibleLocation = playerOneLocation.clone(); //Still needs modified for movement
		switch (movement) {
		    case UP:
			possibleLocation[1]++; //Modifies for movement
			if (validatePlayerOneMovement(possibleLocation)) {
			    playerOneLocation[1] = playerOneLocation[1] + 1;
			}
			break;
		    case DOWN :
			possibleLocation[1]--; //Modifies it for movement
			if (validatePlayerOneMovement(possibleLocation)) {
			    playerOneLocation[1] = playerOneLocation[1] - 1;
			}
			break;
		    case RIGHT:
			possibleLocation[0]++; //Modifies it for movement
			if (validatePlayerOneMovement(possibleLocation)) {
			    playerOneLocation[0] = playerOneLocation[0] + 1;
			}
			break;
		    case LEFT:
			possibleLocation[0]--;//Modifies it for movement
			if (validatePlayerOneMovement(possibleLocation)) {
			    playerOneLocation[0] = playerOneLocation[0] - 1;
			}
			break;
		}
		break;
	    case 2: 
		possibleLocation = playerTwoLocation.clone(); //Still needs modified for movement
		switch (movement) {
		    case UP:
			possibleLocation[1]++;
			if (validatePlayerTwoMovement(possibleLocation)) {
			    playerTwoLocation[1] = playerTwoLocation[1] + 1;
			}
			break;
		    case DOWN :
			possibleLocation[1]--; //Modifies it for movement
			if (validatePlayerTwoMovement(possibleLocation)) {
			    playerTwoLocation[1] = playerTwoLocation[1] - 1;
			}
			break;
		    case RIGHT:
			possibleLocation[0]++; //Modifies it for movement
			if (validatePlayerTwoMovement(possibleLocation)) {
			    playerTwoLocation[0] = playerTwoLocation[0] + 1;
			}
			break;
		    case LEFT:
			possibleLocation[0]--;//Modifies it for movement
			if (validatePlayerTwoMovement(possibleLocation)) {
			    playerTwoLocation[0] = playerTwoLocation[0] - 1;
			}
			break;
		}
		break;
	    default:
		System.out.println("That player is not reconized.");	
	}
    }
    
    private boolean validatePlayerOneMovement(int[] desiredLocation) {
	if (desiredLocation[0] > 8 || desiredLocation[1] > 8 
	    || desiredLocation[0] < 0 || desiredLocation[1] < 0) {
	    //System.out.println("The player would move out of bounds. This is not"
	    //	+ " a valid move.");
	     return false; //Validats that the player will not move out of bounds.
	} else if (Arrays.equals(desiredLocation, playerTwoLocation)){
	    //System.out.println("The players would be on the same space. This is not"
	    //	+ " a valid move.");
	    return false;
	} else {
	    int playerTwoCardCount = playerTwoCardsOnBoard.size();
	    for(int i = 0; i < playerTwoCardCount; i++) {
		CardEntity selectedCard = playerTwoCardsOnBoard.get(i);
		int[] selectedCardCoordinates = selectedCard.getCoordinates();
		if (Arrays.equals(desiredLocation, selectedCardCoordinates)) {
		    //System.out.println("This move would place the player on a space"
		    //	+ " occupied by an enemy card. This is not a valid move.");
		    return false;
		}
	    }
	    int playerOneCardCount = playerOneCardsOnBoard.size();    
	    for(int i = 0; i < playerOneCardCount; i ++) {
		CardEntity selectedCard = playerOneCardsOnBoard.get(i);
		int[] selectedCardCoordinates = selectedCard.getCoordinates();
		if(Arrays.equals(desiredLocation, selectedCardCoordinates)) {
		    System.out.println("There is a friendly card entity at the"
			+ " desired location.");
		    playerOneCardsOnBoard.remove(i);
		    System.out.println("The friendly card was deleted. (Player One)");
		}
	    }
	}
	return true;
    }
    
    private boolean validatePlayerTwoMovement(int[] desiredLocation) {
	if (desiredLocation[0] > 8 || desiredLocation[1] > 8 
	    || desiredLocation[0] < 0 || desiredLocation[1] < 0) {
	    //System.out.println("The player would move out of bounds. This is not"
	    //	+ " a valid move.");
	     return false; //Validats that the player will not move out of bounds.
	} else if (Arrays.equals(desiredLocation, playerOneLocation)){
	    //System.out.println("The players would be on the same space. This is not"
	    //	+ " a valid move.");
	    return false;
	} else {
	    int playerOneCardCount = playerOneCardsOnBoard.size();
	    for(int i = 0; i < playerOneCardCount; i++) {
		CardEntity selectedCard = playerOneCardsOnBoard.get(i);
		int[] selectedCardCoordinates = selectedCard.getCoordinates();
		//System.out.println(Arrays.toString(selectedCardCoordinates));
		if (Arrays.equals(desiredLocation, selectedCardCoordinates)) {
		    //System.out.println("This move would place the player on a space"
		    //	+ " occupied by an enemy card. This is not a valid move.");
		    return false;
		}
	    }
	    int playerTwoCardCount = playerTwoCardsOnBoard.size();
	    for(int i = 0; i < playerTwoCardCount; i ++) {
		CardEntity selectedCard = playerTwoCardsOnBoard.get(i);
		int[] selectedCardCoordinates = selectedCard.getCoordinates();
		if(Arrays.equals(desiredLocation, selectedCardCoordinates)) {
		    System.out.println("There is a friendly card entity at the"
			+ " desired location.");
		    playerTwoCardsOnBoard.remove(i);
		    System.out.println("The friendly card was deleted. (Player Two)");
		}
	    }
	}
	return true;
    }
   
    
    
    
}
