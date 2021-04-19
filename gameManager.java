package Battleship;

public class gameManager {

	public static void main(String[] args) {
		gameBoard board = new gameBoard();
		gameBoard board2 = new gameBoard();
		Barrage barrage = new Barrage();
		Vessel vessel = new Vessel();
		Populate populator = new Populate();
		int[] cruiser = vessel.createVesselCaller(5);
		String[][] boardp1 = board.makeBoard();
		String[][] boardp2 = board2.makeBoard();
		
		boardp1 = populator.placingVessels(boardp1, cruiser, "54", 0);
		board.displayBoard(boardp1);
		System.out.println("");
		boardp1 = populator.placingVessels(boardp1, cruiser, "25", 0);
		board.displayBoard(boardp1);
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		boardp2 = populator.placingVessels(boardp2, cruiser, "26", 1);
		
		board2.displayBoard(boardp2);
		System.out.println("");
		boardp2 = populator.placingVessels(boardp2, cruiser, "62", 1);
		board2.displayBoard(boardp2);

		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		boardp2 = populator.placingVessels(boardp2, cruiser, "27", 0);
		board2.displayBoard(boardp2);
		System.out.println(cruiser[0]);
		barrage.isShipThere(cruiser,"27");
		barrage.isShipThere(cruiser,"37");
		barrage.isShipThere(cruiser,"47");
		barrage.isShipThere(cruiser,"57");
		barrage.isShipThere(cruiser,"67");
	}
}
