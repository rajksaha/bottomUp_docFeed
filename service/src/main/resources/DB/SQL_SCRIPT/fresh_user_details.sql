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
'c49f62c6-c140-11eb-a1cb-0668c7450820',
'Super Admin',
'',
'rajkapursaha@gmail.com',
'+60149314279',
NOW(),
'system',
NOW(),
'system'
)

