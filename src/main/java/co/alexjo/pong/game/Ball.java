package co.alexjo.pong.game;

import co.alexjo.pong.audio.Sound;
import java.awt.Graphics;

public class Ball {

    private int x;
    private int y;
    private int drawx;
    private int drawy;
    private int height;
    private int width;
    private double volx;
    private double voly;
    private int speed = 2;

    public Ball(int x, int y, int width, int height, int vol) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.volx = vol;
        this.voly = vol;
    }

    public void move(Paddle p1, Paddle p2){

        boolean p1con = p1.contact(x, y);
        boolean p2con = p2.contact(x, y);

        if (p2con) {
            bounce(p2);
            volx = -(Math.abs(volx));
        } else if (p1con) {
            bounce(p1);
            volx = (Math.abs(volx));
        }

        if (y >= 580) {
            Pong.playSound(Sound.PING);
            voly = -(Math.abs(voly));
        } else if (y <= 0) {
            Pong.playSound(Sound.PING);
            voly = (Math.abs(voly));
        }


        x += volx;
        y += voly;

        int b = outOfBounds(p1, p2);// score thing
        if (b != -1) {
            Pong.playSound(Sound.DING);
            x = 400;
            y = 300;
            if (b == 1) {
                p1.setScore(p1.getScore() + 1);
            } else if (b == 2) {
                p2.setScore(p2.getScore() + 1);
            }
        }
        drawx = x - (height / 2);
        drawy = y - (height / 2);

    }

    private void bounce(Paddle p){
        Pong.playSound(Sound.DING);
        int contactPoint = (p.getY() + (p.getHeight() / 2)) - y;
        if (contactPoint > (p.getY() + (p.getHeight() / 3)) && contactPoint < (p.getY() + (2 * (p.getHeight() / 3)))) {
            voly--;
            volx++;
            if (voly < 0) {
                voly = 0;
            }
        } else {
            voly++;
        }
        System.out.println("Vol:"+(Math.abs(voly)+Math.abs(volx))+" y: "+voly+" x: "+volx);
    }

    private int outOfBounds(Paddle p1, Paddle p2) {
        if (this.x  > Pong.FRAME_WIDTH || this.x < 0) {
            if (this.x > Pong.FRAME_WIDTH) {
                return 1;
            } else if (this.x + 10 < 0) {
                return 2;
            }
        }
        return -1;
    }

    public void paint(Graphics g) {
        g.fillRect(drawx, drawy, width, height);
    }

//////////////////////////////gettas and settas//////////////////////////////////////////////////////
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getVolx() {
        return volx;
    }
    public void setVolx(double volx) {
        this.volx = volx;
    }
    public double getVoly() {
        return voly;
    }
    public void setVoly(double voly) {
        this.voly = voly;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}