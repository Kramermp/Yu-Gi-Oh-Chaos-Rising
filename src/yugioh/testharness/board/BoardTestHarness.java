package yugioh.testharness.board;

import org.apache.xpath.SourceTree;
import yugioh.chaos.rising.Board;
import yugioh.chaos.rising.Direction;
import yugioh.chaos.rising.Space;
import yugioh.chaos.rising.SpaceType;
import yugioh.testharness.SimpleTestHarness;

import java.lang.reflect.Field;
import java.lang.reflect.ReflectPermission;
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
		System.out.println("Creating a BoardTestHarness.");
		run();
		printResults();
	}

	@Override
	protected void run(){
		System.out.println("Running the BoardTestHarness.");
		testCreation(Board.getTestBoard());
		testGetters(Board.getTestBoard());
		testSetters(Board.getTestBoard());
		testPlayerMovement(Board.getTestBoard());
	}

	@Override
	protected void printResults() {
		if(failureCount == 0){
			System.out.println("The Board TestHarness did not encounter any errors.");
		} else {
			System.err.println("The BoardTestHarness encountered " + failureCount + " errors!");
		}
	}

	private void testCreation(Board boardToTest) {
		if(boardToTest != null) {
			System.out.println("The Board Class successfully created a Board object.");
		} else {
			System.err.println("The Board Class failed to create a Board object.");
			failureCount++;
		}
	}

	private void testGetters(Board testBoard) {
		testGetSpace(testBoard);
	}

	private void testSetters(Board testBoard) {
		testSetSpace(testBoard);
	}

	private void testPlayerMovement(Board testBoard) {
		testMovePlayer(testBoard);
	}

	private void testGetSpace(Board testBoard) {
		System.out.println("Testing Board.getSpace(int, int)");
		try {
			Field spaceArrayField = testBoard.getClass().getDeclaredField("boardSpaces");
			spaceArrayField.setAccessible(true);
			Space[][] actualSpaceArray = (Space[][]) spaceArrayField.get(testBoard);
			Space expectedSpace = actualSpaceArray[0][0];
			if(expectedSpace == testBoard.getSpace(0, 0)) {
				System.out.println("The Space returned by Board.getSpace(int, int) matched the source Space.");
			} else {
				System.err.println("The Space returned by Board.getSpace(int, int) did not match the source Space.");
				failureCount++;
			}
		} catch (NoSuchFieldException ex) {
			System.err.println("While testing Board.getSpace(int, int) the field was not found.");
			System.err.println("There is a problem with the testharness.");
			ex.printStackTrace();
			failureCount++;
		} catch (IllegalAccessException ex) {
			System.err.println("While testing Board.getSpace(int, int) there was a problem accessing the field. ");
			System.err.println("There is a problem with the testharness.");
			ex.printStackTrace();
			failureCount++;
		}
	}

	private void testSetSpace(Board testBoard) {
		System.out.println("Testting Board.setSpace(Space, int, int)");
		try {
			Space theNewSpace = new Space(SpaceType.MEADOW);
			testBoard.setSpace(theNewSpace, 0, 0);
			Field spaceArrayField = testBoard.getClass().getDeclaredField("boardSpaces");
			spaceArrayField.setAccessible(true);
			Space[][] actualSpaceArray = (Space[][]) spaceArrayField.get(testBoard);
			Space returnedSpace = actualSpaceArray[0][0];
			if(theNewSpace == returnedSpace) {
				System.out.println("The Space returned after Board.setSpace(Space, int, int) matched the Space" +
						" specified");
			} else {
				System.err.println("The Space returned after Board.setSpace(Space, int, int) did not match the Space" +
						" specified.");
				failureCount++;
			}
		} catch (NoSuchFieldException ex) {
			System.err.println("While testing Board.setSpace(Space, int, int) the field was not found.");
			System.err.println("There is a problem with the testharness.");
			ex.printStackTrace();
			failureCount++;
		} catch (IllegalAccessException ex) {
			System.err.println("While testing Board.setSpace(Space, int, int) there was a problem accessing the field.");
			System.err.println("There is a problem with the testharness.");
			ex.printStackTrace();
			failureCount++;
		}

	}

	private void testMovePlayer(Board testBoard) {
//		int[] originalLocation;
//		int[] expectedLocation;
//		try {
//			Field playerOneLocationField = testBoard.getClass().getDeclaredField("playerOneLocation");
//			playerOneLocationField .setAccessible(true);
//
//			originalLocation = ((int[]) playerOneLocationField.get(testBoard)).clone();
//			System.out.println("The original player location is: " + Arrays.toString(originalLocation));
//			testBoard.movePlayer(1, Direction.UP);
//			expectedLocation = new int[] {originalLocation[0], originalLocation[1] - 1};
//
//			if(Arrays.equals(expectedLocation, (int[]) playerOneLocationField.get(testBoard))) {
//				System.out.println("The player Location returned after movePlayer(1, Direction.UP) matched the" +
//						" expected location.");
//			} else {
//				System.err.println("The player Location returned after movePlayer(1, Direction.UP) did not match the" +
//						" expected location." +
//						"\nThe original player location was: " + Arrays.toString(originalLocation) +
//						"\nThe player location returned was: " + Arrays.toString(((int[])playerOneLocationField.get(testBoard))) +
//						"\nThe player location expected was: " + Arrays.toString(expectedLocation));
//				failureCount++;
//			}
//
//			originalLocation = ((int[]) playerOneLocationField.get(testBoard)).clone();
//			testBoard.movePlayer(1, Direction.DOWN);
//			expectedLocation = new int[] {originalLocation[0], originalLocation[1] + 1};
//
//			if(Arrays.equals(expectedLocation, (int[]) playerOneLocationField.get(testBoard))) {
//				System.out.println("The player Location returned after movePlayer(1, Direction.DOWN) matched the" +
//						" expected location.");
//			} else {
//				System.err.println("The player Location returned after movePlayer(1, Direction.DOWN) did not match the" +
//						" expected location.");
//				failureCount++;
//			}
//
//			originalLocation = ((int[]) playerOneLocationField.get(testBoard)).clone();
//			testBoard.movePlayer(1, Direction.LEFT);
//			expectedLocation = new int[] {originalLocation[0] - 1, originalLocation[1]};
//
//			if(Arrays.equals(expectedLocation, (int[]) playerOneLocationField.get(testBoard))) {
//				System.out.println("The player Location returned after movePlayer(1, Direction.LEFT) matched the" +
//						" expected location.");
//			} else {
//				System.err.println("The player Location returned after movePlayer(1, Direction.LEFT) did not match the" +
//						" expected location.");
//				failureCount++;
//			}
//
//			originalLocation = ((int[]) playerOneLocationField.get(testBoard)).clone();
//			testBoard.movePlayer(1, Direction.LEFT);
//			expectedLocation = new int[] {originalLocation[0] + 1, originalLocation[1]};
//
//			if(Arrays.equals(expectedLocation, (int[]) playerOneLocationField.get(testBoard))) {
//				System.out.println("The player Location returned after movePlayer(1, Direction.RIGHT) matched the" +
//						" expected location.");
//			} else {
//				System.err.println("The player Location returned after movePlayer(1, Direction.RIGHT) did not match the" +
//						" expected location.");
//				failureCount++;
//			}
//
//		} catch (NoSuchFieldException ex) {
//			System.err.println("While testing Board.getPlayerOneLocation() the field was not found.");
//			System.err.println("There is a problem with the testharness.");
//			ex.printStackTrace();
//			failureCount++;
//		} catch (IllegalAccessException ex) {
//			System.err.println("While testing Board.getPlayerOneLocation()there was a problem accessing the field.");
//			System.err.println("There is a problem with the testharness.");
//			ex.printStackTrace();
//			failureCount++;
//		}
	}

}
