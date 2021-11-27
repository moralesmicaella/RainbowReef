
package RainbowReef;


/**
 *
 * @author micaellamorales
 */
public interface CollisionInterface  {

    public final static int upperRightCollision = 0;
    public final static int upperLeftCollision = 1;
    public final static int lowerRightCollision = 2;
    public final static int lowerLeftCollision = 3;
    
    public void fixCollision(int xLocation);
}
