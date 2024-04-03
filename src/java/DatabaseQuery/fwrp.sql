/* for FWRP by Dunxing Yu  */

DROP DATABASE IF EXISTS FWRP;
CREATE DATABASE FWRP;
use FWRP;
CREATE TABLE Users
(
   userID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   userName varchar(30) NOT NULL,
   userEmail varchar(30) NOT NULL,
   userPassword varchar(30) NOT NULL,
   userCity varchar(30) NOT NULL,
   userType varchar(30) NOT NULL,
   userPhone varchar(30) NOT NULL
);
CREATE TABLE Products
(
   productID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   productName varchar(30) NOT NULL,
   salePrice decimal NOT NULL,
   discountPrice decimal,
   inventoryAmount int NOT NULL,
   discountAmount int,
   donationAmount int,
   productType varchar(30) NOT NULL,
   surplusFlage varchar(4),
   userID int NOT NULL,
   expiryDate date,
   FOREIGN KEY (userID) References Users(userID)
);      

CREATE TABLE UserSubscription
(
usID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
userID int NOT NULL,
productType varchar(30) NOT NULL,
userCity varchar(30) NOT NULL,
surplusFlage varchar(4),
FOREIGN KEY (userID) References Users(userID)
);

CREATE VIEW DonationView AS
SELECT p.userID,productID, productName, donationAmount,userName as DonationCompany
FROM Products as p join users as u on p.userID = u.userID
WHERE donationAmount IS NOT NULL AND donationAmount > 0;

CREATE VIEW DiscountView AS
SELECT p.userID,productID, productName, discountAmount, discountPrice, userName as DiscountCompany
FROM Products as p join users as u on p.userID = u.userID
WHERE discountAmount IS NOT NULL AND discountAmount > 0;


INSERT INTO users (userName,userEmail,userPassword,userCity,userType,userPhone) VALUES ('admin','admin@admin.com','admin','ottawa','admin','6130000000');
INSERT INTO users (userName,userEmail,userPassword,userCity,userType,userPhone) VALUES ('Walmart','Walmart@Walmart.com','walmart','Toronto','retailer','4161234567');
INSERT INTO users (userName,userEmail,userPassword,userCity,userType,userPhone) VALUES ('loblaws','loblaws@loblaws.com','loblaws','Ottawa','retailer','6131234567');
INSERT INTO users (userName,userEmail,userPassword,userCity,userType,userPhone) VALUES ('foodbanks','foodbanks@foodbanks.com','foodbanks','Ottawa','charitable organization','6134445555');
INSERT INTO users (userName,userEmail,userPassword,userCity,userType,userPhone) VALUES ('foodMissions','foodMissions@foodMissions.com','foodMissions','Toronto','charitable organization','4165556666');
INSERT INTO users (userName,userEmail,userPassword,userCity,userType,userPhone) VALUES ('Tom','toms@gmail.com','toms','Ottawa','consumer','6132223333');
INSERT INTO users (userName,userEmail,userPassword,userCity,userType,userPhone) VALUES ('Mike','mike@gmail.com','mike','Toronto','consumer','4162221111');

INSERT INTO Products (productName, salePrice, inventoryAmount, productType, surplusFlage, userID, expiryDate)
VALUES
    ('Product1', 10.99, 100, 'A', 'Y', 3, '2024-04-30'),
    ('Product2', 15.99, 150, 'B', 'N', 2, '2025-04-30'),
    ('Product3', 20.49, 200, 'A', 'Y', 3, '2024-04-15'),
    ('Product4', 8.75, 75, 'C','N', 4, '2024-4-20'),
    ('Product5', 12.25, 120, 'D', 'Y', 2, '2024-04-25'),
    ('Product6', 18.99, 180, 'A', 'N', 3, '2024-10-10'),
    ('Product7', 9.99, 90, 'D', 'Y', 3, '2025-01-05'),
    ('Product8', 22.50, 250, 'A', 'N', 3, '2024-04-12'),
    ('Product9', 17.25, 130, 'B', 'Y', 2, '2024-05-15'),
    ('Product10', 11.49, 110, 'C', 'N', 3, '2024-07-01');
    
INSERT INTO UserSubscription (userID, productType,userCity)
VALUES
    (4, 'A','Ottawa'),
    (5, 'B','Toronto'),
    (6, 'C','Ottawa'),
    (7, 'A','Toronto');


update products set donationAmount =20.0  where productID = 6;
update products set donationAmount =50.0  where productID = 2;
update products set discountAmount =50.0  where productID = 3;
update products set discountAmount =50.0  where productID = 10;
select * from Products;
select * from users;
select * from DonationView;
select * from DiscountView;
select * from usersubscription;

