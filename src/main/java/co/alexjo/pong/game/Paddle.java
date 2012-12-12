package co.alexjo.pong.game;

import java.awt.Graphics;

public class Paddle {

    private int x;
    private int y;
    int player;
    char[] keys;
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

    Paddle(int x, int y, int speed, int player, char[] keys, int width, int height) {
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

    public void move(boolean up, boolean down) {
        setUp(up);
        setDown(down);
        if (isUp() == true && getY() > 0) {
            setY(getY() - speed);
        }
        if (isDown() == true && getY() < (Pong.FRAME_HEIGHT - height)) {
            setY(getY() + speed);
        }
        paddle = new int[]{getX(), getY(), getX() + getWidth(), getY() + getHeight()};
    }

    public boolean contact(int bx, int by) {
        if (checkSides(bx, by, paddle)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkSides(int bx, int by, int[] paddle) {
        if (by >= paddle[1] && by <= paddle[3] && bx >= paddle[0] && bx <= paddle[2]) {
            return true;
        }
        if (by >= paddle[1] && by <= paddle[3] && bx >= paddle[0] && bx <= paddle[2]) {
            return true;
        }

        return false;
    }

//////////////////////////////////////////gettas and settas///////////////////////////////////////////////////
    public boolean isUp() {
        return up;
    }
    public void setUp(boolean up) {
        this.up = up;
    }
    public boolean isDown() {
        return down;
    }
    public void setDown(boolean down) {
        this.down = down;
    }
    public int[] getPaddle() {
        return paddle;
    }
    public void setPaddle(int[] paddle) {
        this.paddle = paddle;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
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
}
