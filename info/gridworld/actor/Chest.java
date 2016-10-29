package info.gridworld.actor;
import info.gridworld.grid.*;
import java.util.ArrayList;

public class Chest extends Actor implements Stepable
{
Item a;

public Chest()
{
ItemIndex selection = new ItemIndex();
a = selection.getRandomItem();
}
public Chest(Item b)
{
a = b;
}
public void stepedOn()
{
Location b = location;
Grid g = grid;
this.removeSelfFromGrid();
if (a != null)
a.putSelfInGrid(g,b);
}
}