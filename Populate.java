package Battleship;

import java.util.ArrayList;
import java.util.Scanner;

public class Populate {
	Vessel vessel = new Vessel();
	gameBoard board = new gameBoard();
	Scanner in = new Scanner(System.in);
	
	public Boolean placingVessels(String[][] gameBoard,int[] battleship,String coords,int orientation)
	{
		String y = Character.toString(coords.charAt(0));
		String x = Character.toString(coords.charAt(1));
		int yi = Integer.parseInt(y);
		int xi = Integer.parseInt(x);
		int shipsize = battleship[3];
		int convertint = Integer.parseInt(coords);
		battleship[0]=convertint;
		battleship[1]=orientation;
		int counter = 0;
		int counter2 = 0;
		if(orientation == 0)
		{
			for (int i=0; i<gameBoard.length; i++)
			{
				for (int k=0; k<gameBoard[0].length; k++)
				{
					if(i == xi-1)
					{
						if(k>=yi-1 && counter2<shipsize)
						{	
							counter2 = counter2 +1;
							if(gameBoard[i][k] == "=")
							{
								System.out.println("Another ship is in the way. Try again.");
								return false;
							}
						}
					}
				}
			}
			
			if(yi+shipsize>gameBoard.length||xi>gameBoard.length)
			{
				System.out.println("Ship placed out of horizontal bounds. Try again.");
				return false;
			}
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
		}
		if(orientation == 1)
		{
			for (int i=0; i<gameBoard.length; i++)
			{
				for (int k=0; k<gameBoard[0].length; k++)
				{
					if(i == yi-1)
					{
						if(k>=xi-1 && counter2<shipsize)
						{	
							counter2 = counter2 +1;
							if(gameBoard[k][i] == "=")
							{
								System.out.println("Another ship is in the way. Try again.");
								return false;
							}
						}
					}
				}
			}
			if(xi+shipsize>gameBoard.length||yi>gameBoard.length)
			{
				System.out.println("Ship placed out of vertical bounds. Try again.");
				return false;
			}
			for (int i=0; i<gameBoard.length; i++)
			{
				for (int k=0; k<gameBoard[0].length; k++)
				{
					if(i == yi-1)
					{
						if(k>=xi-1 && counter<shipsize)
						{	
							counter = counter +1;
							gameBoard[k][i] = "=";
						}
					}
				}
			}
		}

		return true;
	}

	public String[][] placeFleet(ArrayList<int[]> fleetbag, String[][] gameBoard)
	{
		for(int i = 0; i < fleetbag.size(); i++)
		{
			board.displayBoard(gameBoard);
			int[] battleship = fleetbag.get(i);
			System.out.println("Enter xy coordinates.");
			String coords = in.next();
			while(coords.length()!=2)
			{
				System.out.println("Must be two numbers. Enter xy coordinates.");
				coords = in.next();
			}
			System.out.println("Enter orientation. 0 = horizontal, 1 = vertical");
			String orientation = in.next();
			while(orientation.length()!=1)
			{
				System.out.println("Must be 1 number. Re-enter orientation.");
				orientation = in.next();
			}
			int orientationint = Integer.parseInt(orientation); 
			boolean tf = placingVessels(gameBoard,battleship,coords,orientationint);
			if(tf==false)//if placement does not work correctly, walks back the index by one so the user can try again.
			{
				i = i -1;
			}
			if(i==fleetbag.size()-1)
			{
				board.displayBoard(gameBoard);
				System.out.println("Hit n & enter to finish.");
				in.next();
			}
		}
		return gameBoard;
		
	}
	
	
	public int fleetStatus(ArrayList<int[]> fleetbag)
	{
		//determines if fleet is alive or not
		int dead = 0;
		//goes through bag finding ship status
		for(int i = 0; i < fleetbag.size(); i++)
		{
			int[] status = fleetbag.get(i);
			//if 0, ship is dead, counter of dead ships rises
			if(status[2]==0)
			{
				dead = dead + 1;
			}
		}
		
		if(dead==fleetbag.size())
		{
			return 1;
		}
		
		else
		{
			return 0;
		}
		
		
	}
}
