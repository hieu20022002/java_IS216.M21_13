/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;
import ConnectDB.ConnectionOracle;
import ConnectDB.ConnectionUtils;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Kim Lien
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
        int i = 0;
        try ( Connection con = ConnectionUtils.getMyConnection()) {
            String idKH = CreateMaKH();
            String query = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,0,'Vãng lai',?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, idKH);
            ps.setString(2, UserName);
            ps.setString(3, CusName);
            ps.setString(4, CusTel);
            ps.setString(5, CusAdd);
            ps.setString(6, note);
            i = ps.executeUpdate();

        } catch (Exception e) {
            System.out.print(e);
        }
//        try {
//            String idKH = CreateMaKH();
//            Connection conn = CheckOracleConnection.getMyConnection();
//            String sql = "{CALL  SP_ADDCUSTOMER(?,?,?,?,?,0,'Vãng lai',?)}";
//            CallableStatement caSt =conn.prepareCall(sql);
//            caSt.setString(1, idKH);
//            caSt.setString(2, UserName);
//            caSt.setString(3, CusName);
//            caSt.setString(4, CusTel);
//            caSt.setString(5, CusAdd);
//            caSt.setString(6, note);
//            countResult= caSt.executeUpdate();
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println(e);
//            return countResult;
//        }
        return i;
    }
 public int XoaKhachHang(String maKH) {
        int i = 0;
        try ( Connection con = ConnectionUtils.getMyConnection()) {
            String sql = "Delete from CUSTOMER where CUSTOMERID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maKH);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public int SuaTTKhachHang(String maKH, String tenKH, String sdt,
             String diachi, String sldat, String loaiKH, String note) {
        int i = 0;
        try ( Connection con = ConnectionUtils.getMyConnection()) {
            
            String sql = "Update CUSTOMER Set CUSTOMERNAME = ?,CUSTOMERTEL = ?,"
                    + "CUSTOMERADD = ?, BOOKTIME = ?,CUSTOMERTYPE = ?,"
                    + "NOTE = ?, where CUSTOMERID = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenKH);
            ps.setString(2, sdt);
            ps.setString(3, diachi);
            ps.setString(4,sldat);
            ps.setString(5,loaiKH);
            ps.setString(6,note);
            ps.setString(7, maKH);
            
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        System.out.println("Sửa:" +i);
        return i;
    }
}
