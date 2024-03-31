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
   userType varchar(30) NOT NULL
  
);
CREATE TABLE Products
(
   productID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   productName varchar(30) NOT NULL,
   salePrice decimal NOT NULL,
   discountPrice decimal,
   inventoryAmount decimal NOT NULL,
   discountAmount decimal,
   donationAmount decimal,
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
FOREIGN KEY (userID) References Users(userID)
);
CREATE VIEW Donation_view AS
SELECT productID, productName, donationAmount,userName as DonationCompany
FROM Products as p join users as u on p.userID = u.userID
WHERE donationAmount IS NOT NULL AND donationAmount <> 0;

CREATE VIEW Discount_view AS
SELECT userName,productID, productName, discountAmount, discountPrice, userName as DonationCompany
FROM Products as p join users as u on p.userID = u.userID
WHERE discountAmount IS NOT NULL AND discountAmount <> 0;


INSERT INTO users (userName,userEmail,userPassword,userCity,userType) VALUES ('admin','admin@admin.com','admin','ottawa','admin');
INSERT INTO users (userName,userEmail,userPassword,userCity,userType) VALUES ('Walmart','Walmart@Walmart.com','walmart','Toronto',"retailer");
INSERT INTO users (userName,userEmail,userPassword,userCity,userType) VALUES ('loblaws','loblaws@loblaws.com','loblaws','ottawa',"retailer");
INSERT INTO users (userName,userEmail,userPassword,userCity,userType) VALUES ('foodbanks','foodbanks@foodbanks.com','foodbanks','ottawa',"charitable organization");
INSERT INTO users (userName,userEmail,userPassword,userCity,userType) VALUES ('foodMissions','foodMissions@foodMissions.com','foodMissions','ottawa',"charitable organization");
INSERT INTO users (userName,userEmail,userPassword,userCity,userType) VALUES ('Tom','toms@gmail.com','toms','ottawa',"consumer");
INSERT INTO users (userName,userEmail,userPassword,userCity,userType) VALUES ('Mike','mike@gmail.com','mike','Toronto',"consumer");

INSERT INTO Products (productName, salePrice, inventoryAmount, productType, surplusFlage, userID, expiryDate)
VALUES
    ('Product1', 10.99, 100, 'A', 'Y', 1, '2024-04-30'),
    ('Product2', 15.99, 150, 'B', 'N', 2, '2025-04-30'),
    ('Product3', 20.49, 200, 'A', 'Y', 3, '2024-04-15'),
    ('Product4', 8.75, 75, 'C','N', 4, '2024-4-20'),
    ('Product5', 12.25, 120, 'D', 'Y', 1, '2024-04-25'),
    ('Product6', 18.99, 180, 'A', 'N', 2, '2024-10-10'),
    ('Product7', 9.99, 90, 'D', 'Y', 3, '2025-01-05'),
    ('Product8', 22.50, 250, 'A', 'N', 4, '2024-04-12'),
    ('Product9', 17.25, 130, 'B', 'Y', 1, '2024-05-15'),
    ('Product10', 11.49, 110, 'C', 'N', 2, '2024-07-01');
    
INSERT INTO UserSubscription (userID, productType)
VALUES
    (1, 'A'),
    (2, 'B'),
    (3, 'C'),
    (4, 'A');
select * from Products;
select * from users;
select * from Donation_view;
select * from Discount_view;
update products set donationAmount =150.0  where productID = 6;
delete  from UserSubscription where userID =0;
select * from usersubscription;



                                            ;
