package info.gridworld.actor;
import info.gridworld.gui.*;
public abstract class Item extends Actor implements Stepable
{
int worth;
String effect,name;
public Item(String name, int worth)
{
this.name = name;
this.worth = worth;
}
public int getWorth()
{
return worth;
}
public String getName()
{
return name;
}
public String toString()
{
return name + " costs " + worth + " gold.";
}
public void stepedOn()
{

}
}