/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.CheckOracleConnection;
import ConnectDB.OracleConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Kim Lien
 */
public class DoUong {
    public String CreateMaDoUong() throws SQLException, ClassNotFoundException {
        int soID = 0;
        Connection conn = CheckOracleConnection.getMyConnection();
        String sql = "SELECT COUNT(*) FROM BEVERAGE";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            soID = rs.getInt(1) + 1;
        }
        String ID = "BE";
        int sochia = 10;
        while (sochia > 0) {
            int n = soID / sochia;
            ID = ID + n;
            soID = soID - n * sochia;
            sochia = sochia / 10;
        }
        return ID;
    }
    public int ThemDoUong(String madouong,String tendouong,String slconlai,
            String mucgia,String ghichu){
        int i=0;
        try (Connection con = OracleConnect.GetOracleConnect()) {
            String query = "INSERT INTO BEVERAGE VALUES(?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1, madouong);
            ps.setString(2, tendouong);
            ps.setString(3, slconlai);
            ps.setString(4, mucgia);
            ps.setString(5, ghichu);
            i=ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return i;
    }
    public int SuaDoUong(String madouong, String tendouong, String slconlai, 
            String mucgia,String ghichu) {
        int i = 0;
        try ( Connection con = OracleConnect.GetOracleConnect()) {
            String sql = "Update BEVERAGE Set BEVERAGENAME = ?, REMAIN = ?, "
                    + "PRICE = ?, NOTE = ? where BEVERAGEID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tendouong);
            ps.setString(2, slconlai);
            ps.setInt(3, Integer.parseInt(mucgia));
            ps.setString(4, ghichu);
            ps.setString(5, madouong);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public int XoaDoUong(String madouong) {
        int i = 0;
        try ( Connection con = OracleConnect.GetOracleConnect()) {
            String sql = "Delete from BEVERAGE where BEVERAGEID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, madouong);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }
}
