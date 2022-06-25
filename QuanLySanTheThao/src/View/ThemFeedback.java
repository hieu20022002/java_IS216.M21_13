/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ConnectDB.ConnectionUtils;
import Process.Feedback;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author minhh
 */
public class ThemFeedback extends javax.swing.JFrame {

    /**
     * Creates new form ThemFeedback
     */
    ImageIcon star_white;
    ImageIcon star_yellow;
    ImageIcon iconAngry;
    ImageIcon iconCare;
    ImageIcon iconLove;
    ImageIcon iconHaha;
    ImageIcon iconLike;
    ImageIcon iconSad;
    
    public ThemFeedback() {
        initComponents();
        this.setLocationRelativeTo(null);
        star_white = new ImageIcon("src/Resources/star_white.png");
        star_yellow = new ImageIcon("src/Resources/star_yellow.png");
        iconAngry = new ImageIcon("src/Resources/angry.png");
        iconCare = new ImageIcon("src/Resources/care.png");
        iconLove = new ImageIcon("src/Resources/love.png");
        iconLike = new ImageIcon("src/Resources/like.png");
        iconHaha = new ImageIcon("src/Resources/haha.png");
        iconSad = new ImageIcon("src/Resources/sad.png");
        jLabelEmotion.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelEmotion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rank1 = new javax.swing.JRadioButton();
        rank2 = new javax.swing.JRadioButton();
        rank3 = new javax.swing.JRadioButton();
        rank4 = new javax.swing.JRadioButton();
        rank5 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        NhanXet = new javax.swing.JTextPane();
        Submit = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        GhiChu = new javax.swing.JTextPane();
        jPanelTitle = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabelLogOut = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEmotion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEmotion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/angry.png"))); // NOI18N
        jPanel1.add(jLabelEmotion, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 460, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/MucDanhGia.png"))); // NOI18N
        jLabel3.setText("Mức đánh giá");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 372, -1, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 199, -1, -1));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Nhanxet.png"))); // NOI18N
        jLabel6.setText("Nhận xét");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 187, -1, -1));

        buttonGroup2.add(rank1);
        rank1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/star_white.png"))); // NOI18N
        rank1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rank1MouseClicked(evt);
            }
        });
        jPanel1.add(rank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 360, -1, -1));

        buttonGroup2.add(rank2);
        rank2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/star_white.png"))); // NOI18N
        rank2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rank2MouseClicked(evt);
            }
        });
        jPanel1.add(rank2, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 360, -1, -1));

        buttonGroup2.add(rank3);
        rank3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/star_white.png"))); // NOI18N
        rank3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rank3MouseClicked(evt);
            }
        });
        jPanel1.add(rank3, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 360, -1, -1));

        buttonGroup2.add(rank4);
        rank4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/star_white.png"))); // NOI18N
        rank4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rank4MouseClicked(evt);
            }
        });
        jPanel1.add(rank4, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 360, -1, -1));

        buttonGroup2.add(rank5);
        rank5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/star_white.png"))); // NOI18N
        rank5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rank5MouseClicked(evt);
            }
        });
        jPanel1.add(rank5, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 360, -1, -1));

        jScrollPane2.setViewportView(NhanXet);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 168, 315, 66));

        Submit.setBackground(new java.awt.Color(153, 204, 255));
        Submit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icon_confirm.png"))); // NOI18N
        Submit.setText("Gửi");
        Submit.setPreferredSize(new java.awt.Dimension(94, 30));
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        jPanel1.add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 576, -1, -1));

        cancel.setBackground(new java.awt.Color(224, 187, 228));
        cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icon_exit.png"))); // NOI18N
        cancel.setText("Hủy");
        cancel.setPreferredSize(new java.awt.Dimension(94, 30));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 576, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ghiChu.png"))); // NOI18N
        jLabel7.setText("Ghi chú");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 288, -1, -1));

        jScrollPane3.setViewportView(GhiChu);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 279, 203, 33));

        jPanelTitle.setBackground(new java.awt.Color(170, 233, 229));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/feedback.png"))); // NOI18N
        jLabel46.setText("ĐÁNH GIÁ");

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel46)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 74));

        jLabelLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logout.png"))); // NOI18N
        jLabelLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogOutMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 605, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Sự góp ý của bạn là bài học để chúng tôi cải thiện tốt hơn! ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   String cusID= "";
   void setCusID(String customerID){
       cusID = customerID;
   }
    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        //String cusID = maKh.getText();
        int rank;
        String Evaluation = NhanXet.getText();
        String Note = GhiChu.getText();
        if (cusID == "") {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng\n");
        } else {
            String r;

            if (rank1.isSelected()) {
                r = "Rất không hài lòng";
                rank = 1;
            } else if (rank2.isSelected()) {
                r = "Không hài lòng";
                rank = 2;
            } else if (rank3.isSelected()) {
                r = "Bình thường";
                rank = 3;
            } else if (rank4.isSelected()) {
                r = "Hài lòng";
                rank = 4;
            } else if (rank5.isSelected()) {
                r = "Rất hài lòng";
                rank = 5;
            } else {
                rank = 0;
                    JOptionPane.showMessageDialog(this, "Vui chọn mức đánh giá!",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (rank != 0) {
                String s1 = "Cảm ơn quý khách đã đánh giá!\nĐánh giá của bạn:\n";
                try {
                    Connection conn = ConnectionUtils.getMyConnection();
                    String sql = "SELECT CUSTOMERNAME FROM CUSTOMER WHERE CUSTOMERID='" + cusID + "'";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        String tenKH = rs.getString(1);
                        Feedback f = new Feedback();
                        int cont = f.themFeedBack(cusID, rank, Evaluation, Note);
                        if (cont == 1) {
                            String s2 = "Tên khách hàng: " + tenKH + "\nMức đánh giá: " + rank + "\nNhận xét: " + Evaluation + "\nGhi chú: " + Note;
                            String disp = s1 + s2;
                            JOptionPane.showMessageDialog(this, disp);
                            this.dispose();
                        } else if (cont == 0) {
                            JOptionPane.showMessageDialog(this, "Insert không thành công!",
                                    "Lỗi insert CSDL", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Mã khách hàng không tồn tại\n");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ThemFeedback.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ThemFeedback.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        
       
    }//GEN-LAST:event_SubmitActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        if(rank3.isSelected()==true){
            System.out.println("3 sao duoc chon");
        }
    }//GEN-LAST:event_cancelActionPerformed

    private void rank4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rank4MouseClicked
        // TODO add your handling code here:
        rank1.setIcon(star_yellow);
        rank2.setIcon(star_yellow);
        rank3.setIcon(star_yellow);
        rank4.setIcon(star_yellow);
        rank5.setIcon(star_white);
        
        jLabelEmotion.setIcon(iconCare);
        jLabelEmotion.setText("Hài lòng!");
        jLabelEmotion.setVisible(true);
    }//GEN-LAST:event_rank4MouseClicked

    private void rank5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rank5MouseClicked
        // TODO add your handling code here:
        rank1.setIcon(star_yellow);
        rank2.setIcon(star_yellow);
        rank3.setIcon(star_yellow);
        rank4.setIcon(star_yellow);
        rank5.setIcon(star_yellow);
        jLabelEmotion.setIcon(iconLove);
        jLabelEmotion.setText("Rất hài lòng!");
        jLabelEmotion.setVisible(true);

    }//GEN-LAST:event_rank5MouseClicked

    private void rank3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rank3MouseClicked
        // TODO add your handling code here:
        rank1.setIcon(star_yellow);
        rank2.setIcon(star_yellow);
        rank3.setIcon(star_yellow);
        rank4.setIcon(star_white);
        rank5.setIcon(star_white);
        jLabelEmotion.setIcon(iconLike);
        jLabelEmotion.setText("Bình thường!");
        jLabelEmotion.setVisible(true);
    }//GEN-LAST:event_rank3MouseClicked

    private void rank2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rank2MouseClicked
        // TODO add your handling code here:
        rank1.setIcon(star_yellow);
        rank2.setIcon(star_yellow);
        rank3.setIcon(star_white);
        rank4.setIcon(star_white);
        rank5.setIcon(star_white);
        jLabelEmotion.setIcon(iconSad);
        jLabelEmotion.setText("Chưa hài lòng!");
        jLabelEmotion.setVisible(true);
    }//GEN-LAST:event_rank2MouseClicked

    private void rank1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rank1MouseClicked
        // TODO add your handling code here:
        rank1.setIcon(star_yellow);
        rank2.setIcon(star_white);
        rank3.setIcon(star_white);
        rank4.setIcon(star_white);
        rank5.setIcon(star_white);
        jLabelEmotion.setIcon(iconAngry);
        jLabelEmotion.setText("Chất lượng tệ!");
        jLabelEmotion.setVisible(true);
    }//GEN-LAST:event_rank1MouseClicked

    private void jLabelLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogOutMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabelLogOutMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ThemFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemFeedback().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane GhiChu;
    private javax.swing.JTextPane NhanXet;
    private javax.swing.JButton Submit;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelEmotion;
    private javax.swing.JLabel jLabelLogOut;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JRadioButton rank1;
    private javax.swing.JRadioButton rank2;
    private javax.swing.JRadioButton rank3;
    private javax.swing.JRadioButton rank4;
    private javax.swing.JRadioButton rank5;
    // End of variables declaration//GEN-END:variables
}
