import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
public  class Pathing extends Wave
{
    public Image myImage;
    private int myOldX;
    private int myOldY;
    private int myX;
    private int myY;
    private int complication;
    public static Pathing thePath;
    public Pathing(ImageIcon i)
    {
        complication = 0;
        myX = 35;
        myY = 5;
        myImage = i.getImage();
    }

    public Pathing(){
        complication = 0;
        myX = 35;
        myY = 5;
    }
    //accessors
    public int getX()
    {
        return myX;
    }

    public int getY()
    {
        return myY;
    }
    //modifiers
    public void setX(int x)
    {
        myX += x;
    }

    public void setY(int y)
    {
        myY += y;
    }

    public void move()//pathing, not a flexible mechanism
    {
        if (complication >= 0 && complication < 110)
        {
            setY(2);
            complication++;
        }
        if (complication >= 110 && complication < 142)
        {
            setX(2);
            complication++;

        }
        if (complication >= 142 && complication < 220)
        {
            setY(-2);
            complication++;
        }
        if (complication >= 220 && complication < 267)
        {
            setX(2);
            complication++;
        }
        if (complication >= 267 && complication < 393)
        {
            setY(2);
            complication++;
        }
        if (complication >= 393 && complication < 472)
        {
            setX(-2);
            complication++;
        }
        if (complication >= 472 && complication < 632)
        {
            setY(2);
            complication++;
        }
        if (complication >= 632 && complication < 680)
        {
            setX(2);
            complication++;
        }
        if (complication >= 680 && complication < 790)
        {
            setY(-2);
            complication++;
        }
        if (complication >= 790 && complication < 838)
        {
            setX(2);
            complication++;
        }
        if (complication >= 838 && complication < 950)
        {
            setY(2);
            complication++;
        }
        if (complication >= 950 && complication < 998)
        {
            setX(2);
            complication++;
        }
        if (complication >= 998 && complication < 1158)
        {
            setY(-2);
            complication++;
        }
        if (complication >= 1158 && complication < 1175)
        {
            setX(-2);
            complication++;
        }
        if (complication >= 1175 && complication < 1305)
        {
            setY(-2);
            complication++;
        }
        if (complication >= 1305 && complication < 1354)
        {
            setX(2);
            complication++;
        }
        if (complication >= 1354 && complication < 1433)
        {
            setY(2);
            complication++;
        }
        if (complication >= 1433 && complication < 1481)
        {
            setX(2);
            complication++;
        }
        if (complication >= 1481 && complication < 1560)
        {
            setY(-2);
            complication++;
        }
        if (complication >= 1560 && complication < 1608)
        {
            setX(2);
            complication++;
        }
        if (complication >= 1608 && complication < 1737)
        {
            setY(2);
            complication++;
        }
        if (complication >= 1737 && complication < 1816)
        {
            setX(-2);
            complication++;
        }
        if (complication >= 1816 && complication < 1863)
        {
            setY(2);
            complication++;
        }
        if (complication >= 1863 && complication < 1910)
        {
            setX(2);
            complication++;
        }
        if (complication >= 1910 && complication < 1974)
        {
            setY(2);
            complication++;
        }
        if (complication >= 1974 && complication < 2022)
        {
            setX(-2);
            complication++;
        }
        if (complication >= 2022 && complication < 2071)
        {
            setY(2);
            complication++;
        }
        if (complication >= 2071 && complication < 2167)
        {
            setX(2);
            complication++;
        }
        if (complication >= 2167 && complication < 2262)
        {
            setY(-2);
            complication++;
        }
        if (complication >= 2262 && complication < 2294)
        {
            setX(2);
            complication++;
        }
        if (complication >= 2294 && complication < 2486)
        {
            setY(-2);
            complication++;
        }
        if (complication >= 2486 && complication < 2534)
        {
            setX(2);
            complication++;
        }
        if (complication >= 2534 && complication < 2773)
        {
            setY(2);
            complication++;
        }
        if (complication >= 2773 && complication < 2805)
        {
            setX(-2);
            complication++;
        }
        if (complication >= 2805 && complication < 2853)
        {
            setY(2);
            complication++;
        }
        if (complication >= 2853 && complication < 2885)
        {
            setX(2);
            complication++;
        }
        if (complication >= 2885 && complication < 3000)
        {
            setY(2);
            complication++;
        }
    }

    public void draw(Graphics gr)//draws the monster as it moves
    {
        gr.drawImage(myImage, myX, myY, 25, 25, null);
    }
}