/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaosrising.card;

/**
 *
 * @author mpk5206
 */
public abstract class Card {
    
    private String cardName = "Name Not Found";
    private String cardDescription = "Card Description Not Found";
    private CardType cardType = CardType.TEST;
    
    //Constructors
    public Card() {
	
    }
    public Card(String cardName, String cardDescription, CardType cardType) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.cardType = cardType;
    }

    //Accessors for the card class
    public String getCardName() { return this.cardName; }
    public String getCardDescription() { return this.cardDescription;}
    public CardType getCardType() { return this.cardType; }
    
    //Mutators for the card class 
    public void setCardName(String cardName){
        this.cardName = cardName;
    }   
    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }
    public void setCardType (CardType cardType) {
        this.cardType = cardType;
    }
}
