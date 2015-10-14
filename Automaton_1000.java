import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Automaton_1000 extends Tower{//basic machine gun tower
    public static int price;
    public Automaton_1000(int x, int y){
        super(x,y);
        cost=30;
        price=cost;
        damage = 1;
        name="Automaton 1000";
        range=64;
        image=new ImageIcon(this.getClass().getResource("images/AUTOMATON_1000.png")).getImage();
        b=new Bullet(damage, new ImageIcon(this.getClass().getResource("images/Bullet.png")).getImage());
    }

    public void reset()
    {
        b.i = new ImageIcon(this.getClass().getResource("images/Bullet.png")).getImage();
        b.resetHit();
        peace();
    }

    public Automaton_1000(){
        cost=30;
        name="Automaton 1000";
        price=cost;
        damage=1;
        range=64;
        image=new ImageIcon(this.getClass().getResource("images/AUTOMATON_1000.png")).getImage();
    }
}