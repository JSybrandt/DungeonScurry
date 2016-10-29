package info.gridworld.grid;
import info.gridworld.gui.*;
import java.util.ArrayList;
import java.lang.Class;

public  class RoomIndex 
{
	
	//Brian
	private  ArrayList<Room> roomIndex = new ArrayList<Room>();
	
	public RoomIndex()
	{
	   }
	
	public  Room getRandomRoom() 
	{
	    if(roomIndex.size() == 0)
	    return new Room();
	    else
	    {
	    int i = (int)(Math.random()*roomIndex.size());
	    roomIndex.get(i);
	    try
	    {
	    return roomIndex.get(i).getClass().newInstance();
	   }
	   catch (InstantiationException a )
	   {
	       GUI.println("WE ARE SCREWED");
	   }
	   catch (IllegalAccessException a)
	   {
	       GUI.println("BEOTCH-TATAS");
	   }
	    return new Room();
	   }
	   }
	
	public  void addRoomToList(Room a)
	{
	    roomIndex.add(a);
	}
	public  int getNumberOfRooms()
	{
	    return roomIndex.size();
	   }



}
