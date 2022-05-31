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
public class Feedback {
    public String createMaFB() throws SQLException, ClassNotFoundException{
        int soID = 0;
        Connection conn = ConnectionUtils.getMyConnection();
        String sqlcount="SELECT COUNT(*) FROM FEEDBACK";
        PreparedStatement ps = conn.prepareStatement(sqlcount);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
                soID = rs.getInt(1)+1;
        }
        String ID = "FB";
        int sochia = 10;
        while (sochia > 0){
            int n = soID / sochia;
            ID = ID + n;
            soID = soID - n * sochia;
            sochia = sochia / 10; 
        }
        return ID;
    }
    public int themFeedBack(String MaKh,int MucDG, String DanhGia, String note) throws SQLException, ClassNotFoundException{
        int countResult = 0;
        String idFB=createMaFB();
        try {
            Connection conn = ConnectionUtils.getMyConnection();
//            String query = "INSERT INTO FEEDBACK VALUES('"+idKH+"','"+MaKh+"',"+MucDG+",'"+DanhGia+"','"+note+"')";
            String query = "INSERT INTO FEEDBACK VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idFB);
            ps.setString(2, MaKh);
            ps.setInt(3, MucDG);
            ps.setString(4, DanhGia);
            ps.setString(5, note);
            countResult = ps.executeUpdate();   
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return countResult;
        }
        return countResult;
    }
}
