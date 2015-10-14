import java.awt.*;
public class Room
{
    public int worldWidth = 26;
    public int worldHeight = 24;
    public int blockSize = 32;
    public static Block[][] block;
    public Room()
    {
        define();
    }

    public void define(){//defines block properties
        block = new Block[worldHeight][worldWidth];
        for(int y=0; y<block.length; y++){
            for(int x=0; x<block[0].length; x++){
                block[y][x] = new Block(x*blockSize, y*blockSize, blockSize, blockSize, Value.groundGrass, Value.airAir);
            }

        }
    }    

    public void draw(Graphics g){//draws the blocks
        for(int y=0; y<block.length; y++){
            for(int x=0; x<block[0].length; x++){
                block[y][x].draw(g);
            }
        }
    }
}