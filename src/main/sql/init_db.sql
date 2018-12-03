DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS productcategories;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS order_items;


CREATE TABLE productcategories
(
id int PRIMARY KEY NOT NULL,
name varchar(50) NOT NULL,
department varchar(60) NOT NULL,
description varchar(255) NOT NULL
);

CREATE TABLE suppliers
(
id int PRIMARY KEY NOT NULL,
name varchar(50) NOT NULL,
description varchar(255) NOT NULL
);

CREATE TABLE products
(
id int PRIMARY KEY NOT NULL,
name varchar(50) NOT NULL,
defaultprice float NOT NULL,
currency varchar(10) NOT NULL,
description varchar(255),
productcategory_id int NOT NULL REFERENCES productcategories(id),
supplier_id int NOT NULL REFERENCES suppliers(id)
);

CREATE TABLE customers
(
id int PRIMARY KEY NOT NULL,
full_name varchar(255) NOT NULL,
email varchar(255) NOT NULL,
phone varchar(255) NOT NULL,
billing_address varchar(255) NOT NULL,
shipping_Address int NOT NULL
);

CREATE TABLE orders
(
id int PRIMARY KEY NOT NULL,
status varchar(10),
customer_id int NOT NULL REFERENCES customers(id),
payment_type varchar(255),
date DATE,
total_price int
);

CREATE TABLE order_items
(
id int PRIMARY KEY NOT NULL,
order_id int NOT NULL REFERENCES orders(id),
product_id int NOT NULL REFERENCES products(id),
quantity int
);






