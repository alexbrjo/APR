package Pong.game;

import java.awt.Color;
import javax.swing.JApplet;



public class Applet extends JApplet {

    private int frame_height = 600;
    private int frame_width = 800;
    
    Paddlelistener pl = new Paddlelistener();
    Settingslistener sl = new Settingslistener(this);
    Pong game;
    
    private Boolean twoPlayer = true;
    private int scoreToWin = 10;
    private int paddleSize = 100;
    private Color color1 = Color.WHITE;
    private Color color2 = Color.WHITE;
     
    public void init() {
        this.setSize(frame_width, frame_height);
        this.setBounds(0, 0, frame_width, frame_height);
        this.getContentPane().removeAll();
            
        this.addKeyListener(pl);
        this.addKeyListener(sl);
        game = new Pong(pl, getFrame_width(), getFrame_height(), paddleSize);
        this.add(game);
        
        this.setVisible(true);
        this.setSize(frame_width, frame_height);
        //this.setResizable(false);
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
 
 
    public void pause(){
        game.setRun(!game.getRun());
    }

    public void setDefaults() {
        setTwoPlayer((Boolean) true);
        setScoreToWin(10);
        setPaddleSize(50);
        setColor1(Color.WHITE);
        setColor2(Color.WHITE);
    }

//////////////////////////////////////////////////////////////////////////////////////////
    /**
     * @return the twoPlayer
     */
    public Boolean getTwoPlayer() {
        return twoPlayer;
    }

    /**
     * @param twoPlayer the twoPlayer to set
     */
    public void setTwoPlayer(Boolean twoPlayer) {
        this.twoPlayer = twoPlayer;
    }

    /**
     * @return the scoreToWin
     */
    public int getScoreToWin() {
        return scoreToWin;
    }

    /**
     * @param scoreToWin the scoreToWin to set
     */
    public void setScoreToWin(int scoreToWin) {
        this.scoreToWin = scoreToWin;
    }

    /**
     * @return the paddleSize
     */
    public int getPaddleSize() {
        return paddleSize;
    }

    /**
     * @param paddleSize the paddleSize to set
     */
    public void setPaddleSize(int paddleSize) {
        this.paddleSize = paddleSize;
    }

    /**
     * @return the color1
     */
    public Color getColor1() {
        return color1;
    }

    /**
     * @param color1 the color1 to set
     */
    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    /**
     * @return the color2
     */
    public Color getColor2() {
        return color2;
    }

    /**
     * @param color2 the color2 to set
     */
    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    /**
     * @return the frame_height
     */
    public int getFrame_height() {
        return frame_height;
    }

    /**
     * @param frame_height the frame_height to set
     */
    public void setFrame_height(int frame_height) {
        this.frame_height = frame_height;
    }

    /**
     * @return the frame_width
     */
    public int getFrame_width() {
        return frame_width;
    }

    /**
     * @param frame_width the frame_width to set
     */
    public void setFrame_width(int frame_width) {
        this.frame_width = frame_width;
    }


}


