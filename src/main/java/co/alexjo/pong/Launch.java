package co.alexjo.pong;

import co.alexjo.pong.game.Pong;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Launch {

    private int FRAME_HEIGHT = 600,
        FRAME_WIDTH = 800,
        paddleSize = 100;
    
    JFrame frame;
    Pong pong;
    KeyBoard kb = new KeyBoard();

    public Launch() {
        JOptionPane.showMessageDialog(frame, "Left paddle: w, s \nRight paddle: i, k"); 
        frame = new JFrame("Pong");        
        frame.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        frame.getContentPane().removeAll();
            
        frame.addKeyListener(kb);
        pong = new Pong(FRAME_WIDTH, FRAME_HEIGHT, paddleSize, kb);
        frame.add(pong);
        
        frame.setVisible(true);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String arg[]) {
        new Launch();
    }
}