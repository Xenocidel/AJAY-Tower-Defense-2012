import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class RadiationTower extends Tower{ //very effective in certain positions
    //high damage per second
    public static int price;
    public RadiationTower(int x, int y){
        super(x,y);
        cost=275;
        name="Radiation Tower";
        damage=1;
        range=56;
        price=cost;
        myMostHatedEnemies = new ArrayList<Minion>();
        image=new ImageIcon(this.getClass().getResource("images/Radiation_Tower.png")).getImage();
        b=new Radiation(damage,x, y);
    }

    public void eraseBullet()//radiation tower has nothing to erase
    {
    }

    public void reset()
    {
        peace();
    }

    public void peace()
    {
        myMostHatedEnemies = new ArrayList<Minion>();
    }

    public ArrayList<Minion> getEnemies(){
        return myMostHatedEnemies;
    }

    public void detectMinions()//get all minions in its range
    {
        for (Minion m: Screen.myWave.getMyMinions())
        {
            if ((Math.abs(myX - m.getX()) <= range) && (Math.abs(myY - m.getY()) <= range)){
                myMostHatedEnemies.add(m);
                return;
            }
        }
    }

    public RadiationTower(){
        cost=275;
        name="Radiation Tower";
        price=cost;
        damage=1;
        range=56;
        image=new ImageIcon(this.getClass().getResource("images/Radiation_Tower.png")).getImage();
    }
}