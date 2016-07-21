--------------------------------------------------------
--  File created - Thursday-July-21-2016   
--------------------------------------------------------
DROP TABLE "ORA1"."HCUSER";
DROP TABLE "ORA1"."HCSTUDENTS";
DROP TABLE "ORA1"."HCINSTRUCTOR";
DROP TABLE "ORA1"."HCCOURSES";
DROP TABLE "ORA1"."HCCLASSROSTER";
DROP TABLE "ORA1"."HCCLASSES";
--------------------------------------------------------
--  DDL for Table HCUSER
--------------------------------------------------------

  CREATE TABLE "ORA1"."HCUSER" 
   (	"USERID" NUMBER, 
	"FIRSTNAME" VARCHAR2(50 BYTE), 
	"LASTNAME" VARCHAR2(50 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"PASSWORD" VARCHAR2(50 BYTE), 
	"USERNAME" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HCSTUDENTS
--------------------------------------------------------

  CREATE TABLE "ORA1"."HCSTUDENTS" 
   (	"STUDENTID" NUMBER, 
	"USERID" NUMBER, 
	"MAJOR" VARCHAR2(20 BYTE), 
	"ENTRYYEAR" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HCINSTRUCTOR
--------------------------------------------------------

  CREATE TABLE "ORA1"."HCINSTRUCTOR" 
   (	"INSTRUCTORID" NUMBER, 
	"USERID" NUMBER, 
	"DEPTNUMBER" NUMBER, 
	"OFFICENUMBER" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HCCOURSES
--------------------------------------------------------

  CREATE TABLE "ORA1"."HCCOURSES" 
   (	"COURSEID" NUMBER, 
	"CRN" VARCHAR2(20 BYTE), 
	"DEPT" VARCHAR2(20 BYTE), 
	"COURSEDESCRIPTION" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HCCLASSROSTER
--------------------------------------------------------

  CREATE TABLE "ORA1"."HCCLASSROSTER" 
   (	"ROSTERID" VARCHAR2(20 BYTE), 
	"STUDENTID" NUMBER, 
	"CLASSID" NUMBER, 
	"CLASSNAME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HCCLASSES
--------------------------------------------------------

  CREATE TABLE "ORA1"."HCCLASSES" 
   (	"CLASSID" NUMBER, 
	"INSTRUCTORID" NUMBER, 
	"CRN" VARCHAR2(20 BYTE), 
	"DESCRIPTION" VARCHAR2(20 BYTE), 
	"TIME" VARCHAR2(20 BYTE), 
	"LOCATION" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into ORA1.HCUSER
SET DEFINE OFF;
Insert into ORA1.HCUSER (USERID,FIRSTNAME,LASTNAME,EMAIL,PASSWORD,USERNAME) values (11,'Joshua','Tucker','jptucker2009@gmail.com','password','Josh');
REM INSERTING into ORA1.HCSTUDENTS
SET DEFINE OFF;
Insert into ORA1.HCSTUDENTS (STUDENTID,USERID,MAJOR,ENTRYYEAR) values (1,11,'Science','2016');
REM INSERTING into ORA1.HCINSTRUCTOR
SET DEFINE OFF;
REM INSERTING into ORA1.HCCOURSES
SET DEFINE OFF;
REM INSERTING into ORA1.HCCLASSROSTER
SET DEFINE OFF;
REM INSERTING into ORA1.HCCLASSES
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index HCUSER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORA1"."HCUSER_PK" ON "ORA1"."HCUSER" ("USERID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HCSTUDENTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORA1"."HCSTUDENTS_PK" ON "ORA1"."HCSTUDENTS" ("STUDENTID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HCINSTRUCTOR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORA1"."HCINSTRUCTOR_PK" ON "ORA1"."HCINSTRUCTOR" ("INSTRUCTORID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HCCOURSES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORA1"."HCCOURSES_PK" ON "ORA1"."HCCOURSES" ("COURSEID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HCCLASSROSTER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORA1"."HCCLASSROSTER_PK" ON "ORA1"."HCCLASSROSTER" ("ROSTERID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HCCLASSES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORA1"."HCCLASSES_PK" ON "ORA1"."HCCLASSES" ("CLASSID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table HCUSER
--------------------------------------------------------

  ALTER TABLE "ORA1"."HCUSER" ADD CONSTRAINT "HCUSER_PK" PRIMARY KEY ("USERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA1"."HCUSER" MODIFY ("USERID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HCSTUDENTS
--------------------------------------------------------

  ALTER TABLE "ORA1"."HCSTUDENTS" ADD CONSTRAINT "HCSTUDENTS_PK" PRIMARY KEY ("STUDENTID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA1"."HCSTUDENTS" MODIFY ("STUDENTID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HCINSTRUCTOR
--------------------------------------------------------

  ALTER TABLE "ORA1"."HCINSTRUCTOR" ADD CONSTRAINT "HCINSTRUCTOR_PK" PRIMARY KEY ("INSTRUCTORID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA1"."HCINSTRUCTOR" MODIFY ("INSTRUCTORID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HCCOURSES
--------------------------------------------------------

  ALTER TABLE "ORA1"."HCCOURSES" ADD CONSTRAINT "HCCOURSES_PK" PRIMARY KEY ("COURSEID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA1"."HCCOURSES" MODIFY ("DEPT" NOT NULL ENABLE);
  ALTER TABLE "ORA1"."HCCOURSES" MODIFY ("COURSEID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HCCLASSROSTER
--------------------------------------------------------

  ALTER TABLE "ORA1"."HCCLASSROSTER" ADD CONSTRAINT "HCCLASSROSTER_PK" PRIMARY KEY ("ROSTERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA1"."HCCLASSROSTER" MODIFY ("ROSTERID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HCCLASSES
--------------------------------------------------------

  ALTER TABLE "ORA1"."HCCLASSES" ADD CONSTRAINT "HCCLASSES_PK" PRIMARY KEY ("CLASSID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA1"."HCCLASSES" MODIFY ("CLASSID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table HCSTUDENTS
--------------------------------------------------------

  ALTER TABLE "ORA1"."HCSTUDENTS" ADD CONSTRAINT "HCSTUDENTS_FK1" FOREIGN KEY ("USERID")
	  REFERENCES "ORA1"."HCUSER" ("USERID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HCINSTRUCTOR
--------------------------------------------------------

  ALTER TABLE "ORA1"."HCINSTRUCTOR" ADD CONSTRAINT "HCINSTRUCTOR_FK1" FOREIGN KEY ("USERID")
	  REFERENCES "ORA1"."HCUSER" ("USERID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HCCLASSROSTER
--------------------------------------------------------

  ALTER TABLE "ORA1"."HCCLASSROSTER" ADD CONSTRAINT "HCCLASSROSTER_FK1" FOREIGN KEY ("CLASSID")
	  REFERENCES "ORA1"."HCCLASSES" ("CLASSID") ENABLE;
  ALTER TABLE "ORA1"."HCCLASSROSTER" ADD CONSTRAINT "HCCLASSROSTER_FK2" FOREIGN KEY ("STUDENTID")
	  REFERENCES "ORA1"."HCSTUDENTS" ("STUDENTID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HCCLASSES
--------------------------------------------------------

  ALTER TABLE "ORA1"."HCCLASSES" ADD CONSTRAINT "HCCLASSES_FK1" FOREIGN KEY ("INSTRUCTORID")
	  REFERENCES "ORA1"."HCINSTRUCTOR" ("INSTRUCTORID") ENABLE;
--------------------------------------------------------
--  DDL for Trigger HCUSER_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "ORA1"."HCUSER_TRG" 
BEFORE INSERT ON HCUSER 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.USERID IS NULL THEN
      SELECT HCUSER_SEQ.NEXTVAL INTO :NEW.USERID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "ORA1"."HCUSER_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HCSTUDENTS_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "ORA1"."HCSTUDENTS_TRG" 
BEFORE INSERT ON HCSTUDENTS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.STUDENTID IS NULL THEN
      SELECT HCSTUDENTS_SEQ.NEXTVAL INTO :NEW.STUDENTID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "ORA1"."HCSTUDENTS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HCCOURSES_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "ORA1"."HCCOURSES_TRG" 
BEFORE INSERT ON HCCOURSES 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.COURSEID IS NULL THEN
      SELECT HCCOURSES_SEQ.NEXTVAL INTO :NEW.COURSEID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "ORA1"."HCCOURSES_TRG" ENABLE;
