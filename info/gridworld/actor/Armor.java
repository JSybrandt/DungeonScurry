package info.gridworld.actor;
public class Armor extends StatItem
{
public Armor(String name, int worth, int level)
{
super(name,worth,level);
}

public int block()
{
return ((int)(Math.random()*getEffect() + 1));
}
}
//we gonna do this later...