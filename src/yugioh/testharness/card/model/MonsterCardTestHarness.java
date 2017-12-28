/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.testharness.card.model;

import yugioh.chaos.rising.MonsterAttribute;
import yugioh.chaos.rising.MonsterCard;
import yugioh.chaos.rising.MonsterType;
import yugioh.testharness.SimpleTestHarness;

/**
 * This class is the test harness for the MonsterCardClass.
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class MonsterCardTestHarness extends SimpleTestHarness {

	public MonsterCardTestHarness() {
		run();
		printResults();
	}

	@Override
    protected void run() {
        MonsterCard monsterCardTest;
        String cardName = "Summoned Skull";
        MonsterAttribute monsterAttribute = MonsterAttribute.DARK;
        int monsterLevel = 7;
        MonsterType monsterType = MonsterType.FIEND;
        String cardDescription = ("A fiend with dark powers for confusing the enemy. " +
                "Among the Fiend-Type monsters, this monser boasts consierable force.");
        int monsterAttack = 2500;
        int monsterDefense = 1200;

        monsterCardTest = new MonsterCard(cardName, monsterAttribute, monsterLevel,
                monsterType, cardDescription, monsterAttack, monsterDefense);

        if (monsterCardTest == null) {
            failureCount++;
            System.out.println("The Monster Card failed to be created. And was null.");
        } else {
	    /*
		This will go throught the Card classes data and ensure all of it
		can be retreived properly.
	    */
			if (!monsterCardTest.getCardName().equals(cardName)) {
				failureCount++;
				System.out.println("The Monster Card Class failed to return the proper name");
			}
			if (monsterCardTest.getMonsterAttribute() != MonsterAttribute.DARK) {
				failureCount++;
				System.out.println("The Monster Card Class failed to return the"
						+ "proper Monster Attribute");
			}
			if (monsterLevel != monsterCardTest.getMonsterLevel()) {
				failureCount++;
				System.out.println("The Monster Card Class failed to return the "
						+ "proper monster level.");
			}
			if (monsterType != monsterCardTest.getMonsterType()) {
				failureCount++;
				System.out.println("The Monster Card Class failed to return the "
						+ "proper monsterType");
			}
			if (!cardDescription.equals(monsterCardTest.getCardDescription())) {
				failureCount++;
				System.out.println("The Monster Card Class failed to return the "
						+ "proper card description.");
			}
			if (monsterAttack != monsterCardTest.getMonsterAttack()) {
				failureCount++;
				System.out.println("The Monster Card Class failed to return the "
						+ "proper monster attack.");
			}
			if (monsterDefense != monsterCardTest.getMonsterDefense()) {
				failureCount++;
				System.out.println("The Monster Card Class failed to return the "
						+ "proper card description.");
			}
		}
    }

    @Override
    protected void printResults() {
        if(failureCount == 0) {

		} else {
			System.err.println("The MonsterCardTestHarness detected " + failureCount + " errors.");
		}
    }
}
