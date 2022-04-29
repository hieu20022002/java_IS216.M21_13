/*==============================================================*/
/* Table: BILLDETAILS                                           */
/*==============================================================*/
CREATE TABLE BILLDETAILS (
    BILLID NCHAR(5) NOT NULL,
    FIELDID NCHAR(5),
    BEVERAGEID NCHAR(5),
    EQUIPMENTID NCHAR(5),
    FIELD_QUANTIFIER INT,
    BEV_QUANTIFIER INT,
    EQUIP_QUANTIFIER INT,
    CONSTRAINT PK_BILLDETAILS PRIMARY KEY 
                                (BILLID, FIELDID, BEVERAGEID, EQUIPMENTID)
);
/*==============================================================*/
/* FOREIGN KEY: BILLDETAILS                                     */
/*==============================================================*/
ALTER TABLE BILLDETAILS ADD CONSTRAINT FK_BILLDETAILS_BILL
                                  FOREIGN KEY (BILLID)
                                  REFERENCES BILL (BILLID);

ALTER TABLE BILLDETAILS ADD CONSTRAINT FK_BILLDETAILS_BEVERAGE
                                  FOREIGN KEY (BEVERAGEID)
                                  REFERENCES BEVERAGE (BEVERAGEID);

ALTER TABLE BILLDETAILS ADD CONSTRAINT FK_BILLDETAILS_EQUIPMENT
                                  FOREIGN KEY (EQUIPMENTID)
                                  REFERENCES EQUIPMENT (EQUIPMENTID);

ALTER TABLE BILLDETAILS ADD CONSTRAINT FK_BILLDETAILS_FIELD
                                  FOREIGN KEY (FIELDID)
                                  REFERENCES FIELD (FIELDID);