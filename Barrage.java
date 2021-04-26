package Battleship;

import java.util.ArrayList;
import java.util.Scanner;

public class Barrage {
	gameBoard board = new gameBoard();
	Scanner in = new Scanner(System.in);
	public Boolean isShipThere(int[] battleship, String targetcoords,String[][] gameBoard)
	{
		//board target coordinates
		String y = Character.toString(targetcoords.charAt(0));
		String x = Character.toString(targetcoords.charAt(1));
		int yi = Integer.parseInt(y);
		int xi = Integer.parseInt(x);
		int gruCoords = battleship[0];
		if(gameBoard[xi][yi]=="!"||gameBoard[xi][yi]=="o")
		{
			System.out.println("Location already targetted. Try again.");
			return false;
		}
		//ship coordinates
		String gruCoordsS = Integer.toString(gruCoords);//gruCoords = Grouped Coordinates for Ship
		String yS = Character.toString(gruCoordsS.charAt(0));
		String xS = Character.toString(gruCoordsS.charAt(1));
		int yiS = Integer.parseInt(yS);
		int xiS = Integer.parseInt(xS);
		if(battleship[1]==0)
		{
			//runs while c < size of ship
			for(int c=0; c<battleship[3]; c++)
			{
				//walks forward ship coordinate till
				if(xi == xiS && yi == yiS+c)
				{
					if(battleship[2]>1)
					{
						battleship[2]=battleship[2]-1;//lowers hp
						System.out.println("Hit!");
						gameBoard[xi-1][yi-1]="!";
						return false;
					}
					if(battleship[2]==1)
					{
						battleship[2]=0;//lowers hp to zero
						System.out.println("Sunk!");
						gameBoard[xi-1][yi]="!";//hit marker
						return false;
					}
					
				}
				
			}
			//gameBoard[xi-1][yi-1]="o";//miss marker
			//System.out.println("Miss!");
			return false;
		}
		
		
		if(battleship[1]==1)
		{
			//runs while c < size of ship
			for(int c=0; c<battleship[3]; c++)
			{
				//walks forward ship coordinate till
				if(yi == yiS && xi == xiS+c)
				{
					if(battleship[2]>1)
					{
						battleship[2]=battleship[2]-1;//lowers hp
						System.out.println("Hit!");
						gameBoard[xi-1][yi-1]="!";
					}
					if(battleship[2]==1)
					{
						battleship[2]=0;//lowers hp to zero
						System.out.println("Sunk!");
						gameBoard[xi-1][yi]="!";//hit marker
					}
					return false;
				}
				
			}
			gameBoard[xi-1][yi-1]="o";//miss marker
			System.out.println("Miss!");
			return false;
		}
		
		else {
			return false;
		}
	}
	
	public void sweepBoard(String[][] gameBoard, ArrayList<int[]> fleetbag)
	{
		System.out.println("Enter xy coordinates.");
		String targetcoords = in.next();
		for(int i = 0; i < fleetbag.size(); i++)
		{
			//board.displayBoard(gameBoard);
			int[] battleship = fleetbag.get(i);
			isShipThere(battleship,targetcoords,gameBoard);
		}
	}
}
