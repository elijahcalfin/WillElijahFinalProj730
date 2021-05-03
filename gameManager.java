package Battleship;

import java.util.ArrayList;

public class gameManager {

	public static void main(String[] args) {
		Barrage barrage = new Barrage();
		Vessel vessel = new Vessel();
		Populate populator = new Populate();

		gameBoard player1 = new gameBoard();
		String[][] p1b = player1.makeBoard();
		gameBoard player2 = new gameBoard();
		String[][] p2b = player2.makeBoard();
		ArrayList<int[]> p1f = vessel.createFleet();
		ArrayList<int[]> p2f = vessel.createFleet();
		System.out.println("Player 1");
		populator.placeFleet(p1f, p1b);
		for(int i = 0; i<20; i++)//stupid way of clearing console by flooding it
		{
			System.out.println(" ");
		}
		System.out.println("Player 2");
		populator.placeFleet(p2f, p2b);
		int deadcount = 0;
		int whichplayer = 1;
		while(deadcount<1)
		{
			if(whichplayer==1);
			{
				for(int i = 0; i<20; i++)//stupid way of clearing console
				{
					System.out.println(" ");
				}
				System.out.println("");
				player2.displayEnemyBoard(p2b);
				barrage.sweepBoard(p2b, p2f);
				whichplayer=2;
				deadcount=populator.fleetStatus(p2f);
			}
			if(whichplayer==2);
			{
				for(int i = 0; i<20; i++)//stupid way of clearing console
				{
					System.out.println(" ");
				}
				System.out.println("");
				player1.displayEnemyBoard(p1b);
				barrage.sweepBoard(p1b, p1f);
				whichplayer=1;
				deadcount=populator.fleetStatus(p1f);
			}
		}
		if(whichplayer==2)
		{
			System.out.println("Player 2 is dead!");
		}
		if(whichplayer==1)
		{
			System.out.println("Player 1 is dead!");
		}
	}
}
