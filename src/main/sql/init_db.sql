DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS productcategories;
DROP TABLE IF EXISTS users;



CREATE TABLE productcategories
(
id SERIAL PRIMARY KEY NOT NULL,
name  varchar(50) NOT NULL,
department varchar(60) NOT NULL,
description varchar(255) NOT NULL
);

CREATE TABLE suppliers
(
id SERIAL PRIMARY KEY NOT NULL,
name  varchar(50) NOT NULL,
description varchar(255) NOT NULL
);

CREATE TABLE users
(
  id SERIAL PRIMARY KEY NOT NULL,
  email  varchar(255) UNIQUE NOT NULL,
  password varchar(255) NOT NULL
);

CREATE TABLE products
(
id SERIAL PRIMARY KEY NOT NULL,
name  varchar(50) NOT NULL,
defaultprice float NOT NULL,
currency varchar(20) NOT NULL,
description varchar(255),
productcategory_id int NOT NULL REFERENCES productcategories(id),
supplier_id int NOT NULL REFERENCES suppliers(id)
);

CREATE TABLE customers
(
id SERIAL PRIMARY KEY NOT NULL,
full_name varchar(255) NOT NULL,
email  varchar(255) NOT NULL,
phone varchar(255) NOT NULL,
billing_address varchar(255) NOT NULL,
shipping_Address int NOT NULL
);

CREATE TABLE orders
(
id SERIAL PRIMARY KEY NOT NULL,
status varchar(10),
customer_id int NOT NULL REFERENCES customers(id),
payment_type varchar(255),
date DATE,
total_price int
);

CREATE TABLE order_items
(
id SERIAL PRIMARY KEY NOT NULL,
order_id int NOT NULL REFERENCES orders(id),
product_id int NOT NULL REFERENCES products(id),
quantity int
);


INSERT INTO suppliers (name, description)
VALUES ('All', 'All supplier'),
('Gucci', 'Clothing'),
('Lipoti', 'Freshly baked products'),
('Surefire','Christmas decorations'),
('Milka','Christmas chocolates'),
('Rudolf','Artificial christmas trees'),
('Kinder','Christmas chocolates'),
('Lindt','Christmas chocolates'),
('SantaWear','Festive clothes')
;


INSERT INTO productcategories (name, department, description)
VALUES ('All', 'All', 'All categories'),
('Clothes', 'Clothes','Festive sweaters'),
('Cookie', 'Food','Finest freshly baked christmas cookies'),
('Decoration','Decoration','Small christmas decorations'),
('Chocolate','Food','Christmas chocolate specialities'),
('Christmas Tree','Decoration','Christmas trees'),
('Plush','Plush','Soft plushes')
;


INSERT INTO products (name, defaultprice, currency, description, productcategory_id, supplier_id)
VALUES ('Sweater with bow', 25, 'USD', 'Beautiful gift for your loved ones.', 2, 2),
('Star Wars sweater', 32, 'USD', 'The perfect present for Star Wars fans. ', 2, 2),
('Kitten sweater', 39, 'USD', 'Surprise your beloved girlfriend with kittens!', 2, 2),
('Gingerbread - Tree', 9, 'USD', 'Finest freshly baked gingerbread.', 3, 3),
('Gingerbread - Classic', 2, 'USD', 'Classic gingerbread figure.', 3, 3),
('Gingerbread - House', 19, 'USD', 'Handmade gingerbread house.', 3, 3),
('Christmas Bejgli', 9, 'USD', 'Walnut flavoured hungarian cookie speciality.', 3, 3),
('Xmas Ball - Red', 1, 'USD', 'Shiny red christmas decoration ball', 4, 4),
('Xmas Ball - Blue', 1, 'USD', 'Shiny blue christmas decoration ball', 4, 4),
('Xmas Ball - Purple', 1, 'USD', 'Shiny purple christmas decoration ball', 4, 4),
('Wreath - Simple', 19, 'USD', 'Simple, but beautiful Christmas wreath', 4, 4),
('Wreath - Classic', 25, 'USD', 'Classic, decorated Christmas wreath', 4, 4),
('Wreath - Silver', 39, 'USD', 'Special silver colored Christmas wreath ', 4, 4),
('Xmas candy - Marzipan ', 9, 'USD', 'Marzipan flavoured hungarian choco-candy.', 5, 5),
('Xmas candy - Selection', 15, 'USD', 'Selection of hungarian choco-candy specialities.', 5, 5),
('Xmas candy - Nut', 9, 'USD', 'Nut flavoured hungarian choco-candy speciality.', 5, 5),
('Classic Santa hat', 3, 'USD', 'Classic Santa hat. Wear anywhere', 2, 9),
('Winter hat with horns', 10, 'USD', 'Soft and warm hat with cutte horns.', 2, 9),
('Santa hat with Rudolf', 7, 'USD', 'Festive hat with Rudolf, the reindeer', 2, 9),
('Winter hat with bow', 6, 'USD', 'Girly winter hat with a beautiful bow.', 2, 9),
('Choco Santa by Milka', 3, 'USD', 'Classic Santa shaped milk-chocolate', 5, 5),
('Choco Santa by Lindt', 3, 'USD', 'Santa-shaped bitter chocolate', 5, 8),
('Choco Santa by Kinder', 4, 'USD', 'Santa shaped Kinder chocolate', 5, 7),
('Classic reindeer Plush', 14, 'USD', 'Classic reindeer plush for children', 7, 6),
('Cute Rudolf Plush', 15, 'USD', 'Cute Rudolf plush made of 100% cotton', 7, 6),
('Girly Reindeer Plush', 19, 'USD', 'Dressed reindeer plush for girls', 7, 6),
('Mini Santa Plush', 9, 'USD', 'Santa shaped plush made of cotton', 7, 9),
('Festive Pusheen Plush', 12, 'USD', 'Popular Pusheen plush with bow', 7, 9),
('Festive Pikachu Plush', 15, 'USD', 'Popular Pikachu plush with festive robe', 7, 9),
('Xmas Tree - Silver', 59, 'USD', 'Silver colored Christmas tree', 6, 6),
('Xmas Tree - Soft', 49, 'USD', 'Christmas tree with especially soft leaves', 6, 6),
('Xmas Tree - Forest', 79, 'USD', 'Forest Christmas tree', 6, 6),
('Xmas Tree - Classic', 39, 'USD', 'Classic Christmas tree', 6, 6)
;




