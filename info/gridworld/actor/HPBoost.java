package info.gridworld.actor;
import info.gridworld.gui.*;

/**
 * Write a description of class HPBoost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HPBoost extends Consumable
{
   public HPBoost()
   {
       super("HPBoost",1333);
    }
    public void consume()
    {
        GUI.getPlayer().boostHealth();
        GUI.getPlayer().heal(GUI.getPlayer().getMaxHealth());
        super.consume();
    }
}
