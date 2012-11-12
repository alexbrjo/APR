package co.alexjo.pong;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Launch {

    private int FRAME_HEIGHT = 600;
    private int FRAME_WIDTH = 800;
    
    JFrame frame;
    Pong game;
    Listener l = new Listener();

    private int paddleSize = 100;

    public static void main(String arg[]) {
        new Launch();
    }

    public Launch() {
        JOptionPane.showMessageDialog(frame, "Left paddle: w, s \nRight paddle: i, k"); 
        frame = new JFrame("Pong");        
        frame.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        frame.getContentPane().removeAll();
            
        frame.addKeyListener(l);
        game = new Pong(FRAME_WIDTH, FRAME_HEIGHT, paddleSize, l);
        frame.add(game);
        
        frame.setVisible(true);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}