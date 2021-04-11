package Battleship;

import java.util.ArrayList;

public class Populate {
	Vessel vessel = new Vessel();
	gameBoard board = new gameBoard();
	
	ArrayList<ArrayList<Integer>> L = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> createVessels()
	{
		return L;
	}
	
	public String[][] placingVessels(String[][] gameBoard,int[] battleship,String coords,int orientation)
	{
		String x = Character.toString(coords.charAt(0));
		String y = Character.toString(coords.charAt(1));
		int xi = Integer.parseInt(x);
		int yi = Integer.parseInt(y);
		int shipsize = battleship[3];
		int counter = 0;
		for (int i=0; i<gameBoard.length; i++)
		{
			for (int k=0; k<gameBoard[0].length; k++)
			{
				if(i == xi-1)
				{
					if(k>=yi-1 && counter<shipsize)
					{	
						counter = counter +1;
						gameBoard[i][k] = "=";
					}
				}
			}
		}
		return gameBoard;
	}
}
