/*==============================================================*/
/* Table: STAFF                                                 */
/*==============================================================*/
CREATE TABLE STAFF (
    STAFFID NCHAR(5) NOT NULL,
    STAFF_USERNAME NCHAR(10) NOT NULL,
    MANAGERID NCHAR(5),
    STAFFNAME NVARCHAR2(40) NOT NULL,
    STAFFTEL NVARCHAR2(20) NOT NULL,
    STAFFADD NVARCHAR2(100) NOT NULL,
    STARTDATE DATE NOT NULL,
    POSITION NVARCHAR2(20) NOT NULL,
    NOTE NVARCHAR2(100),
    CONSTRAINT PK_STAFF PRIMARY KEY (STAFFID)
);
/*==============================================================*/
/* FOREIGN KEY: STAFF                                           */
/*==============================================================*/
ALTER TABLE STAFF ADD CONSTRAINT FK_STAFF_STAFF 
                  FOREIGN KEY (MANAGERID) REFERENCES STAFF(STAFFID);
                  
ALTER TABLE STAFF ADD CONSTRAINT FK_STAFF_USER FOREIGN KEY (STAFF_USERNAME)
                                REFERENCES USER_ACCOUNT (USERNAME);   
                                