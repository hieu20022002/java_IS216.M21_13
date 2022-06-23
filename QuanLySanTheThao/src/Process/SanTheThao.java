/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.ConnectionOracle;
import ConnectDB.ConnectionUtils;
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
public class SanTheThao {
    /**
    * Them san the thao
    * @param masan
    * @param tensan
    * @param kichthuoc
    * @param tinhtrang
    * @param mucgia
    * @param ghichu
    * @return
     */
    public int ThemSan(String masan,String tensan,String kichthuoc,String mucgia
            ,String tinhtrang,String ghichu){
        int i=0;
        try (Connection con = ConnectionUtils.getMyConnection()) {
            String query = "INSERT INTO FIELD VALUES(?,?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1, masan);
            ps.setString(2, tensan);
            ps.setString(3, kichthuoc);
            ps.setString(4, mucgia);
            ps.setString(5, tinhtrang);
            ps.setString(6, ghichu);
            i=ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return i;
    }
    public int SuaSan(String masan, String tensan, String kichthuoc, String mucgia,
             String tinhtrang, String ghichu) {
        int i = 0;
        try ( Connection con = ConnectionUtils.getMyConnection()) {
            String sql = "Update FIELD Set FIELDNAME = ?, FIELDSIZE = ?, "
                    + "FIELDPRICE = ?,STATUS = ?, NOTE = ? where FIELDID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tensan);
            ps.setString(2, kichthuoc);
            ps.setInt(3, Integer.parseInt(mucgia));
            ps.setString(4, tinhtrang);
            ps.setString(5, ghichu);
            ps.setString(6, masan);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }
    public int XoaSan(String masan) {
        int i = 0;
        try ( Connection con = ConnectionUtils.getMyConnection()) {
            String sql = "Delete from FIELD where FIELDID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, masan);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
        return i;
    }
    
}
