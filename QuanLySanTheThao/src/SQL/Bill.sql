/*==============================================================*/
/* Table: BILL                                                  */
/*==============================================================*/
CREATE TABLE BILL (
    BILLID NCHAR(5) NOT NULL,
    STAFFID NCHAR(5) NOT NULL,
    CUSTOMERID NCHAR(5) NOT NULL,
    PAYMENTMED NVARCHAR2(40) NOT NULL,
    BILLDATE DATE NOT NULL,
    TOTAL NUMBER NOT NULL,
    NOTE NVARCHAR2(100),
    CONSTRAINT PK_BILL PRIMARY KEY (BILLID)
);
/*==============================================================*/
/* FOREIGN KEY: BILL                                            */
/*==============================================================*/
ALTER TABLE BILL ADD CONSTRAINT FK_BILL_STAFF 
                 FOREIGN KEY (STAFFID) REFERENCES STAFF (STAFFID);

ALTER TABLE BILL ADD CONSTRAINT FK_BILL_CUSTOMER 
                FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER (CUSTOMERID);RID);