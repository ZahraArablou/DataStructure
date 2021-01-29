
package day07thornyfractal;

import java.awt.Graphics;
import java.awt.Graphics2D;


public class ThormyFractal extends javax.swing.JPanel {

  
    public ThormyFractal() {
       // initComponents();
    }

     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2d=(Graphics2D) g.create();
        int x1=5;
        int y1=getHeight()-20;
        int x2=getWidth()-5;
        int y2=y1;
       
//        int x1t=x1+a;
//        int x2t=x1t+a;
//        int x3t=(x2+x1)/2;
//        int y3t=Math.abs(y1-((int) (a*Math.sqrt(3))/2));
        
//        g2d.drawLine(x1, y1, x2, y2);
//        g2d.drawLine(x1t,y1,x3t,y3t);
//        g2d.drawLine(x2t,y1,x3t,y3t);
        
        paintThormy( g2d, x1,y1, x2, y2);
        
    }private void  paintThormy(Graphics2D g2d,int x1,int y1,int x2,int y2){
        double dist = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

        if (dist < 10) {
            return;
        }
         int a=(x2-x1)/3;
         int x1t=x1+a;
        int x2t=x1t+a;
        int x3t=(x2+x1)/2;
        int y3t=Math.abs(y1-((int) (a*Math.sqrt(3))/2));
         g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x1t,y1,x3t,y3t);
        g2d.drawLine(x2t,y1,x3t,y3t);
           paintThormy( g2d, x1t,y1,x3t, y3t);
        paintThormy( g2d, x1,y1, x1+a, y2);
        paintThormy( g2d, x1+(2*a),y1, x2, y2);
      //  paintThormy( g2d, x1+a,y1,x3t, y3t);
        
        
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
