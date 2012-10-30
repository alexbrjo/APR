package Pong.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Settingslistener implements KeyListener{ 
    
    Launch l = null;
    Applet a = null;
    
    public Settingslistener(Launch l){
       System.out.println("listening for x");
       this.l = l;
    }

    public Settingslistener(Applet a) {
       System.out.println("listening for x");
       this.a = a;
    }
 
    @Override 
    public void keyTyped(KeyEvent ke) {
    }

    @Override 
    public void keyPressed(KeyEvent ke) {
         if (ke.getKeyChar() == 'x') {
            System.out.println("x");
            pause();
        }
         
    }
    @Override 
    public void keyReleased(KeyEvent ke) {
    }

    private void pause() {
       if(l != null){
           l.pause();
       }
       if(a != null){
           a.pause();
       }
    }
}
