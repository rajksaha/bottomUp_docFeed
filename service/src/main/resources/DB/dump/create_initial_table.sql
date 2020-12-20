CREATE TABLE appointment
(
    appointmentID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	  appointmentType INT(11) NOT NULL,
	  doctorID BIGINT(20) NOT NULL,
    patientID BIGINT(20) NOT NULL,
    appDate DATE NOT NULL,
    addTime TIME NOT NULL,
    status INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn DATETIME,
    createdBy VARCHAR(100),
    createdOn DATETIME

);
CREATE TABLE appointment_type
(
    appointmentTypeID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    shortName VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP

);
CREATE TABLE bottom_up_company
(
    companyID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    companyCode VARCHAR(100),
    companyName VARCHAR(100),
    updatedOn TIMESTAMP,
    updatedBy VARCHAR(100),
    createdOn TIMESTAMP,
    createdBy VARCHAR(100)
);
CREATE TABLE bottom_up_company_module
(
    companyModuleID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    shortName VARCHAR(100),
    companyID INT(11),
    moduleID INT(11),
    updatedOn TIMESTAMP,
    updatedBy VARCHAR(100),
    createdOn TIMESTAMP,
    createdBy VARCHAR(100)
);
CREATE TABLE bottom_up_group_permission
(
    groupPermissionID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userGroupID INT(11),
    permissionID INT(11),
    statusValue INT(11),
    updatedOn TIMESTAMP,
    updatedBy VARCHAR(100),
    createdOn TIMESTAMP,
    createdBy VARCHAR(100)
);

CREATE TABLE bottom_up_module
(
    moduleID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    moduleName VARCHAR(255),
    moduleCode VARCHAR(64),
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);

CREATE TABLE bottom_up_permission
(
    permissionID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    companyModuleID INT(11),
    functionCode VARCHAR(100),
    shortName VARCHAR(45),
    updatedOn TIMESTAMP,
    updatedBy VARCHAR(100),
    createdOn TIMESTAMP,
    createdBy VARCHAR(100),
    isUserDefined INT(11)
);
CREATE TABLE bottom_up_user
(
    userID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userName VARCHAR(100),
    password VARCHAR(100),
    status INT(11),
    isBlocked TINYINT(4),
    companyID INT(11),
    secretKey TEXT,
    secretKeyCreatedOn TIMESTAMP,
    updatedOn TIMESTAMP,
    updatedBy VARCHAR(100),
    createdOn TIMESTAMP,
    createdBy VARCHAR(100)
);

CREATE TABLE bottom_up_user_group
(
    userGroupID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    shortName VARCHAR(45),
    longDesc VARCHAR(500),
    companyModuleID INT(11),
    updatedOn TIMESTAMP,
    updatedBy VARCHAR(100),
    createdOn TIMESTAMP,
    createdBy VARCHAR(100),
    companyID MEDIUMTEXT,
    isUserDefined INT(11)
);
CREATE TABLE bottom_up_user_group_assignment
(
    userGroupAssignmentID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userID INT(11),
    userGroupID INT(11),
    status INT(11),
    updatedOn TIMESTAMP,
    updatedBy VARCHAR(100),
    createdOn TIMESTAMP,
    createdBy VARCHAR(100)
);
CREATE TABLE bottom_up_user_profile
(
    userProfileID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userID INT(11),
    firstName VARCHAR(100),
    lastName VARCHAR(100),
    sex VARCHAR(45),
    emailAddress VARCHAR(100),
    dateOfBirth TIMESTAMP,
    contactNo VARCHAR(45),
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP,
    doctorID MEDIUMTEXT,
    address TEXT
);
CREATE TABLE content_advice
(
    adviceID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    type INT(11) NOT NULL,
    lang TINYINT(1) NOT NULL,
    advice TEXT NOT NULL,
    pdf VARCHAR(512) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE content_detail
(
    contentDetailID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    entityID INT(11) NOT NULL,
    entityType VARCHAR(40) NOT NULL,
    shortName TEXT,
    longDesc TEXT,
    url VARCHAR(1024),
    content TEXT,
    fileFormat VARCHAR(256),
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE content_disease
(
    diseaseID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    diseaseName VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE content_doctor_category
(
    categoryID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    categortName VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE content_dose_type
(
    doseTypeID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    bangla VARCHAR(255),
    english VARCHAR(255),
    pdf VARCHAR(255),
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL,
    doseCode INT(11) NOT NULL
);
CREATE TABLE content_drug
(
    drugID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    typeID INT(11) NOT NULL,
    genericID BIGINT(20),
    companyID BIGINT(20) NOT NULL,
    drugName VARCHAR(255) NOT NULL,
    strength VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE INDEX drugID ON content_drug (drugID, drugName);
CREATE INDEX strength ON content_drug (strength);
CREATE TABLE content_drug_advice
(
    drugAdviceID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorType INT(11) NOT NULL,
    bangla TEXT NOT NULL,
    english TEXT NOT NULL,
    pdf TEXT NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE content_drug_company
(
    drugCompanyID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    companyName VARCHAR(512) NOT NULL,
    folder VARCHAR(55) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE content_drug_type
(
    drugTypeID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    initial VARCHAR(10) NOT NULL,
    unit VARCHAR(25) NOT NULL,
    unitInitial VARCHAR(45) NOT NULL,
    optionalUnitInitial VARCHAR(45) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE UNIQUE INDEX name ON content_drug_type (name);
CREATE TABLE content_duration_type
(
    durationType INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    bangla VARCHAR(255) NOT NULL,
    pdf VARCHAR(255) NOT NULL,
    english VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE content_inv
(
    invID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    categoryID INT(11) NOT NULL,
    name TEXT NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE content_relation
(
    relationID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    relationName VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE content_symptom
(
    symptomID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    symptomName VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE content_vital
(
    vitalID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    vitalName VARCHAR(255) NOT NULL,
    shortName VARCHAR(255) NOT NULL,
    vitalUnit VARCHAR(45) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE content_vital_option
(
    vitalOptionID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    optionName VARCHAR(40) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP,
    vitalID BIGINT(20) NOT NULL
);
CREATE TABLE content_when_type
(
    whenTypeID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    bangla VARCHAR(255) NOT NULL,
    english VARCHAR(255) NOT NULL,
    pdf VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE doctor
(
    doctorID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userID BIGINT(20),
    doctorCode VARCHAR(15) NOT NULL,
    hospitalID BIGINT(20),
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE doctor_advice_disease_template
(
    templateID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorID BIGINT(20) NOT NULL,
    diseaseID INT(11) NOT NULL,
    adviceID INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE doctor_data_backup
(
    doctorID INT(11) PRIMARY KEY NOT NULL,
    lastBackupDate DATE NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE doctor_dose_drug_disease_template
(
    templateID BIGINT(20) NOT NULL,
    dose VARCHAR(100),
    numOfDay INT(11),
    durationType INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE doctor_drug_disease_template
(
    templateID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorID BIGINT(20) NOT NULL,
    diseaseID BIGINT(20) NOT NULL,
    drugTypeID INT(11) NOT NULL,
    drugID BIGINT(20) NOT NULL,
    drugTimeID INT(11) NOT NULL,
    drugDoseUnit VARCHAR(255) NOT NULL,
    drugWhenID INT(11) NOT NULL,
    drugAdviceID INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE doctor_drug_dose_setting
(
    drugDoseSettingID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    drugSettingID BIGINT(20) NOT NULL,
    dose VARCHAR(100),
    numOfDay INT(11),
    durationType INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE UNIQUE INDEX doctorDrugDoseID ON doctor_drug_dose_setting (drugDoseSettingID);
CREATE TABLE doctor_drug_setting
(
    drugSettingID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorID BIGINT(20),
    drugID BIGINT(20) NOT NULL,
    drugDoseUnit VARCHAR(255),
    drugWhenID INT(11),
    drugAdviceID INT(11),
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP,
    doseTypeCode INT(11)
);
CREATE TABLE doctor_follow_up_setting
(
    followUpSettingID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorID BIGINT(20) NOT NULL,
    invID INT(11) NOT NULL,
    patientTypeId INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE doctor_history_setting
(
    historySettingID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorID BIGINT(20) NOT NULL,
    historyID INT(11) NOT NULL,
    displayOrder INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE doctor_inv_disease_template
(
    templateID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorID BIGINT(20) NOT NULL,
    diseaseID INT(11) NOT NULL,
    invID INT(11) NOT NULL,
    note TEXT NOT NULL,
    checked INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE doctor_preference_advice
(
    advicePreferenceID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorID BIGINT(20) NOT NULL,
    adviceID BIGINT(20) NOT NULL,
    displayOrder INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE doctor_preference_inv
(
    invPreferenceID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorID BIGINT(20) NOT NULL,
    invID INT(11) NOT NULL,
    displayOrder INT(11),
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE doctor_setting
(
    doctorSettingID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorID BIGINT(20) NOT NULL,
    category INT(11) NOT NULL,
    state TINYINT(1) NOT NULL,
    patientType INT(11) NOT NULL,
    patientState INT(11) NOT NULL,
    prescriptionStyle TINYINT(1) NOT NULL,
    companyID BIGINT(20) NOT NULL,
    photoSupport TINYINT(1) NOT NULL,
    personCodeInitial INT(16) NOT NULL,
    pdfPage VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE UNIQUE INDEX doctorId ON doctor_setting (doctorID);
CREATE TABLE doctor_vital_setting
(
    vitalSettingID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorID BIGINT(20) NOT NULL,
    vitalID INT(11) NOT NULL,
    displayOrder INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE follow_up_result
(
    resultID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    appID INT(11) NOT NULL,
    followUpID INT(11) NOT NULL,
    data TEXT NOT NULL,
    entryDate DATE NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE history
(
    historyID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    typeCode VARCHAR(45) NOT NULL,
    name VARCHAR(255) NOT NULL,
    shortName VARCHAR(45) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE history_option
(
    historyID INT(11) NOT NULL,
    optionName VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE inv_category
(
    invCategoryID INT(11) PRIMARY KEY NOT NULL,
    name VARCHAR(250) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE inv_report
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    invPrescribeID INT(11) NOT NULL,
    result TEXT NOT NULL,
    status TINYINT(1) NOT NULL
);
CREATE TABLE inv_report_date
(
    invReportDateId INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patientId INT(11) NOT NULL,
    reportDate DATE NOT NULL,
    reportLocation TEXT NOT NULL,
    fileName VARCHAR(55) NOT NULL,
    ext VARCHAR(55) NOT NULL
);
CREATE TABLE menu
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    menuID INT(11) NOT NULL,
    menuURL VARCHAR(255) NOT NULL,
    defaultName VARCHAR(255) NOT NULL,
    isPopUp INT(11) NOT NULL,
    functionName VARCHAR(100) NOT NULL,
    inPrescription TINYINT(1) NOT NULL,
    displayOrder INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE menu_setting
(
    menuSettingID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorID INT(11) NOT NULL,
    menuID INT(11) NOT NULL,
    menuHeader VARCHAR(45) NOT NULL,
    `order` INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE patient
(
    patientID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userID BIGINT(20),
    patientCode VARCHAR(15) NOT NULL,
    occupation VARCHAR(245),
    referredBy VARCHAR(245),
    hospitalName VARCHAR(255),
    bedNum VARCHAR(55),
    wardNum VARCHAR(55),
    headOfUnit VARCHAR(255),
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP,
    patientType INT(11),
    imageURL VARCHAR(1024)
);
CREATE TABLE patient_detail
(
    patientID BIGINT(20) NOT NULL,
    type INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE UNIQUE INDEX patientID ON patient_detail (patientID);
CREATE TABLE patient_drug_history
(
    drugHistoryID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patientID BIGINT(20) NOT NULL,
    drugName VARCHAR(100) NOT NULL,
    currentStatus TINYINT(1) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE patient_family_history
(
    familyHistoryID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patientID BIGINT(20) NOT NULL,
    diseaseID INT(11) NOT NULL,
    relation INT(11) NOT NULL,
    present VARCHAR(45) NOT NULL,
    type VARCHAR(255) NOT NULL,
    detail TEXT,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE patient_follow_up
(
    patientFollowUpID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patientID INT(11) NOT NULL,
    doctorID INT(11) NOT NULL,
    invID INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE patient_history
(
    patientHistoryID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patientID BIGINT(20) NOT NULL,
    historyID BIGINT(20) NOT NULL,
    historyResult VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE patient_past_disease
(
    patientPastDiseaseID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patientID BIGINT(20) NOT NULL,
    diseaseID INT(11) NOT NULL,
    isPresent TINYINT(1) NOT NULL,
    detail TEXT NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE patient_type
(
    patientTypeID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorType INT(11) NOT NULL,
    typeName VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP

);
CREATE TABLE prescription_advice
(
    presAdviceID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    appointmentID BIGINT(20) NOT NULL,
    adviceID BIGINT(20) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE prescription_complain
(
    complainID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    appointmentID BIGINT(20) NOT NULL,
    symptomID INT(11) NOT NULL,
    durationNum DOUBLE NOT NULL,
    durationType INT(11),
    detail TEXT,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE prescription_diagnosis
(
    diagnosisID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    appointmentID BIGINT(20) NOT NULL,
    diseaseID INT(11) NOT NULL,
    note TEXT,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE prescription_drug
(
    presDrugID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    appointmentID BIGINT(20) NOT NULL,
    doseTypeCode INT(11),
    drugTypeID INT(11) NOT NULL,
    drugID BIGINT(20) NOT NULL,
    drugDoseUnit VARCHAR(45) NOT NULL,
    drugWhenID INT(11),
    drugAdviceID INT(11),
    presNum INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP

);
CREATE TABLE prescription_drug_dose
(
    presDrugID BIGINT(20) NOT NULL,
    dose VARCHAR(160),
    numOfDay DOUBLE,
    durationType INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE prescription_family_disease
(
    presFamilyDiseaseID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    appointmentID BIGINT(20) NOT NULL,
    familyDiseaseID INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP

);
CREATE TABLE prescription_history
(
    presHistoryID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patientHistoryID BIGINT(20) NOT NULL,
    appointmentID BIGINT(20) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP

);
CREATE TABLE prescription_inv
(
    presInvID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    appointmentID BIGINT(20) NOT NULL,
    invID INT(11) NOT NULL,
    note TEXT,
    checked INT(11),
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP

);
CREATE TABLE prescription_next_visit
(
    presNextVisitID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    appointmentID BIGINT(20) NOT NULL,
    nextVisitType INT(11) NOT NULL,
    visitDate DATE,
    durationType INT(11),
    numOfDay INT(11),
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL
);
CREATE TABLE prescription_past_disease
(
    presPastDiseaseID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    appointmentID BIGINT(20) NOT NULL,
    pastDiseaseID INT(11) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP

);
CREATE TABLE prescription_reference
(
    prescriptionReferenceID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    appointmentID BIGINT(20) NOT NULL,
    referredDoctorID BIGINT(20) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE prescription_vital
(
    presVitalID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    appointMentID BIGINT(20) NOT NULL,
    vitalID BIGINT(20) NOT NULL,
    vitalResult VARCHAR(255) NOT NULL,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP
);
CREATE TABLE referred_doctor
(
    referredDoctorID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctorName VARCHAR(255) NOT NULL,
    doctorAddress TEXT,
    updatedBy VARCHAR(100),
    updatedOn TIMESTAMP,
    createdBy VARCHAR(100),
    createdOn TIMESTAMP

);