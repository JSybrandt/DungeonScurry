package info.gridworld.grid;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.gui.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.geom.*;

public class Door extends Actor implements Stepable
{
    private Player p;
    public int doorplacement;
    private String s;
    private WorldMap world;
    private int x,y;
    public Door(int i, Player b)
    {
        doorplacement=i;
        p = b;
        //x=a;
        //y=c;
    }

    public void stepedOn()
    {
      //  GUI.println("stepped on " + doorplacement);
        if(doorplacement==1)
        {
            GUI.getPlayer().removeSelfFromGrid();
            WorldMap.moveUp();

        }


        if(doorplacement==4)
        {
            GUI.getPlayer().removeSelfFromGrid();
            WorldMap.moveLeft();
        }

        if(doorplacement==3)
        {
            GUI.getPlayer().removeSelfFromGrid();
            WorldMap.moveDown();
        }

        if(doorplacement==2)
        {
            GUI.getPlayer().removeSelfFromGrid();
            WorldMap.moveRight();
        }
    }

}

