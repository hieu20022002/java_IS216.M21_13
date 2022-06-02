/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.ConnectionUtils;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minhh
 */
public class NhanVien {
    public String CreateMaNV() throws SQLException, ClassNotFoundException {
        int soID = 0;
        Connection conn = ConnectionUtils.getMyConnection();
        String sql = "SELECT COUNT(*) FROM STAFF";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            soID = rs.getInt(1) + 1;
        }
        String ID = "NV";
        int sochia = 100;
        while (sochia > 0) {
            int n = soID / sochia;
            ID = ID + n;
            soID = soID - n * sochia;
            sochia = sochia / 10;
        }
        return ID;
    }
    public int DKNhanVien(String MaDNNhanVien,String idQuanLy,
            String TenNhanVien,String SDT, String DiaChi, String Note){
        int countResult = 0;
        try {
            String idKH = CreateMaNV();
            Connection conn = ConnectionUtils.getMyConnection();
            String sql = "{CALL SP_ADDSTAFF(?,?,?,?,?,?,CURRENT_DATE,'Nhân viên',?)}";
            CallableStatement caSt =conn.prepareCall(sql);
            caSt.setString(1, idKH);
            caSt.setString(2, MaDNNhanVien);
            caSt.setString(3, idQuanLy);
            caSt.setString(4, TenNhanVien);
            caSt.setString(5, SDT);
            caSt.setString(6, DiaChi);
            caSt.setString(7, Note);
            countResult= caSt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
            return countResult;
        }
           
        
        return countResult;
    }
    public HashMap<String,String> getQuanLy(){
        HashMap<String,String> quanly = new HashMap<>();
        try ( Connection con = ConnectionUtils.getMyConnection()){
            String SQL = "SELECT STAFFID,STAFFNAME FROM STAFF WHERE POSITION='Quản lý'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()){
                quanly.put(rs.getString(1),rs.getString(2));
            }
        }catch (Exception ex) {
            System.out.println(ex);
        }
        return quanly;
    }
}
