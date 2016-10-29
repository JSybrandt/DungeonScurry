package info.gridworld.actor;
import info.gridworld.gui.*;

/**
 * Write a description of class Slime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slime extends MeleeTackler
{
   public Slime()
   {
           super("Slime",3,3,0);//will make Oryxs have the name Oryx and right stats 
      
     // tagline = "Whatever";
      maxHealth = 1;
      currentHealth = maxHealth;
      equip(new Stick());
     
   
      //strength = 3;
     // dexterity = 2;
      //intellect = 0;
      
      
     
   
      engaged = false;
      aggression = 100;
      special = 20;
      hostileRange = 3;
    }
    public void removeSelfFromGrid()
{
// GUI.getPlayer().newKill();
        grid.remove(location);
        grid = null;
       location = null;
}
}
