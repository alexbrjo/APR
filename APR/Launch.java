package paneltest;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Launch {

    private final int frame_height = 600;
    private final int frame_width = 800;

    public static void main(String arg[]) {
        new Launch();
    }

    public Launch() {
        JFrame frame = new JFrame("Pong");
        frame.setBounds(0, 0, frame_width, frame_height);

        JPanel j = new JPanel();
        Mylistener ml = new Mylistener();
        frame.addKeyListener(ml);
        frame.getContentPane().add(new Pong(ml, frame_width, frame_height));

        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
