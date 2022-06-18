/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import java.util.Date;
import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Duc Tai
 */
public class BILL {
    private String BILLID, STAFFID, CUSTOMERID, PAYMENTED , NOTE;
    private int TOTAL;
    private Date BillDate;

    public BILL() {
    }

    public BILL(String BILLID, String STAFFID, String CUSTOMERID, String PAYMENTED, String NOTE, int TOTAL, Date BillDate) {
        this.BILLID = BILLID;
        this.STAFFID = STAFFID;
        this.CUSTOMERID = CUSTOMERID;
        this.PAYMENTED = PAYMENTED;
        this.NOTE = NOTE;
        this.TOTAL = TOTAL;
        this.BillDate = BillDate;
    }
    
    /*
    Ham nay duoc goi de tao 1 HD moi khi nguoi dung dat mot lich moi
    */
    public boolean insertBill(String staffID, String customerID, String paymentmed, Date billDate,
                            String bookID){
        try(Connection conn = ConnectionUtils.getMyConnection()){
            String sql = "INSERT INTO BILL VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            String billID = CreateBillID();
            ps.setString(1, billID);
            ps.setString(2, staffID);
            ps.setString(3, customerID);
            ps.setString(4, paymentmed);
            ps.setDate(5, (java.sql.Date) billDate);
            ps.setDouble(6, 0);
            ps.setString(7, null);
            boolean c= ps.executeUpdate()>0;
            ps.close();
            conn.close();
            if( c == true)
               return true;
           
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }   
    public String CreateBillID() {
        int soID = 0;
        try(Connection conn = ConnectionUtils.getMyConnection()){ 
            String sql = "SELECT COUNT(*) FROM BILL";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            soID = rs.getInt(1) + 1;
            }
            String ID = "B";
            int sochia = 100;
            while (sochia > 0) {
            int n = soID / sochia;
            ID = ID + n;
            soID = soID - n * sochia;
            sochia = sochia / 10;
            }
            rs.close();
            ps.close();
            conn.close();
            return ID;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
 }
    }

