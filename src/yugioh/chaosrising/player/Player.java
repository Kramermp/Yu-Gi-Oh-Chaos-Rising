/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaosrising.player;

/**
 *
 * @author faust_000
 */
public class Player {
    //Player will just be used to track health of the player
    //And will be important for telling who owns which card
    public static int defaultHealth = 4000;
    private int health = defaultHealth; //This is the player's default HP
    
    public Player() {
	//Will create a player with the Default HP
    }
    
    public Player(int health) {
	//This can be called to create a player with nondefault HP
	this.health = health;
    }
    
    public int getPlayerHealth() {
	return this.health;
    }
    
    public void modifyPlayerHealth(int healthChange) {
	//If a player takes damage or gains health this will be called to modify
	//their health
	//HealthChange can be negative or positive.
	//This testValue protects against over and underflowed values
	double testValue = this.health + (double) healthChange;
	if (testValue < 0) {
	    this.health = 0;
	} else if ( testValue > 100000) {
	    this.health = 99999;
	} else {
	    this.health = (int) testValue;
	}
	//FIXME: Check for win
    }
    
}
