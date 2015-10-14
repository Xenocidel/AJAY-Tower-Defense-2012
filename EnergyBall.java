import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
public class EnergyBall extends Bullet //fires powerful shot
{
    public EnergyBall(double d, Image img)
    {
        super(d,img);
    }

    public void draw(Graphics g){
        g.drawImage(i, myX, myY, 26, 26, null);
    }
}