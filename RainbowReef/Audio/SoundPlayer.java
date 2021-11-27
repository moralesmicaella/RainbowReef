
package RainbowReef.Audio;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/**
 *
 * @author micaellamorales
 */
public class SoundPlayer {
    private Clip clip;
    private boolean mute;
    
    
    
    //---------------------------------------------
    // accessor and mutator methods
    //---------------------------------------------

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }
    
    
    public void play(boolean continuous, String soundFile){
        try{
            mute = false;
            AudioInputStream soundStream = AudioSystem.getAudioInputStream(new File(soundFile));
            clip = AudioSystem.getClip();
            clip.open(soundStream);
            clip.start();
            if(continuous){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } 
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e);
        }
    }
    
    public void stop(){
        clip.stop();
    }
    
    
}
