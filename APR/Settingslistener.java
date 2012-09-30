package Pong.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Settingslistener implements KeyListener{ 
    
    Launch l;
    
    public Settingslistener(Launch l){
       System.out.println("listening for x");
       this.l = l;
    }
 
    @Override 
    public void keyTyped(KeyEvent ke) {
    }

    @Override 
    public void keyPressed(KeyEvent ke) {
         if (ke.getKeyChar() == 'x') {
            System.out.println("x");
            l.pause();
        }
         
    }
    @Override 
    public void keyReleased(KeyEvent ke) {
    }
}
