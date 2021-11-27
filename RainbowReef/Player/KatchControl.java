
package RainbowReef.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author micaellamorales
 */
public class KatchControl implements KeyListener {
    private final Katch katch;
    private final int right, left;

    public KatchControl(Katch katch, int right, int left) {
        this.katch = katch;
        this.right = right;
        this.left = left;
    }
    

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == right)
            katch.toggleRightPressed();
        if(key == left)
            katch.toggleLeftPressed();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == right)
            katch.untoggleRightPressed();
        if(key == left)
            katch.untoggleLeftPressed();
    }
    
}
