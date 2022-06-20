/*==============================================================*/
/* Table: BEVERAGE                                              */
/*==============================================================*/
CREATE TABLE BEVERAGE (
    BEVERAGEID NCHAR(5) NOT NULL,
    BEVERAGENAME NVARCHAR2(40) NOT NULL,
    REMAIN INT NOT NULL,
    PRICE NUMBER NOT NULL,
    NOTE NVARCHAR2(100),
    CONSTRAINT PK_BEVERAGE PRIMARY KEY (BEVERAGEID)
);
/*==============================================================*/
/* FOREIGN KEY: BEVERAGE                                        */
/*==============================================================*/
                         --None--
                         