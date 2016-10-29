package info.gridworld.grid;
import info.gridworld.actor.*;


public class Treasure extends Room
{
    
    public Treasure()
    {
        
        
        
       
       SheepClaws a1   =  new  SheepClaws ();
        a1.putSelfInGrid(this,new Location(5 ,5  ));
       Halberd a2  =  new Halberd  ();
        a2.putSelfInGrid(this,new Location( 5,6));
        Scythe a3   =  new  Scythe ();
        a3.putSelfInGrid(this,new Location( 5,7  ));
        Scimitar a4   =  new  Scimitar ();
        a4.putSelfInGrid(this,new Location(5 ,8  ));
        Lightsaber a5   =  new  Lightsaber ();
        a5.putSelfInGrid(this,new Location( 5,9  ));
        Rapier a6   =  new Rapier  ();
        a6.putSelfInGrid(this,new Location(5 ,10  ));
        Spear a7   =  new  Spear ();
        a7.putSelfInGrid(this,new Location( 6,5  ));
       Bow a8   =  new Bow  ();
       a8.putSelfInGrid(this,new Location(6 ,6  ));
        Club a9   =  new  Club ();
        a9.putSelfInGrid(this,new Location( 6,7  ));
         Axe a10   =  new  Axe ();
        a10.putSelfInGrid(this,new Location( 6,8  ));
        Sword a11   =  new  Sword ();
        a11.putSelfInGrid(this,new Location( 6,9  ));
        
       Hammer  a12   =  new Hammer  ();
        a12.putSelfInGrid(this,new Location(6 ,10  ));
       Dagger  a13   =  new  Dagger ();
        a13.putSelfInGrid(this,new Location( 7,5  ));
         Stick a14   =  new Stick  ();
        a14.putSelfInGrid(this,new Location( 7,6  ));
        Cloth  a15   =  new Cloth  ();
        a15.putSelfInGrid(this,new Location( 7,7  ));
        Leather  a16   =  new  Leather ();
        a16.putSelfInGrid(this,new Location( 7,8  ));
        Iron  a17  =  new Iron  ();
        a17.putSelfInGrid(this,new Location( 7,9  ));
        Potion a18   =  new  Potion ();
        a18.putSelfInGrid(this,new Location( 7,10  ));
        

        
        for(int x=8;x<17;x++)
        {
            Wall w = new Wall();
            w.putSelfInGrid(this,new Location(16, x));
        }
        
        for(int x=8;x<17;x++)
        {
            Wall w = new Wall();
            w.putSelfInGrid(this,new Location(12, x));
        }
        
        for(int y=12;y<16;y++)
        {
            Wall w = new Wall();
            w.putSelfInGrid(this,new Location(y, 8));
        }
        
        for(int y=12;y<16;y++)
        {
            Wall w = new Wall();
            w.putSelfInGrid(this,new Location(y, 16));
        }
        
        
        
        
        for(int x=4;x<12;x++)
        {
            Wall w = new Wall();
            w.putSelfInGrid(this,new Location(8,x));
        }
        for(int x=4;x<12;x++)
        {
            Wall w = new Wall();
            w.putSelfInGrid(this,new Location(4,x));
        }
         for(int y=4;y<9;y++)
        {
            Wall w = new Wall();
            w.putSelfInGrid(this,new Location(y,4));
        }
         for(int y=4;y<9;y++)
        {
            Wall w = new Wall();
            w.putSelfInGrid(this,new Location(y,11));
        }
        
    
 Banana x= new Banana();
        x.putSelfInGrid(this,new Location(13,10));
        Sheep s1=new Sheep();
        s1.putSelfInGrid(this,new Location(13,11));
       Oryx s2=new Oryx();
        s2.putSelfInGrid(this,new Location(13,12));
       
OrcT s3=new OrcT();
        s3.putSelfInGrid(this,new Location(13,13));
        
       Hay s4= new Hay();
        s4.putSelfInGrid(this,new Location(13,14));
         Slime s5=new  Slime();
        s5.putSelfInGrid(this,new Location(13,15));
        
       TombStone s6=new  TombStone();
        s6.putSelfInGrid(this,new Location(13,9));
        
       Chest s7= new Chest();
        s7.putSelfInGrid(this,new Location(14,10));
        
        
       Reaper s8= new Reaper();
        s8.putSelfInGrid(this,new Location(14,11));
        
        
       Deveney s9= new Deveney();
        s9.putSelfInGrid(this,new Location(14,12));
        
        
       HPBoost s10= new HPBoost();
        s10.putSelfInGrid(this,new Location(14,13));
        
        
       Ghost s11= new Ghost();
        s11.putSelfInGrid(this,new Location(14,14));
        
        
        
       
MustacheMan s12= new MustacheMan();
        s12.putSelfInGrid(this,new Location(14,15));
        
        
        
       
GustOfWind s13= new GustOfWind();
        s13.putSelfInGrid(this,new Location(14,9));
        
        
       Skeleton s14= new Skeleton();
        s14.putSelfInGrid(this,new Location(15,10));
        
        
        
    }    
        
        
        
        
    
}
