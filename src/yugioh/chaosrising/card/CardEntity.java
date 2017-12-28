/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaosrising.card;

import yugioh.chaosrising.utils.Entity;
import yugioh.chaosrising.player.Player;

/**
 *
 * @author faust_000
 */
public abstract class CardEntity extends Entity {
    private Card baseCard;
    
    public CardEntity(Player owner, Card card, int[] coordinates) {
	super(owner, coordinates); //Creates the Entity
	this.baseCard = card; //Tells what card will be the base
    }
    
}
