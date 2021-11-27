
package RainbowReef;

import RainbowReef.Audio.SoundPlayer;
import RainbowReef.GameWorld.*;
import RainbowReef.Graphics.Assets;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author micaellamorales
 */
public class RainbowReefGame extends Game {
    private final GameMenu menu;
    private final RainbowReefWorld world;
    private final SoundPlayer soundPlayer;
    private final ScoreBoard scoreBoard;
    private final Font font = new Font("SansSerif", Font.BOLD, 18);
    
    private final MouseControl mControl;
    private boolean viewScoreBoard, play;
    
    public RainbowReefGame(String title, int width, int height, boolean gameState) {
        super(title, width, height, gameState);
        world = new RainbowReefWorld(this);
        menu = new GameMenu(this);
        soundPlayer = new SoundPlayer();
        scoreBoard = new ScoreBoard("Resources/scores.txt");
        mControl = new MouseControl(this);
        play = true;
    }

    
    //---------------------------------------------
    // accessor and mutator methods
    //---------------------------------------------
    
    public GameMenu getMenu() {
        return menu;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public SoundPlayer getSoundPlayer() {
        return soundPlayer;
    }

    public RainbowReefWorld getWorld() {
        return world;
    }

    public MouseControl getmControl() {
        return mControl;
    }

    public boolean isViewScoreBoard() {
        return viewScoreBoard;
    }

    public void setViewScoreBoard(boolean viewScoreBoard) {
        this.viewScoreBoard = viewScoreBoard;
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }
    
    //---------------------------------------------
    // Game's  methods
    //---------------------------------------------
    @Override
    public void init(){
        Assets.init();
        if(gameState){
            world.init();
        }
        canvas.addMouseListener(mControl);
    }
    
    @Override
    public void update(){
        if(gameState){
            if(play){
                world.update();
                if(world.isGameOver()){
                    scoreBoard.storeScore(world.getPlayer().getPoints());
                    viewScoreBoard = true;
                    play = false;
                }
            }
        }
    }
    
    @Override
    public void draw(){
        bs = canvas.getBufferStrategy();
        if(bs == null){
            canvas.createBufferStrategy(3);
            return;
        }
        g = (Graphics2D) bs.getDrawGraphics();
        
        //draws the menu
        if(!gameState){
            menu.draw(g);
        }
        //draws RainbowReefWorld
        else{
            g.drawImage(Assets.bg1, 0, 0, width, height, null);
            world.draw(g);

            world.getPlayer().getLivesCount().draw(g, width-170, height-80);
            g.drawImage(Assets.score, width-170, height-50, 120, 35, null);

            g.setFont(font);
            g.drawString(String.valueOf(world.getPlayer().getPoints()), width-113, height-25);
            
            //draws ScoreBoard
            if(viewScoreBoard){
                scoreBoard.draw(g);
                g.drawImage(Assets.playButton, 240, 430, 150, 40, null);
                g.drawImage(Assets.mainButton, 400, 430, 150, 40, null);
            }
        }
        
        
        bs.show();
        g.dispose();
    }
    
    @Override
    public void run() {
        init();
        soundPlayer.play(true, "Resources/background.wav");
        while (running) {
            update();
            draw();
            try {
                thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
        stop();
    }
    
    /**
     *  launches the game
     * @param args the command line arguments
     */
    public static void main(String[] args){
        RainbowReefGame game = new RainbowReefGame("Super Rainbow Reef", 800, 600, false);
        game.start();
    }
    
}
