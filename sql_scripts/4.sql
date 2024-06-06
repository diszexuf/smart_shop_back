INSERT INTO public.category (title)
VALUES ('Смартфоны');
INSERT INTO public.category (title)
VALUES ('Наушники');
INSERT INTO public.category (title)
VALUES ('Аксессуары');

-- Добавление характеристик
INSERT INTO public.specifications (id, specification_type, title)
VALUES
    (1, 'number', 'Оперативная память'),
    (2, 'number', 'Внутрення память'),
    (3, 'string', 'Тип матрицы'),
    (4, 'string', 'Бренд'),
    (5, 'string', 'Тип конструкции'),
    (6, 'string', 'Тип подключения'),
    (7, 'string', 'Степень защиты'),
    (8, 'string', 'Материал ремешка');


-- Смартфоны
INSERT INTO public.product (image, title, category_id, price)
VALUES
    ('asdasd', 'Apple Iphone xr', 1, 20500),
    ('asdasd', 'Xiaomi Mi 11', 1, 35000),
    ('asdasd', 'Apple Iphone 12', 1, 40000),
    ('asdasd', 'Apple Iphone 13 Pro', 1, 60000),
    ('asdasd', 'Samsung Galaxy S21', 1, 50000),
    ('asdasd', 'OnePlus 9 Pro', 1, 30000),
    ('asdasd', 'Google Pixel 6 Pro', 1, 70000),
    ('asdasd', 'Huawei P40 Pro', 1, 70000),
    ('asdasd', 'Sony Xperia 1 III', 1, 35000),
    ('asdasd', 'LG Velvet', 1, 47000);


-- Добавление характеристик товаров
INSERT INTO public.product_specifications (value, product_id, specifications_id)
VALUES
    ('3', 1, 1),
    ('128', 1, 2),
    ('IPS', 1, 3),
    ('Apple', 1, 4),

    ('4', 2, 1),
    ('256', 2, 2),
    ('OLED', 2, 3),
    ('Xiaomi', 2, 4),

    ('6', 3, 1),
    ('256', 3, 2),
    ('IPS', 3, 3),
    ('Apple', 3, 4),

    ('4', 4, 1),
    ('256', 4, 2),
    ('OLED', 4, 3),
    ('Apple', 4, 4),

    ('6', 5, 1),
    ('512', 5, 2),
    ('AMOLED', 5, 3),
    ('Samsung', 5, 4),

    ('8', 6, 1),
    ('128', 6, 2),
    ('OLED', 6, 3),
    ('OnePlus', 6, 4),

    ('4', 7, 1),
    ('128', 7, 2),
    ('AMOLED', 7, 3),
    ('Google', 7, 4),

    ('8', 8, 1),
    ('512', 8, 2),
    ('OLED', 8, 3),
    ('Huawei', 8, 4),

    ('12', 9, 1),
    ('512', 9, 2),
    ('OLED', 9, 3),
    ('Sony', 9, 4),

    ('8', 8, 1),
    ('256', 8, 2),
    ('OLED', 8, 3),
    ('LG', 8, 4);

-- Наушники