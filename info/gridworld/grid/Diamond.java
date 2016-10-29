package info.gridworld.grid;
import info.gridworld.actor.*;

/**
 * Write a description of class SlimeRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamond extends Room
{
   public Diamond()
   {
      for(int x=1;x<19;x++)
      for(int y=1;y<19;y++)
      {
          Wall a= new Wall();
          a.putSelfInGrid(this, new Location(x,y));
          
        }
       
      for(int y=1;y<19;y++)
      {
         Location locs= new Location(10,y);
         locs= null;
    }
}
}