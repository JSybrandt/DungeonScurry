
package info.gridworld.actor;
import info.gridworld.gui.*;
/**
 * Write a description of class Oryx here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oryx extends MeleeTackler
{
      
      
     

    /**
     * Constructor for objects of class Oryx
     */
    public Oryx()
    {
        super("Oryx",10,5,0);//will make Oryxs have the name Oryx and right stats 
      
     // tagline = "Whatever";
      maxHealth = 100;
      currentHealth = maxHealth;
      equip(new Iron());
      equip(new OryxSword());
   
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
       GUI.println("ORX HAS BEEN DEFEATED YOU HAVE WON THE GAME!");
        grid.remove(location);
        grid = null;
       location = null;
        GUI.println("You have taken " + GUI.getPlayer().getNumKills() + " monsters to the grave!");
       
}
 
}
