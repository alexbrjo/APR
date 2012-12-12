package co.alexjo.pong.audio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Audio{ 
    
    public Audio(){
        music(Sound.SONG);
    }

    public void music(Sound s){  
        if(s != Sound.NULL){
        String path = s.getPath();
        
        AudioPlayer player = AudioPlayer.player;  
        AudioStream stream;   
  
        try{             
            stream = new AudioStream(getClass().getResourceAsStream("/"+path));     
            player.start(stream);
        }catch (IOException e){  
            System.err.println("File not found: IO");
        } catch (NullPointerException n){            
            System.err.println("File not found: null");  
        }  
        
        }
    }   
}