package info.gridworld.actor;
import info.gridworld.gui.*;
import java.util.ArrayList;
import java.lang.Class;

public  class ItemIndex 
{
	
	//Brian
	private  ArrayList<Item> ItemIndex = new ArrayList<Item>();
	
	public ItemIndex()
	{
	    ItemIndex.add(new SheepClaws());
	    ItemIndex.add(new Halberd());
	    ItemIndex.add(new Scythe());
	    ItemIndex.add(new Scimitar());
	    ItemIndex.add(new Lightsaber());
	    ItemIndex.add(new Rapier());
	    ItemIndex.add(new Spear());
	    ItemIndex.add(new Bow());
	    ItemIndex.add(new Club());
	    ItemIndex.add(new Axe());
	    ItemIndex.add(new Sword());
	    ItemIndex.add(new Hammer());
	    ItemIndex.add(new Dagger());
	    ItemIndex.add(new Stick());
	   // ItemIndex.add(new Wool());
	    ItemIndex.add(new Cloth());
	    ItemIndex.add(new HPBoost());
	    ItemIndex.add(new Iron());
	    ItemIndex.add(new Leather());
	    ItemIndex.add(new Potion());
	    ItemIndex.add(new Potion());
	    ItemIndex.add(new Potion());
	    ItemIndex.add(new Potion());
	    ItemIndex.add(new Potion());
	    ItemIndex.add(new Potion());
	    ItemIndex.add(new Potion());
	   }
	
	public  Item getRandomItem() 
	{
	    if(ItemIndex.size() == 0)
	    return new Potion();
	    else
	    {
	    int i = (int)(Math.random()*ItemIndex.size());
	    ItemIndex.get(i);
	    try
	    {
	    return ItemIndex.get(i).getClass().newInstance();
	   }
	   catch (InstantiationException a )
	   {
	       GUI.println("WE ARE SCREWED");
	   }
	   catch (IllegalAccessException a)
	   {
	       GUI.println("BEOTCH-TATAS");
	   }
	    return new Potion();
	   }
	   }
	
	public  void addItemToList(Item a)
	{
	    ItemIndex.add(a);
	}
	public  int getNumberOfItems()
	{
	    return ItemIndex.size();
	   }



}