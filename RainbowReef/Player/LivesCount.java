
package RainbowReef.Player;

import RainbowReef.Graphics.Assets;
import java.awt.Graphics;

/**
 *
 * @author micaellamorales
 */
public class LivesCount {
    private int life;
    private int maxLife;
    
    public LivesCount() {
        this.life = 3;
        this.maxLife = 6;
    }

    public LivesCount(int life) {
        this.life = life;
    }

    
    // --------------------------------------------
    //  accessor and mutator methods
    // --------------------------------------------
    
    public int getNumLife() {
        return life;
    }

    public void setNumLife(int life) {
        this.life = life;
    }
    
    public void subtractLife(){
        life--;
    }
    
    public void addLife(){
        if(life < maxLife){
            life++;
        }
    }
    
    public void draw(Graphics g, int x, int y){
        int offset = 20;
        for(int i = 0; i < life; i++){
            g.drawImage(Assets.life, x+offset*i, y, 20, 15, null);
        }
    }
    
}
