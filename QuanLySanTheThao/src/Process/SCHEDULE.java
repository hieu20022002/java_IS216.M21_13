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
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Duc Tai
 */

public class SCHEDULE {
    private String BOOKID, CUSTOMERID, STAFFID, STATUS, PAYMENTSTATUS, NOTE;
    private Date BOOKDATE, SCHEDULEDATE;

    public SCHEDULE() {
    }

    public SCHEDULE(String BOOKID, String CUSTOMERID, String STAFFID, String STATUS, 
            String PAYMENTSTATUS, String NOTE, Date BOOKDATE, Date SCHEDULEDATE) {
        this.BOOKID = BOOKID;
        this.CUSTOMERID = CUSTOMERID;
        this.STAFFID = STAFFID;
        this.STATUS = STATUS;
        this.PAYMENTSTATUS = PAYMENTSTATUS;
        this.NOTE = NOTE;
        this.BOOKDATE = BOOKDATE;
        this.SCHEDULEDATE = SCHEDULEDATE;
    }

    public String getBOOKID() {
        return BOOKID;
    }

    public void setBOOKID(String BOOKID) {
        this.BOOKID = BOOKID;
    }

    public String getCUSTOMERID() {
        return CUSTOMERID;
    }

    public void setCUSTOMERID(String CUSTOMERID) {
        this.CUSTOMERID = CUSTOMERID;
    }

    public String getSTAFFID() {
        return STAFFID;
    }

    public void setSTAFFID(String STAFFID) {
        this.STAFFID = STAFFID;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getPAYMENTSTATUS() {
        return PAYMENTSTATUS;
    }

    public void setPAYMENTSTATUS(String PAYMENTSTATUS) {
        this.PAYMENTSTATUS = PAYMENTSTATUS;
    }

    public String getNOTE() {
        return NOTE;
    }

    public void setNOTE(String NOTE) {
        this.NOTE = NOTE;
    }

    public Date getBOOKDATE() {
        return BOOKDATE;
    }

    public void setBOOKDATE(Date BOOKDATE) {
        this.BOOKDATE = BOOKDATE;
    }

    public Date getSCHEDULEDATE() {
        return SCHEDULEDATE;
    }

    public void setSCHEDULEDATE(Date SCHEDULEDATE) {
        this.SCHEDULEDATE = SCHEDULEDATE;
    }
    public String insertSchedule( String staffName, String customerID){
        
        // TODO add your handling code here:
        try(Connection con = ConnectionUtils.getMyConnection()) {
        
            
            String query = "SELECT STAFFID FROM STAFF WHERE STAFFNAME =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,staffName);
            ResultSet staffTable = ps.executeQuery();
            String staffID="";
            while(staffTable.next()){
                staffID = staffTable.getString("STAFFID");
            }
            
            
            /*
            String sqlFieldID = "SELECT FIELDID FROM FIELD WHERE FIELDNAME LIKE ?";
            PreparedStatement psFieldID = con.prepareStatement(sqlFieldID);
            psFieldID.setString(1,fieldName);
            ResultSet rsFieldID = psFieldID.executeQuery();
            String fieldID ="";
            while(rsFieldID.next()){
              fieldID = rsFieldID.getString("FIELDID");
            }
    */
            String sqlInsert = "INSERT INTO SCHEDULE VALUES (?,?,?,?,?,?,?)";
            PreparedStatement cs = con.prepareStatement(sqlInsert);
            //query= "exec SP_ADDSCHEDULE(?,?,?,?,?,?,?,?)";
            //cs = con.prepareStatement(query);
            String bookID = CreateBookID();
            cs.setString(1, bookID);
            cs.setString(2,staffID);
            cs.setString(3,customerID);
            
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            cs.setDate(4, sqlDate);
            cs.setString(5, "Đã đặt");
            cs.setString(6,"Chưa thanh toán");
            cs.setString(7, null);
           
       
            boolean c = cs.executeUpdate()>0;
            staffTable.close();
            ps.close();
            cs.close();
            con.close();
            if(c ==true){
                BILL db1  = new BILL();
                boolean c1 =db1.insertBill(staffID, customerID, "Trực tiếp", sqlDate, bookID);
                if(c1 == true){
                    System.out.println("Insert bill thanh cong!");
                    
                }
                else
                    System.out.println("Khong the insert BILL");
                return bookID;
            }
           
        }
        catch(Exception e){
            System.out.println(e);
        }
        return "";
    }
    public String returnBillID(String insertStatus){
        if(insertStatus.isEmpty()==false){
            try(Connection conn = ConnectionUtils.getMyConnection()){
                String sql = "SELECT BILLID FROM (SELECT * FROM BILL ORDER BY BILLID DESC) WHERE ROWNUM = 1";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                String billID ="";
                if(rs.next())
                    billID = rs.getString("BILLID");
                
                rs.close();
                ps.close();
                conn.close();
                return billID;
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return "";
    }
   
    public String CreateBookID() {
        int soID = 0;
        try(Connection conn = ConnectionUtils.getMyConnection()){ 
            String sql = "SELECT COUNT(*) FROM SCHEDULE";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            soID = rs.getInt(1) + 1;
            }
            String ID = "BK";
            int sochia = 10;
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
