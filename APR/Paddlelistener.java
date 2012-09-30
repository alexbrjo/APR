package Pong.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddlelistener implements KeyListener{ 
    
    Paddle p1;
    Paddle p2;
    
    public Paddlelistener(){
       System.out.println("listening");
    }

    public void setPaddles(Paddle p1, Paddle p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public void move(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            p1.setUp(true);
        }
        if (e.getKeyChar() == 's') {
            p1.setDown(true);
        }
        if (e.getKeyChar() == 'i') {
            p2.setUp(true);
        }
        if (e.getKeyChar() == 'k') {
            p2.setDown(true);
        }
    }

    void stop(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            p1.setUp(false);
        }
        if (e.getKeyChar() == 's') {
            p1.setDown(false);
        }
        if (e.getKeyChar() == 'i') {
            p2.setUp(false);
        }
        if (e.getKeyChar() == 'k') {
            p2.setDown(false);
        }
    }
 
    @Override 
    public void keyTyped(KeyEvent ke) {
    }

    @Override 
    public void keyPressed(KeyEvent ke) {
         move(ke);
    }

    @Override 
    public void keyReleased(KeyEvent ke) {
        stop(ke);
    }
}
