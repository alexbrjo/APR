package co.alexjo.pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

////////////////////////////////////////////////////////////////////////////////////////////////
public class Pong_1 extends Applet implements Runnable, KeyListener {

    static Image bacon;
    static Graphics dbg;
//Player1    
    int p1x; //x
    int p1y; //y
    boolean p1up;
    boolean p1down;
    boolean p1topwall;
    boolean p1bottemwall;
    int p1s = 0; //score
//Player 2     
    int p2x; //x
    int p2y; //y
    boolean p2up;
    boolean p2down;
    boolean p2topwall;
    boolean p2bottemwall;
    int p2s = 0; //score
//  court    
    int st1;
    int speed; // 3-13
    int angle; // 5
    int settime;
    boolean gameover;
    boolean whoserve;
    boolean first = true;
    boolean set = false;
    // start screen
    boolean setdone = false;
    int one41plyr = 1;
    int p1color;
    int p2color;
    // ball
    boolean cc;
    int sbx;
    int sby;
    boolean sbleftright;
    boolean sbupdown;
    int ch;
    int ballx;
    int bally;
    boolean serve;
    boolean updown;
    boolean ballmove;
    boolean balld;
    Font cat = new Font("Book Antiqua", Font.PLAIN, 20);
    Font kitty = new Font("Book Antiqua", Font.PLAIN, 200);
    Font kitten = new Font("Book Antiqua", Font.PLAIN, 12);

    public Pong_1() {
        super();
    }

    public void init() {
        setSize(800, 600);
        addKeyListener(this);
    }

    public void start() {

        Thread th = new Thread(this);
        th.start();
    }

    public void stop() {
    }

    public void destroy() {
    }

    public void run() {

        while (true) {

            if (gameover == false) {

                if (set == false) {


                    if (first == true) {
                        p1x = 20;
                        p1y = 270;

                        p2x = 760;
                        p2y = 270;

                        first = false;
                    }


                    if (p1s < p2s) {

                        speed = p1s + 3;

                    }
                    if (p1s > p2s) {

                        speed = p2s + 3;
                    }

                    if (p1s == p2s) {

                        speed = p2s + 3;
                    }


                    angle = (int) (Math.random() * 3);

                    if (whoserve == true) {
                        ballx = 395;
                        bally = 100 + (int) (Math.random() * 400);
                        balld = true;
                    }

                    if (whoserve == false) {
                        ballx = 395;
                        bally = 100 + (int) (Math.random() * 400);
                        balld = false;
                    }

                    serve = true;
                    set = true;
                }





//paddle bounderies for up and down---------
                if (p1y - 5 <= 0) {
                    p1topwall = true;
                }
                if (p1y + 65 >= 600) {
                    p1bottemwall = true;
                }
                if (p2y - 5 <= 0) {
                    p2topwall = true;
                }
                if (p2y + 65 >= 600) {
                    p2bottemwall = true;
                }



//moves paddles--------------------------  


                if (p1topwall == false) {
                    if (p1up == true) {
                        p1y -= 5;
                    }
                }

                if (p1bottemwall == false) {
                    if (p1down == true) {
                        p1y += 5;
                    }
                }


                if (one41plyr == 2) {
                    if (p2topwall == false) {
                        if (p2up == true) {
                            p2y -= 5;
                        }
                    }

                    if (p2bottemwall == false) {
                        if (p2down == true) {
                            p2y += 5;
                        }
                    }
                }


                if (one41plyr == 1) {



                    if (p2bottemwall == false) {
                        if (bally > p2y + 30) {
                            p2y += 2;
                        }
                    }

                    if (p2topwall == false) {
                        if (bally < p2y + 30) {
                            p2y -= 2;
                        }
                    }

                }
//bounces ball off wall-------------------------        


                if (bally >= 585) {

                    updown = !updown;
                }
                if (bally <= 15) {

                    updown = !updown;
                }


// moves ball up and down          


                if (updown == false) {

                    bally -= angle;
                }

                if (updown == true) {

                    bally += angle;
                }
                // moves title screenball               
                if (setdone == false) {

                    if (sbx >= 790) {
                        sbleftright = true;
                    }
                    if (sbx <= 0) {
                        sbleftright = false;
                    }
                    if (sby >= 590) {
                        sbupdown = true;
                    }
                    if (sby <= 0) {
                        sbupdown = false;
                    }

                    if (sbleftright == true) {
                        sbx--;

                    }
                    if (sbleftright == false) {
                        sbx++;

                    }
                    if (sbupdown == true) {
                        sby--;

                    }
                    if (sbupdown == false) {
                        sby++;

                    }
                }


//tells who scored

                if (ballx <= 0) {

                    set = false;
                    p2s++;
                    whoserve = false;
                }
                if (ballx >= 800) {

                    set = false;
                    p1s++;
                    whoserve = true;
                }

//tells if the ball hits the paddle-------------------------------

                if (ballx <= 45 & ballx >= 25 & bally >= p1y & bally <= p1y + 60) {

                    balld = true;
                    serve = false;
                    cc = true;

                }

                if (ballx >= 755 & ballx <= 775 & bally >= p2y & bally <= p2y + 60) {

                    balld = false;
                    serve = false;
                    cc = true;


                }

                //-------------// top paddle---------------------------------      
                if (ballx <= 45 & ballx >= 25 & bally >= p1y & bally <= p1y + 20) {

                    angle += 1;

                }

                if (ballx >= 755 & ballx <= 775 & bally >= p2y & bally <= p2y + 20) {

                    angle += 1;
                    serve = false;

                }

                //-------------// bottem paddle---------------------------------      
                if (ballx <= 45 & ballx >= 25 & bally >= p1y + 40 & bally <= p1y + 60) {

                    angle += 1;
                }

                if (ballx >= 755 & ballx <= 775 & bally >= p2y + 40 & bally <= p2y + 60) {

                    angle += 1;
                    serve = false;
                }
                //-------------// middle paddle---------------------------------      
                if (ballx <= 45 & ballx >= 22 & bally >= p1y + 20 & bally <= p1y + 40) {

                    angle -= 1;
                    serve = false;
                }

                if (ballx >= 755 & ballx <= 775 & bally >= p2y + 20 & bally <= p2y + 40) {

                    angle -= 1;
                    serve = false;
                }

//left/right of the ball------------------------              

                if (setdone == true) {
                    if (serve == false) {
                        if (balld == true) {
                            ballx += speed;
                        }

                        if (balld == false) {
                            ballx -= speed;
                        }
                    }


                    if (serve == true) {

                        if (balld == true) {
                            ballx += 2;
                        }

                        if (balld == false) {
                            ballx -= 2;
                        }

                    }
                }
// helps the ball speed

                if (angle >= 5) {
                    angle = 5;
                }


                p1topwall = false;
                p1bottemwall = false;
                p2topwall = false;
                p2bottemwall = false;

                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }

            }

        }
    }

    public void paint(Graphics g) {

        List<Neet> netline = new ArrayList<Neet>();

// net 
        for (int j = 0; j < 600; j += 40) {
            Neet n = new Neet(j);
            netline.add(n);

        }
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

        if (p1s == 10) {
            g.setColor(Color.WHITE);
            g.drawString("Player 1 wins", 300, 300);
            gameover = true;
        }

        if (p2s == 10) {
            g.setColor(Color.WHITE);
            g.drawString("Player 2 wins", 300, 300);
            gameover = true;
        }

        g.setColor(Color.white);

        if (setdone == false) {

            if (one41plyr == 1) {
                g.setFont(kitty);
                g.setColor(Color.red);
                g.drawString("PONG", 100, 210);
                g.setFont(cat);
                g.setColor(Color.red);
                g.drawString("1 player VS computer", 300, 280);
                g.setColor(Color.white);
                g.drawString("2 player", 300, 300);
                g.setColor(Color.white);
                g.drawString("1 player wallball", 300, 320);
                g.setColor(Color.white);
                g.drawString("Controls", 300, 340);
            }
            if (one41plyr == 2) {

                g.setFont(kitty);
                g.setColor(Color.green);
                g.drawString("PONG", 100, 210);
                g.setFont(cat);
                g.setColor(Color.white);
                g.drawString("1 player VS computer", 300, 280);
                g.setColor(Color.red);
                g.drawString("2 player", 300, 300);
                g.setColor(Color.white);
                g.drawString("1 player wallball", 300, 320);
                g.setColor(Color.white);
                g.drawString("Controls", 300, 340);
            }
            if (one41plyr == 3) {

                g.setFont(kitty);              
                g.setColor(Color.blue);
                g.drawString("PONG", 100, 210);
                g.setFont(cat);
                g.setColor(Color.white);
                g.drawString("1 player VS computer", 300, 280);
                g.setColor(Color.white);
                g.drawString("2 player", 300, 300);
                g.setColor(Color.red);
                g.drawString("1 player wallball", 300, 320);
                g.setColor(Color.white);
                g.drawString("Controls", 300, 340);
            }
            if (one41plyr == 4) {

                g.setFont(kitty);
                g.setColor(Color.yellow);
                g.drawString("PONG", 100, 210);
                g.setFont(cat);
                g.setColor(Color.white);
                g.drawString("1 player VS computer", 300, 280);
                g.setColor(Color.white);
                g.drawString("2 player", 300, 300);
                g.setColor(Color.white);
                g.drawString("1 player wallball", 300, 320);
                g.setColor(Color.red);
                g.drawString("Controls", 300, 340);
            }
        }

        if (setdone == false) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(sbx, sby, 10, 10);

        }

        if (setdone == true) {
            for (Neet n : netline) {
                n.paintNet(g);
            }

            g.setFont(cat);
            g.drawString("" + p1s, 350, 50);
            g.drawString("" + p2s, 450, 50);

            if (cc == true) {
                ch = (int) (Math.random() * 9);
                cc = false;
            }

        }
        // the balls color          
        if (ch == 0) {
            g.setColor(Color.red);
        }
        if (ch == 1) {
            g.setColor(Color.blue);
        }
        if (ch == 2) {
            g.setColor(Color.green);
        }
        if (ch == 3) {
            g.setColor(Color.yellow);
        }
        if (ch == 4) {
            g.setColor(Color.ORANGE);
        }
        if (ch == 5) {
            g.setColor(Color.CYAN);
        }
        if (ch == 6) {
            g.setColor(Color.MAGENTA);
        }
        if (ch == 7) {
            g.setColor(Color.PINK);
        }
        if (ch == 8) {
            g.setColor(Color.WHITE);
        }
        if (ch == 9) {
            g.setColor(Color.darkGray);
        }

        if (setdone == true) {
            g.fillRect(ballx - 5, bally - 5, 10, 10);

        }

        //      player one color
        if (p1color == 0) {
            g.setColor(Color.red);
        }
        if (p1color == 1) {
            g.setColor(Color.blue);
        }
        if (p1color == 2) {
            g.setColor(Color.green);
        }
        if (p1color == 3) {
            g.setColor(Color.yellow);
        }
        if (p1color == 4) {
            g.setColor(Color.ORANGE);
        }
        if (p1color == 5) {
            g.setColor(Color.CYAN);
        }
        if (p1color == 6) {
            g.setColor(Color.MAGENTA);
        }
        if (p1color == 7) {
            g.setColor(Color.PINK);
        }
        if (p1color == 8) {
            g.setColor(Color.WHITE);
        }
        if (p1color == 9) {
            g.setColor(Color.darkGray);
        }



        if (setdone == true) {
            g.fillRect(p1x, p1y, 20, 60);
        }
        if (setdone == false) {
            g.setFont(kitten);
            g.drawString("Player 1 color", 20, 370);
            g.fillRect(120, 430, 20, 60);
            g.drawRect(10, 350, 240, 240);
        }

        // player two color           
        if (p2color == 0) {
            g.setColor(Color.red);
        }
        if (p2color == 1) {
            g.setColor(Color.blue);
        }
        if (p2color == 2) {
            g.setColor(Color.green);
        }
        if (p2color == 3) {
            g.setColor(Color.yellow);
        }
        if (p2color == 4) {
            g.setColor(Color.ORANGE);
        }
        if (p2color == 5) {
            g.setColor(Color.CYAN);
        }
        if (p2color == 6) {
            g.setColor(Color.MAGENTA);
        }
        if (p2color == 7) {
            g.setColor(Color.PINK);
        }
        if (p2color == 8) {
            g.setColor(Color.WHITE);
        }
        if (p2color == 9) {
            g.setColor(Color.darkGray);
        }

        if (setdone == true) {
            g.fillRect(p2x, p2y, 20, 60);
        }
        if (setdone == false) {
            g.setFont(kitten);
            g.drawString("Player 2 color", 560, 370);
            g.fillRect(660, 430, 20, 60);
            g.drawRect(550, 350, 240, 240);
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

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {

        if (setdone == true) {

            if (e.getKeyChar() == 'w') {

                p1up = true;
            }

            if (e.getKeyChar() == 's') {

                p1down = true;

            }
            if (e.getKeyChar() == 'i') {

                p2up = true;
            }

            if (e.getKeyChar() == 'k') {

                p2down = true;

            }
        }


        if (setdone == false) {

            if (e.getKeyChar() == 'w') {
                p1color++;


            }

            if (p1color == 10) {
                p1color = 0;
            }

            if (e.getKeyChar() == 's') {

                p1color--;
                if (p1color == -1) {
                    p1color = 9;
                }
            }

            if (e.getKeyChar() == 'i') {
                p2color++;
                if (p2color == 10) {
                    p2color = 0;
                }
            }


            if (e.getKeyChar() == 'k') {

                p2color--;
                if (p2color == -1) {
                    p2color = 9;
                }
            }


            if (e.getKeyChar() == ' ') {
                one41plyr++;

                if (one41plyr == 5) {
                    one41plyr = 1;
                }
                if (one41plyr == 0) {
                    one41plyr = 4;
                }

            }
            if (e.getKeyChar() == 'd') {
                setdone = true;
            }

        }




    }

    public void keyReleased(KeyEvent e) {

        if (setdone == true) {

            if (e.getKeyChar() == 'w') {

                p1up = false;
            }

            if (e.getKeyChar() == 's') {

                p1down = false;

            }

            if (e.getKeyChar() == 'i') {

                p2up = false;
            }

            if (e.getKeyChar() == 'k') {

                p2down = false;

            }

        }

    }


}

class Neet {

    int x;
    int y;

    Neet(int j) {
        x = 398;
        y = j;

    }

    public void paintNet(Graphics g) {
        g.setColor(Color.white);
        g.clearRect(x, y, 4, 20);

    }
}
