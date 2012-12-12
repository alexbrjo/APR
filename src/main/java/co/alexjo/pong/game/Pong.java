package co.alexjo.pong.game;

import co.alexjo.pong.audio.Audio;
import co.alexjo.pong.audio.Sound;
import co.alexjo.pong.gui.*;
import co.alexjo.pong.KeyBoard;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

public class Pong extends JComponent implements Runnable {

    Image bacon;
    Graphics dbg;
    KeyBoard kb;
    Audio a;
    Paddle p1;
    Paddle p2;
    Ball bl;
    Screen s = null;
    public static Sound e = Sound.NULL;
    public static int FRAME_HEIGHT;
    public static int FRAME_WIDTH;

    public Pong(int w, int h, int paddleSize, KeyBoard kb) {
        super();
        this.FRAME_WIDTH = w;
        this.FRAME_HEIGHT = h;
        this.kb = kb;
        p1 = new Paddle(50, 275, 5, 1, new char[]{'w', 's'}, 10, paddleSize);
        p2 = new Paddle(750, 275, 5, 2, new char[]{'i', 'k'}, 10, paddleSize);
        bl = new Ball(FRAME_WIDTH / 2, FRAME_HEIGHT / 2, 10, 10, 3);
        this.a = new Audio();
        startThread();
    }

    public void startThread() {
        Thread t = new Thread(this);
        t.start();
        System.out.println("Thread Started");
    }

    @Override
    public void run() {
        while (true) {

            if (s == null) {
                p1.move(KeyBoard.W, KeyBoard.S);
                p2.move(KeyBoard.I, KeyBoard.K);
                bl.move(p1, p2);
            }

            playSound();
           
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException: " + ex);
            }

        }
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        for (int j = 10; j < 610; j += 40) {
            g.setColor(Color.WHITE);
            g.fillRect(400, j, 4, 20);
        }

        p1.paint(g);
        p2.paint(g);
        bl.paint(g);

        g.drawString("" + p1.getScore(), 300, 50);
        g.drawString("" + p2.getScore(), 500, 50);

    }

    @Override
    public void update(Graphics g) {

        if (bacon == null) {

            bacon = createImage(this.getSize().width, this.getSize().height);
            dbg = bacon.getGraphics();
        }

        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);


        dbg.setColor(getForeground());
        paint(dbg);


        g.drawImage(bacon, 0, 0, this);

    }

    static void playSound(Sound s) {
        Pong.e = s;
    }
    private void playSound(){
        a.music(e);
        e = Sound.NULL;
    }
}