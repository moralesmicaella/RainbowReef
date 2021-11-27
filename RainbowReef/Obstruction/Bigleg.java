
package RainbowReef.Obstruction;

import RainbowReef.GameWorld.RainbowReefWorld;
import java.awt.image.BufferedImage;

/**
 *
 * @author micaellamorales
 */
public class Bigleg extends Obstruction {
    private final int defaultWidth = 50;
    private final int defaultHeight = 50;   
    private final static int value = 50;
    
    public Bigleg(BufferedImage img) {
        this.img = img;
        this.width = defaultWidth;
        this.height = defaultHeight;
    }
    
    //adds points to player
    public void update(RainbowReefWorld reefWorld){
        reefWorld.getPlayer().addPoints(value);
    }

    @Override
    public boolean isBreakable() {
        return true;
    }
    
}
