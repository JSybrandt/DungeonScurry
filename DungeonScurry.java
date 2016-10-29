   import java.awt.*;
   import javax.swing.JFrame;
   import java.awt.geom.*;
   import info.gridworld.gui.*;
   import info.gridworld.grid.*;
   import info.gridworld.world.*;
   import info.gridworld.world.World;
   import info.gridworld.actor.*;
   
import java.util.Random;

 

   public class DungeonScurry
   {
      public static void main (String[] args)
      {
          Player player;
             Random randomGenerator = new Random();
            PlayerSetupDialogue test = new PlayerSetupDialogue();
            
    
           String n = test.getName();
 if(n.equals("developer"))
 {
     player= new Player(n,100,100,100);
    }
        else   
           player = new Player(n,12,8,10);
          
           
    Room start = new Room();
   Room treasure= new Treasure();
   
        int height=10;
          int length=10;
       
        
       
        
        
        WorldMap.setUp();  
        
        
           player.putSelfInGrid(start,new Location(10,10) );
         //  player.equip(new Stick());
          WorldMap.fill(treasure,4,5);
           WorldMap.fill(start,4,4); 
           for(int x=5;x<9;x++)
           {
               Wall w= new Wall();
               w.putSelfInGrid(start,new Location(5,x));
            }
            
           for(int x=12;x<16;x++)
           {
               Wall w= new Wall();
               w.putSelfInGrid(start,new Location(5,x));
            }
            
            
           for(int x=5;x<9;x++)
           {
               Wall w= new Wall();
               w.putSelfInGrid(start,new Location(15,x));
            }
              
            for(int x=12;x<16;x++)
           {
               Wall w= new Wall();
               w.putSelfInGrid(start,new Location(15,x));
            }
              
            for(int y=5;y<9;y++)
            {
                Wall w= new Wall();
               w.putSelfInGrid(start,new Location(y,5));
            }
             for(int y=12;y<16;y++)
            {
                Wall w= new Wall();
               w.putSelfInGrid(start,new Location(y,5));
            }
               
            for(int y=5;y<9;y++)
            {
                Wall w= new Wall();
               w.putSelfInGrid(start,new Location(y,15));
            }
             for(int y=12;y<16;y++)
            {
                Wall w= new Wall();
               w.putSelfInGrid(start,new Location(y,15));
            }
            Chest a= new Chest();
            Chest b= new Chest();
            Chest c= new Chest();
            a.putSelfInGrid(start,new Location(5,9));
            b.putSelfInGrid(start,new Location(5,10));
            c.putSelfInGrid(start,new Location(5,11));
            
              //DoorFix.run();
              
         GUI screen = new GUI(player);
            GUI.setGrid(start);
         screen.displayGUI();
            
         GUI.println("Welcome to Dungeon Scurry!");
         GUI.println("A game by Nalta, Controler12, and Kelez");
         GUI.println("");
         GUI.println("You are that short guy in swanky green pants in the top left!");
         GUI.println("Use the on-screen arrow keys to move about the map,");
         GUI.println("And the other buttons to check your stats.");
         GUI.println("It is up to you to slay the boss of this realm!");
         GUI.println("PREPAIR YOURSELF!");
         
         GUI.println(player.getName() + " has joined the fight!");
         player.equip(new Stick());
         GUI.update();
        
      }
   }