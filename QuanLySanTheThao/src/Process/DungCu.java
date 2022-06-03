/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.OracleConnect;
import ConnectDB.CheckOracleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Kim Lien
 */
public class DungCu {
    public String CreateMaDungCu() throws SQLException, ClassNotFoundException {
        int soID = 0;
        Connection conn = CheckOracleConnection.getMyConnection();
        String sql = "SELECT COUNT(*) FROM EQUIPMENT";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            soID = rs.getInt(1) + 1;
        }
        String ID = "EQ";
        int sochia = 10;
        while (sochia > 0) {
            int n = soID / sochia;
            ID = ID + n;
            soID = soID - n * sochia;
            sochia = sochia / 10;
        }
        return ID;
    }
    public int ThemDungCu(String madungcu,String tendungcu,String slconlai,
            String mucgia,String ghichu){
        int i=0;
        try (Connection con = OracleConnect.GetOracleConnect()) {
            
            String query = "INSERT INTO EQUIPMENT  VALUES(?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1, madungcu);
            ps.setString(2, tendungcu);
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
public int SuaDungCu(String madungcu, String tendungcu, String slconlai, 
            String mucgia,String ghichu) {
        int i = 0;
        try ( Connection con = OracleConnect.GetOracleConnect()) {
            String sql = "Update EQUIPMENT Set EQUIPMENTNAME = ?, REMAIN = ?, "
                    + "PRICE = ?, NOTE = ? where EQUIPMENTID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tendungcu);
            ps.setString(2, slconlai);
            ps.setInt(3, Integer.parseInt(mucgia));
            ps.setString(4, ghichu);
            ps.setString(5, madungcu);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public int XoaDungCu(String madungcu) {
        int i = 0;
        try ( Connection con = OracleConnect.GetOracleConnect()) {
            String sql = "Delete from EQUIPMENT where EQUIPMENTID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, madungcu);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }
    
}
