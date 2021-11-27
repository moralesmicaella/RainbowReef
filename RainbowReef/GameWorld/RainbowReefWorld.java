
package RainbowReef.GameWorld;

import RainbowReef.Obstruction.*;
import RainbowReef.Graphics.*;
import RainbowReef.Player.*;
import RainbowReef.*;
import RainbowReef.Audio.SoundPlayer;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author micaellamorales
 */
public class RainbowReefWorld extends GameWorld {
    private int timer = 60;
    private boolean gameOver;
    private int enemyCounter;
    
    private Katch katch;
    private Pop pop;
    private Player player;
    private Rectangle katchRect, popRect, bgRect;
    private List<DrawableInterface> drawable;
    private List<Obstruction> obstruction;
    
    private String[] maps;
    private static int level = 0;
    private final int numLevels = 3;
    
    private final Font font;
    private final SoundPlayer soundPlayer;
    
    private Point top, bottom, topright, topleft, bottomright, bottomleft;
    
    public RainbowReefWorld(RainbowReefGame game) {
        super(game);
        soundPlayer = new SoundPlayer();
        font = new Font("SansSerif", Font.BOLD, 60);
    }
    
    
    //---------------------------------------------
    // accessor and mutator methods
    //---------------------------------------------

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Player getPlayer() {
        return player;
    }
    
    
    //---------------------------------------------
    // Game World's methods
    //---------------------------------------------

   /**
     *  This function initializes RainbowReefWorld. 
     *      -It creates a player, Katch, Pop, as well as 
     *          all the objects needed in the map
     */
    @Override
    public void init() {
        gameOver = false;
        level = 0; enemyCounter = 0;
        drawable = Collections.synchronizedList(new ArrayList());
        obstruction = Collections.synchronizedList(new ArrayList());
        
       katch = new Katch(game.getWidth()/2-50, game.getHeight()-140, Assets.katch);
       pop = new Pop(game.getWidth()/2-20, game.getHeight()-280, Assets.pop);
       player = new Player(katch, pop);
       
       katchRect = katch.getRect();
       popRect = pop.getRect();
       
       //points for a rectangle
       top = new Point();
       bottom = new Point();
       topright = new Point();
       topleft = new Point();
       bottomright = new Point();
       bottomleft = new Point();
       
       maps = new String[] {"Resources/map1.txt", "Resources/map2.txt", "Resources/map3.txt"};
       loadMap(maps[level]);
       level++;
       
       drawable.add(katch);
       drawable.add(pop);
       drawable.addAll(obstruction);
       
       game.getCanvas().addKeyListener(katch.getkControl());
    }

   /**
     *  This function updates RainbowReefWorld. 
     *      -It updates the player
     *      -It checks for collision
     *      -It checks if Pop is out of the screen
     *      -It checks if the player is out of life 
     *      -It checks if all the enemies are defeated and if it should move to the next level
     */
    @Override
    public void update() {
        player.update();
        checkCollisions();
        
        //checks if pop fell down the screen
        if(pop.getY() > game.getHeight() && enemyCounter != 0){
            soundPlayer.play(false, "Resources/Sound_lost.wav");
            pop.respawn();
            player.loseLife();
        }
        
        if(player.getNumLife() == 0){
            gameOver = true;
        }
        
        //checks if all enemies are defeated
        if(enemyCounter == 0){
            drawable.removeAll(obstruction);
            obstruction.clear();
            timer--;
            if(timer == 0  && level < numLevels){
                loadMap(maps[level]);
                level++;
                drawable.addAll(obstruction);
                katch.respawn();
                pop.respawn();
                timer = 60;
            }
            else if(level == numLevels){
                gameOver = true;
            }
        }
        
    }

    /**
     *  draws all drawable objects
     * 
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        if(enemyCounter == 0){
            g.setFont(font);
            if( level < numLevels)
                g.drawString("Next Level!", game.getWidth()/2-180, game.getHeight()/2);
        }
        else{
            for(DrawableInterface object : drawable){
                object.draw(g);
            }
        }
    }
    
    
    
    //--------------------------------------------------------
    // Additional methods of RainbowReefWorld
    //--------------------------------------------------------
    
    /**
     *  This function loads the map of the game from a .txt file using the loadFile function from the Util class.
     *  It then creates the objects of the map and sets their location. 
     *  It also counts how many enemies are created.
     * 
     * @param filePath 
     */
    public void loadMap(String filePath){  
        int key;
        Obstruction bg;
        ArrayList<Integer> file = Util.loadFile(filePath);
        
        int index = 2;
        for(int y = 0; y < file.get(1); y++){
            for(int x = 0; x < file.get(0); x++){
                key = file.get(index);
                bg = Obstruction.newBg(key);
                if(bg != null){
                    bg.setLocation(x*25, y*25);
                    bg.getRect().setBounds(x*25, y*25, bg.getWidth(), bg.getHeight());
                    obstruction.add(bg);
                    if(bg instanceof Bigleg)
                        enemyCounter++;
                }
                index++;
            }
        }
    }
    
    /**
     *  This function checks the area of collision between two objects, and fix them accordingly
     *  by calling the movableObj's own fixCollision function
     * 
     * @param movableObj
     * @param movableRect
     * @param rect 
     */
    public void fixCollision(CollisionInterface movableObj, Rectangle movableRect, Rectangle rect){
        topright.setLocation((int)movableRect.getMaxX()+1, (int)movableRect.getMinY()-1);
        topleft.setLocation((int)movableRect.getMinX()-1, (int)movableRect.getMinY()-1);
        bottomright.setLocation((int)movableRect.getMaxX()+1, (int)movableRect.getMaxY()+1);
        bottomleft.setLocation((int)movableRect.getMinX()-1, (int)movableRect.getMaxY()+1);
        
        if(rect.contains(topright))
            movableObj.fixCollision(CollisionInterface.upperRightCollision);
        else if(rect.contains(topleft))
            movableObj.fixCollision(CollisionInterface.upperLeftCollision);
        else if(rect.contains(bottomright))
            movableObj.fixCollision(CollisionInterface.lowerRightCollision);
        else if(rect.contains(bottomleft))
            movableObj.fixCollision(CollisionInterface.lowerLeftCollision);
        
    }
    
    /**
     *  This function clears all breakable blocks
     */
    public void clearBlocks(){
        int points = 0;
        for (Obstruction bg : obstruction) {
            if(bg instanceof Block){
                if(!(bg instanceof SolidBlock)){
                    bg.setDestroyed(true);
                    points += 5;
                }
            }
        }
        player.addPoints(points);
    }
    
    /**
     *  This function checks for collisions of Katch, Pop, walls, blocks, and Biglegs
     */
    public void checkCollisions(){
        //collision of katch and pop
        if(katchRect.intersects(popRect)){
            soundPlayer.play(false, "Resources/Sound_katch.wav");
            if(popRect.getMinY() < katchRect.getMinY()){
                if(popRect.getCenterX() > katchRect.getCenterX())
                    pop.fixCollision(CollisionInterface.lowerLeftCollision);
                else if(popRect.getCenterX() < katchRect.getCenterX())
                    pop.fixCollision(CollisionInterface.lowerRightCollision);
                
                pop.increaseSpeed();
            }
        }
        
        for (Obstruction bg : obstruction) {
           bgRect = bg.getRect();
           //collision of katch and wall
           if(katchRect.intersects(bgRect)){
               fixCollision(katch, katchRect, bgRect);
           }
           
           if(popRect.intersects(bgRect)){
               //collisions with unbreakable objects 
               if(!bg.isBreakable()){
                    soundPlayer.play(false, "Resources/Sound_wall.wav");
                    top.setLocation((int)popRect.getCenterX(), (int)popRect.getMinY()-1);
                    bottom.setLocation((int)popRect.getCenterX(), (int)popRect.getMaxY()+1);
                    if(bgRect.contains(top))
                        pop.setAngle(90);
                    else if(bgRect.contains(bottom))
                        pop.setAngle(-90);

                    if(popRect.getCenterX()> bgRect.getCenterX()){
                        if(pop.getAngle() > 0)
                            pop.setAngle(35);
                        else
                            pop.setAngle(-35);
                    }
                    else{
                        if(pop.getAngle() > 0)
                            pop.setAngle(125);
                        else
                            pop.setAngle(-125);
                    }
               }
               
               //collisions with breakable objects
               else {
                   if(!bg.isDestroyed()){
                       bg.setDestroyed(true);
                       if(bg instanceof Block){
                            ((Block) bg).update(this);
                            soundPlayer.play(false, "Resources/Sound_block.wav");
                       }
                       if(bg instanceof Bigleg){
                           ((Bigleg)bg).update(this);
                           enemyCounter--;
                           soundPlayer.play(false, "Resources/Sound_bigleg.wav");
                       }
                       fixCollision(pop, popRect, bgRect);
                   }
               }
           }
        }
    }
  
    
}