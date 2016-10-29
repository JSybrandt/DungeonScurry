package info.gridworld.grid;
import info.gridworld.actor.*;
import info.gridworld.gui.*;
import java.util.Random;

public  class WorldMap 
{
private static Room[][] WorldMap;
private static int x, y;
private static RoomIndex roomIndex = new RoomIndex();
private static boolean hasBoss = false;

public  WorldMap() 
{

            

}
public static void setUp()
{
Random randomGenerator = new Random();
             WorldMap= new Room[12][12];
            //int i = (int)Math.random()*9;
            //int k = (int)Math.random()*9;
indexSetUp();
            x=4;
            y=4;
            for(int x=1; x<11;x++)
            for(int y=1; y<11;y++)
            {
            Room a = roomIndex.getRandomRoom();
            if(x==0)
            {
            Diamond diamond= new Diamond();
            WorldMap[x][y]=diamond;
        }
            if(x==1)
            {
            Diamond diamond= new Diamond();
            WorldMap[x][y]=diamond;
        }
            if(x==10)
            {
            Diamond diamond= new Diamond();
            WorldMap[x][y]=diamond;
            }
             if(y==1)
            {
            Diamond diamond= new Diamond();
            WorldMap[x][y]=diamond;
        }
         if(y==10)
            {
            Diamond diamond= new Diamond();
            WorldMap[x][y]=diamond;
        }
            if(x==11)
              {
            Diamond diamond= new Diamond();
            WorldMap[x][y]=diamond;
            }
            if(y==0)
              {
            Diamond diamond= new Diamond();
            WorldMap[x][y]=diamond;
            }
            if(y==11)
              {
            Diamond diamond= new Diamond();
            WorldMap[x][y]=diamond;
            }
            
            
            
            if(WorldMap[x][y]==null)
            {
                 
                if ( a instanceof BossRoom)
                if (hasBoss)
                {
                    while (a instanceof BossRoom)
                    a = roomIndex.getRandomRoom();
                }
                else 
                {
                    hasBoss = true;
                   
                }
                 WorldMap[x][y]=a;
            }
          
           /*  if(x==0 && y==0)
            {
                Wall w= new Wall();
                w.putSelfInGrid(grab(x,y),new Location(10,0));
                 Wall e= new Wall();
                e.putSelfInGrid(grab(x,y),new Location(0,10));
            }
            
          if(x==9 && y==0)
            {
                Wall w= new Wall();
                w.putSelfInGrid(grab(x,y),new Location(10,19));
                 Wall e= new Wall();
                e.putSelfInGrid(grab(x,y),new Location(0,10));
            }
            
            if(x==0 && y==9)
            {
                Wall w= new Wall();
                w.putSelfInGrid(grab(x,y),new Location(19,10));
                 Wall e= new Wall();
                e.putSelfInGrid(grab(x,y),new Location(10,0));
            }
            
            if(x==9 && y==9)
            {Wall w= new Wall();
                w.putSelfInGrid(grab(x,y),new Location(19,10));
                 Wall e= new Wall();
                e.putSelfInGrid(grab(x,y),new Location(10,19));
            }
            
            if(x==0 && y!=0 && y!=9)
            {Wall w= new Wall();
                w.putSelfInGrid(grab(x,y),new Location(10,0));
         
            }
            
            if(x==9 && y!=0 && y!=9)
            {Wall w= new Wall();
                w.putSelfInGrid(grab(x,y),new Location(10,19));
            }
            
             if(y==0 && x!=0 && x!=9)
            {Wall w= new Wall();
                w.putSelfInGrid(grab(x,y),new Location(0,10));
            }
            
             if(y==9 && x!=0 && x!=9)
            {Wall w= new Wall();
                w.putSelfInGrid(grab(x,y),new Location(19,10));
            }
            
            */
            }
        
            
            }
            
            
    
            
            
            
            
            
           
            
            
            
            
            
   private static void indexSetUp()
   {
     // roomIndex.addRoomToList(new Room());
   //   roomIndex.addRoomToList(new TestRoom());
      roomIndex.addRoomToList(new BossRoom());
      roomIndex.addRoomToList(new SheepRoom());
      roomIndex.addRoomToList(new SlimeRoom());
      roomIndex.addRoomToList(new BrianRoom());
      roomIndex.addRoomToList(new Diamond());
      roomIndex.addRoomToList(new Treasure());
      roomIndex.addRoomToList(new RandomRoom());
       roomIndex.addRoomToList(new RandomRoom());
       roomIndex.addRoomToList(new AwfulRoom());
       roomIndex.addRoomToList(new DiagonalRoom1());
       roomIndex.addRoomToList(new DiagonalRoom2());
       roomIndex.addRoomToList(new RoomA());
       //roomIndex.addRoomToList(new VertTunnel());
    }
            
            
    
    
    
    
    
    

public static void addRoomToList(Room a)
{
roomIndex.addRoomToList(a);
}

public static Room grab(int x, int y)
{
//GUI.println(""+x+","+y);
Room a= WorldMap[x][y];
return a;

}


public static void fill(Room a, int x, int y)
{
WorldMap[x][y]=a;
}
public static void moveUp()
{
GUI.getPlayer().clearGrid();
x=x;
y=y-1;

Room z = WorldMap[(x)][y];
GUI.setGrid(z);
GUI.update();
//GUI.println("" + (x) + (y));
GUI.getPlayer().clearGrid();
GUI.getPlayer().putSelfInGrid(z, new Location(18,10));
GUI.update();
}
public static void moveDown()
{
x=x;
y=y+1;

GUI.getPlayer().clearGrid();
Room z = WorldMap[x][y];
GUI.setGrid(z);
GUI.update();
GUI.getPlayer().clearGrid();
//GUI.println("" + (x) + (y));
GUI.getPlayer().putSelfInGrid(z, new Location(1,10));
GUI.update();
}
public static void moveLeft()
{

x=x-1;
y=y;

GUI.getPlayer().clearGrid();
Room z = WorldMap[x][y];
GUI.setGrid(z);
GUI.update();
//GUI.println("" + (x) +(y));
GUI.getPlayer().clearGrid();
GUI.getPlayer().putSelfInGrid(z, new Location(10,18));
GUI.update();
}



public static void moveRight()
{
x=x+1;
y=y;

GUI.getPlayer().clearGrid();
Room z = WorldMap[x][y];
//GUI.println("" + (x)+ (y));
GUI.setGrid(z);
GUI.update();
GUI.getPlayer().clearGrid();
GUI.getPlayer().putSelfInGrid(z, new Location(10,1));
GUI.update();
}

public static int x()
{
return x;
}


public static int y()
{
return y;
}


public static void loop()
{
if (x > 11)
x=0;
if (x<0)
x=11;
if (y>11)
y=0;
if(y<0)
y=11;
}


}
