/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author minhh
 */
public class KhachHang {

    public String CreateMaKH() throws SQLException, ClassNotFoundException {
        int soID = 0;
        Connection conn = ConnectionUtils.getMyConnection();
        String sql = "SELECT COUNT(*) FROM CUSTOMER";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            soID = rs.getInt(1) + 1;
        }
        String ID = "KH";
        int sochia = 100;
        while (sochia > 0) {
            int n = soID / sochia;
            ID = ID + n;
            soID = soID - n * sochia;
            sochia = sochia / 10;
        }
        return ID;

    }

    public int ThemKhachHang(String UserName, String CusName, String CusTel,
            String CusAdd, String note) throws SQLException, ClassNotFoundException {
        int countResult = 1;
        try {
            String idKH = CreateMaKH();
            Connection conn = ConnectionUtils.getMyConnection();
            String sql = "{CALL  SP_ADDCUSTOMER(?,?,?,?,?,0,'Vãng lai',?)}";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idKH);
            ps.setString(2, UserName);
            ps.setString(3, CusName);
            ps.setString(4, CusTel);
            ps.setString(5, CusAdd);
            ps.setString(6, note);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                countResult = 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return countResult;
        }
        return countResult;
    }

}
