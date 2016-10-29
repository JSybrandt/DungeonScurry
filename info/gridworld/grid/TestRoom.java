package info.gridworld.grid;
import info.gridworld.actor.*;


/**
 * Write a description of class TestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestRoom extends Room
{
   public TestRoom()
   {
     
     OrcT dd = new OrcT();
     dd.putSelfInGrid(this, new Location(8,9));
     Chest ch = new Chest(new Potion());
     ch.putSelfInGrid(this, new Location(4,6));
     Chest ch2 = new Chest(new Bow());
     ch2.putSelfInGrid(this, new Location(4,8));
      Chest ch3 = new Chest(new Leather());
     ch3.putSelfInGrid(this, new Location(4,7));
     new Hay().putSelfInGrid(this, new Location(9,9));
     
     MonsterSpawner n = new MonsterSpawner();
    int numMonster = (int)(Math.random()*5);
   while (numMonster > 0)
   {
       int x = (int)(Math.random()*17+2);
      int y = (int)(Math.random()*17+2);
     n.getRandomMonster().putSelfInGrid(this,new Location (x,y));
       numMonster--;
    }     
    }
}
