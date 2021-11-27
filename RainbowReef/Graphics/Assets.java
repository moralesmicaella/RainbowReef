
package RainbowReef.Graphics;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author micaellamorales
 */
public class Assets {
    public static BufferedImage katch, pop, bg1, bigleg,
            wall, block1, block2, block3, block4, block5, 
            block6, block7, blockLife, blockSolid, blockBomb, 
            menuButton, helpButton, startButton, quitButton, scoreButton, 
            mainButton, playButton, score, life, mechanics;
    
    public static void init(){
        try {
            katch = ImageIO.read(new FileInputStream("Resources/Katch.png"));
            pop = ImageIO.read(new FileInputStream("Resources/Pop.png")); 
            bg1 = ImageIO.read(new FileInputStream("Resources/Background1.png")); 
            bigleg = ImageIO.read(new FileInputStream("Resources/Bigleg.png")); 
            
            wall = ImageIO.read(new FileInputStream("Resources/wall.png")); 
            block1 = ImageIO.read(new FileInputStream("Resources/Block1.png")); 
            block2 = ImageIO.read(new FileInputStream("Resources/Block2.png")); 
            block3 = ImageIO.read(new FileInputStream("Resources/Block3.png")); 
            block4 = ImageIO.read(new FileInputStream("Resources/Block4.png")); 
            block5 = ImageIO.read(new FileInputStream("Resources/Block5.png")); 
            block6 = ImageIO.read(new FileInputStream("Resources/Block6.png")); 
            block7 = ImageIO.read(new FileInputStream("Resources/Block7.png")); 
            blockLife = ImageIO.read(new FileInputStream("Resources/Block_life.png")); 
            blockSolid = ImageIO.read(new FileInputStream("Resources/Block_solid.png")); 
            blockBomb = ImageIO.read(new FileInputStream("Resources/Block_bomb.png")); 
            
            menuButton = ImageIO.read(new FileInputStream("Resources/Title.png")); 
            helpButton =  ImageIO.read(new FileInputStream("Resources/Button_help.png")); 
            startButton = ImageIO.read(new FileInputStream("Resources/Button_start.png")); 
            quitButton = ImageIO.read(new FileInputStream("Resources/Button_quit.png")); 
            scoreButton = ImageIO.read(new FileInputStream("Resources/Button_scores.png")); 
            mainButton = ImageIO.read(new FileInputStream("Resources/Button_main.png")); 
            playButton  = ImageIO.read(new FileInputStream("Resources/Button_play.png")); 
            
            score = ImageIO.read(new FileInputStream("Resources/score.png")); 
            life =  ImageIO.read(new FileInputStream("Resources/heart.png")); 
            mechanics = ImageIO.read(new FileInputStream("Resources/mechanics.png")); 
        } 
        catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
