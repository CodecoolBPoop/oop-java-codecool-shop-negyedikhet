DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS productcategories;



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
('Rudolf','Artificial christmas trees');

INSERT INTO productcategories (name, department, description)
VALUES ('All', 'All', 'All categories'),
('Clothes', 'Clothes','Festive sweaters'),
('Cookie', 'Food','Finest freshly baked christmas cookies'),
('Decoration','Decoration','Small christmas decorations'),
('ChocolateCandy','Food','Hungarian Christmas-candy speciality'),
('Christmas Tree','Decoration','Christmas trees');

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
('Xmas Tree - Silver', 59, 'USD', 'Silver colored Christmas tree', 6, 6),
('Xmas Tree - Soft', 49, 'USD', 'Christmas tree with especially soft leaves', 6, 6),
('Xmas Tree - Forest', 79, 'USD', 'Forest Christmas tree', 6, 6),
('Xmas Tree - Classic', 39, 'USD', 'Classic Christmas tree', 6, 6)
;




