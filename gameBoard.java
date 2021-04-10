package Battleship;

public class gameBoard {
	public String[][] makeBoard()
	{
		String[][] gameBoard = new String[8][8];

		
		for (int i=0; i<gameBoard.length; i++)
		{
			for (int k=0; k<gameBoard[0].length; k++)
			{
				gameBoard[i][k] = " ";
			}
		}
		return gameBoard;
	}
	public void displayBoard(String[][] gameBoard)
	{
		
		for (int i=0; i<gameBoard.length; i++)
		{
			for (int k=0; k<gameBoard[0].length; k++)
			{
				if(k == gameBoard[0].length-1)
				{
					System.out.println("["+gameBoard[i][k]+"]");
				}
				else
				{
					System.out.print("["+gameBoard[i][k]+"]");
				}
			}
		}
	}
}
