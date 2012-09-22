package Pong.gui;

import Pong.Launch;
import java.awt.Color;
import javax.swing.JPanel;

public class SettingsGUI extends JPanel {

    Launch l;
    
    public SettingsGUI(Launch launch) {
        initComponents();
        l = launch;
        l.setDefaults();
        preview.add(new Preview());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        gameLogic = new javax.swing.JComboBox();
        players = new javax.swing.JCheckBox();
        scoreToWin = new javax.swing.JSpinner();
        paddleSize = new javax.swing.JSlider();
        color1 = new javax.swing.JComboBox();
        color2 = new javax.swing.JComboBox();
        startGame = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        preview = new javax.swing.JPanel();

        org.jdesktop.layout.GroupLayout jFrame1Layout = new org.jdesktop.layout.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jFrame2Layout = new org.jdesktop.layout.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel1.setText("Pong Settings");

        gameLogic.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Simple", "Advanced", "Custom" }));

        players.setSelected(true);
        players.setText("2 player");
        players.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playersActionPerformed(evt);
            }
        });

        paddleSize.setMinimum(20);
        paddleSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                paddleSizeStateChanged(evt);
            }
        });

        color1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Black", "Blue", "Red", "Green", "White", "Yellow" }));
        color1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color1ActionPerformed(evt);
            }
        });

        color2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Black", "Blue", "Red", "Green", "White", "Yellow" }));
        color2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color2ActionPerformed(evt);
            }
        });
        color2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                color2PropertyChange(evt);
            }
        });

        startGame.setText("Start!");
        startGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout previewLayout = new org.jdesktop.layout.GroupLayout(preview);
        preview.setLayout(previewLayout);
        previewLayout.setHorizontalGroup(
            previewLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 558, Short.MAX_VALUE)
        );
        previewLayout.setVerticalGroup(
            previewLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 560, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jSeparator1)
                        .add(color2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(color1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(paddleSize, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 127, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(startGame)
                        .add(players, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(scoreToWin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(gameLogic, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(preview, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(preview, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(players)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(scoreToWin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(31, 31, 31)
                        .add(paddleSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(color1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(color2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(39, 39, 39)
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(gameLogic, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 226, Short.MAX_VALUE)
                        .add(startGame)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void color2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color2ActionPerformed
        if(color2.getSelectedItem().equals("Blue")){
            l.setColor2(Color.BLUE);
        }else if(color2.getSelectedItem().equals("Red")){
            l.setColor2(Color.RED);
        }else if(color2.getSelectedItem().equals("Green")){
            l.setColor2(Color.GREEN);
        }else if(color2.getSelectedItem().equals("Yellow")){
            l.setColor2(Color.YELLOW);
        }else if(color2.getSelectedItem().equals("Black")){
            l.setColor2(Color.BLACK);
        }else if(color2.getSelectedItem().equals("White")){
            l.setColor2(Color.WHITE);
        }
    }//GEN-LAST:event_color2ActionPerformed

    private void color2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_color2PropertyChange
    }//GEN-LAST:event_color2PropertyChange

    private void playersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playersActionPerformed
        l.setTwoPlayer(players.isSelected());
    }//GEN-LAST:event_playersActionPerformed

    private void color1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color1ActionPerformed
        if(color1.getSelectedItem().equals("Blue")){
            l.setColor1(Color.BLUE);
        }else if(color1.getSelectedItem().equals("Red")){
            l.setColor1(Color.RED);
        }else if(color1.getSelectedItem().equals("Green")){
            l.setColor1(Color.GREEN);
        }else if(color1.getSelectedItem().equals("Yellow")){
            l.setColor1(Color.YELLOW);
        }else if(color1.getSelectedItem().equals("Black")){
            l.setColor1(Color.BLACK);
        }else if(color1.getSelectedItem().equals("White")){
            l.setColor1(Color.WHITE);
        }
    }//GEN-LAST:event_color1ActionPerformed

    private void startGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameActionPerformed
        removeAll();
        revalidate();
        repaint();
        this.removeAll();
        l.doIt("pong");
    }//GEN-LAST:event_startGameActionPerformed

    private void paddleSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_paddleSizeStateChanged
        l.setPaddleSize(paddleSize.getValue()); 
    }//GEN-LAST:event_paddleSizeStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox color1;
    private javax.swing.JComboBox color2;
    private javax.swing.JComboBox gameLogic;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider paddleSize;
    private javax.swing.JCheckBox players;
    private javax.swing.JPanel preview;
    private javax.swing.JSpinner scoreToWin;
    private javax.swing.JButton startGame;
    // End of variables declaration//GEN-END:variables
}
