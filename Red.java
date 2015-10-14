import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Red extends Minion{
    public Red(ImageIcon i){
        super(i);
        myName = "Redy";
        health=1;
        value=1;
    }

    public Red(){
        myImage= new ImageIcon(this.getClass().getResource("images/MINIONREDFRONT.gif")).getImage();
        myName = "Redy";
        health=1;
        value=1;
    }
}