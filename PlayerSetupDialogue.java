import javax.swing.*;
import java.awt.event.*;
 
/**
 * Write a description of class PlayerSetupDialogue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerSetupDialogue
{
   public String getName()
    {

        JFrame frame = new JFrame("WHAT IS YOUR NAME");
        String r =  JOptionPane.showInputDialog(null, "Challenger, what is your name?! ", 
                "", 1);
        return r;
    }

    public String getPlayerClass()
    {   JFrame frame = new JFrame("WHAT IS YOUR CLASS");
        String r =  JOptionPane.showInputDialog(null, "Challenger, what is your Class (F/R/M)?! ", 
                "", 1);
        return r;
    }
}
