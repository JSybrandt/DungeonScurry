package info.gridworld.actor;

public class MustacheMan extends MeleeTackler
{
   public MustacheMan()
   {
           super("Mustache Man",10,8,0);//will make Oryxs have the name Oryx and right stats 
      
     // tagline = "Whatever";
      maxHealth = 25;
      currentHealth = maxHealth;
      equip(new Sword());
      equip(new Leather());
     
   
      //strength = 3;
     // dexterity = 2;
      //intellect = 0;
      
      
     
   
      engaged = false;
      aggression = 75;
      special = 20;
      hostileRange = 3;
    }
   
}