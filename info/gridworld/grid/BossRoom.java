package info.gridworld.grid;
import info.gridworld.actor.*;


/**
 * Write a description of class BossRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossRoom extends Room
{
   public BossRoom()
   {
       super();
          
            for(int i =3;i<8;i++)
        for(int f=3;f<8;f++)
            {
           
        new Wall().putSelfInGrid(this, new Location(i,f));
        }
         for(int i =3;i<8;i++)
        for(int f=12;f<17;f++)
            {
           
        new Wall().putSelfInGrid(this, new Location(i,f));
        }
        for(int i =12;i<17;i++)
        for(int f=3;f<8;f++)
            {
           
        new Wall().putSelfInGrid(this, new Location(i,f));
        }
         for(int i =12;i<17;i++)
        for(int f=12;f<17;f++)
            {
           
        new Wall().putSelfInGrid(this, new Location(i,f));
        }
          
    
    put(new Location(2,9),new Wall());
    put(new Location(2,10),new Wall());
    put(new Location(8,7),new Wall());
    put(new Location(8,12),new Wall());
    put(new Location(10,7),new Wall());
    put(new Location(10,12),new Wall());
    put(new Location(17,9),new Wall());
    put(new Location(17,10),new Wall());
    
    Monster m = new Oryx();
    
    m.putSelfInGrid(this,new Location(9,9));
    
   
    }
}
