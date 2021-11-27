
package RainbowReef;

import RainbowReef.Graphics.Assets;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author micaellamorales
 */
public class GameMenu  {
    private final RainbowReefGame game;
    private boolean showMechanics, showScores;

    public GameMenu(RainbowReefGame game) {
        this.game = game;
    }

    
     //---------------------------------------------
    // accessor and mutator methods
    //---------------------------------------------
    
    public boolean isShowMechanics() {
        return showMechanics;
    }

    public void setShowMechanics(boolean showMechanics) {
        this.showMechanics = showMechanics;
    }

    public boolean isShowScores() {
        return showScores;
    }

    public void setShowScores(boolean showScores) {
        this.showScores = showScores;
    }

    
    public void draw(Graphics g) {
        g.drawImage(Assets.menuButton, 0, 0, game.getWidth(), game.getHeight(), null);
        
        g.drawImage(Assets.startButton, 60, 275, 150, 40, null);
        g.drawImage(Assets.helpButton, 230, 275, 150, 40, null);
        g.drawImage(Assets.scoreButton, 400, 275, 150, 40, null);
        g.drawImage(Assets.quitButton, 570, 275, 150, 40, null);
        
        if(showMechanics){
            g.drawImage(Assets.mechanics, 0, 0, game.getWidth(), game.getHeight(), null);
        }
        if(showScores){
            game.getScoreBoard().draw(g);
            g.setColor(Color.white);
            g.fillRect(545, 110, 15, 5);
        }
    }

}
