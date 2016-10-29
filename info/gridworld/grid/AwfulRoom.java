package info.gridworld.grid;
import info.gridworld.actor.*;

/**
 * Write a description of class RandomRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AwfulRoom extends Room
{
public AwfulRoom()
{
if(Math.random()>0.98)
{
int x = (int)(Math.random()*17+2);
      int y = (int)(Math.random()*17+2);
     new Chest(new Lightsaber()).putSelfInGrid(this,new Location (x,y));
}

   int numChests = (int)(Math.random()*20);
   while (numChests > 0)
   {
       int x = (int)(Math.random()*17+2);
      int y = (int)(Math.random()*17+2);
     new Wall().putSelfInGrid(this,new Location (x,y));
       numChests--;
    }  
    MonsterSpawner n = new MonsterSpawner();
    int numMonster = (int)(Math.random()*15+3);
   while (numMonster > 0)
   {
       int x = (int)(Math.random()*17+2);
      int y = (int)(Math.random()*17+2);
     n.getRandomMonster().putSelfInGrid(this,new Location (x,y));
       numMonster--;
    }  
     int numWalls = (int)(Math.random()*25);
   while (numWalls > 0)
   {
       int x = (int)(Math.random()*17+2);
      int y = (int)(Math.random()*17+2);
     new Wall().putSelfInGrid(this,new Location (x,y));
       numWalls--;
    }  
    }
}

