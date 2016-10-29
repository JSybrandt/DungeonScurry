package info.gridworld.actor;
import info.gridworld.gui.*;
import info.gridworld.grid.*;

public class Being extends Critter
{
    protected int maxHealth = 15;
    protected int currentHealth = maxHealth;
    protected int strength = 1, dexterity = 1, intellect = 1;
    protected String name, tagline = "";

    protected Weapon equippedWeapon = null;
    protected Magic equippedSpell = null;
    protected Armor equippedArmor = new Cloth();

    public Being(String name)
    {
        this.name=name;
    }

    public Being(String name, int s, int d, int i)
    {
        this.name=name;
        strength = s;
        dexterity = d;
        intellect = i;
    }

    public void boostStr()//will level up strength by 1.
    {
        strength++;
    }

    public void changeStr(int c)//increase str by a certain amount (pos or neg)
    {
        strength += c;
        if (strength < 1)
            strength = 1;
    }

    public void setStr(int s)//will set strength to a new value.
    {
        strength = s;
        if (strength < 1)
            strength = 1;
    }

    public void boostDex()//will level up dexterity by 1.
    {
        dexterity++;
    }

    public void changeDex(int d)//change dexterity by a certain amount (pos or neg).
    {
        dexterity += d;
        if (dexterity < 1)
            dexterity = 1;
    }

    public void setDex(int b)//will set dexterity to a new value.
    {
        dexterity = b;
        if (dexterity < 1)
            dexterity = 1;
    }

    public void boostInt()//will level up intellect by 1.
    {
        intellect++;
    }

    public void changeInt(int i)//change intellect by a certain amount (pos or neg).
    {
        intellect += i;
        if (intellect < 1)
            intellect = 1;
    }

    public void setInt(int m)//will set intellect to a new value.
    {
        intellect = m;
        if (intellect < 1)
            intellect = 1;
    }

    //for rolls we are going to assume stats do not go below 0
    public int rollStr()
    {
        return ((int)(Math.random()*strength)+1);
    }

    public int rollDex()
    {
        return ((int)(Math.random()*dexterity)+1);
    }

    public int rollInt()
    {
        return ((int)(Math.random()*intellect)+1);
    }

    public int getStr()
    {
        return strength;
    }

    public int getDex()
    {
        return dexterity;
    }

    public int getInt()
    {
        return intellect;
    }

    public Weapon getWeapon()
    {
        return equippedWeapon;     
    }

    public Magic getSpell()
    {
        return equippedSpell;
    }

    public Armor getArmor()
    {
        return equippedArmor;      
    }

    public String getName()
    {
        return name;
    }

    public boolean checkLOS(Being x)
    {
        if(GUI.getPlayer().checkLife())
        {
            Location xLoc = x.getLocation();
            Location checker = this.getLocation().getAdjacentLocation(this.getLocation().getDirectionToward(xLoc));

            while ( GUI.getPlayer().checkLife()&&this.getGrid().isValid(checker)&&(this.getGrid().get(checker) != x))
            {
                /**Wall tile denotation*/
                if (this.getGrid().get(checker) instanceof Wall)
                    return false;
                else
                    checker = checker.getAdjacentLocation(checker.getDirectionToward(xLoc));
            }

            return true; 
        }
        return false;
    }

    public int checkRange(Actor enemy)//does something stupid
    {
        if(GUI.getPlayer().checkLife())
        {
            Location enemyLoc = enemy.getLocation();
            Location checker = this.getLocation();
            int count = 0;

            while ( GUI.getPlayer().checkLife()&& this.getGrid().get(checker) != enemy)
            {
                checker = checker.getAdjacentLocation(checker.getDirectionToward(enemyLoc));
                count++;

            }
            return count;
        }
        return 1;
    }

    public void fight(Being enemy)
    {
        if (!checkLOS(enemy))
        {
            GUI.println(this.getName() + " cannot see " + enemy.getName());
            return;
        }
        if ((checkRange(enemy) > this.getRange()))
        {
            GUI.println(this.getName() + " is too far away from " + enemy.getName());
            return;
        }
        int playerStr = rollStr();

        if( GUI.getPlayer().getWeapon() instanceof Bow)
            if (playerStr%2==1 || this.rollStr()<=enemy.rollDex())
                GUI.println( this.getName() + " misses!");
            else
                this.swingAt(enemy);//will deal damage if hit       
            else
            if (this.rollStr()>enemy.rollDex()) // Combat log print here
                this.swingAt(enemy);//will deal damage if hit
            else GUI.println( this.getName() + " misses!");
        // else: Combat log print here "____ misses"
    }

    public void swingAt(Being enemy)
    {
        int myDamage=0;
        int hisDefence=0;
        if (equippedWeapon == null)
            myDamage = (int)(Math.random()*4+1);//this is swinging with fists
        else myDamage = equippedWeapon.swing();

        if (enemy.getArmor()!= null)
            hisDefence = enemy.getArmor().block();
        int damage = myDamage-hisDefence;
        if(damage < 0) damage = 0;
        GUI.println( this.getName() + " hits " + enemy.getName() + " for " + damage + " points of damage!");// Combat log print here: this.name + " hits " + enemy.name + " with " + this.getWeapon.name + 
        enemy.dealDamage(damage); 
    }

    public void dealDamage(int pain)
    {
        currentHealth -= pain;
        if (currentHealth<=0)
        {
            this.die();
            currentHealth=0;
        }
    }

    public void heal(int life)
    {
        currentHealth+=life;
        if (currentHealth > maxHealth)
            currentHealth = maxHealth;
    }

    public int getCurrHealth()
    {
        return currentHealth;
    }

    public void die()
    {
GUI.getPlayer().newKill();
        GUI.println(this.getName() + " has died!");
        this.removeSelfFromGrid();
        GUI.update();
        //play sound (if we get to that point), drop item, removeSelfFromGrid
    }

    public String toSting()
    {
        return name + strength + dexterity + intellect;
    }

    public void equip(StatItem x)
    {
        if (x instanceof Weapon)
            equippedWeapon = (Weapon)x;
        if (x instanceof Armor)
            equippedArmor = (Armor)x;
        if (x instanceof Magic)
            equippedSpell = (Magic)x;

    }

    public int getRange()
    {
        if (equippedWeapon != null)
        {

            return equippedWeapon.getRange();

        }

        return 1;
    }
}