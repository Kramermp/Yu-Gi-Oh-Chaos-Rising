package yugioh.testharness;

import javax.sql.rowset.serial.SerialRef;

public abstract class SimpleTestHarness {
	protected int failureCount = 0;

	public SimpleTestHarness() {

	}

	protected abstract void run();

	protected abstract void printResults();

	public final int getFailureCount() {
		if(this.failureCount < 0) {
			System.err.println("The failureCount for this TestHarness was detected to be less than 0!");
			System.err.println("This indicates a failure.");
			System.err.println("Setting failureCount to 1.");
			failureCount = 1;
		}

		return this.failureCount;
	}
}
