package Pong;

import java.awt.Graphics;

public class Paddle {

    int x;
    int y;
    int player;
    String[] keys;
    private boolean up;
    private boolean down;
    private int[] paddle;
    /* paddle[]
     *      [0] x top side
     *      [1] y left side
     *      [2] x bottom side
     *      [3] y right side
     */
    boolean topwall;
    boolean bottomwall;
    private int height;
    private int width;
    private int speed;
    private int score;

    Paddle(int x, int y, int speed, int player, String[] keys, int width, int height) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.keys = keys;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.paddle = new int[]{x, y, x + width, y + height};
    }

    public void paint(Graphics g) {
        g.fillRect(paddle[0], paddle[1], paddle[2] - paddle[0], paddle[3] - paddle[1]);
    }

    public void move() {
        if (up == true) {
            y -= speed;
        }
        if (down == true) {
            y += speed;
        }
        paddle = new int[]{x, y, x + width, y + height};
    }

    public Boolean contact(int[] ball) {
        if (checkSides(ball, paddle)) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean checkSides(int[] ball, int[] paddle) {
        if (ball[1] >= paddle[1] && ball[3] <= paddle[3] && ball[0] >= paddle[0] && ball[2] <= paddle[2]) {
            return true;
        }
        if (ball[3] >= paddle[1] && ball[1] <= paddle[3] && ball[2] >= paddle[0] && ball[0] <= paddle[2]) {
            return true;
        }
        return false;
    }

//////////////////////////////////////////gettas and settas///////////////////////////////////////////////////
    /**
     * @return the up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * @param up the up to set
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * @return the down
     */
    public boolean isDown() {
        return down;
    }

    /**
     * @param down the down to set
     */
    public void setDown(boolean down) {
        this.down = down;
    }

    /**
     * @return the paddle
     */
    public int[] getPaddle() {
        return paddle;
    }

    /**
     * @param paddle the paddle to set
     */
    public void setPaddle(int[] paddle) {
        this.paddle = paddle;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
}
