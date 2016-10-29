package info.gridworld.actor;

public class Deveney extends MeleeTackler
{
   public Deveney()
   {
           super("Deveney",10,10,0);//will make Oryxs have the name Oryx and right stats 
      
     // tagline = "Whatever";
      maxHealth = 42;
      currentHealth = maxHealth;
      equip(new Lightsaber());
      equip(new Iron());
     
   
      //strength = 3;
     // dexterity = 2;
      //intellect = 0;
      
      
     
   
      engaged = false;
      aggression = 100;
      special = 20;
      hostileRange = 0;
    }
   
}