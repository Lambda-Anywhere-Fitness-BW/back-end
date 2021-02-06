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
    VALUES (1,'Justin Benz', 'jusbenz', 'justin@host.local', '$2y$12$x2dLGInRrJV1s5lXutP1Gu4YqI0Kw1675htPUf.78exw79LtyB5Bm', 'Coffee enthusiast. Professional web advocate. Explorer. Certified troublemaker. Travel practitioner. Student. Creator.', 'https://cdn.discordapp.com/attachments/194052884336345089/806302497274069042/gucciturtle.jpg', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2,'Ruben Ramirez', 'rubenar', 'ruben@host.local', '$2y$12$xQ45OZBXOpv0yeuaP06mA.oze3.krSHBNV.0a3Lt3cja6XWqpjbkS', 'Amateur pop cultureaholic. Certified creator. Travel trailblazer. Professional beer fanatic. Thinker. Coffee evangelist.', 'https://cdn.discordapp.com/attachments/194052884336345089/806304255170052176/cate.jpg', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (3,'Andrew Sohrabi', 'asohrabi', 'andrew@host.local', '$2y$12$uEGryxrAlzz4R/7nuZhT0uDU15ajIyTNWDvcBvFeRelYTltWUOwOO', 'Web expert. Amateur reader. Entrepreneur. Freelance coffee ninja. Beer maven. Proud analyst. Bacon junkie. Problem solver. Organizer.', 'https://cdn.discordapp.com/attachments/194052884336345089/806306531888070706/steviecat.jpg', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (4,'Emma Cooper', 'ecoupez', 'emma@host.local', '$2y$12$Qs1FL.BtdKSuB1HSKn17tOgEn8J2y.a.W7WJ1hoeH2qOdmpyoXoUq', 'Travel lover. Bacon guru. Music scholar. Unapologetic alcohol enthusiast. Twitter buff. Social media junkie. Thinker. Student.', 'https://cdn.discordapp.com/attachments/194052884336345089/806310316086525993/okdog.png','SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (5,'Jamie Cassidy', 'jcassidy', 'jamie@host.local', '$2y$12$5AjoCXBaRcMMVE/QGdraV.cLN5KPDO0c/wUGzBsFBoSNfdu4I3Kfm', 'Alcohol buff. Music advocate. Award-winning beer fanatic. Problem solver. Incurable internet fan. Food ninja. Explorer.', 'https://cdn.discordapp.com/attachments/194052884336345089/806675904889225216/cudi-blur.jpg', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO USERROLES(USERID, ROLEID, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
    VALUES (1, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (3, 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (4, 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (5, 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

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

INSERT INTO FITNESSCLASSES(FITNESSCLASSID, INSTRUCTORID, FITNESSCLASSTYPEID, NAME, DATE, DESCRIPTION, STARTTIME, DURATION, INTENSITYLEVEL, LOCATION, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
    VALUES (1, 3, 1, 'Pilates101','February 12th','The jacket fits him like a glove, a tailored glove. It has a subtle pinstripe pattern which gives the suit an elegant look. The 3 buttons of his single breasted jacket have been left unbuttoned, buttoned up wouldve made the overall look too fancy for his taste.
The jacket is the same length all around, it has vents at either side, theres a single pocket on one side and theres a breast pocket which has been left empty', '12:00 PM', '30 minutes', 1, 'Planet Fitness', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2, 4, 3, 'HIIT for dummies','March 3rd','This special and rare creature is a type of mammal. Its about the size of a tiger, has six legs, but they have no tail.
They have a soft, smooth skin covered in short, soft hairs which is usually either light bronze, light pink, purple, light orange or bronze or a combination of these colors.', '2:30 PM', '1 hour', 2, 'Iron Gym', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (3, 3, 2, 'Extreme Gymnastics','April 2nd','These creatures are very peaceful, but theyre very territorial. They mate once every nine to ten months and they mate with a select few partners throughout life. Which, with their long lifepans, is to be expected.', '11:00 AM', '2 hours', 3, 'YMCA', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (4, 4, 4, 'Lose Weight With NO Weights!','December 11th','This adorable and incredibily rare creature is a type of reptile. It''s about the size of a viper, has four legs and a long, useless tail.
They have a thick, rough skin covered in thin, coarse scales, which is usually either dark orange, white, black or purple or a combination of these colors.','45 minutes', '1 hour and 30 minutes', 1, 'The Upside Down', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO CLIENTFITNESSCLASSES(CLIENTID, FITNESSCLASSID, MAXPUNCHES, PUNCHES, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
    VALUES (1, 1, 20, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2, 2, 10, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (1, 3, 5, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2, 4, 15, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);


alter sequence hibernate_sequence restart with 15;