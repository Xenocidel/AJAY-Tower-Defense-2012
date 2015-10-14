import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Orange extends Minion{
    public Orange(ImageIcon i){
        super(i);
        health=2;
        myName = "Orangy";
        value=2;
    }

    public Orange(){
        myImage= new ImageIcon(this.getClass().getResource("images/MINIONORANGEFRONT.gif")).getImage();
        health=2;
        myName = "Orangy";
        value=2;
    }
}