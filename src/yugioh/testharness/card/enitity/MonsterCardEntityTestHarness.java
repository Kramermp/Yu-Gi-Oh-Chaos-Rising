package yugioh.testharness.card.enitity;

import yugioh.chaos.rising.*;
import yugioh.chaosrising.*;
import yugioh.chaosrising.card.MonsterCard;
import yugioh.chaosrising.card.MonsterCardEntity;
import yugioh.chaosrising.card.MonsterType;
import yugioh.testharness.SimpleTestHarness;

import java.util.Arrays;

/**
 * This class is the test harness for the MonsterCardClass
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class MonsterCardEntityTestHarness extends SimpleTestHarness {

	public MonsterCardEntityTestHarness() {
		run();
		printResults();
	}

	@Override
	protected void run() {
		//Creates a MonsterCardEnity and then checks all of its values
		String description = "This legendary dragon is a powerful engine of"
				+ " destruction. Virtually invincible, very few have faced this "
				+ "awesome creature and lived to tell the tale.";
		MonsterCardEntity testMonsterCardEntity = new MonsterCardEntity( new Player(),
				new MonsterCard("Blue-Eyes White Dragon",
						MonsterAttribute.LIGHT, 8, MonsterType.DRAGON, description , 3000, 2500), new int[]{5,5});
		if (!Arrays.equals(testMonsterCardEntity.getCoordinates(), new int[] {5,5})) {
			System.out.println("Placing the monster card entity failed.");
			failureCount++;
		}
		//Test Monster Attack and its related methods
		if(!(testMonsterCardEntity.getMonsterAttack() == 3000)) {
			System.out.println("The monster card entity failed to return the"
					+ " proper attack. (Base)");
			failureCount++;
		} else {
			//The MonsterCardEntity had the correct attack so now we test modifying it
			testMonsterCardEntity.modifyMonsterAttack(500);
			if (testMonsterCardEntity.getMonsterAttack() != 3500) {
				System.out.println("The System failed to modify the"
						+ " MonsterCardEntity attack. (500)");
				System.out.println("The System expected " + 3500 + " but"
						+ " retreived " + testMonsterCardEntity.getMonsterAttack());
				failureCount++;
			}
			testMonsterCardEntity.modifyMonsterAttack(-1000);
			if (testMonsterCardEntity.getMonsterAttack() != 2500) {
				System.out.println("The System failed to modify the"
						+ " MonsterCardEntity attack. (-1000)");
				System.out.println("The System expected " + 2500 + " but"
						+ " retreived " + testMonsterCardEntity.getMonsterAttack());
				failureCount++;
			}
			//Now we will attempt to overflow and under flow the monster attack
			testMonsterCardEntity.modifyMonsterAttack(2147483647);
			if (testMonsterCardEntity.getMonsterAttack() != 99999) {
				System.out.println("The System failed to modify the"
						+ " MonsterCardEntity attack. (2147483647)");
				System.out.println("The System expected " + 99999 + " but"
						+ " retreived " + testMonsterCardEntity.getMonsterAttack());
				failureCount++;
			}
			testMonsterCardEntity.modifyMonsterAttack(-2147483647);
			if (testMonsterCardEntity.getMonsterAttack() != 0) {
				System.out.println("The System failed to modify the"
						+ " MonsterCardEntity attack. (-2147483647)");
				System.out.println("The System expected " + 0 + " but"
						+ " retreived " + testMonsterCardEntity.getMonsterAttack());
				failureCount++;
			}
		}
		if(!(testMonsterCardEntity.getMonsterDefense() == 2500)) {
			System.out.println("The monster card entity failed to return the"
					+ " proper defense.");
			failureCount++;
		} else {
			//Since Monster Defense was created properly we will now test modifying it
			testMonsterCardEntity.modifyMonsterDefense(500);
			if (testMonsterCardEntity.getMonsterDefense() != 3000) {
				System.out.println("The System failed to modify the"
						+ " MonsterCardEntity Defense. (500)");
				System.out.println("The System expected " + 3000 + " but"
						+ " retreived " + testMonsterCardEntity.getMonsterDefense());
				failureCount++;
			}
			testMonsterCardEntity.modifyMonsterDefense(-1000);
			if (testMonsterCardEntity.getMonsterDefense() != 2000) {
				System.out.println("The System failed to modify the"
						+ " MonsterCardEntity Defense. (-1000)");
				System.out.println("The System expected " + 2000 + " but"
						+ " retreived " + testMonsterCardEntity.getMonsterDefense());
				failureCount++;
			}
			//Now we will try to overflow and underflow it
			testMonsterCardEntity.modifyMonsterDefense(2147483647);
			if (testMonsterCardEntity.getMonsterDefense() != 99999) {
				System.out.println("The System failed to modify the"
						+ " MonsterCardEntity Defense. (2147483647)");
				System.out.println("The System expected " + 99999 + " but"
						+ " retreived " + testMonsterCardEntity.getMonsterDefense());
				failureCount++;
			}
			testMonsterCardEntity.modifyMonsterDefense(-2147483647);
			if (testMonsterCardEntity.getMonsterDefense() != 0) {
				System.out.println("The System failed to modify the"
						+ " MonsterCardEntity Defense. (-2147483647)");
				System.out.println("The System expected " + 0 + " but"
						+ " retreived " + testMonsterCardEntity.getMonsterDefense());
				failureCount++;
			}
		}
		if(!(testMonsterCardEntity.getMonsterType() == MonsterType.DRAGON)) {
			System.out.println("The monster card entity failed to return the"
					+ " proper defense.");
			failureCount++;
		}
		if(!(testMonsterCardEntity.getMonsterAttribute() == MonsterAttribute.LIGHT)) {
			System.out.println("The monster card entity failed to return the"
					+ " proper defense.");

		}
	}

	@Override
	protected void printResults() {
		if(failureCount == 0) {

		} else {
			System.err.println("The MonsterCardEntityTestHarness Detected " + failureCount + " errors.");
		}
	}

}
