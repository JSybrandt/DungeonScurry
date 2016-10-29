package info.gridworld.actor;

public class Ghost extends MeleeTackler
{
   public Ghost()
   {
           super("Ghost",3,8,0);//will make Oryxs have the name Oryx and right stats 
      
     // tagline = "Whatever";
      maxHealth = 13;
      currentHealth = maxHealth;
      equip(new Dagger());
      equip(new Cloth());
     
   
      //strength = 3;
     // dexterity = 2;
      //intellect = 0;
      
      
     
   
      engaged = false;
      aggression = 100;
      special = 20;
      hostileRange = 5;
    }
   
}