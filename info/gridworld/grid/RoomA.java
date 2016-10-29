package info.gridworld.grid;
import info.gridworld.actor.*;

/**
 * Write a description of class RoomA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomA extends Room
{
    public RoomA()
    {
        int numChests = (int)(Math.random()*6);
   while (numChests > 0)
   {
       int x = (int)(Math.random()*17+2);
      int y = (int)(Math.random()*17+2);
     new Chest().putSelfInGrid(this,new Location (x,y));
       numChests--;
    }  
    
    MonsterSpawner n = new MonsterSpawner();
    int numMonster = (int)(Math.random()*9);
   while (numMonster > 0)
   {
       int x = (int)(Math.random()*17+2);
      int y = (int)(Math.random()*17+2);
     n.getRandomMonster().putSelfInGrid(this,new Location (x,y));
       numMonster--;
    }  
    
    
    
       for(int x=5;x<13;x++)
       {
        Wall w= new Wall();
        w.putSelfInGrid(this,new Location(6,x));
        }   
        
        for(int x=5;x<13;x++)
       {
        Wall w= new Wall();
        w.putSelfInGrid(this,new Location(9,x));
       
        }   
        
        
        
        for(int y=3;y<12;y++)
       {
        Wall w= new Wall();
        w.putSelfInGrid(this,new Location(y,15));
       
        }   
        int x=3;
         for(int y=17;y>11;y--)
       {
        Wall w= new Wall();
        w.putSelfInGrid(this,new Location(y,x));
        x=x+1;
       
        }   
        }   
        
        
    }

    
    

