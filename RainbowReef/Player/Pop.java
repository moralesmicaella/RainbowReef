
package RainbowReef.Player;

import RainbowReef.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author micaellamorales
 */
public class Pop extends GameObj 
        implements MovableInterface, CollisionInterface, DrawableInterface {
    
    private int angle, speed, rotationAngle;
    private final int spawnX, spawnY;
    
    private int defaultSpeed = 7;
    private final int maxSpeed = 12;
    private final int spawnAngle = 90;
    private final int defaultWidth = 35 , defaultHeight=35;
    
    public Pop(int x, int y, BufferedImage img) {
        super(x, y, img);
        this.spawnX = x;
        this.spawnY = y;
        this.angle = spawnAngle;
        this.speed = defaultSpeed;
        this.width = defaultWidth;
        this.height = defaultHeight;
        rect = new Rectangle(x, y, width, height);
    }

    
    //---------------------------------------------
    // accessor and mutator methods
    //---------------------------------------------
    
    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void increaseSpeed(){
        if(speed < maxSpeed){
            speed++;
        }
    }
    
    public void respawn(){
        x = spawnX;
        y = spawnY;
        angle = spawnAngle;
        speed = defaultSpeed;
        rect.setLocation(x, y);
    }
    
    //---------------------------------------------
    // Methods from CollisionInterface
    //---------------------------------------------
    
    @Override
    public void fixCollision(int xLocation){
        if(xLocation == CollisionInterface.upperRightCollision)
            angle = 125;
        else if(xLocation == CollisionInterface.upperLeftCollision)
            angle = 35;
        else if(xLocation == CollisionInterface.lowerRightCollision)
            angle = -125;
        else if(xLocation == CollisionInterface.lowerLeftCollision)
            angle = -35;
    }

    
    //---------------------------------------------
    // Methods from MovableInterface
    //---------------------------------------------
    
    @Override
    public void move(int speed) {
        int dx = (int) Math.round(speed * Math.cos(Math.toRadians(angle)));
        int dy = (int) Math.round(speed * Math.sin(Math.toRadians(angle)));
        x += dx;
        y += dy;
        rect.setLocation(x, y);
        rotationAngle += 2;
    }

    
    //---------------------------------------------
    // Methods from DrawableInterface
    //---------------------------------------------
    
    @Override
    public void draw(Graphics g) {
       AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(rotationAngle), img.getWidth()/ 2, img.getHeight()/ 2);
        Graphics2D graphic2D = (Graphics2D) g;
        graphic2D.drawImage(img, rotation, null);
    }
    
    public void update(){
        move(speed);
    }
    
}
