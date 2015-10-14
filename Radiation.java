import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
public class Radiation extends Bullet //area of effect damage when minions around tower
{
    public Radiation(double d, int x, int y)
    {
        myX = x;
        myY = y;
        dmg = d;
        i=new ImageIcon("images/PsiStorm.gif").getImage();
    }
    public void draw(Graphics g)
    {
        g.drawImage(i, myX, myY, 128, 128, null);//radius is 64, therefore double x and y for diameter
    }
    public void hitDetection()//radiation
    {
        for (Minion m: Screen.myWave.getMyMinions())
        {
            if (Math.abs(myX - m.getX()) < 4 && Math.abs(myY - m.getY()) < 4)
            {
                    m.health -= dmg;
            }
        }
    }
}