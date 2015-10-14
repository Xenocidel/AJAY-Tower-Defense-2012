import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Automaton_3000 extends Tower{//shoots large fireballs that pierce through all enemies that touch it
    public static int price;
    public Automaton_3000(int x, int y){
        super(x,y);
        damage = 1;
        price=cost;
        cost=175;
        name="Automaton 3000";
        range=128;
        image=new ImageIcon(this.getClass().getResource("images/AUTOMATON_3000.png")).getImage();
        b=new BurningBullet(damage, new ImageIcon(this.getClass().getResource("images/Bullet3.png")).getImage());
    }

    public void reset()
    {
        b.i = new ImageIcon(this.getClass().getResource("images/Bullet3.png")).getImage();
        b.resetHit();
        peace();
    }

    public Automaton_3000(){
        cost=175;
        name="Automaton 3000";
        price=cost;
        damage=1;
        range=128;
        image=new ImageIcon(this.getClass().getResource("images/AUTOMATON_3000.png")).getImage();
    }
}