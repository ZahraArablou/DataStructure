package day06trianglefactal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TriangleFactalPanel extends javax.swing.JPanel {

    private Color[] colorArray
            = {
                new Color(255, 90, 90),
                new Color(90, 255, 90),
                new Color(90, 90, 255)};

    public TriangleFactalPanel() {
        // initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2d = (Graphics2D) g.create();
        int x1 = 5, y1 = getHeight() - 5;
        int x2 = getWidth() - 5, y2 = getHeight() - 5;
        int x3 = (x1 + x2) / 2, y3 = 5;
        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x1, y1, x3, y3);
        g2d.drawLine(x3, y3, x2, y2);
        paintTriangle(g2d, x1, y1, x2, y2, x3, y3, 0);
    }

    void paintTriangle(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3, int level) {
        double dist = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

        if (dist < 20) {
            return;
        }
        if(level>2)level=0;
        int x13m = (x3 + x1) / 2;
        int y13m = (y1 + y3) / 2;
        int x23m = (x2 + x3) / 2;
        int y23m = (y1 + y3) / 2;
        int x12m = (x2 + x1) / 2;
g2d.setColor(colorArray[level++]);
        g2d.drawLine(x13m, y13m, x23m, y13m);//top
        g2d.drawLine(x12m, y1, x23m, y23m);//right
        g2d.drawLine(x12m, y1, x13m, y23m);//left
        
        paintTriangle(g2d, x13m, y13m, x23m, y23m, x3, y3, level);
        paintTriangle(g2d, x1, y1, x12m, y1, x13m, y13m, level);
        paintTriangle(g2d, x12m, y1, x2, y2, x23m, y23m, level);
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
