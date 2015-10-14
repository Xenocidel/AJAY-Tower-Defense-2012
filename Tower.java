import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public abstract class Tower{ //create multiple bullets to improve range
    public Integer cost = 0;
    public String name=null;
    public Integer damage;
    public Integer range;
    public Image image = null;
    public Bullet b;
    public int myX;
    public int myY;
    public Minion myMostHatedEnemy;
    public ArrayList<Minion> myMostHatedEnemies;
    public Tower(int x, int y){//set x and y coordinates for this tower
        damage = 1;
        myX=x;
        myY=y;
        b = new Bullet(damage, new ImageIcon("images/Bullet.png").getImage());
    }

    public void radiate()//for radiation tower only
    {
        for (Minion m : myMostHatedEnemies)
        {
            m.health -= b.dmg;
        }
    }

    public String getName()
    {
        return name;
    }

    public Tower(){
    }

    public void draw(Graphics g, Tower t){//tower param for calling the image
        g.drawImage(t.image, myX, myY, 32, 32,null);
    }

    public void draw(Graphics g, int x, int y, Tower t){
        g.drawImage(t.image, x, y, 32, 32, null);
    }

    public int getY()
    {
        return myY;
    }

    public int getRange()
    {
        return range;
    }

    public Bullet getBullet()
    {
        return b;
    }

    public void setTrajectory()//slope and coordinates for the bullet trajectory
    {
        b.setX(myX);
        b.setY(myY);
        b.setEndX(myMostHatedEnemy.getX());
        b.setEndY(myMostHatedEnemy.getY());
        b.setMySlope();
    }

    public void fire()//move and detect
    {
        b.move();
        b.hitDetection();
    }

    public void reset()//resets targeting system
    {
        b.i = new ImageIcon(this.getClass().getResource("images/Bullet.png")).getImage();
        b.resetHit();
        myMostHatedEnemy = null;
    }

    public void detectMinions()
    {
        for (Minion m: Screen.myWave.getMyMinions())
        {
            if ((Math.abs(myX - m.getX()) <= range) && (Math.abs(myY - m.getY()) <= range)){
                myMostHatedEnemy = m;
                return;//only get 1 minion
            }
        }
    }

    public void eraseBullet()
    {
        b.i = null;
    }

    public Minion getTheEnemy()
    {
        return myMostHatedEnemy;
    }

    public void peace()
    {
        myMostHatedEnemy = null;
    }

    public int getX()
    {
        return myX;
    }

    public void setX(int x)
    {
        myX = x;
    }

    public void setY(int y)
    {
        myY = y;
    }
}