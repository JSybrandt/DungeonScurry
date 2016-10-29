package info.gridworld.actor;
import info.gridworld.gui.*;
public abstract class StatItem extends Item
{
int effect;
public StatItem(String name, int worth, int level)
{
super(name,worth);
effect = level;
}
public int getEffect()
{
return effect;
}
public String toString()
{
return "Level " + effect + " " + super.toString();
}
public void stepedOn()
{
GUI.getPlayer().equip(this);
this.removeSelfFromGrid();
}
}