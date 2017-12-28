/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.testharness.player.model;

import yugioh.chaos.rising.Player;
import yugioh.testharness.SimpleTestHarness;

/**
 * This class is the TestHarness for the the Player class.
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class PlayerModelTestHarness extends SimpleTestHarness {

	public PlayerModelTestHarness() {
		run();
		printResults();
	}

	@Override
    protected void run() {
	//This class will be called to test the Player Class
	//First test is to test that the Player object gets created properly.
	Player testDefaultPlayer = new Player(); //Creates a Player object with default health
	
	if(testDefaultPlayer == null) {
	    System.out.println("The System failled to create a Player object with"
	    + " default health.");
	    failureCount++;//Increment failure count because program failed
	}
	
	int expectedHealth = Player.defaultHealth; //defaultHealth is a public static int of the default Health
	if(expectedHealth != testDefaultPlayer.getPlayerHealth()) {
	    System.out.println("The System failed to retreive the expected health"
	    + " for the Player object.");
	    failureCount++;
	}
	
	//Will now test modifiyng the Player's Health
	//Modifiyng to be 3000
	expectedHealth = expectedHealth - 1000;
	testDefaultPlayer.modifyPlayerHealth(-1000);
	int retreivedHealth = testDefaultPlayer.getPlayerHealth(); //Be sure to get Health after modifying it
	if(expectedHealth != retreivedHealth) {
	    System.out.println("The System failed to retreive the expected health"
		+ " for the Player object after modifying it. (-1000)");
	    System.out.println("The System expected " + expectedHealth + " but"
		+ " retreived " + retreivedHealth);
	    failureCount++;
	}
	expectedHealth = expectedHealth + 2000;
	testDefaultPlayer.modifyPlayerHealth(2000);
	retreivedHealth = testDefaultPlayer.getPlayerHealth();
	if(expectedHealth != testDefaultPlayer.getPlayerHealth()) {
	    System.out.println("The System failed to retreive the expected health"
		+ " for the Player object after modifying it. (+2000)");
	    System.out.println("The System expected " + expectedHealth + " but"
		+ " retreived " + retreivedHealth);
	    failureCount++;
	}
	expectedHealth = 99999;
	testDefaultPlayer.modifyPlayerHealth(2147483647);
	retreivedHealth = testDefaultPlayer.getPlayerHealth();
	if(expectedHealth != testDefaultPlayer.getPlayerHealth()) {
	    System.out.println("The System failed to retreive the expected health"
		+ " for the Player object after modifying it. (+ 2147483647)");
	    System.out.println("The System expected " + expectedHealth + " but"
		+ " retreived " + retreivedHealth);
	    failureCount++;
	}
	expectedHealth = 0;
	testDefaultPlayer.modifyPlayerHealth(-2147483647);
	retreivedHealth = testDefaultPlayer.getPlayerHealth();
	if(expectedHealth != testDefaultPlayer.getPlayerHealth()) {
	    System.out.println("The System failed to retreive the expected health"
		+ " for the Player object after modifying it. (0 2147483647)");
	    System.out.println("The System expected " + expectedHealth + " but"
		+ " retreived " + retreivedHealth);
	    failureCount++;
	}
	
	int customPlayerHealth = 8000;
	Player testCustomPlayer = new Player(customPlayerHealth);
	if(testCustomPlayer == null) {
	    System.out.println("The System failed to create a player with custom"
		+ " health. Player(" + customPlayerHealth + ")");
	    failureCount++;
	}

	retreivedHealth = testCustomPlayer.getPlayerHealth();
	if (customPlayerHealth != retreivedHealth) {
	    System.out.println("The System failed to retreive the expected health"
		+ " for the custom Player object.");
	    failureCount++;	
	}
	
	System.out.println("Player Class: " + failureCount + " failures");
    }

	@Override
    protected void printResults() {
		if(failureCount == 0) {

		} else {
			System.err.println("The PlayerModelTestHarness detected " + failureCount + " errors.");
		}
	}
    
}
