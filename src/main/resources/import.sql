INSERT INTO pizzas (updated_at, created_at, description, name, price, image_link) VALUES('2023-03-31 15:00:00', '2023-03-31 15:00:00', 'pomodoro, salame piccante, mozzarella, peperoncino', 'Diavola', 9.10, 'https://wips.plug.it/cips/buonissimo.org/cms/2012/05/69630013_m.jpg');
INSERT INTO pizzas (updated_at, created_at, description, name, price, image_link) VALUES('2023-03-31 15:00:00', '2023-03-31 15:00:00', 'pomodoro, mozzarella, basilico', 'Margherita', 8.55, 'https://staticcookist.akamaized.net/wp-content/uploads/sites/21/2018/04/pizza-margherita-fatta-in-casa.jpg');
INSERT INTO pizzas (updated_at, created_at, description, name, price, image_link) VALUES('2023-03-31 15:00:00', '2023-03-31 15:00:00', 'carciofini, prosciutto cotto, pomodoro, mozzarella, uovo sodo, olive', 'Capiricciosa', 10.20, 'https://i0.wp.com/www.piccolericette.net/piccolericette/wp-content/uploads/2017/12/3240_Pizza.jpg');
-- insert into speciaò_offer
INSERT INTO db_pizzeria.special_offer (created_at, expire_date, starting_date, title, updated_at, pizza_id) VALUES('2023-01-01 19:00', '2024-01-01 23:00', '2023-01-01 19:00', 'Posate Omaggio', '2023-01-01 19:00', 1);
INSERT INTO db_pizzeria.special_offer (created_at, expire_date, starting_date, title, updated_at, pizza_id) VALUES('2023-01-01 19:00', '2024-01-01 23:00', '2023-01-01 19:00', 'Posate Omaggio', '2023-01-01 19:00', 2);
INSERT INTO db_pizzeria.special_offer (created_at, expire_date, starting_date, title, updated_at, pizza_id) VALUES('2023-01-01 19:00', '2024-01-01 23:00', '2023-01-01 19:00', 'Posate Omaggio', '2023-01-01 19:00', 3);
INSERT INTO db_pizzeria.special_offer (created_at, expire_date, starting_date, title, updated_at, pizza_id) VALUES('2023-01-01 19:00', '2023-07-01 23:00', '2023-01-01 19:00', 'Bicchiere Omaggio', '2023-01-01 19:00', 3);
INSERT INTO db_pizzeria.special_offer (created_at, expire_date, starting_date, title, updated_at, pizza_id) VALUES('2023-01-01 19:00', '2024-01-01 23:00', '2023-01-01 19:00', 'Sconto 25%', '2023-01-01 19:00', 2);