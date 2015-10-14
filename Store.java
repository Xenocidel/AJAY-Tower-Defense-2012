import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
public class Store
{
    public static int shopWidth = 6; 
    public static int buttonSize = 64;
    public static int cellSpace = 10;
    public static Rectangle[] button = new Rectangle[shopWidth];
    public Tower[] towers = new Tower[5];//towers
    public Store()
    {
        define();
    }

    public void define()
    {
        for(int i=0; i<button.length; i++)
        {
            button[i] = new Rectangle(850, (Screen.myHeight/2-170)-((shopWidth*(buttonSize+cellSpace))/2) + ((buttonSize+cellSpace)*i)+32, buttonSize, buttonSize);
        }
        towers[0]=new Automaton_1000();
        towers[1]=new Automaton_2000();
        towers[2]=new Automaton_3000();
        towers[3]=new RadiationTower();
        towers[4]=new EnergyTower();
    }

    public void draw(Graphics g)
    {
        if (Screen.myWave.haveYouSlainThemAll()&&UI.level<30){g.drawImage(new ImageIcon("images/UI.png").getImage(), button[0].x-17, 480, null);}
        else{g.drawImage(new ImageIcon(this.getClass().getResource("images/UI2.png")).getImage(), button[0].x-17, 480, null);}
        for(int x=0; x<towers.length; x++){
            g.drawImage(new ImageIcon(this.getClass().getResource("images/GOLD.png")).getImage(), button[x].x+69, button[x].y+14, 25,25, null);
            g.drawImage(new ImageIcon(this.getClass().getResource("images/ATTACK.png")).getImage(), button[x].x+69, button[x].y+39, 25,25, null);
        }
        for (int x=0; x<towers.length; x++){
            g.drawImage(new ImageIcon(towers[x].image).getImage(), button[x].x, button[x].y, 64, 64, null);
            g.drawString(towers[x].name, button[x].x+69, button[x].y+10);
            g.drawString(towers[x].cost.toString(), button[x].x+99, button[x].y+30);
            g.drawString(towers[x].damage.toString(), button[x].x+99, button[x].y+56);
        }
        g.drawString("(standard)",button[0].x+110,button[0].y+56);
        g.drawString("(high",button[4].x+115,button[4].y+56);
        g.drawString("damage)",button[4].x+110,button[4].y+70);
        g.drawString("(pierces",button[1].x+110,button[1].y+56);
        g.drawString("enemies)",button[1].x+110,button[1].y+70);
        g.drawString("(damage",button[2].x+110,button[2].y+56);
        g.drawString("over time)",button[2].x+110,button[2].y+70);
        g.drawString("(massive",button[3].x+110,button[3].y+56);
        g.drawString("AOE)",button[3].x+110,button[3].y+70);
        g.drawImage(new ImageIcon("images/AuraSphere.gif").getImage(), 410, 720, 16, 16, null); //testing
        g.drawImage(new ImageIcon("images/Bullet3.png").getImage(), 440, 720, 16, 16, null); //testing
        g.drawImage(new ImageIcon("images/GOLD.png").getImage(), button[5].x+69, button[5].y+14, 25, 25, null);
        g.drawImage(new ImageIcon("images/HEART.png").getImage(), button[5].x+69, button[5].y+39, 25, 25, null);
        g.drawImage(new ImageIcon("images/HEARTBUTTON.png").getImage(), button[5].x, button[5].y, 64, 64, null); 
        g.drawImage(new ImageIcon("images/TRASH.png").getImage(), 864, 672, 64, 64, null);
        if (Frame.soundtoggle){
            g.drawImage(new ImageIcon(this.getClass().getResource("images/sound.png")).getImage(), 933, 672, 64, 64, null);
        }
        else{
            g.drawImage(new ImageIcon(this.getClass().getResource("images/soundoff.png")).getImage(), 933,672,64,64,null);
        }
        g.drawString("Life Boost", button[5].x+69, button[5].y+10);
        g.drawString("10", button[5].x+99, button[5].y+30);
        g.drawString("+2", button[5].x+99, button[5].y+56);
        g.drawString(UI.gold.toString(), button[5].x+69, button[5].y+123);
        if (UI.life<=0){g.drawString("0", button[5].x+53, button[5].y+163);}
        else{
            g.drawString(UI.life.toString(), button[5].x+53, button[5].y+163);
        }
        if (UI.level==31){g.drawString("YOU LOSE", button[5].x+78, button[5].y+201);}
        else{
            g.drawString(UI.level.toString()+" / "+Wave.MAX_WAVES, button[5].x+78, button[5].y+201);}
    }
}