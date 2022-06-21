/*==============================================================*/
/*                          TRIGGER                             */
/*==============================================================*/
--------------------------------------------------------------------------------

                        --Ràng buộc khóa ngoại--

--------------------------------------------------------------------------------

/*Số điện thoại của mỗi khách hàng là duy nhất*/

ALTER TABLE CUSTOMER ADD CONSTRAINT SDT_CUS UNIQUE(CUSTOMERTEL );

--------------------------------------------------------------------------------

/*Số điện thoại của mỗi nhân viên là duy nhất*/

ALTER TABLE STAFF ADD CONSTRAINT SDT_STAFF UNIQUE(STAFFTEL );

--------------------------------------------------------------------------------

/*Người quản lí cũng là một nhân viên trong sân thể thao*/
/
CREATE OR REPLACE TRIGGER trg_staff_mananger BEFORE
INSERT OR UPDATE ON STAFF
FOR EACH ROW
DECLARE 
    CURSOR c_staffID IS SELECT STAFFID FROM STAFF ;
    v_staffID STAFF.STAFFID%TYPE;
BEGIN 
    IF :NEW.MANAGERID IS NOT NULL THEN
        OPEN c_staffID;
        LOOP
        FETCH c_staffID INTO v_staffID ;
        EXIT WHEN c_staffID%NOTFOUND;
        IF c_staffID%found THEN
            IF (v_staffID=:NEW.MANAGERID) THEN
                DBMS_OUTPUT.PUT_LINE('THÊM MÃ NGƯỜI QUẢN LÍ THÀNH CÔNG');
            END IF;
        ELSE 
            RAISE_APPLICATION_ERROR(-20000,'MÃ NGƯỜI QUẢN LÍ KHÔNG TỒN TẠI');
        END IF;
        END LOOP;
    ELSE 
        DBMS_OUTPUT.PUT_LINE('THÊM THÀNH CÔNG');
    END IF;
END;
/
--------------------------------------------------------------------------------

                        --Ràng buộc miền giá trị--

--------------------------------------------------------------------------------
/* Khách hàng chỉ có thể chọn những đồ uống có trong hệ thống với số lượng 
nhỏ hơn hoặc bằng số lượng còn lại của loại đồ uống đó */

CREATE OR REPLACE TRIGGER trg_bev_quantity BEFORE
INSERT OR UPDATE ON SCHEDULEDETAILS
FOR EACH ROW
DECLARE 
    v_remain BEVERAGE.REMAIN%TYPE;
BEGIN
    IF :NEW.BEVERAGEID IS NOT NULL THEN 
        SELECT REMAIN INTO v_remain FROM BEVERAGE
        WHERE BEVERAGEID=:NEW.BEVERAGEID;
        IF (v_remain>=:NEW.BEV_QUANTIFIER ) THEN
            DBMS_OUTPUT.PUT_LINE('ĐA ĐẶT ĐỒ UỐNG THÀNH CÔNG');
        ELSE 
            RAISE_APPLICATION_ERROR(-20000,'VƯỢT QUÁ SỐ LƯỢNG ĐỒ UỐNG');
        END IF;
        ELSE 
           IF (:NEW.BEV_QUANTIFIER > 0 ) THEN
               RAISE_APPLICATION_ERROR(-20000,'CHƯA CHỌN MÃ ĐỒ UỐNG');
            END IF;
      END IF;      
END;
/
--------------------------------------------------------------------------------

/* Khách hàng không thể đăng kí số lượng dụng cụ thể thao lớn hơn số lượng còn lại */

CREATE OR REPLACE TRIGGER trg_equip_quantity BEFORE
INSERT OR UPDATE ON SCHEDULEDETAILS
FOR EACH ROW
DECLARE 
    v_remain EQUIPMENT.REMAIN%TYPE;
BEGIN 
      IF :NEW.EQUIPMENTID IS NOT NULL THEN 
        SELECT REMAIN INTO v_remain FROM EQUIPMENT
        WHERE EQUIPMENTID=:NEW.EQUIPMENTID;
        IF (v_remain>=:NEW.EQUIP_QUANTIFIER ) THEN
            DBMS_OUTPUT.PUT_LINE('ĐÃ ĐẶT DỤNG CỤ THÀNH CÔNG');
        ELSE 
            RAISE_APPLICATION_ERROR(-20000,'VƯỢT QUÁ SỐ LƯỢNG DỤNG CỤ');
        END IF;
        ELSE 
             IF (:NEW.EQUIP_QUANTIFIER > 0 ) THEN
               RAISE_APPLICATION_ERROR(-20000,'CHƯA CHỌN MÃ DỤNG CỤ');
            END IF;
      END IF;    
END;
/
--------------------------------------------------------------------------------

/* Mỗi trận có thời gian tối thiểu là 30 phút, và tổng thời gian một 
trận đấu tính theo phút phải là bội số của 5 */

CREATE OR REPLACE TRIGGER trg_scheduledetails_rentingtime BEFORE
INSERT OR UPDATE ON SCHEDULEDETAILS
FOR EACH ROW
BEGIN  
    IF (:new.rentingtime >= 30 AND MOD(:new.rentingtime, 5)=0 ) THEN
        DBMS_OUTPUT.PUT_LINE('ĐÃ THÊM THÀNH CÔNG');
    ELSE 
        RAISE_APPLICATION_ERROR(-20000,'THỜI GIAN TRẬN ĐẤU KHÔNG HỢP LỆ!');
    END IF;
END;
/
--------------------------------------------------------------------------------
/* Nếu số lần đặt sân lớn hơn hoặc bằng 70 thì loại khách hàng là VIP, 
số lần đặt sân lớn hơn hoặc bằng 50 thì loại khách hàng là Thân thiết. Nếu 
số lần đặt sân không đạt được điều kiện trên thì loại khách hàng: Vãng lai */    

CREATE OR REPLACE TRIGGER trg_customer_booktime BEFORE
UPDATE ON CUSTOMER
FOR EACH ROW
DECLARE 
    v_booktime CUSTOMER.BOOKTIME%TYPE;
    v_customerid CUSTOMER.CUSTOMERID%TYPE;
BEGIN
    SELECT CUSTOMER.BOOKTIME INTO v_booktime FROM CUSTOMER
    WHERE v_customerid =: new.CUSTOMERID;
    
    IF (v_booktime >='70' OR :new.BOOKTIME >='70') THEN
        BEGIN
            UPDATE CUSTOMER
            SET CUSTOMERTYPE ='VIP';
        END;
    ELSIF(v_booktime >='50' OR :new.BOOKTIME >='50') THEN
        BEGIN
            UPDATE CUSTOMER
            SET CUSTOMERTYPE ='Thân thiết';
        END;
    ELSE
        BEGIN
            UPDATE CUSTOMER
            SET CUSTOMERTYPE ='Vãng lai';
        END;
    END IF;
END;
/
