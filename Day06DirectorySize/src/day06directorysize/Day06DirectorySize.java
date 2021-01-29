package day06directorysize;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JFileChooser;

public class Day06DirectorySize extends javax.swing.JFrame {

    public Day06DirectorySize() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();
        btChooseDir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTotalSize = new javax.swing.JLabel();
        lblTotalSizeRecursive = new javax.swing.JLabel();
        lblDirPath = new javax.swing.JLabel();

        FileChooser.setAcceptAllFileFilterUsed(false);
        FileChooser.setFileFilter(null);
        FileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btChooseDir.setText("Choose a directory ");
        btChooseDir.setName("btChooseDirectory"); // NOI18N
        btChooseDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChooseDirActionPerformed(evt);
            }
        });

        jLabel1.setText("Size of foles in this dir(in KB):");

        jLabel2.setText("Size of all files in this dir and all subdirectories(recursive):");

        lblTotalSize.setText("...");

        lblTotalSizeRecursive.setText("...");

        lblDirPath.setText("<html>..<html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btChooseDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblDirPath)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalSizeRecursive, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 426, Short.MAX_VALUE))
                            .addComponent(lblTotalSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btChooseDir)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTotalSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalSizeRecursive)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(lblDirPath, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btChooseDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChooseDirActionPerformed
        //We already set it to only show directories and disabled "accept all files" option
        if (FileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedDir = FileChooser.getSelectedFile();
            lblDirPath.setText(selectedDir.toString());
            lblDirPath.setText(selectedDir.toString());
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator(' ');
            DecimalFormat df = new DecimalFormat("###,###,###,###.0", symbols);
            // lblTotalSize.setText(String.format("%.1f KB",getDirSizeBytes(selectedDir)/1024.0d));
            lblTotalSize.setText(df.format(getDirSizeBytes(selectedDir) / 1024.0d) + " kB");
            lblTotalSizeRecursive.setText(df.format(getDirSizeBytesRecutsive(selectedDir) / 1024.0d) + " kB");
        }

    }//GEN-LAST:event_btChooseDirActionPerformed
    private long getDirSizeBytes(File dir) {
        long total = 0;
        File[] itemsList = dir.listFiles();
        for (File item : itemsList) {
            if (item.isFile()) {//because Java has another things so we check if it if file
                total += item.length();
            }
        }
        return total;
    }

    private long getDirSizeBytesRecutsive(File dir) {
        long total = 0;
        File[] itemsList = dir.listFiles();
        for (File item : itemsList) {
            if (item.isFile()) {//because Java has another things so we check if it if file
                total += item.length();
            }
            if (item.isDirectory()) {
                total += getDirSizeBytesRecutsive(item);
            }
        }
        return total;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Day06DirectorySize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day06DirectorySize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day06DirectorySize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day06DirectorySize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Day06DirectorySize().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JButton btChooseDir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblDirPath;
    private javax.swing.JLabel lblTotalSize;
    private javax.swing.JLabel lblTotalSizeRecursive;
    // End of variables declaration//GEN-END:variables
}
