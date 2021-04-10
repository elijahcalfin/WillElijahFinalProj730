package Battleship;

public class gameManager {

	public static void main(String[] args) {
		gameBoard board = new gameBoard();
		String[][] board1 = board.makeBoard();
		board.displayBoard(board1);
	}
}
