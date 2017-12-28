package yugioh.testharness;

import yugioh.testharness.board.MasterBoardTestHarness;
import yugioh.testharness.card.MasterCardTestHarness;
import yugioh.testharness.player.MasterPlayerTestHarness;


/**
 * This class serves as the entry point to the different test harnesses that will branch and test out the different
 * sections of the program. This will be used to ensure that functionality is maintained while modifying the code.
 *
 * The TestHarnesses are all structured in a similar way. Their constructors are called and the constructor calls two
 * methods, private void run(){}, and public void printResults(){}. To ensure that all of the TestHarnesses follow this
 * structure there is the abstract class SimpleTestHarness. This class contains the methods that TestHarnesses need to
 * have and contains the variable failureCount, that each TestHarness uses to count the number of testes that it fails.
 * After running and counting the test failures, the TestHarness need to call the printResults method. This method
 * simple prints outs whether the TestHarness failed any testes, and if it did how many testes it did fail.
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class MasterTestHarness extends SimpleTestHarness {

    public MasterTestHarness() {
		run();
		printResults();
    }

	@Override
	protected void run() {
    	failureCount+= new MasterCardTestHarness().getFailureCount();
    	failureCount+= new MasterPlayerTestHarness().getFailureCount();
    	failureCount+= new MasterBoardTestHarness().getFailureCount();
	}

	@Override
	protected void printResults() {
		if(failureCount == 0) {
			System.out.println("The MasterTestHarness did not detect any errors.");
			System.out.println("All Systems Operational");
		} else {
			System.err.println("The MasterTestHarness detected " + failureCount + " errors.");

		}
	}


    
}
