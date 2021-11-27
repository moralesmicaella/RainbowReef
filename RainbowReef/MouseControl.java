
package RainbowReef;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author micaellamorales
 */
public class MouseControl implements MouseListener {
    private final RainbowReefGame game;

    public MouseControl(RainbowReefGame game) {
        this.game = game;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) { 
        int mx = e.getX();
        int my = e.getY();
        
        //when in game menu
        if(!game.isGameState()){
            if(mx > 60 && mx < 210){
                if(my > 275 && my < 315){
                    game.getSoundPlayer().play(false, "Resources/Sound_click.wav");
                    game.getWorld().init();
                    game.setGameState(true);
                }
            }

             if(mx > 230 && mx < 380){
                if(my > 275 && my < 315){
                    game.getSoundPlayer().play(false, "Resources/Sound_click.wav");
                    game.getMenu().setShowMechanics(true);
                }
            }

            if(mx > 400 && mx < 550){
                if(my > 275 && my < 315){
                    game.getSoundPlayer().play(false, "Resources/Sound_click.wav");
                    game.getMenu().setShowScores(true);
                    game.getScoreBoard().loadScores();
                }
            }

            if(mx > 570 && mx < 720){
                if(my > 275 && my < 315){
                    game.getSoundPlayer().play(false, "Resources/Sound_click.wav");
                    System.exit(1);
                }
            }

            if(game.getMenu().isShowMechanics()){
                if(mx > 755 && mx < 775){
                    if(my > 15 && my < 35){
                        game.getSoundPlayer().play(false, "Resources/Sound_click.wav");
                        game.getMenu().setShowMechanics(false);
                    }
                }
            }

            if(game.getMenu().isShowScores()){
                if(mx > 545 && mx < 560){
                    if(my > 110 && my < 115){
                        game.getSoundPlayer().play(false, "Resources/Sound_click.wav");
                        game.getMenu().setShowScores(false);
                    }
                }
            }
        }
        //after game is over
        else{
            if(!game.isPlay()){
                if(mx > 240 && mx < 390){
                    if(my > 430 && my < 470){
                        game.getSoundPlayer().play(false, "Resources/Sound_click.wav");
                        game.setViewScoreBoard(false);
                        game.setPlay(true);
                        game.getWorld().init();
                    }
                }
                if(mx > 400 && mx < 550){
                    if(my > 430 && my < 470){
                        game.getSoundPlayer().play(false, "Resources/Sound_click.wav");
                        game.setGameState(false);
                        game.setViewScoreBoard(false);
                        game.setPlay(true);
                    }
                }
            }
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) { 
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) { 
    }
    
}
