package Pong.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

class Preview extends JComponent implements Runnable {

    Image bacon;
    Graphics dbg;

    public Preview() {
    }

    public void run() {
        repaint();
        try {
            Thread.sleep(25);
        } catch (InterruptedException ex) {
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

        for (int j = 10; j < 610; j += 40) {
            g.setColor(Color.WHITE);
            g.fillRect(400, j, 4, 20);
        }

    }
        
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
}
