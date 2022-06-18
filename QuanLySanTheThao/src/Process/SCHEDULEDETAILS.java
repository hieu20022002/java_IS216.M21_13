/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Duc Tai
 */
public class SCHEDULEDETAILS {
    private String BOOKID, BILLID, FIELDID, BEVERAGEID, EQUIPMENTID;
    private int FIELD_QUANTIFIER,BEV_QUANTIFIER,EQUIP_QUANTIFIER, RENTINGTIME;

    public SCHEDULEDETAILS() {
    }

    public SCHEDULEDETAILS(String BOOKID, String BILLID, String FIELDID, String BEVERAGEID, String EQUIPMENTID, int FIELD_QUANTIFIER, int BEV_QUANTIFIER, int EQUIP_QUANTIFIER, int RENTINGTIME) {
        this.BOOKID = BOOKID;
        this.BILLID = BILLID;
        this.FIELDID = FIELDID;
        this.BEVERAGEID = BEVERAGEID;
        this.EQUIPMENTID = EQUIPMENTID;
        this.FIELD_QUANTIFIER = FIELD_QUANTIFIER;
        this.BEV_QUANTIFIER = BEV_QUANTIFIER;
        this.EQUIP_QUANTIFIER = EQUIP_QUANTIFIER;
        this.RENTINGTIME = RENTINGTIME;
    }

    public String getBOOKID() {
        return BOOKID;
    }

    public void setBOOKID(String BOOKID) {
        this.BOOKID = BOOKID;
    }

    public String getBILLID() {
        return BILLID;
    }

    public void setBILLID(String BILLID) {
        this.BILLID = BILLID;
    }

    public String getFIELDID() {
        return FIELDID;
    }

    public void setFIELDID(String FIELDID) {
        this.FIELDID = FIELDID;
    }

    public String getBEVERAGEID() {
        return BEVERAGEID;
    }

    public void setBEVERAGEID(String BEVERAGEID) {
        this.BEVERAGEID = BEVERAGEID;
    }

    public String getEQUIPMENTID() {
        return EQUIPMENTID;
    }

    public void setEQUIPMENTID(String EQUIPMENTID) {
        this.EQUIPMENTID = EQUIPMENTID;
    }

    public int getFIELD_QUANTIFIER() {
        return FIELD_QUANTIFIER;
    }

    public void setFIELD_QUANTIFIER(int FIELD_QUANTIFIER) {
        this.FIELD_QUANTIFIER = FIELD_QUANTIFIER;
    }

    public int getBEV_QUANTIFIER() {
        return BEV_QUANTIFIER;
    }

    public void setBEV_QUANTIFIER(int BEV_QUANTIFIER) {
        this.BEV_QUANTIFIER = BEV_QUANTIFIER;
    }

    public int getEQUIP_QUANTIFIER() {
        return EQUIP_QUANTIFIER;
    }

    public void setEQUIP_QUANTIFIER(int EQUIP_QUANTIFIER) {
        this.EQUIP_QUANTIFIER = EQUIP_QUANTIFIER;
    }

    public int getRENTINGTIME() {
        return RENTINGTIME;
    }

    public void setRENTINGTIME(int RENTINGTIME) {
        this.RENTINGTIME = RENTINGTIME;
    }
    
    /*
    thêm ScheduleDetails khi người dùng tạo một Schedule
    */
    
    public void insertScheduledetails(String bookID, String billID, String fieldID, int rentingTime){
        
        try(Connection conn = ConnectionUtils.getMyConnection()){
            String sql = "INSERT INTO SCHEDULEDETAILS VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bookID);
            ps.setString(2, billID);
            ps.setString(3, fieldID);
            ps.setString(4, "");
            ps.setString(5, "");
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.setInt(9, rentingTime);
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
