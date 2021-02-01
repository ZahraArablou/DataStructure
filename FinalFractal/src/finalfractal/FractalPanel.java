
package finalfractal;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class FractalPanel extends javax.swing.JPanel {

  
    public FractalPanel() {
        //  initComponents();
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
        int distx = (x2 - x1) / 2;
        int disty = (y3 - y1) / 2;

        int distSmallx = (x2 - x1) / 4;
        int distSmally = (y3 - y1) / 4;
        if (distx < 5) {
            return;
        }
        int xTemp=x1 + distSmallx;
        int yTemp=y1 + distSmally;

        g2d.drawLine(x1 + distx, y1, x1, y1 + disty);
        g2d.drawLine(x1, y1 + disty, x3 + distx, y3);
        g2d.drawLine(x3 + distx, y3, x2, y1 + disty);
        g2d.drawLine(x2, y1 + disty, x1 + distx, y1);

        g2d.drawLine(xTemp, y1, xTemp, yTemp);
        g2d.drawLine(xTemp, yTemp, xTemp, yTemp);
        g2d.drawLine(xTemp, yTemp, x1, yTemp);

        g2d.drawLine(x2 - distSmallx, y1, x2 - distSmallx, yTemp);
        g2d.drawLine(x2 - distSmallx, yTemp, x2, yTemp);

        g2d.drawLine(x4, y4 - distSmally, x4 - distSmallx, y4 - distSmally);
        g2d.drawLine(x4 - distSmallx, y4 - distSmally, x4 - distSmallx, y4);

        g2d.drawLine(x3, y3 - distSmally, x3 + distSmallx, y3 - distSmally);
        g2d.drawLine(x3 + distSmallx, y3 - distSmally, x3 + distSmallx, y3);

        paintSquare(g2d, x1, y1, xTemp, y1, x1, yTemp, xTemp, yTemp);
        paintSquare(g2d, x2 - distSmallx, y1, x2, y2, x2 - distSmallx, yTemp, x2, yTemp);
        paintSquare(g2d, x4 - distSmallx, y4 - distSmally, x4, y4 - distSmally, x4 - distSmallx, y4, x4, y4);
        paintSquare(g2d, x3, y3 - distSmally, x3 + distSmallx, y3 - distSmally, x3, y3, x3 + distSmallx, y3
    

    );

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
