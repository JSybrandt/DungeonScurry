package info.gridworld.grid;
import info.gridworld.actor.*;

/**
 * Write a description of class SlimeRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlimeRoom extends Room
{
   public SlimeRoom()
   {
        int numSlime = (int)(Math.random()*30);
   while (numSlime > 0)
   {
       int x = (int)(Math.random()*18+1);
      int y = (int)(Math.random()*18+1);
    new Slime().putSelfInGrid(this,new Location (x,y));
       numSlime--;
    }
    int numChests = (int)(Math.random()*20);
   while (numChests > 0)
   {
       int x = (int)(Math.random()*17+2);
      int y = (int)(Math.random()*17+2);
     new Wall().putSelfInGrid(this,new Location (x,y));
       numChests--;
    }  
    }
}
