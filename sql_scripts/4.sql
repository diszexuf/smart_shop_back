INSERT INTO public.category (title)
VALUES ('Смартфоны');
INSERT INTO public.category (title)
VALUES ('Наушники');
INSERT INTO public.category (title)
VALUES ('Аксессуары');

INSERT INTO public.product (image, title, category_id)
VALUES
    ('asdasd', 'Apple Iphone xr', 1),
    ('asdasd', 'Xiaomi Mi 11', 1),
    ('asdasd', 'Apple Iphone 12', 1),
    ('asdasd', 'Apple Iphone 13 Pro', 1),
    ('asdasd', 'Samsung Galaxy S21', 1),
    ('asdasd', 'OnePlus 9 Pro', 1),
    ('asdasd', 'Google Pixel 6 Pro', 1),
    ('asdasd', 'Huawei P40 Pro', 1),
    ('asdasd', 'Sony Xperia 1 III', 1),
    ('asdasd', 'LG Velvet', 1);


-- Добавление характеристик
INSERT INTO public.specifications (id, specification_type, title)
VALUES
    (1, 'number', 'Оперативная память'),
    (2, 'number', 'Внутрення память'),
    (3, 'string', 'Тип матрицы'),
    (4, 'string', 'Бренд'),
    (5, 'number', 'Цена');

-- Добавление характеристик товаров
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES
    ('3', 1, 1),
    ('128', 1, 2),
    ('20500', 1, 5),
    ('IPS', 1, 3),
    ('Apple', 1, 4),

    ('4', 2, 1),
    ('256', 2, 2),
    ('35000', 2, 5),
    ('OLED', 2, 3),
    ('Xiaomi', 2, 4),

    ('6', 3, 1),
    ('256', 3, 2),
    ('40000', 3, 5),
    ('IPS', 3, 3),
    ('Apple', 3, 4),

    ('4', 4, 1),
    ('256', 4, 2),
    ('60000', 4, 5),
    ('OLED', 4, 3),
    ('Apple', 4, 4),

    ('6', 5, 1),
    ('512', 5, 2),
    ('50000', 5, 5),
    ('AMOLED', 5, 3),
    ('Samsung', 5, 4),

    ('8', 6, 1),
    ('128', 6, 2),
    ('30000', 6, 5),
    ('OLED', 6, 3),
    ('OnePlus', 6, 4),

    ('4', 7, 1),
    ('128', 7, 2),
    ('70000', 7, 5),
    ('AMOLED', 7, 3),
    ('Google', 7, 4),

    ('8', 8, 1),
    ('512', 8, 2),
    ('70000', 8, 5),
    ('OLED', 8, 3),
    ('Huawei', 8, 4),

    ('12', 9, 1),
    ('512', 9, 2),
    ('70000', 9, 5),
    ('OLED', 9, 3),
    ('Sony', 9, 4),

    ('8', 8, 1),
    ('256', 8, 2),
    ('70000', 8, 5),
    ('OLED', 8, 3),
    ('LG', 8, 4);
