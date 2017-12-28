/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaos.rising;

import java.util.ArrayList;

/**
 *
 * @author faust_000
 */
public class Deck {
    
    private String deckName = "Deck title not found";
    private ArrayList<Card> deckList = new ArrayList<Card>();
    private int deckCount = 0;
    
    //Constructors
    public Deck (String deckTitle, ArrayList<Card> cards) {
	this.deckName = deckName;
	if (deckList.size() + cards.size() <= 60) {
	    deckList.addAll(cards);
	} else {
	    System.out.println("This deck would be too large.");
	}
	this.deckCount = deckList.size();
    }
    
    //Accessors
    public String getDeckName() { return this.deckName; }
    public ArrayList<Card> getDeckList() { return this.deckList; }
    public int getDeckCount() { return this.deckCount; }
    
    
    //Methods
    
}
