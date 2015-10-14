import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Automaton_2000 extends Tower{ 
    //does lots of damage but doesn't kill
    //pierces enemies and delivers a bit of damage
    public static int price;
    public Automaton_2000(int x, int y){
        super(x,y);
        damage = 3;
        cost=80;
        name="Automaton 2000";
        range=96;
        price=cost;
        image=new ImageIcon(this.getClass().getResource("images/AUTOMATON_2000.png")).getImage();
        b=new BlackBullet(damage, new ImageIcon(this.getClass().getResource("images/BlackBullet.png")).getImage());
    }

    public void reset()
    {
        b.i = new ImageIcon(this.getClass().getResource("images/BlackBullet.png")).getImage();
        b.resetHit();
        peace();
    }

    public Automaton_2000(){
        cost=80;
        name="Automaton 2000";
        price=cost;
        damage=3;
        range=96;
        image=new ImageIcon(this.getClass().getResource("images/AUTOMATON_2000.png")).getImage();
    }
}