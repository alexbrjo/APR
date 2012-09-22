package Pong;

import Pong.gui.SettingsGUI;
import java.awt.Color;
import javax.swing.JFrame;

public class Launch {

    private final int frame_height = 600;
    private final int frame_width = 800;
    JFrame frame;
    SettingsGUI settingsGUI;
    Mylistener ml = new Mylistener();
    private Boolean twoPlayer = true;
    private int scoreToWin = 10;
    private int paddleSize = 50;
    private Color color1 = Color.WHITE;
    private Color color2 = Color.WHITE;

    public static void main(String arg[]) {
        new Launch();
    }

    public Launch() {
        frame = new JFrame("Pong");        
        frame.setBounds(0, 0, frame_width, frame_height);
        doIt("gui");
    }

    public void doIt(String to) {
        frame.dispose();
        frame = new JFrame("Pong"); 
        frame.getContentPane().removeAll();

        if (to.equals("gui")) {
            settingsGUI = new SettingsGUI(this);
            frame.add(settingsGUI);
        } else if (to.equals("pong")) {
            
            frame.addKeyListener(ml);
            frame.add(new Pong(ml, frame_width, frame_height, paddleSize));
        }
        
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
}
