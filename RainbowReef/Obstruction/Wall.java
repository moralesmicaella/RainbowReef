
package RainbowReef.Obstruction;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author micaellamorales
 */
public class Wall extends Obstruction {
    private final int defaultWidth = 25;
    private final int defaultHeight = 25;
    
    public Wall(BufferedImage img) {
        this.img = img;
        this.width = defaultWidth;
        this.height = defaultHeight;
    }

    @Override
    public boolean isBreakable() {
        return false;
    }
    
    
}
