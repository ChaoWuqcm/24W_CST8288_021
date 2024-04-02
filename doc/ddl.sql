-- t_user
CREATE TABLE IF NOT EXISTS t_user
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    username   VARCHAR(255) NOT NULL,
    role       VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- t_inventory
CREATE TABLE IF NOT EXISTS t_inventory
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(255)   NOT NULL,
    expiration_date DATE           NOT NULL,
    category        VARCHAR(255)   NOT NULL,
    price           DECIMAL(10, 2) NOT NULL,
    tag             VARCHAR(255)   NOT NULL DEFAULT '',
    quantity        INT            NOT NULL,
    approaching     BOOLEAN        NOT NULL DEFAULT FALSE,
    created_at      DATETIME                DEFAULT CURRENT_TIMESTAMP
);

-- t_expired_food
CREATE TABLE IF NOT EXISTS t_expired_food
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    food_id           INT          NOT NULL,
    name              VARCHAR(255) NOT NULL,
    expiration_date   DATE         NOT NULL,
    quantity          INT          NOT NULL,
    type              VARBINARY(50) NOT NULL DEFAULT 'pending',
    discount          DECIMAL(5, 2) NOT NULL DEFAULT 1.00,
    recipient_user_id INT          NULL,
    recipient         VARCHAR(255) NOT NULL DEFAULT '',
    created_at        DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- t_purchase_record
CREATE TABLE IF NOT EXISTS t_purchase_record
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    food_id           INT            NOT NULL,
    item_name         VARCHAR(255)   NOT NULL,
    purchase_date     DATE           NOT NULL,
    price             DECIMAL(10, 2) NOT NULL,
    quantity          INT            NOT NULL,
    purchaser_user_id INT            NOT NULL,
    purchaser         VARCHAR(255)   NOT NULL,
    created_at        DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- t_subscription_record
CREATE TABLE IF NOT EXISTS t_subscription_record
(
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    food_id            INT,
    item_name         VARCHAR(255)   NOT NULL,
    subscriber_user_id INT          NOT NULL,
    subscriber_user    VARCHAR(255) NOT NULL,
    food_category      VARCHAR(255) NOT NULL,
    email              VARCHAR(255) NOT NULL,
    created_at         DATETIME DEFAULT CURRENT_TIMESTAMP
);
