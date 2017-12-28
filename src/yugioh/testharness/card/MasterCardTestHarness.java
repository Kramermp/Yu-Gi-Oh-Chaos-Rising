package yugioh.testharness.card;

import yugioh.testharness.MasterTestHarness;
import yugioh.testharness.SimpleTestHarness;
import yugioh.testharness.card.enitity.MasterCardEntityTestHarness;
import yugioh.testharness.card.model.MasterCardModelTestHarness;

/**
 * This class is the master testharness for the different card testharnesses. It runs creates the
 * MasterCardEntityTestHarness and the MasterCardModelTestHarness.
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class MasterCardTestHarness extends SimpleTestHarness {
	public MasterCardTestHarness() {
		run();
		printResults();
	}

	@Override
	protected void run() {
		failureCount += new MasterCardEntityTestHarness().getFailureCount();
		failureCount += new MasterCardModelTestHarness().getFailureCount();
	}

	@Override
	protected void printResults() {
		if(failureCount == 0) {

		} else {
			System.out.println("The MasterCardTestHarness detected " + failureCount + " errors.");
		}
	}
}
