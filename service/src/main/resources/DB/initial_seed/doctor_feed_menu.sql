DROP TABLE doctor_feed.menu;
CREATE TABLE menu
(
  menuID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  menuURL VARCHAR(255) NOT NULL,
  defaultName VARCHAR(255) NOT NULL,
  isPopUp INT NOT NULL,
  functionName VARCHAR(100) NOT NULL,
  inPrescription TINYINT(1) NOT NULL,
  displayOrder INT NOT NULL,
  updatedBy VARCHAR(100),
  updatedOn TIMESTAMP,
  createdBy VARCHAR(100),
  createdOn TIMESTAMP
);
INSERT INTO doctor_feed.menu (menuURL, defaultName, isPopUp, functionName, inPrescription, displayOrder, updatedBy, updatedOn, createdBy, createdOn) VALUES ('#/history?histpryType=MH', 'MH', 1, '', 2, 0, null, null, null, null);
INSERT INTO doctor_feed.menu (menuURL, defaultName, isPopUp, functionName, inPrescription, displayOrder, updatedBy, updatedOn, createdBy, createdOn) VALUES ('#/history?histpryType=OBS', 'OBS', 1, '', 2, 0, null, null, null, null);
INSERT INTO doctor_feed.menu (menuURL, defaultName, isPopUp, functionName, inPrescription, displayOrder, updatedBy, updatedOn, createdBy, createdOn) VALUES ('#/history?histpryType=RISK', 'RISK', 1, '', 2, 0, null, null, null, null);
INSERT INTO doctor_feed.menu (menuURL, defaultName, isPopUp, functionName, inPrescription, displayOrder, updatedBy, updatedOn, createdBy, createdOn) VALUES ('#/history?histpryType=ALLERGY', 'ALLERGY', 1, '', 2, 0, null, null, null, null);
INSERT INTO doctor_feed.menu (menuURL, defaultName, isPopUp, functionName, inPrescription, displayOrder, updatedBy, updatedOn, createdBy, createdOn) VALUES ('#/history?histpryType=HABBIT', 'HABBIT', 1, '', 2, 0, null, null, null, null);