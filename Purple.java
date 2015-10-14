import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Purple extends Minion{
    public Purple(ImageIcon i){
        super(i);
        health=90;
        myName = "Fred";
        value=10;
    }

    public Purple(){
        myImage= new ImageIcon(this.getClass().getResource("images/MINIONPURPLEFRONT.gif")).getImage();
        health=90;
        myName = "Fred";
        value=10;
    }
}