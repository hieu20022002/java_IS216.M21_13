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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        maKh = new javax.swing.JTextField();
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

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelEmotion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEmotion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/angry.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ID-San.png"))); // NOI18N
        jLabel2.setText("Mã khách hàng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/MucDanhGia.png"))); // NOI18N
        jLabel3.setText("Mức đánh giá");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Nhanxet.png"))); // NOI18N
        jLabel6.setText("Nhận xét");

        buttonGroup2.add(rank1);
        rank1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/star_white.png"))); // NOI18N
        rank1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rank1MouseClicked(evt);
            }
        });

        buttonGroup2.add(rank2);
        rank2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/star_white.png"))); // NOI18N
        rank2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rank2MouseClicked(evt);
            }
        });

        buttonGroup2.add(rank3);
        rank3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/star_white.png"))); // NOI18N
        rank3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rank3MouseClicked(evt);
            }
        });

        buttonGroup2.add(rank4);
        rank4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/star_white.png"))); // NOI18N
        rank4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rank4MouseClicked(evt);
            }
        });

        buttonGroup2.add(rank5);
        rank5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/star_white.png"))); // NOI18N
        rank5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rank5MouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(NhanXet);

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ghiChu.png"))); // NOI18N
        jLabel7.setText("Ghi chú");

        jScrollPane3.setViewportView(GhiChu);

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

        jLabelLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logout.png"))); // NOI18N
        jLabelLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogOutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogOut)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(maKh, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(146, 146, 146)
                        .addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(rank1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rank2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rank3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rank4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rank5))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabelEmotion)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel6))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addComponent(jLabel7))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rank5)
                                .addComponent(rank3)
                                .addComponent(rank4)
                                .addComponent(rank2)
                                .addComponent(rank1)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabelEmotion)
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLogOut)
                        .addContainerGap())))
        );

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
   
    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        String cusID=maKh.getText();
        int rank;
        String Evaluation = NhanXet.getText();
        String Note =GhiChu.getText();
        if(cusID==""){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng\n");            
        }
        else{
            String r;
            
            if(rank1.isSelected()){
                r ="Rất không hài lòng";
                rank=1;
            }
            else if(rank2.isSelected()){
                r ="Không hài lòng";
                rank=2;
            }
            else if(rank3.isSelected()){
                r ="Bình thường";
                rank=3;
            }
            else if(rank4.isSelected()){
                r ="Hài lòng";
                rank =4;
            }
            else{
                r ="Rất hài lòng";
                rank=5;
            }
            String s1= "Cảm ơn quý khách đã đánh giá!\nĐánh giá của bạn:\n";
            try {
                Connection conn = ConnectionUtils.getMyConnection();
                String sql="SELECT CUSTOMERNAME FROM CUSTOMER WHERE CUSTOMERID='"+cusID+"'";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String tenKH=rs.getString(1);
                    Feedback f = new Feedback();
                    int cont=f.themFeedBack(cusID, rank,Evaluation ,Note);
                    if(cont==1){
                    String s2= "Name: "+tenKH+"\nMức đánh giá: "+rank+"\nNhận xét: "+Evaluation+"\nGhi chú"+Note;
                    String disp=s1+s2;
                    JOptionPane.showMessageDialog(this, disp);
                    }
                    else if(cont==0){
                                    JOptionPane.showMessageDialog(this, "Insert không thành công!",
                    "Lỗi insert CSDL", JOptionPane.ERROR_MESSAGE);
                    }

                }
                else{
                    JOptionPane.showMessageDialog(this, "Mã khách hàng không tồn tại\n");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ThemFeedback.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThemFeedback.class.getName()).log(Level.SEVERE, null, ex);
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
        this.toBack();
        setVisible(false);
        new ManHinhChinh_KhachHang().toFront();
        new ManHinhChinh_KhachHang().setState(java.awt.Frame.NORMAL);
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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField maKh;
    private javax.swing.JRadioButton rank1;
    private javax.swing.JRadioButton rank2;
    private javax.swing.JRadioButton rank3;
    private javax.swing.JRadioButton rank4;
    private javax.swing.JRadioButton rank5;
    // End of variables declaration//GEN-END:variables
}
