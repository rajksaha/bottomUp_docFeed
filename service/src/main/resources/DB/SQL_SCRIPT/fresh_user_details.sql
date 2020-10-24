TRUNCATE  TABLE bottom_up_module;
TRUNCATE  TABLE bottom_up_permission;
TRUNCATE  TABLE bottom_up_company;
TRUNCATE  TABLE bottom_up_company_module;
TRUNCATE  TABLE bottom_up_user_group;
TRUNCATE  TABLE bottom_up_group_permission;
TRUNCATE  TABLE bottom_up_user_group_assignment;
TRUNCATE  TABLE bottom_up_user_profile;
TRUNCATE  TABLE bottom_up_user;

INSERT INTO `bottom_up_user`
(
  `userName`,
  `password`,
  `status`,
  `isBlocked`,
  `companyID`,
  `secretKey`,
  `secretKeyCreatedOn`,
  `updatedOn`,
  `updatedBy`,
  `createdOn`,
  `createdBy`
)
VALUES
  (
    'mathauser',
    '7c4a8d09ca3762af61e59520943dc26494f8941b',
    1,
    0,
    NULL ,
    NULL ,
    NULL,
    NOW(),
    'system',
    NOW(),
    'system'
  );


INSERT INTO `bottom_up_user_profile`
(
`userID`,
`firstName`,
`lastName`,
`emailAddress`,
`contactNo`,
`updatedOn`,
`updatedBy`,
`createdOn`,
`createdBy`

)
VALUES
(
1,
'Super Admin',
'',
'rajkapursaha@gmail.com',
'+60149314279',
NOW(),
'system',
NOW(),
'system'
)

