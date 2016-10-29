package info.gridworld.actor;

public class Skeleton extends MeleeTackler
{
   public Skeleton()
   {
           super("Skeleton",6,4,0);//will make Oryxs have the name Oryx and right stats 
      
     // tagline = "Whatever";
      maxHealth = 15;
      currentHealth = maxHealth;
      equip(new Scimitar());
      
     
   
      //strength = 3;
     // dexterity = 2;
      //intellect = 0;
      
      
     
   
      engaged = false;
      aggression = 100;
      special = 20;
      hostileRange = 3;
    }
    
}