import java.awt.*;
import javax.swing.*;
public class Menu{
    public Menu(){
    }
    public void draw(Graphics g){
        if (Screen.selection==-1){//difficulty
            g.drawImage(new ImageIcon(this.getClass().getResource("images/difficulty.png")).getImage(), 192, 64, null);
        }
        if (Screen.selection==0){//menu
            g.drawImage(new ImageIcon(this.getClass().getResource("images/menu.png")).getImage(), -1, 0, 1024, 747, null);
            g.drawImage(new ImageIcon(this.getClass().getResource("images/start.png")).getImage(), 800,500,200,100, null);
            g.drawImage(new ImageIcon(this.getClass().getResource("images/howtoplay.png")).getImage(), 800,620,200,100, null);
            if (Frame.soundtoggle){
                g.drawImage(new ImageIcon(this.getClass().getResource("images/sound.png")).getImage(), 700, 516, 64, 64, null);
            }
            else{
                g.drawImage(new ImageIcon(this.getClass().getResource("images/soundoff.png")).getImage(), 700,516,64,64,null);
            }
        }
        if (Screen.selection==2){//how to play
            g.drawImage(new ImageIcon(this.getClass().getResource("images/Instructions.png")).getImage(), 0, 0, 1024, 747, null);
            g.drawImage(new ImageIcon(this.getClass().getResource("images/back.png")).getImage(), 800,620,200,100, null);
        }
    }
}