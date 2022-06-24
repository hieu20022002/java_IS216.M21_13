/*==============================================================*/
/* Table: EXPENSE                                               */
/*==============================================================*/
CREATE TABLE EXPENSE (
    EXPENSEID NCHAR(5) NOT NULL,
    STAFFID NCHAR(5) NOT NULL,
    EXPENSENAME NVARCHAR2(40) NOT NULL,
    TOTAL NUMBER NOT NULL,
    EXPENSEDATE DATE NOT NULL,
    NOTE NVARCHAR2(100),
    CONSTRAINT PK_EXPENSE PRIMARY KEY (EXPENSEID)
);
/*==============================================================*/
/* FOREIGN KEY: EXPENSE                                         */
/*==============================================================*/ 
ALTER TABLE EXPENSE ADD CONSTRAINT FK_EXPENSE_STAFF FOREIGN KEY (STAFFID)
                                REFERENCES STAFF (STAFFID);
