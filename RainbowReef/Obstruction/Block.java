
package RainbowReef.Obstruction;

import RainbowReef.GameWorld.RainbowReefWorld;
import java.awt.image.BufferedImage;

/**
 *
 * @author micaellamorales
 */
public abstract class Block extends Obstruction {
    private final int defaultWidth = 50;
    private final int defaultHeight = 25;
    
    
    public Block(BufferedImage img){
        this.img = img;
        this.width = defaultWidth;
        this.height = defaultHeight;
    }
    
    public abstract void update(RainbowReefWorld reefWorld);
    
}
