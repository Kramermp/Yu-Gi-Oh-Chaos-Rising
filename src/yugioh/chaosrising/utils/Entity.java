/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaosrising.utils;

import yugioh.chaosrising.player.Player;

/**
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public abstract class Entity {
    private Player owner; //Which player owns this entity
    private int[] coordinates = new int[2]; //Location of the entity

	public Entity() {

	}

    public Entity(Player owner, int[] coordinates) {
		this.owner = owner;
		this.coordinates = coordinates;
    }
    
    public Player getOwner() {
	//Returns the owner of an entity
	//All entities will use this basic one
	return this.owner;
    }
    
    public void setOwner(Player owner) {
	//Changes the owner of an entity
	//This will be called for when a card switches ownership for whatever reason
	this.owner = owner;
    }
    
    public int[] getCoordinates() {
	//This will be called to retreive the X,Y coordinates for an entity
	return this.coordinates;
    }
    
}
