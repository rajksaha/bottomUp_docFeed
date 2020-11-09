ALTER TABLE doctor_feed.appointment ADD updatedBy VARCHAR(100) NULL;
ALTER TABLE doctor_feed.appointment ADD updatedOn TIMESTAMP NULL;
ALTER TABLE doctor_feed.appointment ADD createdBy VARCHAR(100) NULL;
ALTER TABLE doctor_feed.appointment ADD createdOn TIMESTAMP NULL;

ALTER TABLE doctor_feed.menu_setting ADD updatedBy VARCHAR(100) NULL;
ALTER TABLE doctor_feed.menu_setting ADD updatedOn TIMESTAMP NULL;
ALTER TABLE doctor_feed.menu_setting ADD createdBy VARCHAR(100) NULL;
ALTER TABLE doctor_feed.menu_setting ADD createdOn TIMESTAMP NULL;


ALTER TABLE doctor_feed.prescription_complain CHANGE id complainId BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE doctor_feed.prescription_complain MODIFY appointMentID BIGINT NOT NULL;
ALTER TABLE doctor_feed.prescription_complain ADD updatedBy VARCHAR(100) NULL;
ALTER TABLE doctor_feed.prescription_complain ADD updatedOn TIMESTAMP NULL;
ALTER TABLE doctor_feed.prescription_complain ADD createdBy VARCHAR(100) NULL;
ALTER TABLE doctor_feed.prescription_complain ADD createdOn TIMESTAMP NULL;