package info.gridworld.actor;
import info.gridworld.grid.*;
import info.gridworld.gui.*;

public class Player extends Being
{
    private BoundedGrid<Item> inventory = new BoundedGrid<Item>(5,3);
    private boolean weaponActive = true, alive = true;
    private int numKills = 0;
    public Player(String name)
    {
        super(name,4,4,4);
        maxHealth=25;
        currentHealth=25;
    }

    public Player(String name, int s, int d, int r)
    {
        super(name,s,d,r);
        maxHealth=25;
        currentHealth=25;
    }

    public void moveUp()
    {
        if (this.getGrid().isValid(getLocation().getAdjacentLocation(Location.NORTH)))
        {
            Location l = this.getLocation().getAdjacentLocation(Location.NORTH);
            if ((getGrid().get(l)== null))
                this.moveTo(this.getLocation().getAdjacentLocation(Location.NORTH));
            if (getGrid().get(l) instanceof Stepable)
            checkStep(getGrid().get(l));
        }
    }

    public void moveDown()
    {
        if (this.getGrid().isValid(getLocation().getAdjacentLocation(Location.SOUTH)))
        {
            Location l = this.getLocation().getAdjacentLocation(Location.SOUTH);
            if ((getGrid().get(l)== null))
                this.moveTo(this.getLocation().getAdjacentLocation(Location.SOUTH));
           if (getGrid().get(l) instanceof Stepable)
            checkStep(getGrid().get(l));
        }
     
    }

    public void moveLeft()
    {
        if (this.getGrid().isValid(getLocation().getAdjacentLocation(Location.WEST)))
        {
            Location l = this.getLocation().getAdjacentLocation(Location.WEST);
            if ((getGrid().get(l)== null))
                this.moveTo(this.getLocation().getAdjacentLocation(Location.WEST));
            if (getGrid().get(l) instanceof Stepable)
            checkStep(getGrid().get(l));
        }
    }

    public void moveRight()
    {
        if (this.getGrid().isValid(getLocation().getAdjacentLocation(Location.EAST)))
        {
            Location l = this.getLocation().getAdjacentLocation(Location.EAST);
            if ((getGrid().get(l)== null))
                this.moveTo(this.getLocation().getAdjacentLocation(Location.EAST));
            if (getGrid().get(l) instanceof Stepable)
            checkStep(getGrid().get(l));
            
        }
    }
    public void checkStep(Actor a)
    {
       Stepable b = (Stepable)a;
       b.stepedOn();
    }
    public Grid getInv()
    {
        return inventory;
    }

    public void addToInventory(Item a)
    {
        Location index = new Location(0,0);
        for(int y = 0; y <= 3; y++)
            for(int x = 0; x <=5; x++)
            {
                Location i = new Location(x,y);
                if (inventory.get(i)==null)
                {
                    inventory.put(i, a);
                    return;
                }
        }
    }
   
    public void setWeaponActive(boolean x)
    {
        weaponActive = x;
    }
    public int getRange()
    {
        if (equippedWeapon != null || equippedSpell != null)
        {
            if (weaponActive)
            return equippedWeapon.getRange();
            else return equippedSpell.getRange();
        }
        
        return 1;
    }
    public void die()
    {
        GUI.println("YOU HAVE DIED");
        GUI.println("With you, you have taken " + numKills + " monsters to the grave!");
        Location l = getLocation();
        Grid g = getGrid();
        //GUI.getPlayer().removeSelfFromGrid();
        alive = false;
        Actor a = new TombStone();
        a.putSelfInGrid(g,l);
    }
    public int getNumKills()
    {
        return numKills;
    }
    public boolean checkLife()
    {
        return alive;
    }
    public void fight(Being enemy)
    {
    GUI.getWorld().step();
    super.fight(enemy);
    }
    public void equip(StatItem a)
    {
        if (a instanceof Weapon && equippedWeapon!= null)
        {
        equippedWeapon.putSelfInGrid(this.getGrid(), this.getGrid().getEmptyAdjacentLocations(location).get(0));
        equippedWeapon = null;
    }
        if (a instanceof Armor && equippedArmor!= null)
        {
        equippedArmor.putSelfInGrid(this.getGrid(), this.getGrid().getEmptyAdjacentLocations(location).get(0));
        equippedArmor = null;
    }
        super.equip(a);
        GUI.println(a.getName()+ " has been equiped.");
    }
    public void newKill()
    {
        numKills++;
    }
     public void heal(int life)
     {
         int oldHealth = currentHealth;
          currentHealth+=life;
        if (currentHealth > maxHealth)
            currentHealth = maxHealth;
            
            GUI.println(this.name + " has been healed for " + (currentHealth - oldHealth));
        }
        public int getMaxHealth()
        {
            return maxHealth;
        }
        public void boostHealth()
        {
            maxHealth++;
        }
}
