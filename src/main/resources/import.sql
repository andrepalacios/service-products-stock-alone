INSERT INTO productos (name, description, price, available_stock, restock_threshold, maxstock_threshold) VALUES('Panasonic', 'TV color',800 ,5, 2, 10);
INSERT INTO productos (name, description, price, available_stock, restock_threshold, maxstock_threshold) VALUES('Sony', 'DVD HD',450 ,3, 2, 10);
INSERT INTO productos (name, description, price, available_stock, restock_threshold, maxstock_threshold) VALUES('LG', 'Smart TV HD',675 ,3, 2, 10);
INSERT INTO productos (name, description, price, available_stock, restock_threshold, maxstock_threshold) VALUES('Samsung', 'Smart TV ultimate generation',1200 ,5, 2, 10);
INSERT INTO productos (name, description, price, available_stock, restock_threshold, maxstock_threshold) VALUES('Google', 'glasses ultimate generation',890 ,5, 2, 10);

INSERT INTO products_audit (producto_id, description, username, create_at) VALUES(1, 'input', 'jose', NOW());
INSERT INTO products_audit (producto_id, description, username, create_at) VALUES(1, 'output', 'jose', NOW());
INSERT INTO products_audit (producto_id, description, username, create_at) VALUES(2, 'sale', 'pedro', NOW());
INSERT INTO products_audit (producto_id, description, username, create_at) VALUES(2, 'input', 'jose', NOW());
INSERT INTO products_audit (producto_id, description, username, create_at) VALUES(3, 'output', 'jose', NOW());
INSERT INTO products_audit (producto_id, description, username, create_at) VALUES(3, 'input', 'jose', NOW());
INSERT INTO products_audit (producto_id, description, username, create_at) VALUES(4, 'sale', 'pedro', NOW());
INSERT INTO products_audit (producto_id, description, username, create_at) VALUES(4, 'input', 'pedro', NOW());

INSERT INTO wharehouse_activity (producto_id, qty, activity_type, create_at) VALUES	 (1, 3, 1, NOW());
INSERT INTO wharehouse_activity (producto_id, qty, activity_type, create_at) VALUES	 (1, 2, 2, NOW());
INSERT INTO wharehouse_activity (producto_id, qty, activity_type, create_at) VALUES	 (1, 4, 3, NOW());
INSERT INTO wharehouse_activity (producto_id, qty, activity_type, create_at) VALUES	 (2, 1, 1, NOW());
INSERT INTO wharehouse_activity (producto_id, qty, activity_type, create_at) VALUES	 (2, 5, 3, NOW());
INSERT INTO wharehouse_activity (producto_id, qty, activity_type, create_at) VALUES	 (3, 3, 1, NOW());
INSERT INTO wharehouse_activity (producto_id, qty, activity_type, create_at) VALUES	 (4, 3, 1, NOW());
INSERT INTO wharehouse_activity (producto_id, qty, activity_type, create_at) VALUES	 (4, 2, 2, NOW());