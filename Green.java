import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Green extends Minion{
    public Green(ImageIcon i){
        super(i);
        health=45;
        myName = "Greeny";
        value=4;
    }

    public Green(){
        myImage= new ImageIcon(this.getClass().getResource("images/MINIONGREENFRONT.gif")).getImage();
        health=45;
        myName = "Greeny";
        value=4;
    }
}