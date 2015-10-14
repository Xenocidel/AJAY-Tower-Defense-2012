import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
public class Game_Over
{
    public static void drawEnd(Graphics g){
        g.drawImage(new ImageIcon("images/YouWin.gif").getImage(), 128, 64, null);
    }

    public static void draw(Graphics g){
        g.drawImage(new ImageIcon("images/GameOver.gif").getImage(), 128, 64, null);
    }

    public static void lose(){//wave cannot be advanced any further
        UI.level=Wave.MAX_WAVES+1;
    }
}