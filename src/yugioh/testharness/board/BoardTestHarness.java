package yugioh.testharness.board;

import yugioh.chaos.rising.Board;
import yugioh.chaos.rising.Direction;
import yugioh.chaos.rising.Space;
import yugioh.chaos.rising.SpaceType;
import yugioh.testharness.SimpleTestHarness;

import java.util.Arrays;

/**
 * This class is the TestHarness for the Board class. It runs through the Board class and tests its different methods.
 *
 * @author Michael Kramer
 * @version .1
 * @since .1
 */
public class BoardTestHarness extends SimpleTestHarness {

	public BoardTestHarness() {
		run();
		printResults();
	}

	@Override
	protected void run(){
		System.out.println("Testing the board Class.");
		Space[][] testOriginalSpaceArray = new Space[9][9];
		Space waterSpace = new Space(SpaceType.WATER);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				testOriginalSpaceArray[i][j] = waterSpace;
			}
		}

		Board testBoard = new Board(testOriginalSpaceArray);

		if (testBoard != null) {
			//System.out.println("The System successfully created the board class.");
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if(testOriginalSpaceArray[i][j].getSpaceType() == waterSpace.getSpaceType()){
						//System.out.println("The System returned the correct space type"
						//	+ " at " + i + " , " + j);
					} else {
						System.out.println("The System failed to return the correct"
								+ " space type at " + i + " , " + j);
						failureCount++;
					}
				}
			}
			//System.out.println("Testing changing space.");
			Space[][] testNewSpaceArray = new Space[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					testNewSpaceArray[i][j] = waterSpace;
				}
			}
			testNewSpaceArray[0][0] = new Space(SpaceType.CRUSH);
			testNewSpaceArray[1][0] = new Space(SpaceType.DARK);
			testNewSpaceArray[2][0] = new Space(SpaceType.FOREST);
			testNewSpaceArray[3][0] = new Space(SpaceType.LABYRINTH);
			testNewSpaceArray[4][0] = new Space(SpaceType.MEADOW);
			testNewSpaceArray[5][0] = new Space(SpaceType.MOUNTAIN);
			testNewSpaceArray[6][0] = new Space(SpaceType.NORMAL);
			testNewSpaceArray[7][0] = new Space(SpaceType.TOON);
			testNewSpaceArray[8][0] = new Space(SpaceType.WASTELAND);
			testNewSpaceArray[0][1] = new Space(SpaceType.WATER);

			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					testBoard.setSpace(i, j , testNewSpaceArray[i][j]);
				}
			}
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					if (testBoard.getSpace(i, j).getSpaceType() == testNewSpaceArray[i][j].getSpaceType()) {
						//System.out.println("The System correctly changed the space"
						//    + " at " + i + " , " + j);
					} else {
						System.out.println("The System failed to change the space"
								+ " at " + i + " , " + j);
						failureCount++;
					}
				}
			}

			//System.out.println("Testing player movement.");
			int[] expectedPlayerOneLocation = {4,0};
			if(!Arrays.equals(expectedPlayerOneLocation, testBoard.getPlayerOneLocation())) {
				System.out.println("The test board failed to place player one at correct place.");
				failureCount++;
			}
			testBoard.movePlayer(1, Direction.UP);
			expectedPlayerOneLocation[1]++;
			if(!(Arrays.equals(expectedPlayerOneLocation, testBoard.getPlayerOneLocation()))) {
				System.out.println("The test board failed to move the player one up.");
				System.out.println(Arrays.toString(expectedPlayerOneLocation));
				System.out.println(Arrays.toString(testBoard.getPlayerOneLocation()));
				failureCount++;
			}
			testBoard.movePlayer(1, Direction.RIGHT);
			expectedPlayerOneLocation[0]++;
			if(!Arrays.equals(expectedPlayerOneLocation, testBoard.getPlayerOneLocation())) {
				System.out.println("The test board failed to move the player one right.");
				failureCount++;
			}
			expectedPlayerOneLocation[1]--;
			testBoard.movePlayer(1, Direction.DOWN);
			if(!Arrays.equals(expectedPlayerOneLocation, testBoard.getPlayerOneLocation())) {
				System.out.println("The test board failed to move the player one down.");
				failureCount++;
			}
			testBoard.movePlayer(1, Direction.LEFT);
			expectedPlayerOneLocation[0]--;
			if(!Arrays.equals(expectedPlayerOneLocation, testBoard.getPlayerOneLocation())) {
				System.out.println("The test board failed to move the player one left.");
				failureCount++;
			}
			int[] expectedPlayerTwoLocation = {4,8};
			if(!Arrays.equals(expectedPlayerTwoLocation, testBoard.getPlayerTwoLocation())) {
				System.out.println("The test board failed to place player two at correct place.");
				failureCount++;
			}
			testBoard.movePlayer(2, Direction.RIGHT);
			expectedPlayerTwoLocation[0]++;
			if(!Arrays.equals(expectedPlayerTwoLocation, testBoard.getPlayerTwoLocation())) {
				System.out.println("The test board failed to move the player two right.");
				failureCount++;
			}

			expectedPlayerTwoLocation[1]--;
			testBoard.movePlayer(2, Direction.DOWN);
			if(!Arrays.equals(expectedPlayerTwoLocation, testBoard.getPlayerTwoLocation())) {
				System.out.println("The test board failed to move the player two down.");
				failureCount++;
			}
			testBoard.movePlayer(2, Direction.LEFT);
			expectedPlayerTwoLocation[0]--;
			if(!Arrays.equals(expectedPlayerTwoLocation, testBoard.getPlayerTwoLocation())) {
				System.out.println("The test board failed to move the player two left.");
				failureCount++;
			}
			testBoard.movePlayer(2, Direction.UP);
			expectedPlayerTwoLocation[1]++;
			if(!(Arrays.equals(expectedPlayerTwoLocation, testBoard.getPlayerTwoLocation()))) {
				System.out.println("The test board failed to move the two player up.");
				System.out.println(Arrays.toString(expectedPlayerTwoLocation));
				System.out.println(Arrays.toString(testBoard.getPlayerTwoLocation()));
				failureCount++;
			}
			testBoard.movePlayer(2, Direction.UP);
			if(!(Arrays.equals(expectedPlayerTwoLocation, testBoard.getPlayerTwoLocation()))) {
				System.out.println("The test board failed to detect the upper border. (player two)");
				failureCount++;
			}
			testBoard.movePlayer(1, Direction.DOWN);
			if(!Arrays.equals(expectedPlayerOneLocation, testBoard.getPlayerOneLocation())) {
				System.out.println("The test board failed to dected the lower border. (player one)");
				failureCount++;
			}
			//System.out.println("Testing player collision now.");
			testBoard.movePlayer(1, Direction.UP);
			testBoard.movePlayer(1, Direction.UP);
			testBoard.movePlayer(1, Direction.UP);
			testBoard.movePlayer(1, Direction.UP);
			testBoard.movePlayer(1, Direction.UP);
			testBoard.movePlayer(1, Direction.UP);
			testBoard.movePlayer(1, Direction.UP);
			testBoard.movePlayer(1, Direction.UP);
			if(Arrays.equals(testBoard.getPlayerTwoLocation(), testBoard.getPlayerOneLocation())) {
				System.out.println("The test board failed to detect the player collision.");
				failureCount++;
			}
			testBoard.movePlayer(2, Direction.DOWN);
			if(Arrays.equals(testBoard.getPlayerTwoLocation(), testBoard.getPlayerOneLocation())) {
				System.out.println("The test board failed to detect the player collision.");
				failureCount++;
			}
			//Player One is at location 4,7
			//Player Two is at location 4,8

			//Test moving player two onto the new card entity.
			//System.out.println(Arrays.toString(testBoard.getPlayerTwoLocation()));

		} else {
			System.out.println("The System failed to create the board class.");
		}

		System.out.println("The Board class encountered " + failureCount + " failures.");
	}

	@Override
	protected void printResults() {
		if(failureCount == 0){
			System.out.println("The Board TestHarness did not encounter any errors.");
		} else {
			System.err.println("The BoardTestHarness encountered " + failureCount + " errors!");
		}
	}
}
