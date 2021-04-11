package Battleship;

public class gameManager {

	public static void main(String[] args) {
		gameBoard board = new gameBoard();
		Vessel vessel = new Vessel();
		Populate populator = new Populate();
		int[] cruiser = vessel.createVesselCaller(5);
		String[][] board1 = board.makeBoard();
		board.displayBoard(board1);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		board1 = populator.placingVessels(board1, cruiser, "52", 0);
		board.displayBoard(board1);
		
		
	}
}
