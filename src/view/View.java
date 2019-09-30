/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import model.Board;

/**
 *
 * @author Gitta Szabo
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    private Board board;
    private Controller controller;
    private JToggleButton[] buttons;
    private int size;
    private JToggleButton pressed;
    private static final Color CBLUE = new Color(0, 60, 168);
    private static final Color CRED = new Color(199, 18, 50);

    public View(Controller controller, Board board) {

        initComponents();

        setLocationRelativeTo(null);
        setTitle("Five in a row");

        this.board = board;
        this.controller = controller;
        size = board.getSize();

        pnlBoard.setLayout(new GridLayout(size, size));

        buttons = new JToggleButton[size * size];
        for (int i = 0; i < size * size; i++) {
            JToggleButton button = new JToggleButton();
            button.setName(i + "");
            button.setBorder(new LineBorder(Color.DARK_GRAY));
            Font font = new Font("Arial", Font.BOLD, 360 / size);
            button.setFont(font);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pressed = (JToggleButton) e.getSource();
                    controller.makeMove(Integer.parseInt(pressed.getName()));
                }
            }
            );
            buttons[i] = button;
            pnlBoard.add(button);
        }
    }

    public void mark(String player) {
        if (pressed.getText().equals("")) {
            pressed.setText(player);
            if ("X".equals(player)) {
                pressed.setForeground(CBLUE);
            } else {
                pressed.setForeground(CRED);
            }
        }
    }

    public void showWinner() {
        JOptionPane.showMessageDialog(rootPane, board.getPlayer() + " has won!",
                "End of game", JOptionPane.INFORMATION_MESSAGE);
    }

    public void isDraw() {
        JOptionPane.showMessageDialog(rootPane, "No more possible moves; the game is draw!",
                "End of game", JOptionPane.INFORMATION_MESSAGE);
    }

    public void reset() {
        for (JToggleButton b : buttons) {
            if ("X".equals(b.getText()) || "O".equals(b.getText())) {
                b.setText("");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBoard = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miTen = new javax.swing.JMenuItem();
        miFifteen = new javax.swing.JMenuItem();
        miTwenty = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBoard.setLayout(new java.awt.GridLayout(20, 20));

        jMenu1.setText("New Game");

        miTen.setText("10 x 10");
        miTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTenActionPerformed(evt);
            }
        });
        jMenu1.add(miTen);

        miFifteen.setText("15 x 15");
        miFifteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFifteenActionPerformed(evt);
            }
        });
        jMenu1.add(miFifteen);

        miTwenty.setText("20 x 20");
        miTwenty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTwentyActionPerformed(evt);
            }
        });
        jMenu1.add(miTwenty);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTenActionPerformed
        controller.newGame(10);
    }//GEN-LAST:event_miTenActionPerformed

    private void miTwentyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTwentyActionPerformed
        controller.newGame(20);
    }//GEN-LAST:event_miTwentyActionPerformed

    private void miFifteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFifteenActionPerformed
        controller.newGame(15);
    }//GEN-LAST:event_miFifteenActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miFifteen;
    private javax.swing.JMenuItem miTen;
    private javax.swing.JMenuItem miTwenty;
    private javax.swing.JPanel pnlBoard;
    // End of variables declaration//GEN-END:variables

}