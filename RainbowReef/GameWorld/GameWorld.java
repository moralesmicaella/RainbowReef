
package RainbowReef.GameWorld;

import RainbowReef.Game;
import java.awt.Graphics;

/**
 *
 * @author micaellamorales
 */
public abstract class GameWorld {
    protected final Game game;

    public GameWorld(Game game) {
        this.game = game;
    }
    
    public abstract void init();
    
    public abstract void update();
    
    public abstract void draw(Graphics g);
}
