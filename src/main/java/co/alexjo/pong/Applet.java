/*package co.alexjo.pong;

import java.awt.Color;
import javax.swing.JApplet;



public class Applet extends JApplet {

    private int frame_height = 600;
    private int frame_width = 800;
    Listener l = new Listener();
    Pong game;
    
    private Boolean twoPlayer = true;
    private int scoreToWin = 10;
    private int paddleSize = 100;
    private Color color1 = Color.WHITE;
    private Color color2 = Color.WHITE;
     
   @Override
   public void init() {
        this.setSize(frame_width, frame_height);
        this.setBounds(0, 0, frame_width, frame_height);
        this.getContentPane().removeAll();
            
        game = new Pong(getFrame_width(), getFrame_height(), paddleSize, l);
        this.add(game);
        
        this.setVisible(true);
        this.setSize(frame_width, frame_height);
      //this.setResizable(false);
      //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    public Boolean getTwoPlayer() {
        return twoPlayer;
    }

    public void setTwoPlayer(Boolean twoPlayer) {
        this.twoPlayer = twoPlayer;
    }

    public int getScoreToWin() {
        return scoreToWin;
    }

    public void setScoreToWin(int scoreToWin) {
        this.scoreToWin = scoreToWin;
    }

    public int getPaddleSize() {
        return paddleSize;
    }

    public void setPaddleSize(int paddleSize) {
        this.paddleSize = paddleSize;
    }

    public Color getColor1() {
        return color1;
    }


    public void setColor1(Color color1) {
        this.color1 = color1;
    }


    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }


    public int getFrame_height() {
        return frame_height;
    }


    public void setFrame_height(int frame_height) {
        this.frame_height = frame_height;
    }


    public int getFrame_width() {
        return frame_width;
    }


    public void setFrame_width(int frame_width) {
        this.frame_width = frame_width;
    }


}
*/

