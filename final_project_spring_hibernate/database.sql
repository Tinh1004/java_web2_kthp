SELECT * FROM final_web.products;
SELECT * FROM final_web.categories;
SELECT * FROM final_web.users;
SELECT * FROM final_web.receipts;

SELECT * FROM final_web.receipts where user_id = 2;

SELECT p.product_id, p.product_name, p.price, p.image, p.category_id, p.product_dt FROM Receipts c INNER JOIN Users u ON c.user_id = 1  INNER JOIN Products p ON c.product_id = p.product_id;


INSERT INTO `products` (product_name,price,image,category_id) VALUES ('Điện Thoại Samsung Galaxy A03 (3+32GB)',2250000,'https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_29551/dien-thoai-sams_main_435_1020.png.webp',1),
	('Samsung Galaxy A13 (4GB+128GB)',4190000,'https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_30061/samsung-galaxy-_main_630_1020.png.webp',1),
	('Samsung Galaxy Z FLIP 4 (256GB)',18990000,'https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_31154/samsung-galaxy-_main_130_1020.png.webp',1),
	('Điện Thoại Samsung Galaxy A03 (3+32GB)',2250000,'https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_29551/dien-thoai-sams_main_435_1020.png.webp', 1);



CREATE TABLE products(
	product_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	product_name VARCHAR(50) NOT NULL ,
	price INT(11) NOT NULL ,
    image VARCHAR(255) NOT NULL ,
    category_id INT(11) NOT NULL,
    product_dt DATETIME DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE users(
	user_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	fullname VARCHAR(50) NOT NULL ,
	username VARCHAR(50) NOT NULL ,
    password VARCHAR(255) NOT NULL ,
    user_role  boolean not null default 0,
    user_dt DATETIME DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (username)
);

drop table users
insert into users (fullname,username,password) values ("Pham Ngoc Tinh","tinh",123456);

-- addmin 
insert into users (fullname,username,password,user_role) values ("Admin","admin",123456,1);

CREATE TABLE categories(
	category_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	category_name VARCHAR(50) NOT NULL ,
    category_dt DATETIME DEFAULT CURRENT_TIMESTAMP
);
insert into categories (category_name) values ("samsung");
insert into categories (category_name) values ("Iphone");
insert into categories (category_name) values ("Vivo");
SELECT * FROM categories c INNER JOIN products p ON c.category_id = p.category_id ;

CREATE TABLE receipts(
	receipt_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	product_id INT(11) NOT NULL,
    user_id INT(11) NOT NULL,
    quantity INT(11) NOT NULL,
	receipt_dt DATETIME DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

drop table receipts

insert into receipts (product_id,user_id,quantity) values (1,1,1);

delete from receipts where user_id = 1;

select * from products, users, receipts, categories
where products.product_id = receipts.receipt_id
and receipts.receipt_id = users.user_id
and categories.category_id = products.category_id