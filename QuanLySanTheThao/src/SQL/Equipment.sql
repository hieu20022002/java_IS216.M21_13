/*==============================================================*/
/* Table: EQUIPMENT                                             */
/*==============================================================*/
CREATE TABLE EQUIPMENT (
    EQUIPMENTID NCHAR(5) NOT NULL,
    EQUIPMENTNAME NVARCHAR2(40) NOT NULL,
    REMAIN INT NOT NULL,
    PRICE NUMBER NOT NULL,
    NOTE NVARCHAR2(100),
    CONSTRAINT PK_EQUIPMENT PRIMARY KEY (EQUIPMENTID)
);
/*==============================================================*/
/* FOREIGN KEY: EQUIPMENT                                       */
/*==============================================================*/
                         --None--