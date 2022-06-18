/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
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
        int countResult = 0;
        try {
            Connection conn = ConnectionUtils.getMyConnection();
            String sql = "{CALL SP_ADDUSER(?,?,'Khách Hàng')}";
            CallableStatement caSt =conn.prepareCall(sql);
            caSt.setString(1, user);
            caSt.setString(2, pass);
            countResult= caSt.executeUpdate();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return countResult;
        }
        return countResult;
    }
    public int DK_TK_NV (String user, String pass) throws SQLException, ClassNotFoundException{
        int countResult = 0;
        try {
            Connection conn = ConnectionUtils.getMyConnection();
            String sql = "{CALL SP_ADDUSER(?,?,'Nhân Viên')}";
            CallableStatement caSt =conn.prepareCall(sql);
            caSt.setString(1, user);
            caSt.setString(2, pass);
            countResult= caSt.executeUpdate();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return countResult;
        }
        return countResult;
    }   

    public String DangNhap(String user, String pass) throws SQLException, ClassNotFoundException {
        String userRole = "";
        try {
            Connection conn = ConnectionUtils.getMyConnection();
            String sql = "SELECT USERNAME,USER_PASSWORD, USER_ROLE FROM USER_ACCOUNT "
                    + "WHERE USERNAME='"+user+"' AND USER_PASSWORD='"+pass+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userRole = rs.getString("USER_ROLE");
            }
            
            return userRole;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return userRole;
    }
    public String returnKhachHang(String user, String pass){
        try(Connection conn = ConnectionUtils.getMyConnection()){

            String sql = "SELECT USERNAME FROM USER_ACCOUNT "
                    + "WHERE USERNAME='"+user+"' AND USER_PASSWORD='"+pass+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String username="";
            if(rs.next()){
                username = rs.getString("USERNAME");
            }
            rs.close();
            ps.close();
            conn.close();
            return username;
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace(System.out);
        }
        return "";
       
    }
}
