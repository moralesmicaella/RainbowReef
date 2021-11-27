
package RainbowReef.Player;

import RainbowReef.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author micaellamorales
 */
public class Katch extends GameObj 
        implements MovableInterface, CollisionInterface, DrawableInterface {
    
    private final int spawnX, spawnY;
    private final int defaultSpeed = 25;
    private final int defaultWidth = 100, defaultHeight=40;
    
    private boolean rCollision, lCollision;
    private boolean rightPressed, leftPressed;
    private KatchControl kControl;

    public Katch(int x, int y, BufferedImage img) {
        super(x, y, img);
        this.spawnX = x;
        this.spawnY = y;
        this.width = defaultWidth;
        this.height = defaultHeight;
        rect = new Rectangle(x-6, y, width+12, height);
        kControl = new KatchControl(this, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT);
    }
    

    //---------------------------------------------
    // accessor and mutator methods
    //---------------------------------------------
    

    public KatchControl getkControl() {
        return kControl;
    }

    public boolean isrCollision() {
        return rCollision;
    }

    public void setrCollision(boolean rCollision) {
        this.rCollision = rCollision;
    }

    public boolean islCollision() {
        return lCollision;
    }

    public void setlCollision(boolean lCollision) {
        this.lCollision = lCollision;
    }
    
    public void respawn(){
        x = spawnX;
        y = spawnY;
        rect.setLocation(x, y);
    }

    public void setkControl(KatchControl kControl) {
        this.kControl = kControl;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }
    
    public void toggleRightPressed(){
        rightPressed = true;
    }
    
    public void toggleLeftPressed(){
        leftPressed = true;
    }
    
    public void untoggleRightPressed(){
        rightPressed = false;
    }
    
    public void untoggleLeftPressed(){
        leftPressed = false;
    }
    
    
    //---------------------------------------------
    // Methods from CollisionInterface
    //---------------------------------------------
    
    @Override
    public void fixCollision(int xLocation){
        if(xLocation == CollisionInterface.upperRightCollision || xLocation == CollisionInterface.lowerRightCollision){
            rCollision = true;
            lCollision = false;
        }
        else if(xLocation == CollisionInterface.upperLeftCollision || xLocation == CollisionInterface.lowerLeftCollision){
            lCollision = true;
            rCollision = false;
        }
    }
    
    
    //---------------------------------------------
    // Methods from MovableInterface
    //---------------------------------------------
    
    @Override
    public void move(int speed) {
        x += speed;
        rect.setLocation(x-6, y);
        
        rCollision = false;
        lCollision = false;
    }

    
    //---------------------------------------------
    // Methods from DrawableInterface
    //---------------------------------------------
    @Override
    public void draw(Graphics g) { 
        g.drawImage(img, x, y, width, height, null);
    }
    
    
    public void update(){
        if(rightPressed && !rCollision)
            move(defaultSpeed);
        if(leftPressed && !lCollision)
            move(-defaultSpeed);
    }
    
    
}
