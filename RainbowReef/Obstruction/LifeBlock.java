
package RainbowReef.Obstruction;

import RainbowReef.GameWorld.RainbowReefWorld;
import java.awt.image.BufferedImage;

/**
 *
 * @author micaellamorales
 */
public class LifeBlock extends Block {
    
    public LifeBlock(BufferedImage img){
        super(img);
    }
    
    @Override
    public boolean isBreakable() {
        return true;
    }

    //adds one life to the player
    @Override
    public void update(RainbowReefWorld reefWorld) {
        reefWorld.getPlayer().addLife();
    }
    
}
