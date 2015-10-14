import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Yellow extends Minion{
    public Yellow(ImageIcon i){
        super(i);
        myName = "Yellowy";
        health=8;
        value=3;
    }

    public Yellow(){
        myImage= new ImageIcon(this.getClass().getResource("images/MINIONYELLOWFRONT.gif")).getImage();
        health=8;
        myName = "Yellowy";
        value=3;
    }
}