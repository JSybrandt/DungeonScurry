package info.gridworld.grid;
import info.gridworld.actor.*;

public class SheepRoom extends Room
{
public SheepRoom()
{
int numBales = (int)(Math.random()*30);

while(numBales > 0)
  {
     int x = (int)(Math.random()*17+2);
      int y = (int)(Math.random()*17+2);
     new Hay().putSelfInGrid(this,new Location (x,y));
      numBales--;
   }
   int numSheep = (int)(Math.random()*30);
   while (numSheep > 0)
   {
       int x = (int)(Math.random()*17+2);
      int y = (int)(Math.random()*17+2);
     new Sheep().putSelfInGrid(this,new Location (x,y));
       numSheep--;
    }
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
