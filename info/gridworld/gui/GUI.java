

package info.gridworld.gui;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import info.gridworld.world.World;
import java.util.ResourceBundle;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI
{

    class ButtonListener implements ActionListener {
        ButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            if(player.getGrid() != null && getPlayer().checkLife())
            {
                if (e.getActionCommand().equals("Weapon")) {  
                    if(player.getWeapon() != null)
                    {
                        println(player.getWeapon().getName() + " Level:" + player.getWeapon().getEffect() );
                        player.setWeaponActive(true);
                    }
                    else

                        println(player.getName() + " will attack with their fists.");
                }
                if (e.getActionCommand().equals("Armor")) {
                    if(player.getArmor() != null)
                        println(player.getArmor().getName() + " Level:" + player.getArmor().getEffect());
                    else
                        println("Unequipped");
                }
                if (e.getActionCommand().equals("Magic")) {
                    println("THERE IS NO MAGIC MORTAL!");
                }

                if (e.getActionCommand().equals("^")) {
                    player.moveUp();
                    worldFrame.getWorld().step();
                    update();
                }
                if (e.getActionCommand().equals("V")) {
                    player.moveDown();
                    worldFrame.getWorld().step();
                    update();
                }
                if (e.getActionCommand().equals("<")) {
                    player.moveLeft();
                    worldFrame.getWorld().step();
                    update();
                }
                if (e.getActionCommand().equals(">")) {
                    player.moveRight();
                    worldFrame.getWorld().step();
                    update();
                }
                if (e.getActionCommand().equals("Inv"))
                {
                    println("This never made it in, click items to equip or eat them.");
                }
                if (e.getActionCommand().equals("Character"))
                {
                    println(player.getName() + "\nHas Strength: " + player.getStr() + "\nHas Dexterity: " + player.getDex() );
                }
            }
        }
    }

       
       
    protected static JFrame frame = new JFrame();
    protected  JButton weapon, armor, magic,inv,chaDetails;
    protected static Container pane=frame.getContentPane();
    protected static Container bar = new Container();
    protected static Container gridBox = new Container();
    protected static JLabel hp = new JLabel("HP:");
    //protected JLabel xp = new JLabel("XP:");
    //protected JProgressBar xpBar = new JProgressBar(0,150);	
    protected static JProgressBar healthBar = new JProgressBar(0,25);
    protected static BoundedGrid room = new BoundedGrid(20,20);
    protected static World map = new World(room);
    protected static WorldFrame<Actor> worldFrame = new WorldFrame<Actor>(map);
    // protected GridPanel map = new GridPanel(new DisplayMap());
    protected static Player player;
    public GUI(Player p)
    {
        player = p;
    }

    public  void  displayGUI()
    {

        map.setGrid(new BoundedGrid(20,20));
        frame.setTitle("Dungeon Scurry");
        frame.setSize(525,625);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        bar.setLayout(new FlowLayout(FlowLayout.TRAILING));

        pane.add(hp);
        healthBar.setForeground(Color.RED);
        healthBar.setStringPainted(true);
        pane.add(healthBar);
        //pane.add(xp);
        //pane.add(xpBar);
        weapon = new JButton("Weapon");
        weapon.addActionListener(new ButtonListener());
        weapon.setMnemonic(KeyEvent.VK_W);
        armor = new JButton("Armor");
        armor.addActionListener(new ButtonListener());
        armor.setMnemonic(KeyEvent.VK_A);
        //  magic = new JButton("Magic");
        //   magic.addActionListener(new ButtonListener());
        //  inv =  new JButton("Inv");
        //    inv.addActionListener(new ButtonListener());
        chaDetails =  new JButton("Character");
        chaDetails.addActionListener(new ButtonListener());
        chaDetails.setMnemonic(KeyEvent.VK_C);

        bar.add(weapon);
        bar.add(armor);
        //   bar.add(magic);
        //  bar.add(inv);
        bar.add(chaDetails);
        pane.add(bar);

        frame.setVisible(true);
        makeDPad();
        bar.add(dPad);
        makeTextArea();
        pane.add(worldFrame.getGridPanel());

    }


      
    protected  Container dPad = new Container();
    protected  JButton up = new JButton("^"), down = new JButton("V"), left = new JButton("<"), right  = new JButton(">");

    protected void makeDPad()
    {
        up.addActionListener(new ButtonListener());
        up.setMnemonic(KeyEvent.VK_UP);
        down.addActionListener(new ButtonListener());
        down.setMnemonic(KeyEvent.VK_DOWN);
        left.addActionListener(new ButtonListener());
        left.setMnemonic(KeyEvent.VK_LEFT);
        right.addActionListener(new ButtonListener());
        right.setMnemonic(KeyEvent.VK_RIGHT);

        dPad.setLayout(new GridLayout(2,3));
        dPad.add(new JButton(""));
        dPad.add(up);   
        dPad.add(new JButton(""));
        dPad.add(left);
        dPad.add(down);
        dPad.add(right);
        //dPad.setSize(150,100);
        // dPad.setResizable(false);
        //dPad.setVisible(true);
    }

    protected static JFrame textFrame = new JFrame();
    protected static JTextArea textArea = new JTextArea();
    protected static JScrollPane scrollPane = new JScrollPane(textArea);
    protected void makeTextArea()
    {
        textFrame.setSize(500,400);
        textFrame.add(scrollPane);
        textFrame.setVisible(true);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        scrollPane.setWheelScrollingEnabled(true);
    }

    public static void print(String r)
    {
        textArea.append(r);
        update();
    }

    public static void println(String r)
    {
        textArea.append("\n"+ r);
        update();
    }

    public static void setGrid(Grid<Actor> n)
    {
        //pane.remove(worldFrame.getGridPanel());
        pane.remove(worldFrame.getGridPanel());
        worldFrame = new WorldFrame<Actor>(new World(n));
        GridPanel g = worldFrame.getGridPanel();
        g.setSize(new Dimension(400,400));
        pane.add(g);

    }
    public void setHealthBar(int hp)
    {
        healthBar.setValue(hp);
    }

    public static Player getPlayer()
    {
        return player;
    }

    public static void update()
    {  worldFrame.repaint();
        healthBar.setValue(player.getCurrHealth());
        healthBar.setMaximum(player.getMaxHealth());
        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue( vertical.getMaximum() + 1 );
        textArea.selectAll();
    }

    protected static JFrame invFrame = new JFrame();
    protected static  World invWorld;
    protected static WorldFrame<Actor> invWorldFrame;

    public static World getWorld()
    {
        return worldFrame.getWorld();
    }

    public static Grid getGrid()
    {
        return map.getGrid();
    }

    public void showInv()
    {
        invFrame.setSize(303,525);
        invWorld = new World(player.getInv());
        invWorldFrame = new WorldFrame<Actor>(invWorld);
        invFrame.add(invWorldFrame.getGridPanel());
        invFrame.setVisible(true);

    }
}