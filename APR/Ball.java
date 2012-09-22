package Pong;

import java.awt.Graphics;

public class Ball {

    private int x;
    private int y;
    private int height;
    private int width;
    private int[] ball;
     /* ball[]
     *      [0] x top side
     *      [1] y left side
     *      [2] x bottom side
     *      [3] y right side
    */
    private int volx;
    private int voly;
    private int speed = 2;
    double angle;

    public Ball(int x, int y, int width, int height, int vol) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.ball = new int[] {x,y,x+width,y+height};
        this.volx = vol;
        this.voly = vol;
    }

    public void move(Paddle p1, Paddle p2) {

        if (p2.contact(ball) == true) {
            volx = -volx;
        } else if (p1.contact(ball) == true) {
            volx = -volx;
        }

        if (ball[3] >= 580) {
            voly = -voly;
        } else if (ball[1] <= 0) {
            voly = -voly;
        }
        x += volx;
        y += voly;

        int b = outOfBounds(p1,p2);
        if (b != -1) {
            x = 400;
            y = 300;
            if(b == 1){
                p1.setScore(p1.getScore()+1);
            }else if(b == 2){
                p2.setScore(p2.getScore()+1);
            }
        }
        
        ball = new int[] {x,y,x + width,y + height};

    }

    private int outOfBounds(Paddle p1, Paddle p2) {
        if (this.x > 800 || this.x < 0) {
            if(this.x > 800){
                return 1;
            }else if(this.x < 0){
                return 2;
            }
        }
        return -1;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, width, height);
    }

//////////////////////////////gettas and settas//////////////////////////////////////////////////////
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the volx
     */
    public int getVolx() {
        return volx;
    }

    /**
     * @param volx the volx to set
     */
    public void setVolx(int volx) {
        this.volx = volx;
    }

    /**
     * @return the voly
     */
    public int getVoly() {
        return voly;
    }

    /**
     * @param voly the voly to set
     */
    public void setVoly(int voly) {
        this.voly = voly;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}