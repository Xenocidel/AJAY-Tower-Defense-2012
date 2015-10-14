import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EnergyTower extends Tower{ //armor piercing long range 
    //turret that does heavy damage to single targets.
    public static int price;
    public EnergyTower(int x, int y){
        myX=x;
        damage = 20;
        myY=y;
        b=new Bullet(damage, new ImageIcon(this.getClass().getResource("images/AuraSphere.gif")).getImage());
        cost=350;
        price=cost;
        name="Energy Tower";
        range=144;
        image=new ImageIcon(this.getClass().getResource("images/Turret5Screen.png")).getImage();
    }

    public void reset()
    {
        b.i = new ImageIcon(this.getClass().getResource("images/AuraSphere.gif")).getImage();
        b.resetHit();
        peace();
    }

    public EnergyTower(){
        cost=350;
        price=cost;
        name="Energy Tower";
        damage=20;
        range=144;
        image=new ImageIcon(this.getClass().getResource("images/Turret5Screen.png")).getImage();
    }
}