import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Blue extends Minion{
    public Blue(ImageIcon i){
        super(i);
        health=50;
        myName = "Bluey";
        value=5;
    }

    public Blue(){
        myImage= new ImageIcon(this.getClass().getResource("images/MINIONBLUEFRONT.gif")).getImage();
        health=50;
        myName = "Bluey";
        value=5;
    }
}