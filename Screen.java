import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class Screen extends JPanel implements Runnable{
    //runner
    public Thread thread = new Thread(this);
    public static boolean isFirst = true; 
    public static int myWidth, myHeight;
    public static Room room;
    public static Image[] tileset_ground = new Image[2];
    public static Image[] tileset_air = new Image[2];
    public static Save save;
    public static Store store;
    public static Tower to = null;
    public static ArrayList<Tower> tplace = new ArrayList<Tower>();
    public static int xval=0;
    public static int yval=0;
    public static javax.swing.Timer t;
    private javax.swing.Timer a;
    private javax.swing.Timer j;
    public static Wave myWave;
    public static int selection;
    public static Menu menu;
    public Screen(){
        myWave = new Wave();
        menu= new Menu();
        selection=-1;
        t = new javax.swing.Timer(270, new WaveListener());//270 is just a placeholder, this number is set during the difficulty select
        t.start();
        j = new javax.swing.Timer(400, new DelayListener());//for school computers so range isn't Sh**
        j.start();
        a = new javax.swing.Timer(1, new ShooterListener()); //0 makes bullet invisable... (erases bullet instantaneously)
        a.start();
        thread.start();
    }   

    public void define()//loads the game
    {
        room = new Room();
        save = new Save();
        store = new Store();
        for(int i=0; i<tileset_ground.length; i++){
            tileset_ground[i] = new ImageIcon(this.getClass().getResource("images/tileset_ground.png")).getImage();
            tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0, 32*i, 32, 32)));
        }
        for(int i=0; i<tileset_air.length; i++){
            tileset_air[i] = new ImageIcon(this.getClass().getResource("images/tileset_air.png")).getImage();
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
        if (selection<=0||selection==2){//redirects to Menu class to draw the menu
            menu.draw(g);
        }
        if (selection==1){//main game
            room.draw(g); // draw map
            store.draw(g); //draw sidebar
            for (Minion m: myWave.getMyMinions())
            {
                m.death();
                m.draw(g);
            }
            if (to!=null){//tower follow mouse
                to.draw(g,xval,yval,to);
            }
            for (Tower i:tplace){
                i.draw(g, i);
                i.getBullet().draw(g);
            }
            if (UI.life<=0){
                Game_Over.draw(g);
                Game_Over.lose();
            }
            if (UI.level==Wave.MAX_WAVES && myWave.haveYouSlainThemAll()){
                Game_Over.drawEnd(g);
            }
        }
    }

    public void run(){//gameloop
        while(true){
            if(!isFirst){}
            repaint();
            try{
                Thread.sleep(1);
            }
            catch (Exception e){
            }
        }
    }
    private class WaveListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (myWave.isNewWave())
            {
                myWave.getWave();
                myWave.resetCounter();
            }
            if (myWave.getMyMinions().size() != 0)
            {
                myWave.minionsMove();
                myWave.launchAssault();
            }
        }
    }
    private class ShooterListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            for (Tower t: tplace)
            {
                if (t.getName() == "Radiation Tower")
                {
                    t.radiate();
                }
                else
                {
                    if(t.getTheEnemy() != null)
                    {
                        t.fire();
                    }
                    else
                    {
                        t.eraseBullet();//erase ghost bullets
                    }
                }
                if (t.getName() == "Automaton 1000")
                {
                    j.setDelay(275);
                    if(t.getTheEnemy() != null)
                    {
                        t.fire();
                    }
                    else
                    {
                        t.eraseBullet();//erase ghost bullets
                    }
                }
                if (t.getName() == "Automaton 2000")
                {
                    j.setDelay(315);
                    if(t.getTheEnemy() != null)
                    {
                        t.fire();
                    }
                    else
                    {
                        t.eraseBullet();//erase ghost bullets
                    }
                }
                if (t.getName() == "Automaton 3000")
                {
                    j.setDelay(330);
                    t.getBullet().speed = 0.5;
                    if(t.getTheEnemy() != null)
                    {
                        t.fire();
                    }
                    else
                    {
                        t.eraseBullet();//erase ghost bullets
                    }
                }
                if (t.getName() == "Energy Tower")
                {
                    j.setDelay(350);
                    if(t.getTheEnemy() != null)
                    {
                        t.fire();
                    }
                    else
                    {
                        t.eraseBullet();//erase ghost bullets
                    }
                }
            }
        }
    } 
    private class DelayListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            for (Tower t: tplace)
            {
                t.reset();
                t.detectMinions();
                if (t.getTheEnemy() != null)
                {
                    t.setTrajectory();
                }
                else{
                    t.eraseBullet();
                }
            }
        }
    }
}