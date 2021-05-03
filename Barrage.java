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
		boolean toobigx = false;
		boolean toobigy = false;
		if(xi==8)
		{
			xi=7;
			toobigx = true;
		}
		if(yi==8)
		{
			yi=7;
			toobigy = true;	
		}
		if(gameBoard[xi][yi]=="!"||gameBoard[xi][yi]=="o")
		{
			return false;
		}
		if(toobigy==true)
		{
			yi=8;
		}
		if(toobigx==true)
		{
			xi=8;
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
						return true;
					}
					if(battleship[2]==1)
					{
						battleship[2]=0;//lowers hp to zero
						System.out.println("Sunk!");
						gameBoard[xi-1][yi-1]="!";//hit marker
						return true;
					}
					
				}
				
			}
			//does not overwrite hit coordinate
			if(gameBoard[xi-1][yi-1]!="=")
			{
				gameBoard[xi-1][yi-1]="o";//miss marker
				System.out.println("Miss!");
			}

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
						return true;
					}
					if(battleship[2]==1)
					{
						battleship[2]=0;//lowers hp to zero
						System.out.println("Sunk!");
						gameBoard[xi][yi-1]="!";//hit marker
						return true;
					}
					
				}
				
			}
			//does not overwrite hit coordinate
			if(gameBoard[xi-1][yi-1]!="=")
			{
				gameBoard[xi-1][yi-1]="o";//miss marker
				System.out.println("Miss!");
			}
			return false;
		}
		
		else {
			return false;
		}
	}
	
	public Boolean isTargettedYet(String targetcoords,String[][] gameBoard)
	{
		//board target coordinates
		String y = Character.toString(targetcoords.charAt(0));
		String x = Character.toString(targetcoords.charAt(1));
		int yi = Integer.parseInt(y);
		int xi = Integer.parseInt(x);
		if(gameBoard[xi-1][yi-1]=="!"||gameBoard[xi-1][yi-1]=="o")
		{
			System.out.println("Location already targetted. Try again.");
			return false;
		}
//		gameBoard[xi][yi]="x"; for dev purposes
//		System.out.println("Good");
		return true;
	}
		public void sweepBoard(String[][] gameBoard, ArrayList<int[]> fleetbag)
	{
		boolean pretarg = true;
		System.out.println("Enter xy target coordinates.");
		String targetcoords = in.next();
		while(targetcoords.length()!=2)
		{
			System.out.println("Must be two numbers. Enter xy target coordinates.");
			targetcoords = in.next();
		}
		pretarg = isTargettedYet(targetcoords,gameBoard);
		while(pretarg==false)
		{
			System.out.println("Enter xy target coordinates.");
			targetcoords = in.next();
			pretarg = isTargettedYet(targetcoords,gameBoard);
		}
		for(int i = 0; i < fleetbag.size(); i++)
		{
			//board.displayBoard(gameBoard);
			int[] battleship = fleetbag.get(i);
			boolean wegotahit = isShipThere(battleship,targetcoords,gameBoard);
			if(wegotahit==true)
			{
				i = fleetbag.size();
			}
		}
	}
}
