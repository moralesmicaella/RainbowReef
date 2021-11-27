
package RainbowReef;

import RainbowReef.Graphics.Util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author micaellamorales
 */
public class ScoreBoard {
    private ArrayList<Integer> scores;
    private final String scoresFile;
    
    public ScoreBoard(String scoresFile){
        scores = new ArrayList();
        this.scoresFile = scoresFile;
    }
    
    /**
     *  This function stores the scores from the file in an array list. 
     *  The list is then sorted from highest to lowest scores
     */
    public void loadScores(){
        scores = Util.loadFile(scoresFile);
        Collections.sort(scores);
        Collections.reverse(scores);
    }
    
    /**
     *  This function stores/appends the score into the text file.  
     * 
     * @param score 
     */
    public void storeScore(int score){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(scoresFile, true));
            writer.append(String.valueOf(score));
            writer.append("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        loadScores();
    }
    
    public void draw(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(220, 100, 350, 400);
        
        Font font = new Font("SansSerif", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Score Board", 270, 150);
        
        int x = 270;
        int y = 180;
        String score;
        for(int i = 0; i < scores.size(); i++){
            if(i<10){
                score = String.valueOf(i+1) + ". " + String.valueOf(scores.get(i));
                g.drawString(score, x, y+(i*25));
            }
        }
    }
    
    
}
