import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Wave
{
    public static final int MAX_WAVES = 30;//modular wave system
    private int currWave;
    private boolean isClicked;
    private int counter;
    private ArrayList<Minion> myMinions;
    public boolean invurnability;//since all monsters appear at once in the start, this sets invulnerability
    public Wave()
    {
        invurnability = true;
        currWave = 0;
        isClicked = false;
        myMinions = new ArrayList<Minion>();
        counter = 1;
    }

    public void setClicked(boolean bool)
    {
        isClicked = bool;
    }

    public ArrayList<Minion> getMyMinions()
    {
        return myMinions;
    }

    public void minionsMove()
    {
        int temp = counter;//delays each monster for their turn
        for (Minion m: myMinions)
        {
            if (temp > 0)
            {
                for (int x = 0; x < 13; x++)//monster moves 13 times before next monster behind it moves
                {
                    m.move();
                }
                m.invurnability = false;//is now vulnarable
                temp--;
            }
        }
        if (counter < myMinions.size())
            counter++;
    }
    //modifier
    public void setCurrWave(int x)
    {
        currWave = x;
    }

    public void resetCounter()
    {
        counter = 1;
    }
    //accessor
    public int getCurrWave()
    {
        return currWave;
    }

    public boolean isNewWave()
    {
        if (isClicked)
        {
            isClicked = false;
            return true;
        }
        else
        {
            return false;
        }
    }

    public void launchAssault()
    {
        for (Minion m: myMinions)
        {
            m.attack();
        }
    }

    public boolean haveYouSlainThemAll()
    {
        for (Minion m: myMinions)
        {
            if (!(m.isMinionDead()))
            {
                return false;
            }
        }
        return true;
    }

    public void getWave()//gets the wave, modular system
    {
        myMinions=new ArrayList<Minion>();
        if (getCurrWave()==1){
            for (int x=0; x<6; x++){
                myMinions.add(new Red());
            }
        }
        if (getCurrWave()==2){
            for (int x=0; x<8; x++){
                myMinions.add(new Red());
            }
        }
        if (getCurrWave()==3){
            for (int x=0; x<11; x++){
                myMinions.add(new Red());
            }
            for (int x=0; x<15; x++){
                myMinions.add(new Orange());
            }
        }
        if (getCurrWave()==4){
            for (int x=0; x<10; x++){
                myMinions.add(new Red());
            }
            for (int x=0; x<28; x++){
                myMinions.add(new Orange());
            }
        }
        if (getCurrWave()==5){
            for (int x=0; x<10; x++){
                myMinions.add(new Red());
            }
            for (int x=0; x<10; x++){
                myMinions.add(new Orange());
            }
            for (int x=0; x<20; x++){
                myMinions.add(new Orange());
            }
        }
        if (getCurrWave()==6){
            for (int x=0; x<5; x++){
                myMinions.add(new Red());
            }
            for (int x=0; x<40; x++){
                myMinions.add(new Orange());
            }
        }
        if (getCurrWave()==7){
            for (int x=0; x<20; x++){
                myMinions.add(new Orange());
            }
            for (int x=0; x<10; x++){
                myMinions.add(new Yellow());
            }
        }
        if (getCurrWave()==8){
            for (int x=0; x<15; x++){
                myMinions.add(new Orange());
            }
            for (int x=0; x<20; x++){
                myMinions.add(new Yellow());
            }
        }
        if (getCurrWave()==9){
            for (int x=0; x<25; x++){
                myMinions.add(new Yellow());
            }
        }
        if (getCurrWave()==10){
            myMinions.add(new Purple());

        }
        if (getCurrWave()==11){
            for (int x=0; x<10; x++){
                myMinions.add(new Orange());
            }
            for (int x=0; x<10; x++){
                myMinions.add(new Yellow());
            }
            for (int x=0; x<10; x++){
                myMinions.add(new Green());
            }
        }
        if (getCurrWave()==12){
            for (int x=0; x<15; x++){
                myMinions.add(new Yellow());
            }
            for (int x=0; x<15; x++){
                myMinions.add(new Green());
            }
        }
        if (getCurrWave()==13){
            for (int x=0; x<20; x++){
                myMinions.add(new Green());
            }
        }
        if (getCurrWave()==14){
            for (int x=0; x<10; x++){
                myMinions.add(new Yellow());
            }
            for (int x=0; x<10; x++){
                myMinions.add(new Green());
            }
            for (int x=0; x<5; x++){
                myMinions.add(new Blue());
            }
        }
        if (getCurrWave()==15){
            for (int x=0; x<15; x++){
                myMinions.add(new Green());
            }
            for (int x=0; x<10; x++){
                myMinions.add(new Blue());
            }
        }
        if (getCurrWave()==16){
            for (int x=0; x<25; x++){
                myMinions.add(new Green());
            }
        }
        if (getCurrWave()==17){
            for (int x=0; x<40; x++){
                myMinions.add(new Green());
                myMinions.get(x).setHealth(25);
            }
        }
        if (getCurrWave()==18){
            for (int x=0; x<10; x++){
                myMinions.add(new Yellow());
            }
            for (int x=0; x<30; x++){
                myMinions.add(new Blue());
                myMinions.get(x+10).setHealth(40);
            }
        }
        if (getCurrWave()==19){
            for (int x=0; x<30; x++){
                myMinions.add(new Blue());
                myMinions.get(x).setHealth(50);
            }            
        }
        if (getCurrWave()==20){
            for (int x=0; x<20; x++){
                myMinions.add(new Green());
            }
            for (int x=0; x<10; x++){
                myMinions.add(new Purple());
            }
        }
        if (getCurrWave()==21){
            for (int x=0; x<20; x++){
                myMinions.add(new Purple());
                myMinions.get(x).setHealth(50);
            }

        }
        if (getCurrWave()==22){
            for (int x=0; x<25; x++){
                myMinions.add(new Purple());
                myMinions.get(x).setHealth(70);
            }

        }
        if (getCurrWave()==23){
            for (int x=0; x<35; x++){
                myMinions.add(new Purple());
                myMinions.get(x).setHealth(110);
            }

        }
        if (getCurrWave()==24){
            for (int x=0; x<50; x++){
                myMinions.add(new Purple());
                myMinions.get(x).setHealth(150);
            }

        }
        if (getCurrWave()==25){
            for (int x=0; x<70; x++){
                myMinions.add(new Purple());
                myMinions.get(x).setHealth(200);
            }

        }
        if (getCurrWave()==26){
            for (int x=0; x<85; x++){
                myMinions.add(new Purple());
                myMinions.get(x).setHealth(300);
            }

        }
        if (getCurrWave()==27){
            for (int x=0; x<100; x++){
                myMinions.add(new Purple());
                myMinions.get(x).setHealth(400);
            }

        }
        if (getCurrWave()==28){
            for (int x=0; x<115; x++){
                myMinions.add(new Purple());
                myMinions.get(x).setHealth(400);
            }

        }
        if (getCurrWave()==29){
            for (int x=0; x<140; x++){
                myMinions.add(new Purple());
                myMinions.get(x).setHealth(550);
            }

        }
        if (getCurrWave()==30){
            for (int x=0; x<50; x++){
                myMinions.add(new Purple());
                myMinions.get(x).setHealth(700);
            }
            for (int x=0; x<20; x++){
                myMinions.add(new Purple());
                myMinions.add(new Blue());
                myMinions.add(new Green());
                myMinions.add(new Yellow());
                myMinions.add(new Orange());
                myMinions.add(new Red());
            }
        }
    }
}