ALTER TABLE doctor_feed.menusettings RENAME TO doctor_feed.menuSetting;
ALTER TABLE doctor_feed.menu_setting CHANGE id menuSettingID INT(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE doctor_feed.menusetting RENAME TO doctor_feed.menu_setting;

ALTER TABLE doctor_feed.reffered_doctor RENAME TO doctor_feed.referred_doctor;
ALTER TABLE doctor_feed.referred_doctor CHANGE refferedDoctorID referredDoctorID BIGINT(20) NOT NULL AUTO_INCREMENT;