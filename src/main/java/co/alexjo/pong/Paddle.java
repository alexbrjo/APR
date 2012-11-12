package co.alexjo.pong;

import java.awt.Graphics;

public class Paddle {

    private int x;
    private int y;
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
    private int FRAME_HEIGHT;
    private int FRAME_WIDTH;

    Paddle(int x, int y, int speed, int player, String[] keys, int width, int height, int FRAME_WIDTH, int FRAME_HEIGHT) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.keys = keys;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.paddle = new int[]{x, y, x + width, y + height};
        this.FRAME_WIDTH = FRAME_WIDTH;
        this.FRAME_HEIGHT = FRAME_HEIGHT;
    }

    public void paint(Graphics g) {
        g.fillRect(paddle[0], paddle[1], paddle[2] - paddle[0], paddle[3] - paddle[1]);
    }

    public void move() {
        if (up == true && getY() > 0) {
            setY(getY() - speed);
        }
        if (down == true && getY() < (FRAME_HEIGHT - height)) {
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

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

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
     * @return the FRAME_HEIGHT
     */
    public int getFRAME_HEIGHT() {
        return FRAME_HEIGHT;
    }

    /**
     * @return the FRAME_WIDTH
     */
    public int getFRAME_WIDTH() {
        return FRAME_WIDTH;
    }
}
