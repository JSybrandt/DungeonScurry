 package info.gridworld.actor;
/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sheep extends MeleeTackler
{
      
      
     

    /**
     * Constructor for objects of class Orc
     */
    public Sheep()
    {
        super("Sheep",3,2,0); 
      
     // tagline = "Whatever";
      maxHealth = 5;
      currentHealth = maxHealth;
      equip(new Cloth());
      equip(new SheepClaws());
   
     
   
      engaged = false;
      aggression = 1;
      special = 0;
      hostileRange = 2;
    }

 
}
