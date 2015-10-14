import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
public class BlackBullet extends Bullet //pierces enemies
{
    public BlackBullet(int d, Image img)
    {
        super(d,img);
    }

    public void draw(Graphics g)
    {
        g.drawImage(i, myX, myY, 20, 20, null);
    }

    public void hitDetection()//piercing small hitbox
    {
        for (Minion m: Screen.myWave.getMyMinions())
        {
            if (!(m.invurnability))
            {
                if (Math.abs(getX() - m.getX()) < 4 && Math.abs(getY() - m.getY()) < 4)
                {
                    m.health -= dmg;
                    //absense of haveYouHit variable means bullet will not disappear upon hitting a monster
                }
            }
        }
    }
}