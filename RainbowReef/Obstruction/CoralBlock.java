
package RainbowReef.Obstruction;

import RainbowReef.GameWorld.RainbowReefWorld;
import java.awt.image.BufferedImage;

/**
 *
 * @author micaellamorales
 */
public class CoralBlock extends Block {
    private final int value = 5;
    
    public CoralBlock(BufferedImage img) {
        super(img);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean isBreakable() {
        return true;
    }

    //adds points to player
    @Override
    public void update(RainbowReefWorld reefWorld) {
        reefWorld.getPlayer().addPoints(value);
    }
    
}
