package info.gridworld.actor;
import info.gridworld.gui.*;



public class Consumable extends Item implements Stepable
{
public Consumable (String n, int w)
{
super(n,w);
}

public void stepedOn()
{
this.consume();
}
    public void consume()//will remove itself from grid;
    {
        
        this.removeSelfFromGrid();
    }
}
