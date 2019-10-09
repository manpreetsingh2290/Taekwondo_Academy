

create table USER_DETAILS 
(
User_ID number(15),
User_FirstName varchar2(20),
User_LastName varchar2(20),
User_UserName varchar2(50) unique,
User_Password varchar2(50),
User_Role number(5),
primary key (User_ID)
);

--alter table  USER_DETAILS modify  User_UserName varchar2(15) unique;

CREATE SEQUENCE USER_ID_SEQ
  MINVALUE 1
  MAXVALUE 9999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

create table INSTRUCTOR_DETAILS 
(
Instructor_ID number(15),
Instructor_FirstName varchar2(20),
Instructor_LastName varchar2(20),
primary key (Instructor_ID)
);
--alter table  INSTRUCTOR_DETAILS ADD User_Role number(5);
CREATE SEQUENCE INSTRUCTOR_ID_SEQ
  MINVALUE 1
  MAXVALUE 9999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

create table STUDENT_DETAILS 
(
Student_ID number(15),
Student_FirstName varchar2(20),
Student_LastName varchar2(20),
Student_DOB date,
Email_ID varchar2(50),
Phone_No varchar2(20),
Emrgency_Contact_No varchar2(20),
Addrs_HouseNumber varchar2(20),
Addrs_Street varchar2(20),
Addrs_City varchar2(20),
Addrs_State varchar2(20),
Addrs_PostalCode varchar2(20),
Gender varchar2(20),
STATUS char(1),
CONSTRAINT CHK_SD_STATUS CHECK (STATUS in ('0','1')),
primary key (Student_ID)
);
--alter table  STUDENT_DETAILS ADD Phone_No varchar2(15);
--alter table  STUDENT_DETAILS ADD Emrgency_Contact_No varchar2(15);
--alter table STUDENT_DETAILS rename column SEX TO Gender;
CREATE SEQUENCE STUDENT_ID_SEQ
  MINVALUE 1
  MAXVALUE 9999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

create table PRODUCT_DETAILS 
(
Product_ID number(15),
Product_Name varchar2(50),
Product_Description varchar2(100),
Cost_Price number(15,2),
Selling_Price number(15,2),
Creation_Time TimeStamp default sysdate,
primary key (Product_ID)
);
--alter table PRODUCT_DETAILS modify Creation_Time default sysdate;
--alter table PRODUCT_DETAILS modify Product_Description varchar2(100);

CREATE SEQUENCE PRODUCT_ID_SEQ
  MINVALUE 1
  MAXVALUE 9999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

create table PRODUCT_ORDER
(
Order_ID number(15),
Student_ID number(15),
Purchase_Date date,
primary key (Order_ID),
CONSTRAINT fk_po_student_id
    FOREIGN KEY (Student_ID)
    REFERENCES STUDENT_DETAILS (Student_ID)
);


CREATE SEQUENCE ORDER_ID_SEQ
  MINVALUE 1
  MAXVALUE 9999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

create table PRODUCT_ORDER_DETAILS
(
Order_ID number(15),
Product_ID number(15),
Product_Quantity number(15),
Unit_Price  number(15,2),
Total_Amount number(15,2),
primary key (Order_ID,Product_ID),
CONSTRAINT fk_pod_order_id
    FOREIGN KEY (Order_ID)
    REFERENCES PRODUCT_ORDER (Order_ID),
CONSTRAINT fk_pod_product_id
    FOREIGN KEY (Product_ID)
    REFERENCES PRODUCT_DETAILS (Product_ID)
);

--Alter table PRODUCT_ORDER_DETAILS rename column Price to Unit_Price; 
--Alter table PRODUCT_ORDER_DETAILS add  Total_Amount number(15,2);


create table CLASS_DETAILS 
(
Class_ID number(15),
Class_Description varchar2(100),
Class_Fee number(15,2),
Instructor_ID number(15), 
primary key (Class_ID),
CONSTRAINT fk_cd_instructor_id
    FOREIGN KEY (Instructor_ID)
    REFERENCES INSTRUCTOR_DETAILS (Instructor_ID)
);

CREATE SEQUENCE CLASS_ID_SEQ
  MINVALUE 1
  MAXVALUE 9999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

create table CLASS_AVAILABILITY 
(
Class_ID number(15),
Class_Day varchar2(15),
Start_Time varchar2(10),
End_Time  varchar2(10),
primary key (Class_ID,Class_Day,Start_time,End_Time),
CONSTRAINT fk_class_id2
    FOREIGN KEY (Class_ID)
    REFERENCES CLASS_DETAILS (Class_ID)
);


create table CLASS_TAKEN 
(
Class_ID number(15),
Student_ID number(15),
Begin_Date date,
primary key (Class_ID,Student_ID),
CONSTRAINT fk_ct_class_id
    FOREIGN KEY (Class_ID)
    REFERENCES CLASS_DETAILS (Class_ID),
CONSTRAINT fk_ct_student_id
    FOREIGN KEY (Student_ID)
    REFERENCES STUDENT_DETAILS (Student_ID)
);


create table STUDENT_REGISTRATION 
(
Student_ID number(15),
Joining_Date date,
Exit_Date date,
primary key (Student_ID,Joining_Date),
CONSTRAINT fk_sreg_Student_id
    FOREIGN KEY (Student_ID)
    REFERENCES STUDENT_DETAILS (Student_ID)
);
--alter table STUDENT_REGISTRATION add CONSTRAINT fk_sreg_Student_id   FOREIGN KEY (Student_ID)    REFERENCES STUDENT_DETAILS (Student_ID);

create table PARENT_DETAILS 
(
Parent_ID number(15),
Parent_FirstName varchar2(20),
Parent_LastName varchar2(20),
Parent_DOB date,
Email_ID varchar2(50),
Phone_No varchar2(20),
Addrs_HouseNumber varchar2(20),
Addrs_Street varchar2(20),
Addrs_City varchar2(20),
Addrs_State varchar2(20),
Addrs_PostalCode varchar2(20),
Gender varchar2(20),
primary key (Parent_ID)
);

CREATE SEQUENCE PARENT_ID_SEQ
  MINVALUE 1
  MAXVALUE 9999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

create table STUDENT_PARENT 
(
Parent_ID number(15),
Student_ID number(15),
Relation varchar2(50),
primary key (Parent_ID,Student_ID),
CONSTRAINT fk_sp_student_id
    FOREIGN KEY (Student_ID)
    REFERENCES STUDENT_DETAILS (Student_ID),
CONSTRAINT fk_sp_Parent_id
    FOREIGN KEY (Parent_ID)
    REFERENCES PARENT_DETAILS (Parent_ID)
);

create table STUDENT_ATTENDANCE 
(
Class_ID number(15),
Student_ID number(15),
Class_Date date,
STATUS char(1),
CONSTRAINT CHK_SA_STATUS CHECK (STATUS in ('A','P')),
primary key (Class_ID,Student_ID,Class_Date),
CONSTRAINT fk_sa_Student_id
    FOREIGN KEY (Student_ID)
    REFERENCES STUDENT_DETAILS (Student_ID),
CONSTRAINT fk_sa_Class_id
    FOREIGN KEY (Class_ID)
    REFERENCES CLASS_DETAILS (Class_ID)
);
--alter table STUDENT_ATTENDANCE add CONSTRAINT fk_sa_Student_id   FOREIGN KEY (Student_ID)    REFERENCES STUDENT_DETAILS (Student_ID);
--alter table STUDENT_ATTENDANCE add CONSTRAINT fk_sa_Class_id     FOREIGN KEY (Class_ID)    REFERENCES CLASS_DETAILS (Class_ID);

create table BELT_RANK
(
Rank_ID number(15),
Belt_Color varchar2(50),
Rank_Level varchar2(50),
primary key (Rank_ID)
);

CREATE SEQUENCE RANK_ID_SEQ
  MINVALUE 1
  MAXVALUE 9999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

create table STUDENT_RANK
(
Student_ID number(15),
Rank_ID number(15),
Rank_Attain_Date date,
primary key (Student_ID,Rank_ID,Rank_Attain_Date),
CONSTRAINT fk_sr_student_id
    FOREIGN KEY (Student_ID)
    REFERENCES STUDENT_DETAILS (Student_ID),
CONSTRAINT fk_sr_Rank_id
    FOREIGN KEY (Rank_ID)
    REFERENCES BELT_RANK (Rank_ID)
);

create table STUDENT_FEE
(
Student_ID number(15),
Class_ID number(15),
Payment_Date date,
Fee_Amount number(15,2),
primary key (Student_ID,Class_ID, Payment_Date),
CONSTRAINT fk_sf_student_id
    FOREIGN KEY (Student_ID)
    REFERENCES STUDENT_DETAILS (Student_ID),
CONSTRAINT fk_sf_Class_ID
    FOREIGN KEY (Class_ID)
    REFERENCES Class_DETAILS (Class_ID)
);