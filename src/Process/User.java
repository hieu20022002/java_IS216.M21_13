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
public class User {

    public User() {
    }
    public int DK_TK_KH (String user, String pass) throws SQLException, ClassNotFoundException{
        int countResult = 1;
        try {
            Connection conn = ConnectionUtils.getMyConnection();
            String sql = "EXECUTE SP_ADDUSER(?,?,'Khách Hàng')";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            
            if(!rs.isBeforeFirst()){
                countResult=0;
            }
            
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return countResult;
        }
        return countResult;
    }
    

    public int DangNhap(String user, String pass) throws SQLException, ClassNotFoundException {
        int countResult = 0;
        try {
            Connection conn = ConnectionUtils.getMyConnection();
            String sql = "SELECT USERNAME,USER_PASSWORD FROM USER_ACCOUNT "
                    + "WHERE USERNAME='"+user+"' AND USER_PASSWORD='"+pass+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                countResult = 1;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return countResult;
        }
        return countResult;
    }
}
