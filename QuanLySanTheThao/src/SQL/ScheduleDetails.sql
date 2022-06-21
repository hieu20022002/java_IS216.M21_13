/*==============================================================*/
/* Table: SCHEDULEDETAILS                                       */
/*==============================================================*/
CREATE TABLE SCHEDULEDETAILS (
    BOOKID NCHAR(5) NOT NULL,
    BILLID NCHAR(5),
    FIELDID NCHAR(5) NOT NULL,
    BEVERAGEID NCHAR(5),
    EQUIPMENTID NCHAR(5),
    BEV_QUANTIFIER NUMBER NOT NULL,
    EQUIP_QUANTIFIER NUMBER NOT NULL,
    RENTINGTIME NUMBER NOT NULL,
    BOOKDATE DATE NOT NULL
);
/*==============================================================*/
/* FOREIGN KEY: SCHEDULEDETAILS                                 */
/*==============================================================*/
ALTER TABLE SCHEDULEDETAILS ADD CONSTRAINT FK_SCHEDULEDETAILS_SCHEDULE
                                  FOREIGN KEY (BOOKID)
                                  REFERENCES SCHEDULE(BOOKID);

ALTER TABLE SCHEDULEDETAILS ADD CONSTRAINT FK_SCHEDULEDETAILS_BEVERAGE
                                  FOREIGN KEY (BEVERAGEID)
                                  REFERENCES BEVERAGE(BEVERAGEID);

ALTER TABLE SCHEDULEDETAILS ADD CONSTRAINT FK_SCHEDULEDETAILS_EQUIPMENT
                                  FOREIGN KEY (EQUIPMENTID)
                                  REFERENCES EQUIPMENT(EQUIPMENTID);

ALTER TABLE SCHEDULEDETAILS ADD CONSTRAINT FK_SCHEDULEDETAILS_FIELD
                                  FOREIGN KEY (FIELDID)
                                  REFERENCES FIELD(FIELDID);
                                  
ALTER TABLE SCHEDULEDETAILS ADD CONSTRAINT FK_SCHEDULEDETAILS_BILL
                                  FOREIGN KEY (BILLID)
                                  REFERENCES BILL(BILLID);
                                  