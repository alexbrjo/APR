package co.alexjo.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

public class Pong extends JComponent implements Runnable {
    
    Image bacon;
    Graphics dbg;
    Listener l;
    boolean pause;
    Paddle p1;
    Paddle p2;
    Ball bl;
    private Boolean run = true;
    private final int FRAME_HEIGHT;
    private final int FRAME_WIDTH;

    public Pong(int w, int h, int paddleSize, Listener l) {
        super();
        this.FRAME_WIDTH = w;
        this.FRAME_HEIGHT = h;
        this.l = l;
        p1 = new Paddle(50, 275, 5, 1, new String[]{"w", "s"}, 10, paddleSize, getFRAME_WIDTH(), getFRAME_HEIGHT());
        p2 = new Paddle(750, 275, 5, 2, new String[]{"i", "k"}, 10, paddleSize, getFRAME_WIDTH(), getFRAME_HEIGHT());
        bl = new Ball(getFRAME_WIDTH() / 2, getFRAME_HEIGHT() / 2, 10, 10, 2, getFRAME_WIDTH(), getFRAME_HEIGHT());
        l.setPaddles(p1, p2);
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
                try {
                    bl.move(p1, p2);
                } catch (Exception ex) {
                    Logger.getLogger(Pong.class.getName()).log(Level.SEVERE, null, ex);
                }
                repaint();

            } else {
                repaint();
            }
            
            setRun(!l.isPause());

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
        g.fillRect(0, 0, getFRAME_WIDTH(), getFRAME_HEIGHT());

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

    public Boolean getRun() {
        return run;
    }

    public void setRun(Boolean run) {
        this.run = run;
    }

    public int getFRAME_HEIGHT() {
        return FRAME_HEIGHT;
    }

    public int getFRAME_WIDTH() {
        return FRAME_WIDTH;
    }

}