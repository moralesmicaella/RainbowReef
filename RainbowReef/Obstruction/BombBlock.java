
package RainbowReef.Obstruction;

import RainbowReef.GameWorld.RainbowReefWorld;
import java.awt.image.BufferedImage;

/**
 *
 * @author micaellamorales
 */
public class BombBlock extends Block {

    public BombBlock(BufferedImage img) {
        super(img);
    }
    
    @Override
    public boolean isBreakable() {
        return true;
    }

    //clears all breakable blocks
    @Override
    public void update(RainbowReefWorld reefWorld) {
        reefWorld.clearBlocks();
    }
    
}
