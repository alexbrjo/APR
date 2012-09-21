package paneltest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

public class Pong extends JComponent implements Runnable {

    Image bacon;
    Graphics dbg;
    Mylistener ml;
    Paddle p1;
    Paddle p2;
    Ball bl;
    
    private final int frame_height;
    private final int frame_width;

    public Pong(Mylistener ml,int h,int w) {
        super();
        startThread();
        this.ml = ml;
        this.frame_height = h;
        this.frame_width = w;
    }

    public void startThread() {
        Thread t = new Thread(this);
        t.start();
        System.out.print("Game Thread Started " + System.getProperty("line.separator"));
    }

    public void stop() {
    }

    public void destroy() {
    }

    @Override
    public void run() {
        p1 = new Paddle(50, 275, 5, 1, new String[]{"w", "s"}, 10, 50);
        p2 = new Paddle(750, 275, 5, 2, new String[]{"i", "k"}, 10, 50);
        bl = new Ball(getFrame_width(), getFrame_height(), 10, 10, 2);
        ml.setPaddles(p1, p2);
        while (true) {

            p1.move();
            p2.move();
            bl.move(p1, p2);
            repaint();

            try {
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException: " + ex);
            }
        }
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

        for (int j = 10; j < 610; j += 40) {
            g.setColor(Color.WHITE);
            g.fillRect(400, j, 4, 20);
        }
        p1.paint(g);
        p2.paint(g);
        bl.paint(g);
        
        g.drawString(""+ p1.getScore(), 300, 50);
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

    public int getFrame_height() {
        return frame_height;
    }
    public int getFrame_width() {
        return frame_width;
    }
}