/* for FWRP by Dunxing Yu  */

DROP DATABASE IF EXISTS FWRP;
CREATE DATABASE FWRP;
use FWRP;
CREATE TABLE Users
(
   userID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   userName varchar(30) NOT NULL,
   userEmail varchar(30) NOT NULL,
   userPhoneNumber varchar(30) NOT NULL,
   userPassword varchar(30) NOT NULL,
   userCity varchar(30) NOT NULL,
   userType varchar(30) NOT NULL
);
-- CREATE TABLE Products
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

-- CREATE TABLE UserSubscription
CREATE TABLE UserSubscription
(
    subscriptionID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userID int NOT NULL,
    productType varchar(30) NOT NULL,
    communicationMethod  varchar(30),
    userEmail  varchar(30),
    userPhoneNumber  varchar(30),
    userCity varchar(30) NOT NULL,
    surplusFlage varchar(4),
    FOREIGN KEY (userID) References Users(userID)
);
-- CREATE TABLE ProductTypes


-- CREATE TABLE SubscriptionMsg
CREATE TABLE SubscriptionMsg
(
 ID  int NOT NULL AUTO_INCREMENT PRIMARY KEY,
 senderName varchar(100) NOT NULL,
 recipientID int NOT NULL,
 content varchar(200) NOT NULL,
 dateSent date
);

CREATE VIEW DonationView AS
SELECT p.userID as uID,productID, productName, donationAmount,u.userName as DonationCompany
FROM Products as p join users as u on p.userID = u.userID
WHERE donationAmount IS NOT NULL AND donationAmount > 0;

CREATE VIEW DiscountView As
SELECT p.userID as uID,productID, productName, discountAmount, discountPrice, u.userName as DiscountCompany
FROM Products as p join users as u on p.userID = u.userID
WHERE discountAmount IS NOT NULL AND discountAmount > 0;


INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('admin','admin@admin.com','6130000000','admin','ottawa','admin');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('Walmart','Walmart@Walmart.com','4161234567','walmart','Toronto','retailer');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('loblaws','loblaws@loblaws.com','6131234567','loblaws','Ottawa','retailer');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('foodbanks','foodbanks@foodbanks.com','6134445555','foodbanks','Ottawa','charitable organization');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('foodMissions','foodMissions@foodMissions.com','4165556666','foodMissions','Toronto','charitable organization');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('Tom','toms@gmail.com','6132223333','toms','Ottawa','consumer');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('Mike','mike@gmail.com','4162221111','mike','Toronto','consumer');
-- INSERT product TO Products
INSERT INTO Products (productName, salePrice, inventoryAmount, productType, surplusFlage, userID, expiryDate)
VALUES
    ('Product1', 10.99, 100, 'bread', 'Y', 3, '2024-04-30'),
    ('Product2', 15.99, 150, 'bread', 'N', 2, '2025-04-30'),
    ('Product3', 20.49, 200, 'meat', 'Y', 3, '2024-04-15'),
    ('Product4', 8.75, 75, 'meat','N', 2, '2024-4-20'),
    ('Product5', 12.25, 120, 'friut', 'Y', 3, '2024-04-25'),
    ('Product6', 18.99, 180, 'friut', 'N', 2, '2024-10-10'),
    ('Product7', 9.99, 90, 'vegi', 'Y', 3, '2025-01-05'),
    ('Product8', 22.50, 250, 'vegi', 'N', 2, '2024-04-12'),
    ('Product9', 17.25, 130, 'dairy', 'Y', 3, '2024-05-15'),
    ('Product10', 11.49, 110, 'dairy', 'N', 2, '2024-07-01');
    
-- INSERT records TO UserSubscription    
INSERT INTO UserSubscription (userID, productType,userCity)
VALUES
    (6, 'meat','Ottawa'),
    (7, 'meat','Ottawa'),
    (6, 'bread','Ottawa'),
    (7, 'bread','Toronto');
-- CREATE VIEW ProductTypes
CREATE VIEW ProductTypes AS 
SELECT DISTINCT productType FROM Products;


-- INSERT records TO subscriptionMsg
INSERT INTO subscriptionMsg (senderName,recipientID,content,dateSent)
VALUES
    ('walmart',6,'meat','2024-04.01'),
    ('walmart',6,'fruit','2024-04.03'),
    ('loblaws',7,'meat','2024-04.01'),
    ('loblaws',7,'fruit','2024-04.03');


update products set donationAmount =20.0  where productID = 6;
update products set donationAmount =50.0  where productID = 2;
update products set discountAmount =50.0  where productID = 3;
update products set discountAmount =50.0  where productID = 10;
select * from Products where userID=2 and surplusFlage='Y';
select * from users;
select * from DonationView where uID =2;
select * from DiscountView;
select * from usersubscription;
update discountview set discountPrice =20  where productID = 10;
select * from subscriptionMsg;

