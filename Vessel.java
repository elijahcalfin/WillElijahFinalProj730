package Battleship;

import java.util.ArrayList;

public class Vessel {
	
	
	public ArrayList<int[]> createFleet()
	{
		int[] Carrier = createVessel(5);
		int[] Battleship = createVessel(4);
		int[] Cruiser = createVessel(3);
		int[] Destroyer = createVessel(2);
		int[] Submarine = createVessel(2);
		ArrayList<int[]> fleet = new ArrayList<int[]>();
		fleet.add(Carrier);
		fleet.add(Battleship);
		fleet.add(Cruiser);
		fleet.add(Destroyer);
		fleet.add(Submarine);
		return fleet;
	}
	
	private int[] createVessel(int size)
	{
		//0 by default, will change in Populate.java
		int position = 0;
		//0 = horizontal, 1 = vertical
		int orientation = 0;
		int health = size;
		int[] battleship = {position,orientation,health,size};
		return battleship;
	}
	
	public int[] createVesselCaller(int size)
	{
		int[] myReturn = createVessel(size);
		return myReturn;
	}
	
	
	
	
}
