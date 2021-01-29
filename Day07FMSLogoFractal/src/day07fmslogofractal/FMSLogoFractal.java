package day07fmslogofractal;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class FMSLogoFractal extends javax.swing.JPanel {

    public FMSLogoFractal() {
        // initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2d = (Graphics2D) g.create();
        int x1 = 10, y1 = 10;

        int x2 = getWidth() - 10, y2 = 10;
        int x3 = x1;
        int y3 = getHeight() - 10;
        int x4 = x2, y4 = y3;
        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x1, y1, x3, y3);
        g2d.drawLine(x2, y2, x4, y4);
        g2d.drawLine(x3, y3, x4, y4);
        paintSquare(g2d, x1, y1, x2, y2, x3, y3, x4, y4);
    }

    void paintSquare(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int distx = (x2 - x1) / 5;
        int disty = (y3 - y1) / 5;
        if (distx < 10) {
            return;
        }

        g2d.drawLine(x1 + distx * 2, y2, x1 + distx * 2, y1 + disty * 2);
        g2d.drawLine(x3, y1 + disty * 2, x1 + distx * 2, y1 + disty * 2);

        g2d.drawLine(x1 + (distx * 3), y2, x1 + (distx * 3), y1 + disty * 2);
        g2d.drawLine(x1 + (distx * 3), y1 + disty * 2, x2, y1 + disty * 2);

        g2d.drawLine(x1 + (distx * 3), y1 + disty * 3, x2, y1 + disty * 3);
        g2d.drawLine(x1 + (distx * 3), y1 + disty * 3, x1 + (distx * 3), y4);

        g2d.drawLine(x1 + distx * 2, y2 + disty * 3, x1, y2 + disty * 3);
        g2d.drawLine(x1 + distx * 2, y2 + disty * 3, x1 + distx * 2, y4);
        
        paintSquare(g2d, x1, y1, x1 + distx * 2,  y2, x1,  y1 + disty * 2, x1 + distx * 2, y1 + disty * 2);
        paintSquare(g2d,x1 + (distx * 3), y1,  x2,  y2, x1 + (distx * 3), y1 + disty * 2, x2, y1 + disty * 2);
        paintSquare( g2d, x1, y1 + disty * 3, x1 + distx * 2,y1 + disty * 3,  x3,  y3, x1 + distx * 2, y4);
        paintSquare( g2d, x1 + (distx * 3), y1 + disty * 3,  x2,y1 + disty * 3, x1 + (distx * 3), y3,  x4,  y4);

//        paintSquare(g2d, x1 + (distx * 2), y2, x1 + (distx * 2), y1 + (disty * 2), x3, y1 + (disty * 2), x1 + (distx * 2), y1 + (disty * 2));
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
