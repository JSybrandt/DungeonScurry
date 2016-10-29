 package info.gridworld.actor;
/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrcT extends MeleeTackler
{
      
      
     

    /**
     * Constructor for objects of class Orc
     */
    public OrcT()
    {
        super("Orc",3,2,0);//will make orcs have the name orc and right stats 
      
     // tagline = "Whatever";
      maxHealth = 15;
      currentHealth = maxHealth;
      equip(new Leather());
      equip(new Axe());
   
      //strength = 3;
     // dexterity = 2;
      //intellect = 0;
      
      
     
   
      engaged = false;
      aggression = 100;
      special = 0;
      hostileRange = 3;
    }

 
}
