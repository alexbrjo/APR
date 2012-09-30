package Pong.game;

import com.sun.tools.apt.Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.media.j3d.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JComponent;

public class Pong extends JComponent implements Runnable {

    Image bacon;
    Graphics dbg;
    Paddlelistener pl;
    Paddle p1;
    Paddle p2;
    Ball bl;
    private Boolean run = true;
    private int frame_height;
    private int frame_width;

    public Pong(Paddlelistener pl, int h, int w, int paddleSize) {
        super();
        this.pl = pl;
        this.frame_height = h;
        this.frame_width = w;
        p1 = new Paddle(50, 275, 5, 1, new String[]{"w", "s"}, 10, paddleSize);
        p2 = new Paddle(750, 275, 5, 2, new String[]{"i", "k"}, 10, paddleSize);
        bl = new Ball(getFrame_height() / 2, getFrame_width() / 2, 10, 10, 2);
        pl.setPaddles(p1, p2);
        startThread();
    }

    public void startThread() {
        Thread t = new Thread(this);
        t.start();
        System.out.println("Thread Started");
    }

    /*public void sound() {
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/path/to/sounds/" + url));
        clip.open(inputStream);
        clip.start();
    }*/

    @Override
    public void run() {
        while (true) {
            if (getRun()) {

                p1.move();
                p2.move();
                bl.move(p1, p2);
                repaint();

            } else {
                repaint();
            }



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
        g.fillRect(0, 0, getFrame_height(), getFrame_width());

        for (int j = 10; j < 610; j += 40) {
            g.setColor(Color.WHITE);
            g.fillRect(400, j, 4, 20);
        }

        if (!getRun()) {
            g.drawString("PAUSED", 400, 300);
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
//////////////////////////////////////////////////////////////////////////////////////////

    public int getFrame_height() {
        return frame_height;
    }

    public int getFrame_width() {
        return frame_width;
    }

    /**
     * @return the run
     */
    public Boolean getRun() {
        return run;
    }

    /**
     * @param run the run to set
     */
    public void setRun(Boolean run) {
        this.run = run;
    }

    /**
     * @param frame_height the frame_height to set
     */
    public void setFrame_height(int frame_height) {
        this.frame_height = frame_height;
    }

    /**
     * @param frame_width the frame_width to set
     */
    public void setFrame_width(int frame_width) {
        this.frame_width = frame_width;
    }
}