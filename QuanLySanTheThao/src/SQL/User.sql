CREATE TABLE USER_ACCOUNT (
    USERNAME NCHAR(10) NOT NULL,
    USER_PASSWORD NCHAR(20) NOT NULL,
    USER_ROLE NVARCHAR2(20) NOT NULL,
    CONSTRAINT PK_USER PRIMARY KEY (USERNAME)
);
/*==============================================================*/
/* FOREIGN KEY: USER                                            */
/*==============================================================*/ 
                        --None-- 
