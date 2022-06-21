/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import ConnectDB.ConnectionUtils;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Duc Tai
 */
public class HoaDon extends javax.swing.JFrame {
    DefaultTableModel tableHoaDon;
    /**
     * Creates new form HoaDon
     */
    public HoaDon() {
        initComponents();
        tableHoaDon = (DefaultTableModel) jTableHoaDon.getModel();
        this.setLocationRelativeTo(null);
        
    }
    
     void setThongTinKhachHang(String customerID){
        try(Connection conn = ConnectionUtils.getMyConnection()){
            String sql = "Select CUSTOMERNAME, CUSTOMERTEL FROM CUSTOMER WHERE CUSTOMERID ='"+customerID+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, customerID);
            ResultSet rs= ps.executeQuery();
            
            
            String customerName="";
            String customerTel ="";
            if(rs.next()){
                customerName = rs.getString("CUSTOMERNAME");
                customerTel = rs.getString("CUSTOMERTEL");
            }
            jLabelTenKhachHang.setText(customerName);
            jLabelMaKhachHang.setText(customerID);
            jLabelSDT.setText(customerTel);
            
            rs.close();
            ps.close();
            conn.close();
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
       
        ArrayList<Integer> giaTienDoUong =  new ArrayList<>();
        ArrayList<Integer> giaTienDungCu =  new ArrayList<>();
        ArrayList<Integer> giaTienSan = new ArrayList<>();
        
        ArrayList<String> tenSan = new ArrayList<>();
        ArrayList<String> tenDungCu = new ArrayList<>();
        ArrayList<String> tenDoUong = new ArrayList<>();
    private void layGiaTien(ArrayList<String> maDoUongDuocChon, ArrayList<String> maDungCuDuocChon,
                            ArrayList <String> sanDuocChon){
        /*
        Vong lap dau tien duyet tat ca cac do uong duoc chon (BevID) va luu gia tien
        cua tung mon vao trong arraylistGiatien
        */
        for (int i = 0; i < maDoUongDuocChon.size(); i++) {
            try(Connection conn = ConnectionUtils.getMyConnection()){
                String sql = "SELECT * from BEVERAGE WHERE BEVERAGEID =?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, maDoUongDuocChon.get(i));
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    giaTienDoUong.add(rs.getInt("PRICE"));
                    tenDoUong.add(rs.getString("BEVERAGENAME"));
                }
                rs.close();
                ps.close();
                conn.close();
                
            }catch(Exception e ){
                System.out.println(e);
                e.printStackTrace();
            }
                }

             /*
        Vong lap thu 2 duyet tat ca cac dung cu duoc chon (EquipID) va luu gia tien
        cua tung mon vao trong arraylistGiatien
        */
        for (int i = 0; i < maDungCuDuocChon.size(); i++) {
           
            try(Connection conn = ConnectionUtils.getMyConnection()){
                String sql = "Select * from EQUIPMENT where EQUIPMENTID =?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, maDungCuDuocChon.get(i));
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    giaTienDungCu.add(rs.getInt("PRICE"));
                    tenDungCu.add(rs.getString("EQUIPMENTNAME"));
                }
                rs.close();
                ps.close();
                conn.close();
            }catch(Exception e ){
                System.out.println(e);
                e.printStackTrace();
            }
        }
              /*
        Vong lap thu 3 duyet tat ca cac san duoc chon (FieldID) va luu gia tien
        cua tung san vao trong arraylistGiatien
        */
        for (int i = 0; i < sanDuocChon.size(); i++) {
           
            try(Connection conn = ConnectionUtils.getMyConnection()){
                String sql = "Select * from FIELD where FIELDID =?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, sanDuocChon.get(i));
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    giaTienSan.add(rs.getInt("FIELDPRICE"));
                    tenSan.add(rs.getString("FIELDNAME"));
                }
                rs.close();
                ps.close();
                conn.close();
            }catch(Exception e ){
                System.out.println(e);
                e.printStackTrace();
            }
        }     
    
    }
        
    void thanhToan(String billID){
        tableHoaDon.setRowCount(0);
        ArrayList<String> maSan =new ArrayList<>();       
        ArrayList<String> maDungCu =new ArrayList<>();
        ArrayList<String> maDoUong =new ArrayList<>();
        
        ArrayList<Integer> thoiGianThue =new ArrayList<>();       
        ArrayList<Integer> soLuongDungCu =new ArrayList<>();
        ArrayList<Integer> soLuongDoUong =new ArrayList<>();
        
        try(Connection conn =ConnectionUtils.getMyConnection()){
            String sql ="SELECT * FROM SCHEDULEDETAILS WHERE BILLID='"+billID+"'";
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("RENTINGTIME")!=0){
                    maSan.add(rs.getString("FIELDID"));
                    thoiGianThue.add(rs.getInt("RENTINGTIME"));
                }
                if(rs.getInt("BEV_QUANTIFIER")!=0){
                    maDoUong.add(rs.getString("BEVERAGEID"));
                    soLuongDoUong.add(rs.getInt("BEV_QUANTIFIER"));
                }
                if(rs.getInt("EQUIP_QUANTIFIER")!=0){
                    maDungCu.add(rs.getString("EQUIPMENTID"));
                    soLuongDungCu.add(rs.getInt("EQUIP_QUANTIFIER"));
                }
            }
            layGiaTien(maDoUong, maDungCu, maSan);
            for (int i = 0; i < tenSan.size(); i++) {
                tableHoaDon.addRow(new Object[]{
                    tenSan.get(i),
                    giaTienSan.get(i),
                    thoiGianThue.get(i),
                    ((double) thoiGianThue.get(i)/60)*giaTienSan.get(i),
                });
            }
            for (int i = 0; i < tenDoUong.size(); i++) {
                tableHoaDon.addRow(new Object[]{
                    tenDoUong.get(i),
                    giaTienDoUong.get(i),
                    soLuongDoUong.get(i),
                    (double) soLuongDoUong.get(i)*giaTienDoUong.get(i),
                });
            }
            for (int i = 0; i < tenDungCu.size(); i++) {
                tableHoaDon.addRow(new Object[]{
                    tenDungCu.get(i),
                    giaTienDungCu.get(i),
                    soLuongDungCu.get(i),
                   (double) soLuongDungCu.get(i)*giaTienDungCu.get(i),
                });
            }
            double total= 0;
            for (int i = 0; i < tableHoaDon.getRowCount(); i++) {
                total += (double)tableHoaDon.getValueAt(i, 3);
            }
            jLabelTongTien.setText(String.valueOf(total));
            
            giaTienSan.clear();
            giaTienDoUong.clear();
            giaTienDungCu.clear();
            tenSan.clear();
            tenDungCu.clear();
            tenDoUong.clear();
            
            rs.close();
            ps.close();
            conn.close();
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }   
    void doDuLieuLenTable( ArrayList<String> maDoUongDuocChon, ArrayList<Integer> soLuongDoUongDuocChon,
                                   ArrayList<String> tenDoUongDuocChon, ArrayList<String> maDungCuDuocChon, 
                                   ArrayList<Integer> soLuongDungCuDuocChon, ArrayList<String> tenDungCuDuocChon,
                                   ArrayList <String> maSanDuocChon, ArrayList<String> tenSanDuocChon,
                                   ArrayList<Integer> thoiLuongThueSan){
        
        /*
        tao 3 arraylist luu gia tien cua cac do uong/dung cu/san duoc chon
        */
        layGiaTien(maDoUongDuocChon, maDungCuDuocChon, maSanDuocChon);
        
        for (int i = 0; i < tenSanDuocChon.size(); i++) {
            
            tableHoaDon.addRow(new Object[]{
                tenSanDuocChon.get(i),
                giaTienSan.get(i),
                thoiLuongThueSan.get(i),
                ((double)thoiLuongThueSan.get(i)/60)*giaTienSan.get(i),
            });
        }
        
        for (int i = 0; i < tenDoUongDuocChon.size(); i++) {
            tableHoaDon.addRow(new Object[]{
                tenDoUongDuocChon.get(i),
                giaTienDoUong.get(i),
                soLuongDoUongDuocChon.get(i),
                (double) giaTienDoUong.get(i)*soLuongDoUongDuocChon.get(i),
            });
        }
        
        for (int i = 0; i < tenDungCuDuocChon.size(); i++) {
            tableHoaDon.addRow(new Object[]{
                tenDungCuDuocChon.get(i),
                giaTienDungCu.get(i),
                soLuongDungCuDuocChon.get(i),
                (double) giaTienDungCu.get(i)*soLuongDungCuDuocChon.get(i),
            });
        }
  
    }
    void updateBill(String billID){
        double total =0;
        for (int i = 0; i<tableHoaDon.getRowCount(); i++) {
            total += (double)tableHoaDon.getValueAt(i, 3);
        }
        jLabelTongTien.setText(String.valueOf(total)+"  VND");
        try(Connection conn = ConnectionUtils.getMyConnection()){
            String sql = "UPDATE BILL SET TOTAL =? WHERE BILLID =?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setDouble(1, total);
            ps.setString(2, billID);
            ps.executeUpdate();
            
            
            giaTienSan.clear();
            giaTienDoUong.clear();
            giaTienDungCu.clear();
            tenSan.clear();
            tenDungCu.clear();
            tenDoUong.clear();
            ps.close();
            conn.close();
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
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
        jPanelTitle = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelTenKhachHang = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelMaKhachHang = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelSDT = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHoaDon = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabelTongTien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanelTitle.setBackground(new java.awt.Color(181, 227, 227));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hoaDon.png"))); // NOI18N
        jLabel46.setText("HÓA ĐƠN");

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel46)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("25-27 đường N1 KDC 61, ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("TWAN Sport");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("khu phố Tân Lập, Dĩ An, Bình Dương");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("TEL: 0352330676");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("KHÁCH HÀNG:");

        jLabelTenKhachHang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTenKhachHang.setText("jLabel6");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("MÃ KH:");

        jLabelMaKhachHang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMaKhachHang.setText("jLabel7");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("TEL:");

        jLabelSDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSDT.setText("jLabel8");

        jTableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dịch vụ", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ));
        jTableHoaDon.setFocusable(false);
        jTableHoaDon.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableHoaDon);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Tổng cộng:");

        jLabelTongTien.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabelTongTien.setText("jLabel9");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel9.setText("TWAN Sport chân thành cảm ơn quý khách!");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel10.setText("Hẹn gặp lại quý khách lần sau");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTenKhachHang)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelSDT))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMaKhachHang)))
                .addGap(74, 74, 74))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelTongTien)
                                .addGap(111, 111, 111))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(116, 116, 116))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabelTenKhachHang))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelMaKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabelSDT))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMaKhachHang;
    private javax.swing.JLabel jLabelSDT;
    private javax.swing.JLabel jLabelTenKhachHang;
    private javax.swing.JLabel jLabelTongTien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableHoaDon;
    // End of variables declaration//GEN-END:variables
}
