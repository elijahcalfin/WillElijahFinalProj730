package Battleship;

public class Barrage {

	public Boolean isShipThere(int[] battleship, String targetcoords)
	{
		//board target coordinates
		String y = Character.toString(targetcoords.charAt(0));
		String x = Character.toString(targetcoords.charAt(1));
		int yi = Integer.parseInt(y);
		int xi = Integer.parseInt(x);
		int gruCoords = battleship[0];
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
						battleship[2]=battleship[2]-1;
						System.out.println("Hit!");
					}
					if(battleship[2]==1)
					{
						battleship[2]=0;
						System.out.println("Sunk!");
					}
					return true;
				}
			}
		}
		if(battleship[1]==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
