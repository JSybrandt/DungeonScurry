package info.gridworld.grid; 
import info.gridworld.actor.*;
import java.util.Random;
import info.gridworld.gui.*;
import java.util.*;

public class Room extends BoundedGrid
{
    //Brian screw you
    protected Player player;
    private Door left, right, up, down;

        
    public Room()   
    {
        super(20,20);
        player = GUI.getPlayer();
        Random randomGenerator = new Random();
        //x=a;
        //y=b;
        for(int i=0; i<20; i++)
        {
            for(int f=0; f<20; f++)
            {

                if(i==0 || i==19 || f==0 || f==19)
                {
                    Location locs= new Location(i,f);
                    Wall walls= new Wall();
                    walls.putSelfInGrid( this,locs);
                }
                // makes it so doors dont spawn on outside walls

                int xm = WorldMap.x();
                int ym =WorldMap.y();

                //  if(WorldMap.grab(WorldMap.x()-1,WorldMap.y())!=null)
                {
                    Door left= new Door(4, player);
                    Location locs= new Location(10,0);
                    left.putSelfInGrid(this,locs);
                }

                // if(WorldMap.grab(WorldMap.x(),WorldMap.y()+1)!=null)
                {
                    Door down= new Door(3,player);
                    Location  locs= new Location(19,10);
                    down.putSelfInGrid(this,locs);
                }

                // if(WorldMap.grab(WorldMap.x()+1,WorldMap.y())!=null)
                {
                    Door right= new Door(2, player);
                    Location locs= new Location(10,19);
                    right.putSelfInGrid(this,locs);
                }

                // if(WorldMap.grab(WorldMap.x(),WorldMap.y()-1)!=null)
                {
                    Door up= new Door(1, player);
                    Location    locs= new Location(0,10);
                    up.putSelfInGrid(this, locs);
                }
                /*

                

                if(xm==0 && ym==0)
                {
                Door down= new Door(3,player);
                Location  locs= new Location(19,10);
                putSelfInGrid(locs, down);

                Door right= new Door(2, player);
                locs= new Location(10,19);
                putSelfInGrid(locs, right);

                }
                else
                {
                if(xm==0 && ym==9)
                {

                Door right= new Door(2, player);
                Location locs= new Location(10,19);
                putSelfInGrid(locs, right);

                Door up= new Door(1, player);
                locs= new Location(0,10);
                putSelfInGrid(locs, up);
                }
                else{
                if(xm==9 && ym==0)
                {

                Door down= new Door(3,player);
                Location  locs= new Location(19,10);
                putSelfInGrid(locs, down);

                Door right= new Door(2, player);
                locs= new Location(10,19);
                putSelfInGrid(locs, right);

                }
                else{
                if(xm==9 && ym==9)
                {
                Door left= new Door(4, player);
                Location locs= new Location(10,0);
                putSelfInGrid(locs, left);

                Door up= new Door(1, player);
                locs= new Location(0,10);
                putSelfInGrid(locs, up);
                }
                else{
                if(xm==0 && ym!=0 && ym!=9)
                {   

                Door down= new Door(3,player);
                Location  locs= new Location(19,10);
                putSelfInGrid(locs, down);

                Door right= new Door(2, player);
                locs= new Location(10,19);
                putSelfInGrid(locs, right);

                Door up= new Door(1, player);
                locs= new Location(0,10);
                putSelfInGrid(locs, up);
                }

                else{
                if(xm==9 && ym!=0 && ym!=9)
                {   Door left= new Door(4, player);
                Location locs= new Location(10,0);
                putSelfInGrid(locs, left);

                Door down= new Door(3,player);
                locs= new Location(19,10);
                putSelfInGrid(locs, down);

                Door up= new Door(1, player);
                locs= new Location(0,10);
                putSelfInGrid(locs, up);
                }
                else{
                if(ym==0 && xm!=0 && xm!=9)
                {
                Door left= new Door(4, player);
                Location locs= new Location(10,0);
                putSelfInGrid(locs, left);

                Door down= new Door(3,player);
                locs= new Location(19,10);
                putSelfInGrid(locs, down);

                Door right= new Door(2, player);
                locs= new Location(10,19);
                putSelfInGrid(locs, right);

                }
                else{
                if(ym==9 && xm!=0 && xm!=9)
                {
                Door left= new Door(4, player);
                Location locs= new Location(10,0);
                putSelfInGrid(locs, left);

                Door right= new Door(2, player);
                locs= new Location(10,19);
                putSelfInGrid(locs, right);

                Door up= new Door(1, player);
                locs= new Location(0,10);
                putSelfInGrid(locs, up);
                }


                else
                {
                Door left= new Door(4, player);
                Location locs= new Location(10,0);
                putSelfInGrid(locs, left);

                Door down= new Door(3,player);
                locs= new Location(19,10);
                putSelfInGrid(locs, down);

                Door right= new Door(2, player);
                locs= new Location(10,19);
                putSelfInGrid(locs, right);

                Door up= new Door(1, player);
                locs= new Location(0,10);
                putSelfInGrid(locs, up);
                }

                }
                }
                }
                }
                }
                }
                }
                 */

                /*
                for(int h=0;h<4;i++)
                {
                OrcT x= new OrcT();
                Location locss= new Location((int)Math.random()*18,(int)Math.random()*18);
                x.putSelfInGridSelfInGrid(this,locss);
                }

            
                 */

           
   
            }
        }   

      int numChests = (int)(Math.random()*3);
   while (numChests > 0)
   {
       int x = (int)(Math.random()*17+2);
      int y = (int)(Math.random()*17+2);
     new Chest().putSelfInGrid(this,new Location (x,y));
       numChests--;
    }  
    
    
    }
    
    
}