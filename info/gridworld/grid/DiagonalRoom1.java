package info.gridworld.grid;
import info.gridworld.actor.*;
/**
 * Write a description of class DiagonalRoom1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiagonalRoom1 extends Room
{
    public DiagonalRoom1()
    {

        int numChests = (int)(Math.random()*7);
        while (numChests > 0)
        {
            int x = (int)(Math.random()*17+2);
            int y = (int)(Math.random()*17+2);
            new Chest().putSelfInGrid(this,new Location (x,y));
            numChests--;
        }  
        MonsterSpawner n = new MonsterSpawner();
        int numMonster = (int)(Math.random()*6);
        while (numMonster > 0)
        {
            int x = (int)(Math.random()*17+2);
            int y = (int)(Math.random()*17+2);
            n.getRandomMonster().putSelfInGrid(this,new Location (x,y));
            numMonster--;
        }  
        int numWalls = (int)(Math.random()*20);
        while (numWalls > 0)
        {
            int x = (int)(Math.random()*17+2);
            int y = (int)(Math.random()*17+2);
            new Wall().putSelfInGrid(this,new Location (x,y));
            numWalls--;
        }  
        int y = 1;
        for(int x = 1; x<19; x++)
            {
                Wall w= new Wall();
                w.putSelfInGrid(this,new Location(y,x));
                y++;
        }
    }
}
