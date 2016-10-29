package info.gridworld.actor;

public class GustOfWind extends MeleeTackler
{
   public GustOfWind()
   {
           super("Gust Of Wind",2,12,0);//will make Oryxs have the name Oryx and right stats 
      
     // tagline = "Whatever";
      maxHealth = 2;
      currentHealth = maxHealth;
      equip(new Dagger());
      
     
   
      //strength = 3;
     // dexterity = 2;
      //intellect = 0;
      
      
     
   
      engaged = false;
      aggression = 75;
      special = 20;
      hostileRange = 5;
    }
   
}