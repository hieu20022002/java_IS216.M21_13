/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
CREATE TABLE CUSTOMER (
    CUSTOMERID NCHAR(5) NOT NULL,
    CUS_USERNAME NCHAR(10) NOT NULL,
    CUSTOMERNAME NVARCHAR2(40) NOT NULL,
    CUSTOMERTEL NVARCHAR2(20) NOT NULL,
    CUSTOMERADD NVARCHAR2(100) NOT NULL,
    BOOKTIME INT NOT NULL,
    CUSTOMERTYPE NVARCHAR2(10) NOT NULL,
    NOTE NVARCHAR2(100),
    CONSTRAINT PK_CUSTOMER PRIMARY KEY (CUSTOMERID)
);

/*==============================================================*/
/* FOREIGN KEY: CUSTOMER                                        */
/*==============================================================*/
ALTER TABLE CUSTOMER ADD CONSTRAINT FK_CUSTOMER_USER FOREIGN KEY (CUS_USERNAME)
                                    REFERENCES USER_ACCOUNT (USERNAME);
