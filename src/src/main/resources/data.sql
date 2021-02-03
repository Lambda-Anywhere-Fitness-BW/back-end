DELETE
FROM users;

DELETE
FROM clients;

DELETE
FROM instructors;

DELETE
FROM userroles;

DELETE
FROM roles;

DELETE
FROM fitnessclasses;

DELETE
FROM fitnessclasstypes;

INSERT INTO ROLES(ROLEID, NAME, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
    VALUES (1, 'CLIENT', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP ),
           (2, 'INSTRUCTOR', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP );

INSERT INTO USERS(USERID, NAME, USERNAME, EMAIL, PASSWORD, BIO, AVIURL, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
    VALUES (1,'Justin Benz', 'jusbenz', 'justin@host.local', 'pufflah', 'Coffee enthusiast. Professional web advocate. Explorer. Certified troublemaker. Travel practitioner. Student. Creator.', 'https://cdn.discordapp.com/attachments/194052884336345089/806302497274069042/gucciturtle.jpg', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2,'Ruben Ramirez', 'rubenar', 'ruben@host.local', 'arbysreuben', 'Amateur pop cultureaholic. Certified creator. Travel trailblazer. Professional beer fanatic. Thinker. Coffee evangelist.', 'https://cdn.discordapp.com/attachments/194052884336345089/806304255170052176/cate.jpg', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (3,'Andrew Sohrabi', 'asohrabi', 'andrew@host.local', 'owaowa', 'Web expert. Amateur reader. Entrepreneur. Freelance coffee ninja. Beer maven. Proud analyst. Bacon junkie. Problem solver. Organizer.', 'https://cdn.discordapp.com/attachments/194052884336345089/806306531888070706/steviecat.jpg', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (4,'Emma Cooper', 'ecoupez', 'emma@host.local', 'emC124', 'Travel lover. Bacon guru. Music scholar. Unapologetic alcohol enthusiast. Twitter buff. Social media junkie. Thinker. Student.', 'https://cdn.discordapp.com/attachments/194052884336345089/806310316086525993/okdog.png','SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO USERROLES(USERID, ROLEID, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
    VALUES (1, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (3, 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (4, 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO CLIENTS(CLIENTID, USERID, FITNESSLEVEL, LOCATION, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
    VALUES (1, 1, 3, 'Guayaba, Dominican Republic', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2, 2, 2, 'Gogosu, Romania', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO INSTRUCTORS(INSTRUCTORID, USERID, YEARSEXP, CREDENTIALS, SPECIALTY, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
    VALUES (3, 3, 25, 'Done a lot', 'p90X', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP ),
           (4, 4, 13, 'Done some', 'zoomba', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP );

INSERT INTO FITNESSCLASSTYPES(FITNESSCLASSTYPEID, NAME)
    VALUES (1, 'Contrology'),
           (2, 'Interval Training'),
           (3, 'Gymnastics'),
           (4, 'Kalisthenics');

INSERT INTO FITNESSCLASSES(FITNESSCLASSID, INSTRUCTORID, FITNESSCLASSTYPEID, NAME, STARTTIME, DURATION, INTENSITYLEVEL, LOCATION, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
    VALUES (1, 3, 1, 'Pilates101', '12:00 PM', '30 minutes', 1, 'Planet Fitness', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2, 4, 3, 'HIIT for dummies', '2:30 PM', '1 hour', 2, 'Iron Gym', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (3, 3, 2, 'Extreme Gymnastics', '11:00 AM', '2 hours', 3, 'YMCA', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (4, 4, 4, 'Lose Weight With NO Weights!', '45 minutes', '1 hour and 30 minutes', 1, 'The Upside Down', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO CLIENTFITNESSCLASSES(CLIENTID, FITNESSCLASSID, MAXPUNCHES, PUNCHES, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
    VALUES (1, 1, 20, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2, 2, 10, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (1, 3, 5, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2, 4, 15, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);




alter sequence hibernate_sequence restart with 15;