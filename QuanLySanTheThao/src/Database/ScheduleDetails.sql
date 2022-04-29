/*==============================================================*/
/* Table: SCHEDULEDETAILS                                        */
/*==============================================================*/
CREATE TABLE SCHEDULEDETAILS (
    BOOKID NCHAR(5) NOT NULL,
    FIELDID NCHAR(5) NOT NULL,
    BEVERAGEID NCHAR(5) NOT NULL,
    EQUIPMENTID NCHAR(5) NOT NULL,
    FIELD_QUANTIFIER NUMBER NOT NULL,
    BEV_QUANTIFIER NUMBER,
    EQUIP_QUANTIFIER NUMBER,
    RENTINGTIME NUMBER NOT NULL,
    CONSTRAINT PK_BOOKINGDETAILS PRIMARY KEY 
                                (BOOKID, FIELDID, BEVERAGEID, EQUIPMENTID)
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