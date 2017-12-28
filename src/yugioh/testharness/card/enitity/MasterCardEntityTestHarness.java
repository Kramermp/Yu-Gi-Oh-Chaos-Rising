/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.testharness.card.enitity;

import java.util.Arrays;
import yugioh.chaos.rising.MonsterAttribute;
import yugioh.chaos.rising.MonsterCard;
import yugioh.chaos.rising.MonsterCardEntity;
import yugioh.chaos.rising.MonsterType;
import yugioh.chaos.rising.Player;
import yugioh.testharness.SimpleTestHarness;

/**
 * This class is the master testharness for all of the different card entities.
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class MasterCardEntityTestHarness extends SimpleTestHarness {

	public MasterCardEntityTestHarness() {
		run();
		printResults();
	}

	@Override
    protected void run() {
		failureCount = failureCount + new MonsterCardEntityTestHarness().getFailureCount();

    }

	@Override
    protected void printResults() {
		if(failureCount == 0) {

		} else {
			System.err.println("The MasterCardEntityTestHarness encountered " + failureCount + " errors.");
		}
	}
}
