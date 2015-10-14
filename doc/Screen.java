import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class Screen extends JPanel implements Runnable{
    public Thread thread = new Thread(this);
    public static boolean isFirst = true; 
    public static int myWidth, myHeight;
    public static Room room;
    public static Image[] tileset_ground = new Image[100];
    public static Image[] tileset_air = new Image[100];
    public static Save save;
    public static Store store;
    public static Tower to = null;
    public static ArrayList<Tower> tplace = new ArrayList<Tower>();
    public static int xval=0;
    public static int yval=0;
    private Minion mm;
    private Tower tt;
    private Tower x;
    private Tower y;
    private Bullet b;
    private javax.swing.Timer t;
    private javax.swing.Timer a;
    private ArrayList<Minion> theWave;
    private Wave myWave;
    private Minion theMinion;
    private javax.swing.Timer[] timers;
    public Screen(){
        myWave = new Wave();
        tt = new RadiationTower(500,600);
        y = new RadiationTower(1000,600);
        x = new Automaton_1000(600,500);
        theMinion = new Red(new ImageIcon("MINIONPURPLEFRONT.gif"));
        theWave = myWave.getWave();
        mm = new Minion(new ImageIcon("MINIONFRONT.gif"));
        //b = new Bullet(mm, tt);
        t = new javax.swing.Timer(10, new Listener());//adjust speed by changing the int parameter
        t.start(); //by altering when you call this method you can choose the start of the minion pathing!
        //t.stop(); how to stop the javax.swing.Timer
//         a = new javax.swing.Timer(10, new BulletListener());
//         a.start();
        thread.start();
    }
//     public void createTimers()
//     {
//         timers = new javax.swing.Timer[Wave.numMinions];
//         javax.swing.Timer temp = new javax.swing.Timer(0, new Listener());
//         for (int x = 0; x < Wave.numMinions; x++)
//         {
//             timers[x] = temp;
//             timers[x].setDelay(multiplier*10);
//             timers[x].start();
//             multiplier++;
//         }
//         multiplier = 0;
//     }
    public void define()
    {
        room = new Room();
        save = new Save();
        store = new Store();
        for(int i=0; i<tileset_ground.length; i++){
            tileset_ground[i] = new ImageIcon("tileset_ground.png").getImage();
            tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0, 32*i, 32, 32)));
        }
        for(int i=0; i<tileset_air.length; i++){
            tileset_air[i] = new ImageIcon("tileset_air.png").getImage();
            tileset_air[i] = createImage(new FilteredImageSource(tileset_air[i].getSource(), new CropImageFilter(0, 32*i, 32, 32)));
        }
        save.loadSave(new File("save/mission.ajay"));
    }

    public void paintComponent(Graphics g){//display
        if(isFirst){
            myWidth = getWidth();
            myHeight = getHeight();
            define();
            isFirst = false;
        }
        g.clearRect(0, 0, getWidth(), getHeight());
        room.draw(g); // draw map
        store.draw(g); //draw sidebar
        //b.draw(g);
        theMinion.draw(g);
        if (to!=null){//tower selected movement
            to.draw(g,xval,yval,to);
        }
        for (Tower i:tplace){
            i.draw(g, i);
        }
    }
    public void run(){
        while(true){
            if(!isFirst)
            {
                room.physic();
            }
            repaint();
            try{
                Thread.sleep(1);
            }
            catch (Exception e){
            }
        }
    }
    
    private class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            theMinion.move();
        }
    }
//     private class BulletListener implements ActionListener
//     {
//         public void actionPerformed(ActionEvent e)
//         {
//             b.move();
//         }
//     }
}