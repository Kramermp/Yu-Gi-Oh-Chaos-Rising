package yugioh.testharness.board;

import yugioh.testharness.SimpleTestHarness;

/**
 * This class is the master test harness for all of the classes that fall under the board package. It creates the other
 * sub testharness. Stucturing it this way allows for a clean and easy way to iterate through the different packages.
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class MasterBoardTestHarness extends SimpleTestHarness {

	public MasterBoardTestHarness() {
		run();
		printResults();
	}

	@Override
	protected void run() {
		failureCount+= new BoardTestHarness().getFailureCount();
//		failureCount+= new SpaceTestHarness().getFailureCount();
	}

	@Override
	protected void printResults() {
		if(failureCount == 0) {

		} else {
			System.err.println("The MasterBoardTestHarness detected " + failureCount + " errors.");
		}
	}
}
