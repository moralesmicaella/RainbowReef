
package RainbowReef.Obstruction;

import RainbowReef.DrawableInterface;
import RainbowReef.GameObj;
import RainbowReef.Graphics.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author micaellamorales
 */
public abstract class Obstruction extends GameObj implements DrawableInterface {
    protected boolean destroyed;
    
    public Obstruction() {
        rect = new Rectangle();
    }
    
    public static Obstruction newBg(int key){
        Obstruction bg = null;
        if(key == 1) bg = new Wall(Assets.wall);
        else if(key == 2) bg = new SolidBlock(Assets.blockSolid);
        else if(key == 3) bg = new CoralBlock(Assets.block1);
        else if(key == 4) bg = new CoralBlock(Assets.block2);
        else if(key == 5) bg = new CoralBlock(Assets.block3);
        else if(key == 6) bg = new CoralBlock(Assets.block4);
        else if(key == 7) bg = new CoralBlock(Assets.block5);
        else if(key == 8) bg = new CoralBlock(Assets.block6);
        else if(key == 9) bg = new CoralBlock(Assets.block7);
        else if(key == 10) bg = new LifeBlock(Assets.blockLife);
        else if(key == 11) bg = new BombBlock(Assets.blockBomb);
        else if(key == 12) bg = new Bigleg(Assets.bigleg);
        return bg;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    
    public abstract boolean isBreakable();
    
    @Override
    public void draw(Graphics g) {
        if(!destroyed)
            g.drawImage(img, x, y, width, height, null);
    }
    
    
}
