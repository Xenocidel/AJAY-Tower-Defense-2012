import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Minion extends Pathing{
    public int health=0;    
    public int value=0;//damage it deals to you and gold it gives upon killing it
    public String myName;//was used in testing
    public boolean isDead = false;
    public boolean death=true;//true=not dead
    public Minion(ImageIcon i)
    {
        super(i);
    }

    public Minion(){}

    public void death()//moves out of the screen upon death
    {
        if (health <= 0)
        {
            myImage = null;
            setX(-5000);
            setY(-5000);
            isDead = true;
            addGold();
            death=false;
        }
    }

    public void setHealth(int x)
    {
        health = x;
    }

    public void addGold(){
        if (death){
            UI.gold+=value;
        }
    }

    public String getMyName()
    {
        return myName;
    }

    public boolean isMinionDead()
    {
        return isDead;
    }

    public void attack()
    {
        if (getX() > 765 && getY() > 730 && getY() < 747 && !(isDead))
        {
            UI.life-=value;
            isDead = true;
        }
    }
}