package info.gridworld.actor;
import info.gridworld.gui.*;
import java.util.ArrayList;
import java.lang.Class;

public  class MonsterSpawner 
{
	
	//Brian
	private  ArrayList<Monster> monsterIndex = new ArrayList<Monster>();
	
	public MonsterSpawner()
	{
	    monsterIndex.add(new Slime());
	    monsterIndex.add(new Sheep());
	    monsterIndex.add(new Sheep());
	    monsterIndex.add(new Skeleton());
	    monsterIndex.add(new Skeleton());
	    monsterIndex.add(new Skeleton());
	    monsterIndex.add(new OrcT());
	    monsterIndex.add(new OrcT());
	    monsterIndex.add(new Reaper());
	    monsterIndex.add(new MustacheMan());
	    monsterIndex.add(new GustOfWind());
	    monsterIndex.add(new GustOfWind());
	    monsterIndex.add(new GustOfWind());
	    monsterIndex.add(new Ghost());
	    monsterIndex.add(new Deveney());
	    monsterIndex.add(new Deveney());
	    monsterIndex.add(new FireSprite());
	    monsterIndex.add(new FireSprite());
	    monsterIndex.add(new Banana());
	    monsterIndex.add(new Banana());
	    monsterIndex.add(new Banana());
	   }
	
	public  Monster getRandomMonster() 
	{
	    if(monsterIndex.size() == 0)
	    return new Sheep();
	    else
	    {
	    int i = (int)(Math.random()*monsterIndex.size());
	    monsterIndex.get(i);
	    try
	    {
	    return monsterIndex.get(i).getClass().newInstance();
	   }
	   catch (InstantiationException a )
	   {
	       GUI.println("WE ARE SCREWED");
	   }
	   catch (IllegalAccessException a)
	   {
	       GUI.println("BEOTCH-TATAS");
	   }
	    return new Slime();
	   }
	   }
	
	public  void addMonsterToList(Monster a)
	{
	    monsterIndex.add(a);
	}
	public  int getNumberOfItems()
	{
	    return monsterIndex.size();
	   }



}