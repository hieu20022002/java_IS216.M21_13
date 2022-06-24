/*==============================================================*/
/* Table: FIELD                                                 */
/*==============================================================*/
CREATE TABLE FIELD (
    FIELDID NCHAR(5) NOT NULL,
    FIELDNAME NVARCHAR2(40) NOT NULL,
    FIELDSIZE NVARCHAR2(40) NOT NULL,
    FIELDPRICE NUMBER NOT NULL,
    STATUS NVARCHAR2(10) NOT NULL,
    NOTE NVARCHAR2(100),
    CONSTRAINT PK_FIELD PRIMARY KEY (FIELDID)
);
/*==============================================================*/
/* FOREIGN KEY: FIELD                                           */
/*==============================================================*/
                         --None--
