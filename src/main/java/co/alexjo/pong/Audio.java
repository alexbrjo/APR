package co.alexjo.pong;

import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio { 
    
    static Clip goal;
    static Clip hit;
    static Clip wall;

    public Audio() throws Exception {
        goal = makeClip(getClass().getResourceAsStream("/huh.wav"));
        hit = makeClip(getClass().getResourceAsStream("/ping.wav"));
        wall = makeClip(getClass().getResourceAsStream("/ding.wav"));
    }
    
    private Clip makeClip(InputStream a) throws Exception{
        
        AudioInputStream sound = AudioSystem.getAudioInputStream(a);
        DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
        Clip clip = (Clip) AudioSystem.getLine(info);

        clip.open(sound);

        clip.addLineListener(
                new LineListener() {

                    @Override
                    public void update(LineEvent event) {
                        if (event.getType() == LineEvent.Type.STOP) {
                            event.getLine().close();
                            //System.exit(0);
                        }
                    }
                });
        return clip;
    }
    
    public static void goal() throws Exception{
        Audio a = new Audio();
        a.goal.start();
    }
    public static void hit() throws Exception{
        Audio a = new Audio();
        a.hit.start();
    }
    public static void wall() throws Exception{
        Audio a = new Audio();
        a.wall.start();
    }
}