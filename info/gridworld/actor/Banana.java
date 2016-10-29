package info.gridworld.actor;
import info.gridworld.gui.*;

public class Banana extends MeleeTackler
{
   public Banana()
   {
           super("Banana",6,7,0);//will make Oryxs have the name Oryx and right stats 
      
     // tagline = "Whatever";
      maxHealth = 21;
      currentHealth = maxHealth;
      equip(new Club());
      
     
   
      //strength = 3;
     // dexterity = 2;
      //intellect = 0;
      
      
     
   
      engaged = true;
      aggression = 100;
      special = 20;
      hostileRange = 10;
    }
    public void removeSelfFromGrid()
{
 if(GUI.getPlayer() != null && GUI.getPlayer().getName().equals("Deveney"))
 {
     GUI.println("ULTIMATE VICTORY HAS BEEN ACHIEVED!");
    }
        grid.remove(location);
        grid = null;
       location = null;
}
}