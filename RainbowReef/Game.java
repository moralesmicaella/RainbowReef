
package RainbowReef;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author micaellamorales
 */
public abstract class Game implements Runnable {
    protected static String title;
    protected static int width, height;
    
    protected final JFrame frame;
    protected final Canvas canvas;
    protected static Graphics2D g;
    protected static BufferStrategy bs;
    
    protected boolean gameState;
    protected boolean running;
    protected Thread thread;    

    public Game(String title, int width, int height, boolean gameState) {
        Game.title = title;
        Game.width = width;
        Game.height = height;
        this.gameState = gameState;
        
        running = false;
        
        frame = new JFrame(title);
        canvas = new Canvas();
        createFrame();
    }

    private void createFrame() {
        canvas.setPreferredSize(new Dimension(width, height));
        
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.pack();
    }
    
    
    // --------------------------------------------
    //  accessor and mutator methods
    // --------------------------------------------
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }
    
    public boolean isGameState() {
        return gameState;
    }

    public void setGameState(boolean gameState) {
        this.gameState = gameState;
    }
    
    
    // ----------------------------------------------------------------------------
    //  implementation of start and stop function from Runnable
    // ----------------------------------------------------------------------------
    
    public synchronized void start() {
        if(!running){
            running = true;
            thread = new Thread(this);
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        }
    }
    
    public synchronized void stop() {
        if(running){
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    
    
    //--------------------------------------------
    // abstract method
    //--------------------------------------------
    
    public abstract void init();
    
    public abstract void update();
    
    public abstract void draw();
    
}
