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
        int countResult = 0;
        try {
            String idKH = CreateMaKH();
            Connection conn = ConnectionUtils.getMyConnection();
            String sql = "{CALL  SP_ADDCUSTOMER(?,?,?,?,?,0,'Vãng lai',?)}";
            CallableStatement caSt =conn.prepareCall(sql);
            caSt.setString(1, idKH);
            caSt.setString(2, UserName);
            caSt.setString(3, CusName);
            caSt.setString(4, CusTel);
            caSt.setString(5, CusAdd);
            caSt.setString(6, note);
            countResult= caSt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return countResult;
        }
        return countResult;
    }

}
