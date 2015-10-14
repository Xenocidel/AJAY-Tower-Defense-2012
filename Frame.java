/*
Project Title: AJAY Tower Defense
Authors: Aaron Liao, Jeffrey Wang, Alex Wang, Yunjun Kim
Date (ver.1.0 release): June 11 2012
School: Troy High School
 */
import javax.swing.*; //timers
import java.awt.*;//java basic utilities
import java.awt.event.*;//imports Listeners
import java.applet.*;//for sound
import java.net.*;
import java.io.*;
import javax.sound.sampled.*;
public class Frame extends JFrame {
    //driver
    public static String title = "AJAY Tower Defense";//window title
    public static Dimension size = new Dimension(1024,768);//size of window
    public static Clip clip;
    public static URL url; //location of audio file
    public static AudioInputStream audioIn;
    private JPanel mousepanel;//mouse inputs
    public static boolean sound=true;//managing sound
    public static boolean sound2=true;//managing sound
    public static boolean soundtoggle=true;
    public Frame(){
        setTitle(title);
        setSize(size);
        setResizable(false);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }

    public static void main(String args[]){
        Frame frame = new Frame();
    }

    public void init(){//call Screen to draw the frame
        setLayout(new GridLayout(1,1,0,0)); //creates a grid for easy coordinate layout
        Screen screen = new Screen();
        add(screen); //adds Screen to Frame
        setVisible(true);
        mousepanel = screen;//connects the game's JPanel to mousepanel
        HandlerClass handler = new HandlerClass();
        //start mouse and key inputs
        mousepanel.addMouseListener(handler);
        mousepanel.addMouseMotionListener(handler);
    }
    private class HandlerClass implements MouseListener, MouseMotionListener{
        private Tower tower = null;//holds a tower when button is clicked
        //MouseListener classes
        public void mouseClicked(MouseEvent e){}

        public void mousePressed(MouseEvent e){
            /* e is a signal by the mouse
             * e.getX()/e.getY() are the coordinates of the mouse cursor on the screen
             * e.getButton() reads which button the mouse is inputting
             * MouseEvent.BUTTON1 is the signal from the left click of the mouse
             * Screen.selection and "if" structures handles how the program reacts to mouse inputs when
             * the game is in different stages.
             */
            if (Screen.selection==-1){//difficulty option
                if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=274&&e.getX()<=494)&&(e.getY()>=485&&e.getY()<=605)){
                    Screen.t.setDelay(340);//longer delay for slower monster speed
                    Screen.selection=0;
                    setBackground(Color.WHITE);
                }
                if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=525&&e.getX()<=745)&&(e.getY()>=485&&e.getY()<=605)){
                    Screen.t.setDelay(200);//shorter delay for faster monster speed
                    UI.gold = 40;
                    Screen.selection=0;
                    setBackground(Color.WHITE);
                }
            }
            if ((Screen.selection == 0 || Screen.selection == 2)&&e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=810&&e.getX()<=1000)&&(e.getY()>=620&&e.getY()<=720))
            {
                //avoids confliction between the back button and the forward button
                if (Screen.selection == 0) //when on the menu
                {
                    Screen.selection = 2; //chooses info
                }
                else
                {
                    Screen.selection = 0; //chooses menu again
                }
            }
            if (Screen.selection==0){
                if (sound){
                    try {
                        url = this.getClass().getResource("/SomeMusic.wav");
                        audioIn = AudioSystem.getAudioInputStream(url);
                        clip = AudioSystem.getClip();
                        clip.open(audioIn);
                        clip.loop(Clip.LOOP_CONTINUOUSLY);//start music, looping continuously
                    }
                    catch (UnsupportedAudioFileException a) {
                        a.printStackTrace();//brings the user to this source instead of throwing a scary exception in the Terminal Window
                    } catch (IOException a) {
                        a.printStackTrace();
                    } catch (LineUnavailableException a) {
                        a.printStackTrace();
                    }
                    sound=false;//called once
                }
                else if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=700&&e.getX()<=764)&&(e.getY()>=516&&e.getY()<=580)){
                    if (soundtoggle){
                        clip.stop();
                        soundtoggle=false;
                    }
                    else{
                        soundtoggle=true;
                        try {
                            url = this.getClass().getResource("SomeMusic.wav");
                            audioIn = AudioSystem.getAudioInputStream(url);
                            clip = AudioSystem.getClip();
                            clip.open(audioIn);
                            clip.loop(Clip.LOOP_CONTINUOUSLY);//start music, looping continuously
                        }
                        catch (UnsupportedAudioFileException a) {
                            a.printStackTrace();//brings the user to this source instead of throwing a scary exception in the Terminal Window
                        } catch (IOException a) {
                            a.printStackTrace();
                        } catch (LineUnavailableException a) {
                            a.printStackTrace();
                        }
                    }
                }
                else if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=800&&e.getX()<=1000)&&(e.getY()>=500&&e.getY()<=600)){
                    if (sound2){
                        clip.stop();}//stop menu music upon starting the game
                    Screen.selection=1;//game screen
                    soundtoggle=true;
                }
            }
            if (Screen.selection==1){
                if (sound2&&soundtoggle){
                    try {
                        url = this.getClass().getResource("MoreMusic.wav");
                        audioIn = AudioSystem.getAudioInputStream(url);
                        clip = AudioSystem.getClip();
                        clip.open(audioIn);
                        clip.loop(Clip.LOOP_CONTINUOUSLY);//start music, looping continuously
                    }
                    catch (UnsupportedAudioFileException a) {
                        a.printStackTrace();
                    } catch (IOException a) {
                        a.printStackTrace();
                    } catch (LineUnavailableException a) {
                        a.printStackTrace();
                    }
                    sound2=false;
                }
                else if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=933&&e.getX()<=997)&&(e.getY()>=672&&e.getY()<=736)){
                    if (soundtoggle){
                        clip.stop();
                        soundtoggle=false;
                    }
                    else{
                        soundtoggle=true;
                        try {
                            url = this.getClass().getResource("MoreMusic.wav");
                            audioIn = AudioSystem.getAudioInputStream(url);
                            clip = AudioSystem.getClip();
                            clip.open(audioIn);
                            clip.loop(Clip.LOOP_CONTINUOUSLY);//start music, looping continuously
                        }
                        catch (UnsupportedAudioFileException a) {
                            a.printStackTrace();//brings the user to this source instead of throwing a scary exception in the Terminal Window
                        } catch (IOException a) {
                            a.printStackTrace();
                        } catch (LineUnavailableException a) {
                            a.printStackTrace();
                        }
                    }
                }
                if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=400&&e.getX()<=420)&&(e.getY()>=704&&e.getY()<=735))//testing
                {
                    Screen.t.setDelay(3); //testing
                }
                if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=430&&e.getX()<=450)&&(e.getY()>=704&&e.getY()<=735))//testing
                {
                    Screen.t.setDelay(200); //testing
                }
                if (tower!=null){
                    if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=864&&e.getX()<=924)&&(e.getY()>=672&&e.getY()<=736)){
                        Screen.to=null;//trash can
                        tower=null;
                    }
                }
                if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[0].y&&e.getY()<=Store.button[0].y+64)&&UI.gold>=Automaton_1000.price){
                    tower=new Automaton_1000(e.getX(), e.getY());
                    Screen.to=tower;
                }
                if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[1].y&&e.getY()<=Store.button[1].y+64)&&UI.gold>=Automaton_2000.price){
                    tower=new Automaton_2000(e.getX(), e.getY());
                    Screen.to=tower;
                }
                if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[2].y&&e.getY()<=Store.button[2].y+64)&&UI.gold>=Automaton_3000.price){
                    tower=new Automaton_3000(e.getX(), e.getY());
                    Screen.to=tower;
                }
                if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[3].y&&e.getY()<=Store.button[3].y+64)&&UI.gold>=RadiationTower.price){
                    tower=new RadiationTower(e.getX(), e.getY());
                    Screen.to=tower;
                }
                if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[4].y&&e.getY()<=Store.button[4].y+64)&&UI.gold>=EnergyTower.price){
                    tower=new EnergyTower(e.getX(), e.getY());
                    Screen.to=tower;
                }
                if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=850&&e.getX()<=914)&&(e.getY()>=Store.button[5].y&&e.getY()<=Store.button[5].y+64)&&(UI.gold>=10)){
                    UI.life+=2;//life boost
                    UI.gold-=10;
                }
                if (e.getButton()==MouseEvent.BUTTON1&&(e.getX()>=844&&e.getX()<=1015)&&(e.getY()>=609&&e.getY()<=666)&&Screen.myWave.haveYouSlainThemAll()&&UI.level<Wave.MAX_WAVES){
                    Screen.myWave.setCurrWave(Screen.myWave.getCurrWave() + 1);//next wave
                    Screen.myWave.setClicked(true);
                    UI.level++;
                }
            }
        }

        public void mouseReleased(MouseEvent e)//place turret, tower stops following the cursor
        {
            if (tower!=null)
            {
                if (e.getX()>=832){}//do nothing when clicked on the sidebar
                else if (e.getButton()==MouseEvent.BUTTON1&&Room.block[e.getY()/32][e.getX()/32].groundID==0&&e.getY()<=735&&UI.gold >= tower.cost)
                {
                    tower.setX(Screen.xval);
                    tower.setY(Screen.yval);
                    tower.b.setX(Screen.xval - 50);
                    tower.b.setY(Screen.yval - 50);
                    UI.gold-=tower.cost;
                    Screen.tplace.add(tower);//adds tower to list of towers on map
                    Screen.to=null;
                    tower=null;
                }
            }
        }

        public void mouseEntered(MouseEvent e){}

        public void mouseExited(MouseEvent e){}
        //MouseMotionListener classes
        public void mouseDragged(MouseEvent e){
            if (Screen.to!=null){
                Screen.xval=((int)(e.getX()/32 + 0.5))*32;
                Screen.yval=((int)(e.getY()/32 + 0.5))*32;
            }
            //System.out.println(e.getX() +"," + e.getY()); testing
        }

        public void mouseMoved(MouseEvent e){//turret image follows mouse and locks to every 32 pixels
            if (Screen.to!=null){
                Screen.xval=((int)(e.getX()/32 + 0.5))*32;
                Screen.yval=((int)(e.getY()/32 + 0.5))*32;
            }
        }
    }
}