/*==============================================================*/
/* Table: SCHEDULEDETAILS                                        */
/*==============================================================*/
CREATE TABLE SCHEDULEDETAILS (
    BOOKID NCHAR(5) NOT NULL,
    FIELDID NCHAR(5) NOT NULL,
    BEVERAGEID NCHAR(5),
    EQUIPMENTID NCHAR(5),
    BEV_QUANTIFIER NUMBER,
    EQUIP_QUANTIFIER NUMBER,
    RENTINGTIME NUMBER NOT NULL,
    CONSTRAINT PK_BOOKINGDETAILS PRIMARY KEY 
                                (BOOKID, FIELDID)
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