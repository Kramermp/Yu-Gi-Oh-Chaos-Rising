package yugioh.testharness.board;

import yugioh.chaosrising.MonsterType;
import yugioh.chaosrising.Space;
import yugioh.chaosrising.SpaceType;
import yugioh.testharness.SimpleTestHarness;

import java.util.ArrayList;

/**
 * This is the class is the TestHarness for the SpaceClass.
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class SpaceTestHarness extends SimpleTestHarness {

	public SpaceTestHarness() {
		run();
		printResults();
	}

	@Override
	protected void run() {
		System.out.println("Testing space class");
		SpaceType testOriginalSpaceType = SpaceType.MEADOW;
		//If changing the testOriginalSpaceType change these test values as well
		MonsterType[] testOriginalMonstersStrengthened = {MonsterType.WARRIOR,	    //<--
				MonsterType.BEAST_WARRIOR};					    //<--
		MonsterType[] testOriginalMonstersWeakened = {MonsterType.SPELLCASTER};	    //<--

		Space testSpace = new Space(testOriginalSpaceType);
		if (testSpace != null){
			//System.out.println("The Sytem successfully created the space class with"
			//	+ " the default constructor.");
			if (testSpace.getSpaceType().equals(testOriginalSpaceType)) {
				//This will fail if we change default value of the space
				//System.out.println("The System successfully retreived the space type.");
			} else {
				System.out.println("The System failed to return the correct space type");
				failureCount++;
			}
			ArrayList<MonsterType> testSpaceMonstersStrengthened = testSpace.getMonstersStrengthened();
			ArrayList<MonsterType> testSpaceMonstersWeakened = testSpace.getMonstersWeakened();
			try {
				for (int i = 0; i < testSpaceMonstersStrengthened.size(); i++) {
					MonsterType selectedType = testSpaceMonstersStrengthened.get(i);
					if (selectedType == testOriginalMonstersStrengthened[i]) {
						//System.out.println("The System returned the correct monster "
						//    + " strengthened at index " + i);
					} else {
						System.out.println("The System failed to return the correct "
								+ " monster stengthened at index " + i);
						failureCount++;
					}
				}
			} catch (Exception e) {
				System.out.println("The System failed to return the correct monsters"
						+ " Stengthened");
				failureCount++;
			}
			try {
				for (int i = 0; i < testSpaceMonstersWeakened.size(); i++) {
					MonsterType selectedType = testSpaceMonstersWeakened.get(i);
					if (selectedType == testOriginalMonstersWeakened[i]) {
						//System.out.println("The System returned the correct monster "
						//    + " weakened at index " + i);
					} else {
						//System.out.println("The System failed to return the correct "
						//    + " monster weakened at index " + i);
						failureCount++;
					}
				}
			} catch (Exception e) {
				System.out.println("The System failed to return the correct monsters"
						+ " weakened");
				failureCount++;
			}

		} else {
			System.out.println("The System failed to create the space class with"
					+ " the SpaceType, int[] constructor.");
			failureCount++;
		}

		//System.out.println("Testing changing space type.");
		SpaceType newTestSpaceType = SpaceType.WATER;
		testSpace.setSpaceType(newTestSpaceType);

		if (testSpace.getSpaceType() == newTestSpaceType) {
			//System.out.println("The System correctly reassigned the space type.");
			ArrayList<MonsterType> testSpaceMonstersStrengthened = testSpace.getMonstersStrengthened();
			ArrayList<MonsterType> testSpaceMonstersWeakened = testSpace.getMonstersWeakened();

			MonsterType[] testNewMonstersStrengthened = { MonsterType.AQUA, MonsterType.FISH,
					MonsterType.SEA_SERPENT, MonsterType.THUNDER };
			MonsterType[] testNewMonstersWeakened = {MonsterType.MACHINE, MonsterType.ROCK,
					MonsterType.PYRO };


			try {
				for (int i = 0; i < testSpaceMonstersStrengthened.size(); i++) {
					MonsterType selectedType = testSpaceMonstersStrengthened.get(i);
					if (selectedType == testNewMonstersStrengthened[i]) {
						//System.out.println("The System returned the correct monster "
						//    + " strengthened at index " + i);
					} else {
						System.out.println("The System failed to return the correct "
								+ " changed monster stengthened at index " + i);
						failureCount++;
					}
				}
			} catch (Exception e) {
				System.out.println("The System failed to return the correct monsters"
						+ " Stengthened");
				failureCount++;
			}
			try {
				for (int i = 0; i < testSpaceMonstersWeakened.size(); i++) {
					MonsterType selectedType = testSpaceMonstersWeakened.get(i);
					if (selectedType == testNewMonstersWeakened[i]) {
						//System.out.println("The System returned the correct monster "
						//    + " weakened at index " + i);
					} else {
						System.out.println("The System failed to return the correct "
								+ " changed monster weakened at index " + i);
						failureCount++;
					}
				}
			} catch (Exception e) {
				System.out.println("The System failed to return the correct monsters"
						+ " weakened");
				failureCount++;
			}

		} else if (testSpace.getSpaceType() == testOriginalSpaceType ) {
			System.out.println("The System failed to reassing the space type,"
					+ " the value remained the same.");
		} else {
			System.out.println("The System failed to reassign the space type.");
			failureCount++;
		}

		if (failureCount == 0 ) {
			System.out.println("The Space class encountered " + failureCount + " failures.");
		}
	}

	@Override
	protected void printResults() {
		if(failureCount == 0) {
			System.out.println("The SpaceTestHarness did not encounter any errors.");
		} else {
			System.err.println("The SpaceTestHarness encountered "  + failureCount + " errors!");
		}
	}
}
