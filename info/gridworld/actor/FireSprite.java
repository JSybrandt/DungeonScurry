package info.gridworld.actor;
import info.gridworld.gui.*;
public class FireSprite extends MeleeTackler
{
   public FireSprite()
   {
           super("FireSprite",7,3,0);//will make Oryxs have the name Oryx and right stats 
      
     // tagline = "Whatever";
      maxHealth = 5;
      currentHealth = maxHealth;
      equip(new Sword());
     
     
   
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