
package RainbowReef;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author micaellamorales
 */
public class GameObj {
    protected int x, y;
    protected int width, height;
    protected BufferedImage img;
    protected Rectangle rect;

    public GameObj(){ }
    
    public GameObj(int x, int y, BufferedImage img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }
    
    
    //-------------------------------------
    // Accessors and Mutators
    //-------------------------------------

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
    
    public Rectangle getRect() {
        return rect;
    }
    
}
