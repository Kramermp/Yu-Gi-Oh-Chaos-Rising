package yugioh.testharness.player.entity;


import yugioh.testharness.SimpleTestHarness;

/**
 * I'm not sure whats going on with this class. I think I need to remake the player entity class, I'm not sure what
 * happened to it in the first place.
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 *
 */
public class PlayerEntityTestHarness extends SimpleTestHarness {

	public PlayerEntityTestHarness() {

	}

	@Override
    public void run() {
//	int failureCount = 0;
//
//	Player testPlayer = new Player();
//	int[] startingCoordinates = new int[] {0,8};
//	PlayerEntity testPlayerEntity;
//	testPlayerEntity = new PlayerEntity(testPlayer, startingCoordinates.clone());
//	//Testing the the PlayerEntity was created and is not null
//	if (testPlayerEntity == null) {
//	    System.out.println("The System failed to create the PlayerEntity.");
//	}
//	//Testing that the retreived owner is the correct owner
//	Player retreivedOwner = testPlayerEntity.getOwner();
//	if (retreivedOwner != testPlayer) {
//	    System.out.println("The System failed to retreive the correct player"
//		    + " entity.");
//	    failureCount++;
//	}
//	//Testing that the player class was placed at the correct locations
//	if (!Arrays.equals(testPlayerEntity.getCoordinates(), startingCoordinates)) {
//	    System.out.println("The System failed to retreive the expected"
//		    + " coordinates for the player entity.");
//	    System.out.println("Expected : " + Arrays.toString(startingCoordinates));
//	    System.out.println("Retreived: " + Arrays.toString(testPlayerEntity.getCoordinates()));
//	    failureCount++;
//	}
//
//	//Testing a simple move
//	int moveMagnitude = 1;
//	testPlayerEntity.move(Direction.UP); // Coordinate[1] ++;
//	int[] retreivedCoordinates = testPlayerEntity.getCoordinates();
//	int[] newCoordinates = new int[] {startingCoordinates[0], (startingCoordinates[1] + moveMagnitude)};
//	if (!Arrays.equals(testPlayerEntity.getCoordinates(), newCoordinates)) {
//	    System.out.println("The System failed to move the PlayerEntity."
//		    + " Using move(Direction UP).");
//	    System.out.println("Expected : " + Arrays.toString(newCoordinates));
//
//	    System.out.println("Retreived  : " + Arrays.toString(retreivedCoordinates));
//	    failureCount++;
//	}
//	retreivedCoordinates = testPlayerEntity.getCoordinates().clone();
//	testPlayerEntity.move(Direction.DOWN); // Coordinate[1] --;
//
//	newCoordinates = new int[] {retreivedCoordinates[0], (retreivedCoordinates[1] - moveMagnitude)};
//	if (!Arrays.equals(testPlayerEntity.getCoordinates(), newCoordinates)) {
//	    System.out.println("The System failed to move the PlayerEntity."
//		    + " Using move(Direction DOWN).");
//	    System.out.println("Expected : " + Arrays.toString(newCoordinates));
//	    System.out.println("Retreived  : " + Arrays.toString(retreivedCoordinates));
//	    failureCount++;
//	}
//	retreivedCoordinates = testPlayerEntity.getCoordinates().clone();
//	testPlayerEntity.move(Direction.LEFT); // Coordinate[0] --;
//	newCoordinates = new int[] {retreivedCoordinates[0] - moveMagnitude, retreivedCoordinates[1]};
//	if (!Arrays.equals(testPlayerEntity.getCoordinates(), newCoordinates)) {
//	    System.out.println("The System failed to move the PlayerEntity."
//		    + " Using move(Direction LEFT).");
//	    System.out.println("Expected : " + Arrays.toString(newCoordinates));
//	    System.out.println("Retreived  : " + Arrays.toString(retreivedCoordinates));
//	    failureCount++;
//	}
//	retreivedCoordinates = testPlayerEntity.getCoordinates().clone();
//	testPlayerEntity.move(Direction.RIGHT); // Coordinate[0] ++;
//	newCoordinates = new int[] {retreivedCoordinates[0] + moveMagnitude, retreivedCoordinates[1]};
//	if (!Arrays.equals(testPlayerEntity.getCoordinates(), newCoordinates)) {
//	    System.out.println("The System failed to move the PlayerEntity."
//		    + " Using move(Direction RIGHT).");
//	    System.out.println("Expected : " + Arrays.toString(newCoordinates));
//	    System.out.println("Retreived  : " + Arrays.toString(retreivedCoordinates));
//	    failureCount++;
//	}
//
//	//Testing a move with magnitude two
//	moveMagnitude = 2;
//	testPlayerEntity.move(Direction.UP, moveMagnitude); // Coordinate[1] +2;
//	newCoordinates = new int[] {startingCoordinates[0], (startingCoordinates[1] + moveMagnitude)};
//	if (!Arrays.equals(testPlayerEntity.getCoordinates(), newCoordinates)) {
//	    System.out.println("The System failed to move the PlayerEntity."
//		    + " Using move(Direction direction, int magnitude).");
//	    System.out.println("Expected : " + Arrays.toString(newCoordinates));
//	    System.out.println("Retreived  : " + Arrays.toString(retreivedCoordinates));
//	    failureCount++;
//	}
//		retreivedCoordinates = testPlayerEntity.getCoordinates().clone();
//	testPlayerEntity.move(Direction.DOWN, moveMagnitude); // Coordinate[1] +2;
//
//	newCoordinates = new int[] {retreivedCoordinates[0], (retreivedCoordinates[1] - moveMagnitude)};
//	if (!Arrays.equals(testPlayerEntity.getCoordinates(), newCoordinates)) {
//	    System.out.println("The System failed to move the PlayerEntity."
//		    + " Using move(Direction DOWN).");
//	    System.out.println("Expected : " + Arrays.toString(newCoordinates));
//	    System.out.println("Retreived  : " + Arrays.toString(retreivedCoordinates));
//	    failureCount++;
//	}
//	retreivedCoordinates = testPlayerEntity.getCoordinates().clone();
//	testPlayerEntity.move(Direction.LEFT, moveMagnitude); // Coordinate[0] -2;
//	newCoordinates = new int[] {retreivedCoordinates[0] - moveMagnitude, retreivedCoordinates[1]};
//	if (!Arrays.equals(testPlayerEntity.getCoordinates(), newCoordinates)) {
//	    System.out.println("The System failed to move the PlayerEntity."
//		    + " Using move(Direction LEFT).");
//	    System.out.println("Expected : " + Arrays.toString(newCoordinates));
//	    System.out.println("Retreived  : " + Arrays.toString(retreivedCoordinates));
//	    failureCount++;
//	}
//	retreivedCoordinates = testPlayerEntity.getCoordinates().clone();
//	testPlayerEntity.move(Direction.RIGHT, moveMagnitude); // Coordinate[0] +2;
//	newCoordinates = new int[] {retreivedCoordinates[0] + moveMagnitude, retreivedCoordinates[1]};
//	if (!Arrays.equals(testPlayerEntity.getCoordinates(), newCoordinates)) {
//	    System.out.println("The System failed to move the PlayerEntity."
//		    + " Using move(Direction RIGHT).");
//	    System.out.println("Expected : " + Arrays.toString(newCoordinates));
//	    System.out.println("Retreived  : " + Arrays.toString(retreivedCoordinates));
//	    failureCount++;
//	}
//	System.out.println("PlayerEntity Class : " + failureCount + " failures");
//	return failureCount;
    }

	@Override
	protected void printResults() {
		if(failureCount == 0) {

		} else {
			System.err.println("The PlayerEntityTestHarness detected " + failureCount + " errors.");
		}
	}
}
