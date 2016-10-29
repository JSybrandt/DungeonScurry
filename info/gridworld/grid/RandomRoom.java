package info.gridworld.grid;
import info.gridworld.actor.*;

/**
 * Write a description of class RandomRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomRoom extends Room
{
public RandomRoom()
{
   int numChests = (int)(Math.random()*13);
   while (numChests > 0)
   {
       int x = (int)(Math.random()*17+1);
      int y = (int)(Math.random()*17+1);
     new Chest().putSelfInGrid(this,new Location (x,y));
       numChests--;
    }  
    
    
    MonsterSpawner n = new MonsterSpawner();
    int numMonster = (int)(Math.random()*15);
   while (numMonster > 0)
   {
       int x = (int)(Math.random()*17+1);
      int y = (int)(Math.random()*17+1);
     n.getRandomMonster().putSelfInGrid(this,new Location (x,y));
       numMonster--;
    }  
    
    
    int numWalls = (int)(Math.random()*20);
   while (numWalls > 0)
   {
       int x = (int)(Math.random()*17+1);
      int y = (int)(Math.random()*17+1);
     new Wall().putSelfInGrid(this,new Location (x,y));
       numWalls--;
    }  
    }
}
