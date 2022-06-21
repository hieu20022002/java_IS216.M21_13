/*==============================================================*/
/* Table: FEEDBACK                                              */
/*==============================================================*/
CREATE TABLE FEEDBACK (
    FEEDBACKID NCHAR(5) NOT NULL,
    CUSTOMERID NCHAR(5) NOT NULL,
    SATISFIEDLEVEL INT NOT NULL,
    EVALUATION NVARCHAR2(100) NOT NULL,
    NOTE NVARCHAR2(100),
    CONSTRAINT PK_FEEDBACK PRIMARY KEY (FEEDBACKID)
);
/*==============================================================*/
/* FOREIGN KEY: FEEDBACK                                        */
/*==============================================================*/
ALTER TABLE FEEDBACK ADD CONSTRAINT FK_FEEDBACK_CUSTOMER 
                FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID);
                
