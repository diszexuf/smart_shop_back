INSERT INTO public.category (id, title)
VALUES (1, 'Смартфоны');
INSERT INTO public.category (id, title)
VALUES (2, 'Ноутбуки');
INSERT INTO public.category (id, title)
VALUES (3, 'Аксессуары');

INSERT INTO public.product (id, image, title, category_id)
VALUES (1, 'asdasd', 'iphone xr', 1);
INSERT INTO public.product (id, image, title, category_id)
VALUES (2, 'asdasd', 'iphone 11', 1);
INSERT INTO public.product (id, image, title, category_id)
VALUES (3, 'asdasd', 'iphone 12', 1);
INSERT INTO public.product (id, image, title, category_id)
VALUES (4, 'asdasd', 'iphone 13 Pro', 1);

INSERT INTO public.specifications (id, specification_type, title)
VALUES (1, 'number', 'Оперативная память');
INSERT INTO public.specifications (id, specification_type, title)
VALUES (2, 'number', 'Внутрення память');
INSERT INTO public.specifications (id, specification_type, title)
VALUES (3, 'string', 'Тип матрицы');
INSERT INTO public.specifications (id, specification_type, title)
VALUES (4, 'string', 'Бренд');
INSERT INTO public.specifications (id, specification_type, title)
VALUES (5, 'number', 'Цена');

INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('3', 1, 1);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('128', 1, 2);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('20500', 1, 5);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('IPS', 1, 3);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('Apple', 1, 4);


INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('4', 2, 1);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('256', 2, 2);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('35000', 2, 5);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('OLED', 2, 3);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('Xiaomi', 2, 4);

INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('6', 3, 1);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('256', 3, 2);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('40000', 3, 5);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('IPS', 3, 3);
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES ('Apple', 3, 4);



