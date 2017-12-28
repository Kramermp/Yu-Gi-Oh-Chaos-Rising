package yugioh.testharness.player;

import yugioh.testharness.SimpleTestHarness;
import yugioh.testharness.player.entity.PlayerEntityTestHarness;
import yugioh.testharness.player.model.PlayerModelTestHarness;

/**
 * This class is the master test harness for the player test harnesses. It creates the PlayerEntityTestHarness and
 * the PlayerModelTestHarness.
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class MasterPlayerTestHarness extends SimpleTestHarness {

	public MasterPlayerTestHarness() {
		run();
		printResults();
	}

	@Override
	protected void run() {
		failureCount+= new PlayerModelTestHarness().getFailureCount();
		failureCount+= new PlayerEntityTestHarness().getFailureCount();
	}

	@Override
	protected void printResults() {
		if(failureCount == 0) {

		} else {
			System.err.println("The MasterPlayerTestHarness detected " + failureCount + " errors.");
		}
	}
}
