
package RainbowReef.Obstruction;

import RainbowReef.GameWorld.RainbowReefWorld;
import java.awt.image.BufferedImage;

/**
 *
 * @author micaellamorales
 */
public class SolidBlock extends Block {

    public SolidBlock(BufferedImage img){
        super(img);
    }
    
    @Override
    public boolean isBreakable() {
        return false;
    }
    
    @Override
    public void update(RainbowReefWorld reefWorld) {
    }
    
}
