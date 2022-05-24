/*==============================================================*/
/* Table: SCHEDULE                                              */
/*==============================================================*/
CREATE TABLE SCHEDULE (
    BOOKID NCHAR(5) NOT NULL,
    STAFFID NCHAR(5) NOT NULL,
    CUSTOMERID NCHAR(5) NOT NULL,
    BOOKDATE DATE NOT NULL,
    SCHEDULEDATE DATE NOT NULL,
    STATUS NVARCHAR2(20) NOT NULL,
    PAYMENTSTATUS NVARCHAR2(20) NOT NULL,
    NOTE NVARCHAR2(100),
    CONSTRAINT PK_SCHEDULE PRIMARY KEY (BOOKID)
);
/*==============================================================*/
/* FOREIGN KEY: SCHEDULE                                        */
/*==============================================================*/
ALTER TABLE SCHEDULE ADD CONSTRAINT FK_SCHEDULE_STAFF 
                 FOREIGN KEY(STAFFID)REFERENCES STAFF (STAFFID);

ALTER TABLE SCHEDULE ADD CONSTRAINT FK_SCHEDULE_CUSTOMER 
                FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER (CUSTOMERID);