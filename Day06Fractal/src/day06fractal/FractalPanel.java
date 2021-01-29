
package day06fractal;

import java.awt.Graphics;
import java.awt.Graphics2D;


public class FractalPanel extends javax.swing.JPanel {

   
    public FractalPanel() {
       // initComponents();
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
           g2d.drawLine(10,10,getWidth()-10,10);
            
drawFractal(g2d, 10, getWidth()-10, getHeight()/10, getHeight()/10);
     
    }
    private void drawFractal(Graphics2D g2d, int startX, int endX, int Y,int stepY){
        int width=endX-startX;
        if(width<3)return;
        //2.draws the two lines
        Y+=stepY;
        g2d.drawLine(startX, Y,startX+ width/3, Y);
        g2d.drawLine(endX-width/3, Y,endX, Y);
        //3.make two recursive calls,one for each line you just drew
        drawFractal(g2d, startX, startX+width/3, Y, stepY);
         drawFractal(g2d, endX-width/3, endX, Y, stepY);
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
