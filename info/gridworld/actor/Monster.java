package info.gridworld.actor;
import info.gridworld.grid.*;
import info.gridworld.gui.*;
import java.util.ArrayList;
/**
 * Parent class from which only the Melee monsters will be derived for now.
 * 
 * @Steve Zelek
 * @5/28/2012
 */
public class Monster extends Being
{

    protected boolean engaged = false;
    protected int aggression = 100;
    protected int special = 0;
    protected int hostileRange = 3;
    protected int retreatCounter;
    protected final int TURN = 90, HALF_TURN = 45;
    protected Location playerLoc; //= GUI.getPlayer().getLocation();

    /**
     * Constructor for objects of class Monster
     */
    public Monster (String name, int s, int d, int i)
    {
        super(name,s,d,i);
    }

    public void act()
    {

        
        if (this.getGrid() == null || !GUI.getPlayer().checkLife())
            return;
        if (currentHealth < maxHealth)
            engaged = true;
        playerLoc = GUI.getPlayer().getLocation();

        String actPref = this.actionDecider();
        if (actPref.equals("advance") || actPref.equals("special"))
            this.advance();

        if (actPref.equals("fight") || actPref.equals("special"))
            this.fight(GUI.getPlayer());

        if (actPref.equals("move"))
            this.move();
        GUI.update();
    }

    private String actionDecider()
    {      
        if (!engaged)
        {
            if (getDistance() <= hostileRange)
            {
                if (checkLOS())
                    engaged = true;
            }
        }

        if (engaged)
        {
            if (getDistance() > this.getRange())
                return ("advance");

            else
            {
                int decider = (int) Math.random()*100 +1;
                if (decider >= 100 - aggression)
                {
                    int decider2 = (int) Math.random() * 100 +1;
                    if (decider2 >= 100 - special)
                        return ("special");
                    else
                        return ("fight");
                }

                else 
                    return ("move");
            }   
        }
        return "boobs";//causes act not to run any meathods 
    }

    public int getDistance()
    {
        playerLoc = GUI.getPlayer().getLocation();
        Location checker = this.getLocation().getAdjacentLocation(this.getLocation().getDirectionToward(playerLoc));
        int count = 1;

        while ( this.getGrid().isValid(checker)&&!(this.getGrid().get(checker) instanceof Player))
        {
            checker = checker.getAdjacentLocation(checker.getDirectionToward(playerLoc));
            count++;
        }

        return count;
    }

    public boolean checkLOS()
    {
        playerLoc = GUI.getPlayer().getLocation();
        Location checker = this.getLocation().getAdjacentLocation(this.getLocation().getDirectionToward(playerLoc));

        while ( this.getGrid().isValid(checker)&&!(this.getGrid().get(checker) instanceof Player))
        {
            /**Wall tile denotation*/
            if (this.getGrid().get(checker) instanceof Wall)
                return false;
            else
                checker = checker.getAdjacentLocation(checker.getDirectionToward(playerLoc));
        }

        return true;       
    }

    public void advance()
    {
        playerLoc = GUI.getPlayer().getLocation();
        int playerDir = this.getLocation().getDirectionToward(playerLoc);
        Location targetLoc;     
        //if direction returned by getDirectionToward to playerDir is a cardinal direction and the move is a 
        //valid one it will be executed.
        if (playerDir % 90 == 0)
        {
            targetLoc = this.getLocation().getAdjacentLocation(playerDir);
            /**wall denotation*/
            if (this.getGrid().isValid(targetLoc) && !(this.getGrid().get(targetLoc) != null)
            && !(this.getGrid().get(targetLoc) instanceof Actor))
                this.moveTo(targetLoc);

            //if it is a cardinal direction, but blocked stay in the same spot.
            else
                this.moveTo(this.getLocation());

        }

        //otherwise, get closest of the 2 cardinal directions the direction is between and try and move in that direction,
        //else move in the other cardinal direction if possible.
        //if neither is closer (eg:the direction is 45, pick one at random)
        else{
            for (int a = 0; a < 4; a++)
            {

                if (playerDir > TURN*a && playerDir < TURN*(a+1))
                {
                    if (playerDir == TURN*(a+1) - HALF_TURN)
                    {
                        int r = (int) Math.random() * 2;
                        if (r == 1)
                        {
                            targetLoc = this.getLocation().getAdjacentLocation(TURN*(a+1));

                            if (this.getGrid().isValid(targetLoc) && !(this.getGrid().get(targetLoc) != null) 
                            && !(this.getGrid().get(targetLoc) instanceof Actor))
                                this.moveTo(targetLoc);

                            else
                                this.moveTo(this.getLocation());
                        }

                        else
                        {
                            targetLoc = this.getLocation().getAdjacentLocation(TURN*a);

                            if (this.getGrid().isValid(targetLoc) && !(this.getGrid().get(targetLoc) != null )
                            && !(this.getGrid().get(targetLoc) instanceof Actor))
                                this.moveTo(targetLoc);

                            else
                                this.moveTo(this.getLocation());
                        }

                    }

                    else
                    {

                        if (playerDir > TURN*(a+1) - HALF_TURN)
                        {
                            targetLoc = this.getLocation().getAdjacentLocation(TURN*(a+1));
                            if (this.getGrid().isValid(targetLoc) && !(this.getGrid().get(targetLoc) != null) 
                            && !(this.getGrid().get(targetLoc) instanceof Actor))
                                this.moveTo(targetLoc);

                            else
                                this.moveTo(this.getLocation());
                        }

                        else
                        {
                            targetLoc = this.getLocation().getAdjacentLocation(TURN*a);
                            if (this.getGrid().isValid(targetLoc) && !(this.getGrid().get(targetLoc) != null) 
                            && !(this.getGrid().get(targetLoc) instanceof Actor))
                                this.moveTo(targetLoc);

                            else
                                this.moveTo(this.getLocation());
                        }
                    }
                }
            }

        }
    }

    public void removeSelfFromGrid()
    {
        //GUI.getPlayer().newKill();
        Location c = location;
        Grid g = grid;
        super.removeSelfFromGrid();
        if(equippedWeapon != null && equippedArmor != null)
            if(Math.random() >0.5)
                equippedWeapon.putSelfInGrid(g,c);
            else
                equippedArmor.putSelfInGrid(g,c);
            else
            {
                if (equippedWeapon != null)
                    equippedWeapon.putSelfInGrid(g,c);
                if (equippedArmor != null)
                    equippedArmor.putSelfInGrid(g,c);
        }
    }

    public void move()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        //look for spaces perpendicular to direction of player (add or subtract 90 degrees or a TURN) if the player is in a cardinal direction, else 45 (HALF_TURN)         
        //check to see if the move is valid, else just revert to an attack.
        playerLoc = GUI.getPlayer().getLocation();
        int playerDir = this.getLocation().getDirectionToward(playerLoc);
        Location targetLoc;

        if (playerDir % 90 == 0)
        {
            targetLoc = this.getLocation().getAdjacentLocation(playerDir - TURN);

            if (this.getGrid().isValid(targetLoc) && !(this.getGrid().get(targetLoc) instanceof Wall) 
            && !(this.getGrid().get(targetLoc) instanceof Actor))
                locs.add(targetLoc);

            targetLoc = this.getLocation().getAdjacentLocation(playerDir + TURN);

            if (this.getGrid().isValid(targetLoc) && !(this.getGrid().get(targetLoc) instanceof Wall)
            && !(this.getGrid().get(targetLoc) instanceof Actor))
                locs.add(targetLoc);

        }

        else
        {

            targetLoc = this.getLocation().getAdjacentLocation(playerDir - HALF_TURN);

            if (this.getGrid().isValid(targetLoc) &&  !(this.getGrid().get(targetLoc) instanceof Wall)
            && !(this.getGrid().get(targetLoc) instanceof Actor))
                locs.add(targetLoc);

            targetLoc = this.getLocation().getAdjacentLocation(playerDir + HALF_TURN);

            if (this.getGrid().isValid(targetLoc) &&  !(this.getGrid().get(targetLoc) instanceof Wall)
            && !(this.getGrid().get(targetLoc) instanceof Actor))
                locs.add(targetLoc);
        }

        if (locs.size() == 0)
            this.fight(GUI.getPlayer());

        else
        {
            if (locs.size() == 1)
                this.moveTo(locs.get(0));

            else
            {
                int r = (int) Math.random() * 2;
                this.moveTo(locs.get(r));
            }
        }

    }

}
