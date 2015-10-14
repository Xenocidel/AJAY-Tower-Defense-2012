import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
public class Bullet //minions hit by this lose life
{
    public Image i;//different images of bullet for each tower
    public int myX, myY;
    public int endX, endY;
    public double mySlope;//geometry was used in this project
    public int dir;// direction to shoot
    public boolean init;
    public double dmg;
    public double speed;
    public boolean haveYouHit;
    public Bullet(double d, Image img)
    {
        speed = 2;
        i=img;
        dmg = d;
        init = true;
        haveYouHit = false;
    }
    public Bullet(){}
    
    public void setMySlope()
    {
        mySlope = (Math.abs(myY - endY)/Math.abs(myX-endX));//geometry wasn't a waste of time after all
    }
    
    public int getX()
    {
        return myX;
    }
    
    public int getY()
    {
        return myY;
    }
    
    public void setX(int x)
    {
        myX = x;
    }
    
    public void setY(int y)
    {
        myY = y;
    }
    
    public void move()
    {
        if (init && myX > endX && myY < endY + 10)//bottom left
        {
            dir = 0;
            init = !init;
        }
        if (init && myX < endX && myY < endY + 10)//bottom right
        {
            dir = 1;
            init = !init;
        }
        if (init && myX < endX && myY > endY + 10)//upper right
        {
            dir = 2;
            init = !init;
        }
        if (init && myX > endX && myY > endY + 10)//upper left
        {
            dir = 3;
            init = !init;
        }
        if (dir == 0)//moves in staircase manner too subtle to distinguish from a normal line
        {
            myY += mySlope * speed;
            myX -= speed;
        }
        if (dir == 1)
        {
            myY += mySlope * speed;
            myX += speed;
        }
        if (dir == 2)
        {
            myY -= mySlope * speed;
            myX += speed;
        }
        if (dir == 3)
        {
            myY -= mySlope * speed;
            myX -= speed;
        }
    }
    
    public void resetHit()
    {
        haveYouHit = false;
        init = true;
    }
    
    public void setEndX(int x)
    {
        endX = x;
    }
    
    public void setEndY(int y)
    {
        endY = y;
    }
    
    public void hitDetection()//registers as a hit when 16 pixels away from a minion
    {
        for (Minion m: Screen.myWave.getMyMinions())
        {
            if (!haveYouHit&&Math.abs(myX - m.getX()) < 16 && Math.abs(myY - m.getY()) < 16)
            {
                    m.health -= dmg;
                    i = null;
                    haveYouHit = true;
            }
        }
    }
    public void draw(Graphics g)
    {
        g.drawImage(i, myX, myY, 15, 15, null);
    }
}