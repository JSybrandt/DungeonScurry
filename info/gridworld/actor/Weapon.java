package info.gridworld.actor;
public class Weapon extends StatItem
{
protected int range;
public Weapon (String name, int worth, int level)
{
super(name,worth,level);
}
public Weapon (String name, int worth, int level, int range)
{
super(name,worth,level);
this.range = range;
}
public int swing()
{
return ((int)(Math.random()*getEffect() + 1));
}
public int getRange()
{
return range;
}


}
//we gonna do this later...