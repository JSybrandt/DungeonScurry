package info.gridworld.actor;
import info.gridworld.gui.*;


public class Potion extends Consumable
{ int level;
    public Potion()
    {
        super("Potion", 3);
        level = 7;
        
    }
    public Potion(int l)
    {
        super("Potion",4);
        level = l;
    }
    public void consume()
    {
        GUI.getPlayer().heal ((int)(Math.random()*level+1));
        super.consume();
    }
}
