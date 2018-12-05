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


INSERT INTO productcategories (name,department,description) VALUES ('Id Limited','Ante Lectus Convallis Corp.','enim. Suspendisse aliquet, sem ut cursus luctus,'),('Fringilla Est Mauris Industries','Viverra Maecenas LLP','Cras interdum. Nunc sollicitudin commodo ipsum. Suspendisse'),('Vitae Diam Proin Corp.','Dolor Nonummy Ac Associates','Nulla interdum. Curabitur dictum. Phasellus in felis.'),('Pellentesque A Limited','Vel Incorporated','convallis, ante lectus convallis est, vitae sodales'),('Id Consulting','Laoreet Limited','pellentesque eget, dictum placerat, augue. Sed molestie.'),('Placerat Ltd','Ut Mi Duis Consulting','mollis. Duis sit amet diam eu dolor'),('Nec Foundation','Non Associates','quam quis diam. Pellentesque habitant morbi tristique'),('Lacus Institute','Integer Vitae Institute','tellus. Nunc lectus pede, ultrices a, auctor'),('Mauris Integer Sem Industries','Tempor Associates','Cum sociis natoque penatibus et magnis dis'),('Mauris Vel LLC','Elementum Corp.','consectetuer mauris id sapien. Cras dolor dolor,');
INSERT INTO productcategories (name,department,description) VALUES ('Ante Nunc Associates','Amet Inc.','ante dictum mi, ac mattis velit justo'),('Enim Nisl Institute','Mus Donec Incorporated','Quisque ac libero nec ligula consectetuer rhoncus.'),('Semper Corp.','Est Mollis Corporation','In condimentum. Donec at arcu. Vestibulum ante'),('Lobortis Quis Pede Consulting','Eget LLP','id, blandit at, nisi. Cum sociis natoque'),('Fermentum Metus Inc.','Magnis PC','ut nisi a odio semper cursus. Integer'),('Senectus Corp.','Ut Mi Corp.','Sed congue, elit sed consequat auctor, nunc'),('Vulputate Nisi Limited','Vitae Sodales At Incorporated','ridiculus mus. Proin vel arcu eu odio'),('Vel Quam Dignissim PC','Amet Consectetuer Adipiscing Associates','imperdiet ullamcorper. Duis at lacus. Quisque purus'),('Molestie Dapibus Ligula Incorporated','Donec Luctus Limited','eleifend, nunc risus varius orci, in consequat'),('Congue Turpis Associates','Amet Company','et netus et malesuada fames ac turpis');


INSERT INTO suppliers (name,description) VALUES ('Eleifend Egestas Consulting','sed pede. Cum sociis natoque'),('Lectus A Sollicitudin Institute','non magna. Nam ligula elit,'),('Proin Incorporated','vulputate velit eu sem. Pellentesque'),('Non Quam Ltd','Maecenas libero est, congue a,'),('Dui LLC','arcu et pede. Nunc sed'),('Mauris LLC','Fusce fermentum fermentum arcu. Vestibulum'),('Phasellus Dolor Corp.','condimentum. Donec at arcu. Vestibulum'),('Arcu Eu Odio Company','et ultrices posuere cubilia Curae;'),('Ornare Associates','Sed nunc est, mollis non,'),('Quisque Inc.','sit amet ornare lectus justo');
INSERT INTO suppliers (name,description) VALUES ('Purus Mauris Incorporated','mus. Proin vel arcu eu'),('Ut Corp.','amet, consectetuer adipiscing elit. Etiam'),('In Molestie Tortor LLP','convallis erat, eget tincidunt dui'),('Arcu Vivamus PC','dolor. Donec fringilla. Donec feugiat'),('Convallis Dolor Incorporated','ligula eu enim. Etiam imperdiet'),('Eu Odio Foundation','mauris sagittis placerat. Cras dictum'),('Varius PC','leo. Vivamus nibh dolor, nonummy'),('Faucibus Ut LLP','vehicula aliquet libero. Integer in'),('Iaculis Aliquet Diam Limited','in faucibus orci luctus et'),('Diam At Pretium Industries','lobortis quam a felis ullamcorper');

INSERT INTO products (name,defaultprice,currency,description,productcategory_id,supplier_id) VALUES ('In Ornare Sagittis Consulting',20,'enim,','auctor quis, tristique ac, eleifend',5,9),('Malesuada Corp.',11,'sapien,','arcu. Vestibulum ante ipsum primis',5,19),('Dictum Institute',4,'blandit','amet orci. Ut sagittis lobortis',20,8),('Ac Tellus Ltd',125,'mollis','scelerisque neque. Nullam nisl. Maecenas',17,8),('Rutrum Industries',14,'scelerisque','mauris ut mi. Duis risus',7,16),('Mauris Magna Duis Foundation',139,'fermentum','sem. Pellentesque ut ipsum ac',10,6),('Nec Ligula Corp.',123,'et','ornare, elit elit fermentum risus,',7,15),('Eu Elit Nulla Corporation',11,'nulla','Mauris blandit enim consequat purus.',19,1),('Aliquet Company',15,'purus','Suspendisse aliquet, sem ut cursus',7,14),('Sed Congue Elit Associates',21,'placerat,','auctor velit. Aliquam nisl. Nulla',3,14);
INSERT INTO products (name,defaultprice,currency,description,productcategory_id,supplier_id) VALUES ('Vel Company',48,'at','Phasellus dolor elit, pellentesque a,',12,17),('Sit Industries',13,'tincidunt,','ut eros non enim commodo',8,10),('Tellus Lorem LLP',134,'eu','Duis ac arcu. Nunc mauris.',18,20),('Cursus Et Incorporated',143,'ante.','parturient montes, nascetur ridiculus mus.',12,13),('At Pede Consulting',108,'interdum','dictum eu, placerat eget, venenatis',9,9),('Tempus Mauris Industries',129,'tincidunt.','risus. Donec nibh enim, gravida',12,10),('Conubia Incorporated',101,'risus.','consequat auctor, nunc nulla vulputate',14,3),('Pede Suspendisse Ltd',84,'cubilia','Aliquam nec enim. Nunc ut',2,10),('Magna Sed PC',115,'vestibulum,','tellus id nunc interdum feugiat.',2,7),('Mauris Company',147,'pretium','conubia nostra, per inceptos hymenaeos.',1,17);
INSERT INTO products (name,defaultprice,currency,description,productcategory_id,supplier_id) VALUES ('Amet LLP',36,'lacinia','lectus pede, ultrices a, auctor',8,5),('Ac Tellus LLC',116,'ultrices','Cras vehicula aliquet libero. Integer',12,18),('Ipsum Industries',97,'mattis','erat. Etiam vestibulum massa rutrum',18,15),('A Scelerisque Sed Institute',20,'posuere','et, euismod et, commodo at,',13,14),('Semper Auctor Corp.',120,'gravida.','urna et arcu imperdiet ullamcorper.',4,2),('Elit Erat Inc.',30,'faucibus','sed pede nec ante blandit',11,17),('Ut Dolor Dapibus Ltd',63,'malesuada.','nunc id enim. Curabitur massa.',3,20),('Odio Phasellus Institute',90,'malesuada','ornare tortor at risus. Nunc',10,10),('Metus Ltd',5,'dolor.','pellentesque, tellus sem mollis dui,',8,18),('Luctus Inc.',131,'mauris','fermentum risus, at fringilla purus',13,10);
INSERT INTO products (name,defaultprice,currency,description,productcategory_id,supplier_id) VALUES ('Mauris Vel Turpis Limited',121,'Aenean','Donec elementum, lorem ut aliquam',16,5),('Nulla Dignissim Inc.',120,'sed','montes, nascetur ridiculus mus. Proin',9,2),('Magna Sed Inc.',23,'molestie','Fusce aliquam, enim nec tempus',10,10),('Enim Corp.',26,'pede','adipiscing, enim mi tempor lorem,',15,3),('Erat Eget Tincidunt Foundation',90,'Cras','posuere, enim nisl elementum purus,',20,18),('Arcu Imperdiet Inc.',106,'diam','dapibus ligula. Aliquam erat volutpat.',20,3),('Tortor LLC',47,'Donec','libero. Morbi accumsan laoreet ipsum.',7,17),('At LLP',92,'turpis.','posuere cubilia Curae; Phasellus ornare.',4,14),('Feugiat Sed Nec Corporation',78,'nunc','posuere cubilia Curae; Donec tincidunt.',18,16),('Amet LLC',95,'eu,','eu neque pellentesque massa lobortis',8,8);
