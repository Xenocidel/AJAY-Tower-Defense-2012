import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
public class BurningBullet extends Bullet //pierces enemies, large hitbox
{
    public BurningBullet(int d, Image img)
    {
        super(d,img);
    }

    public void hitDetection()
    //larger hitbox means continuous damage for a longer period of time
    {
        for (Minion m: Screen.myWave.getMyMinions())
        {
            if (!(m.invurnability))
            {
                if (Math.abs(getX() - m.getX()) < 16 && Math.abs(getY() - m.getY()) < 16)
                {
                    m.health -= dmg;
                }
            }
        }
    }

    public void draw(Graphics g)//a fiery drawing
    {
        g.drawImage(i, myX, myY, 40, 40, null);
    }
}