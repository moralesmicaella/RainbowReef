
package RainbowReef.Player;


/**
 *
 * @author micaellamorales
 */
public class Player {
    private final Katch katch;
    private final Pop pop;
    
    private int points;
    private final LivesCount livesCount;

    public Player(Katch katch, Pop pop) {
        this.katch = katch;
        this.pop = pop;
        
        points = 0;
        livesCount = new LivesCount();
    }

    public int getPoints() {
        return points;
    }
    
    public void addPoints(int points){
        this.points += points;
        System.out.println(this.points);
    }

    public LivesCount getLivesCount() {
        return livesCount;
    }
    
    public int getNumLife() {
        return livesCount.getNumLife();
    }

    public void setNumLife(int life) {
        livesCount.setNumLife(life);
    }
    
    public void loseLife(){
        livesCount.subtractLife();
    }
    
    public void addLife(){
        livesCount.addLife();
    }
    
    public void update(){
        katch.update();
        pop.update();
    }
    
}
