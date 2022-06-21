/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


/**
 *
 * @author Duc Tai
 */
public class XacNhanThanhToan extends javax.swing.JFrame {

    /**
     * Creates new form XacNhanThanhToan
     */
    public XacNhanThanhToan() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jMK = new javax.swing.JPasswordField();
        jbtXacNhan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Vui lòng nhập mật khẩu");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jMK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 150, -1));

        jbtXacNhan.setBackground(new java.awt.Color(155, 209, 167));
        jbtXacNhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icon_confirm.png"))); // NOI18N
        jbtXacNhan.setText("Xác nhận");
        jbtXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtXacNhanActionPerformed(evt);
            }
        });
        jPanel1.add(jbtXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/password.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String billID="";
    String userName="";
    private boolean kiemTraMK(String user_Name){
        boolean check=false;
        try(Connection conn= ConnectionUtils.getMyConnection()){
            String sql = "SELECT * " +
                            "FROM USER_ACCOUNT " +
                            "WHERE username='"+user_Name+"' AND USER_PASSWORD = '"+jMK.getText()+"'";
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String mkDB="";
            if(rs.next()){
                mkDB = rs.getString("USER_PASSWORD");
       
            }
            if(mkDB.isBlank()==true){
                JOptionPane.showMessageDialog(rootPane, "Sai mật khẩu!");
            }else if(jMK.getText().isBlank()==true){
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập mật khẩu!");
            }else if(mkDB.isBlank()==false){
                check = true;
            }
   
                rs.close();
                ps.close();
                conn.close();

            
   
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        return check;
    }
    
    private void jbtXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtXacNhanActionPerformed
        // TODO add your handling code here:
        if(kiemTraMK(userName)==false){
            //JOptionPane.showMessageDialog(rootPane, "Sai mật khẩu!");
        
        }else{
            int respone = JOptionPane.showConfirmDialog(rootPane, "Xác nhận thanh toán", "Xác nhận", 
                                          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respone == JOptionPane.YES_OPTION){
                //String billID = (String) tableHD.getValueAt(jTableHD.getSelectedRow(), 0);
                try(Connection conn = ConnectionUtils.getMyConnection()){
                    String sql = "UPDATE SCHEDULE " +
                                    "SET paymentstatus='Đã thanh toán' " +
                                    "WHERE BOOKID IN(SELECT DISTINCT BOOKID FROM SCHEDULEDETAILS WHERE BILLID='"+billID+"')";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    if(ps.executeUpdate()>0){
                        JOptionPane.showMessageDialog(rootPane, "Thanh toán thành công!");
                        ps.close();
                        conn.close();
                        ThanhToan t = new ThanhToan();
                        t.setThongTin(userName);
                        t.setVisible(true);
                        t.toFront();
                        this.dispose();
                        
                        
                    }    
                   

                }catch(Exception e){
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jbtXacNhanActionPerformed

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
            java.util.logging.Logger.getLogger(XacNhanThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XacNhanThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XacNhanThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XacNhanThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XacNhanThanhToan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jMK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtXacNhan;
    // End of variables declaration//GEN-END:variables
}
