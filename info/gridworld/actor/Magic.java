package info.gridworld.actor;
public  class Magic extends StatItem
{
protected String spellDescription;
protected int range;
public Magic (String d, int w, int l, int r)
{
super(d, w ,l);
range = r; 
}
public void setDescription(String s)
{
spellDescription = s;
}
public String getSpellDescription()
{
return spellDescription;
}
public int getRange()
{
return range;
}

}
//we gonna do this later...