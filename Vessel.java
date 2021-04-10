package Battleship;

public class Vessel {
	
	
	private int[] createVessel(int size)
	{
		//0 by default, will change in Populate.java
		int position = 0;
		//0 = horizontal, 1 = vertical
		int orientation = 0;
		int[] battleship = {position,orientation,size};
		return battleship;
	}
	
	public int[] createVesselCaller(int size)
	{
		int[] myReturn = createVessel(size);
		return myReturn;
	}
	
	
}
