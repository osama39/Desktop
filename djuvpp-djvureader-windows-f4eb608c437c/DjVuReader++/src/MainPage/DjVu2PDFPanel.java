/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPage;

import PDF2DjVu.DjVU2TIF;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author salah Ben Atwa
 */
public class DjVu2PDFPanel extends javax.swing.JPanel {

    /**
     * Creates new form DjVu2PDFPanel
     */
    String fullPDF = null;
    //convert djvu to pdf
    FileDialog djvuFileSelectDialog = null;
    FileDialog DjVu2pdf = null;
    String djvuSelectFullPath = null;
    String newPDFFullPath = null;

    public DjVu2PDFPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bar = new javax.swing.JLabel();
        DjVuPDF = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Convert DjVu To PDF", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BAR.gif"))); // NOI18N
        jPanel1.add(bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, 20));
        bar.setVisible(false);

        DjVuPDF.setBackground(new java.awt.Color(102, 0, 204));
        DjVuPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DjVu to P 48.png"))); // NOI18N
        DjVuPDF.setToolTipText("Select Your DjVu");
        DjVuPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DjVuPDF.setOpaque(false);
        DjVuPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DjVuPDFActionPerformed(evt);
            }
        });
        jPanel1.add(DjVuPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 80, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Select Your DjVu");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Convert Djvu Into PDF");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 140, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/white with blue.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 100));

        add(jPanel1);
        jPanel1.setBounds(0, 0, 150, 100);
    }// </editor-fold>//GEN-END:initComponents

    private void DjVuPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DjVuPDFActionPerformed
        // TODO add your handling code here:
        bar.setVisible(true);

        try {
            djvuFileSelectDialog = new FileDialog(new java.awt.Frame(), "Select DjVu", FileDialog.LOAD);
            djvuFileSelectDialog.setVisible(true);
           djvuFileSelectDialog. setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/DjvuIcon.png")));
            djvuSelectFullPath = djvuFileSelectDialog.getDirectory() + djvuFileSelectDialog.getFile();
            if (djvuFileSelectDialog.getFile() != null) {

                String Djvupath = "\"" + djvuSelectFullPath + "\""; // skip spaces 
                String d = djvuSelectFullPath.substring(djvuSelectFullPath.lastIndexOf("."));
                d = d.toLowerCase();
                int s = 1;
                if (d.equals(".djvu")) {
                    DjVu2pdf = new FileDialog(new java.awt.Frame(), "Save PDF", FileDialog.SAVE);
                    DjVu2pdf.setVisible(true);
                    newPDFFullPath = DjVu2pdf.getDirectory() + DjVu2pdf.getFile();

                    if (DjVu2pdf.getFile() != null) {
                        //String Pdfsave = "\"" + newPDFFullPath + "\""; // skip spaces 
                        DjVU2TIF.convertDjvu2PDF(Djvupath, newPDFFullPath, s);

                    } else {
                        djvuSelectFullPath = null;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "File selected is not Djvu");
                    djvuSelectFullPath = null;
                }

            }

        } catch (Exception ex) {
        } finally {
            File write = new File("C:\\DjVu++Task\\tiffff.tif");
            if (write.exists()) {
                write.delete();
            }
            bar.setVisible(false);
        }


    }//GEN-LAST:event_DjVuPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DjVuPDF;
    private javax.swing.JLabel bar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}