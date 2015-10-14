/*
Project Title: AJAY Tower Defense
Authors: Aaron Liao, Jeffrey Wang, Alex Wang, Yunjun Kim
Readme.txt for more information
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//imports Listeners
public class Frame extends JFrame {
    public static String title = "AJAY Tower Defense";//window title
    public static Dimension size = new Dimension(1024,768);
    private JPanel mousepanel;
    public Frame(){
        setTitle(title);
        setSize(size);
        setResizable(false);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }
    public static void main(String args[]){
        Frame frame = new Frame();
    }
    public void init(){
        setLayout(new GridLayout(1,1,0,0));
        Screen screen = new Screen();
        add(screen);
        setVisible(true);
        mousepanel = screen;
        HandlerClass handler = new HandlerClass();
        //start mouse and key inputs
        mousepanel.addMouseListener(handler);
        mousepanel.addMouseMotionListener(handler);
    }
    public class HandlerClass implements MouseListener, MouseMotionListener{
        private Tower tower = null;
        
        //MouseListener classes
        public void mouseClicked(MouseEvent e){
        }
        public void mousePressed(MouseEvent e){
            if (tower!=null){
                if ((e.getX()>=864&&e.getX()<=924)&&(e.getY()>=672&&e.getY()<=736)){
                    Screen.to=null;
                    tower=null;
                }
            }
            if ((e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[0].y&&e.getY()<=Store.button[0].y+64)&&UI.gold>=30){
                tower=new Automaton_1000(e.getX(), e.getY());
                Screen.to=tower;
            }
            if ((e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[1].y&&e.getY()<=Store.button[1].y+64)&&UI.gold>=45){
                tower=new Automaton_2000(e.getX(), e.getY());
                Screen.to=tower;
            }
            if ((e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[2].y&&e.getY()<=Store.button[2].y+64)&&UI.gold>=60){
                tower=new Automaton_3000(e.getX(), e.getY());
                Screen.to=tower;
            }
            if ((e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[3].y&&e.getY()<=Store.button[3].y+64)&&UI.gold>=65){
                tower=new RadiationTower(e.getX(), e.getY());
                Screen.to=tower;
            }
            if ((e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[4].y&&e.getY()<=Store.button[4].y+64)&&UI.gold>=80){
                tower=new Unknown(e.getX(), e.getY());
                Screen.to=tower;
            }
            if ((e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[5].y&&e.getY()<=Store.button[5].y+64)&&(UI.gold>=10)){
                UI.life++;
                UI.gold-=10;
            }
            if ((e.getX()>=844&&e.getX()<=1015)&&(e.getY()>=609&&e.getY()<=666)&&Wave.numMinions==0&&UI.level<Wave.MAX_WAVES){
                UI.level++;
            }
        }
        public void mouseReleased(MouseEvent e)
        {
            if (tower!=null)
            {
                if (e.getX()>=832){}
                 else if (Room.block[e.getY()/32][e.getX()/32].groundID==0&&e.getY()<=735)
                 {
                      UI.gold-=tower.cost;
                      tower.setX(Screen.xval);
                      tower.setY(Screen.yval);
                      Screen.tplace.add(tower);
                      Screen.to=null;
                      tower=null;
                 }
                }
            }
        
        public void mouseEntered(MouseEvent e){
        }
        public void mouseExited(MouseEvent e){
            //pause game
        }
        //MouseMotionListener classes
        public void mouseDragged(MouseEvent e){
            if (Screen.to!=null){
                Screen.xval=((int)(e.getX()/32 + 0.5))*32;
                Screen.yval=((int)(e.getY()/32 + 0.5))*32;
            }
        }
        public void mouseMoved(MouseEvent e){
            if (Screen.to!=null){
                Screen.xval=((int)(e.getX()/32 + 0.5))*32;
                Screen.yval=((int)(e.getY()/32 + 0.5))*32;
            }
        }
    }
}
