package co.alexjo.pong.audio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

public enum Sound {

    NULL("null"),
    PING("co/alexjo/pong/efx/hit1.wav"),
    DING("co/alexjo/pong/efx/hit2.wav"),
    SONG() {

        public String getPath() {
            String classPath = "co.alexjo.pong.audio.*";
            
            Collection<String> files = CPFiles.getClassPathResources(".*");
            ArrayList<String> filePaths = new ArrayList<String>();
            
            for(String path: files){
                if(path.endsWith(".wav") && path.contains("/audio/")){
                    filePaths.add(path);
                    System.out.println(path);
                }
            }
        
            return filePaths.get((int)(Math.random()*(filePaths.size())-1));
        }
    };
    
    private String path;
    Sound() {
    }

    Sound(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
