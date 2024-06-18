INSERT INTO public.category (title)
VALUES ('Смартфоны');
INSERT INTO public.category (title)
VALUES ('Наушники');
INSERT INTO public.category (title)
VALUES ('Аксессуары');
INSERT INTO public.category (title)
VALUES ('Умные часы');

-- Добавление характеристик
INSERT INTO public.specifications (title)
VALUES
    ('Оперативная память'),
    ('Внутренняя память'),
    ('Тип матрицы'),
    ('Бренд'),
    ('Тип конструкции'),
    ('Тип подключения'),
    ('Степень защиты'),
    ('Материал ремешка');


-- Смартфоны
INSERT INTO public.product (image, title, category_id, price)
VALUES
    ('/AppleIphonexr.jpg', 'Apple Iphone xr', 1, 20500),
    ('/XiaomiMi11.jpg', 'Xiaomi Mi 11', 1, 35000),
    ('/AppleIphone12.jpg', 'Apple Iphone 12', 1, 40000),
    ('/AppleIphone13Pro.jpg', 'Apple Iphone 13 Pro', 1, 60000),
    ('/SamsungGalaxyS21.jpg', 'Samsung Galaxy S21', 1, 50000),
    ('/OnePlus9Pro.jpg', 'OnePlus 9 Pro', 1, 30000),
    ('/GooglePixel6Pro.jpg', 'Google Pixel 6 Pro', 1, 70000),
    ('/HuaweiP40Pro.jpg', 'Huawei P40 Pro', 1, 70000),
    ('/SonyXperia1III.jpg', 'Sony Xperia 1 III', 1, 35000),
    ('/LGVelvet.jpg', 'LG Velvet', 1, 47000);

INSERT INTO public.product (image, title, category_id, price)
VALUES
    ('/SonyWH1000XM4.jpg', 'Sony WH-1000XM4', 2, 25000),
    ('/BoseQuietComfort35II.jpg', 'Bose QuietComfort 35 II', 2, 20000),
    ('/SennheiserMomentumTrueWireless2.jpg', 'Sennheiser Momentum True Wireless 2', 2, 15000),
    ('/JabraEliteActive75t.jpg', 'Jabra Elite Active 75t', 2, 18000),
    ('/AirPodsPro.jpg', 'AirPods Pro', 2, 22000),
    ('/SamsungGalaxyBudsLive.jpg', 'Samsung Galaxy Buds Live', 2, 12000),
    ('/AnkerSoundcoreLibertyAir2Pro.jpg', 'Anker Soundcore Liberty Air 2 Pro', 2, 10000),
    ('/BeatsStudio3.jpg', 'Beats Studio3', 2, 17000),
    ('/SkullcandyCrusherANC.jpg', 'Skullcandy Crusher ANC', 2, 23000),
    ('/BangOlufsenBeoplayH95.jpg', 'Bang & Olufsen Beoplay H95', 2, 30000);


INSERT INTO public.product (image, title, category_id, price)
VALUES
    ('/AppleWatchSeries7.jpg', 'Apple Watch Series 7', 3, 25000),
    ('/SamsungGalaxyWatch4.jpg', 'Samsung Galaxy Watch 4', 3, 20000),
    ('/FitbitVersa3.jpg', 'Fitbit Versa 3', 3, 15000),
    ('/GarminVenuSq.jpg', 'Garmin Venu Sq', 3, 22000),
    ('/HuaweiWatchGT2.jpg', 'Huawei Watch GT 2', 3, 18000),
    ('/AmazfitGTS2.jpg', 'Amazfit GTS 2', 3, 10000),
    ('/XiaomiMiWatchRevolve.jpg', 'Xiaomi Mi Watch Revolve', 3, 12000),
    ('/FossilGen5.jpg', 'Fossil Gen 5', 3, 17000),
    ('/MobvoiTicWatchPro3.jpg', 'Mobvoi TicWatch Pro 3', 3, 23000),
    ('/Suunto9Baro.jpg', 'Suunto 9 Baro', 3, 30000);

INSERT INTO public.product (image, title, category_id, price)
VALUES
    ('/SamsungFastChargePowerBank.jpg', 'Samsung Fast Charge Power Bank', 4, 5000),
    ('/AnkerPowerCore20100.jpg', 'Anker PowerCore 20100', 4, 3000),
    ('/AppleMagSafeCharger.jpg', 'Apple MagSafe Charger', 4, 2000),
    ('/SonyUSBTypeCCharger.jpg', 'Sony USB Type-C Charger', 4, 1500),
    ('/SamsungGalaxyS21Case.jpg', 'Samsung Galaxy S21 Case', 4, 1000),
    ('/AppleIphone13SiliconeCase.jpg', 'Apple Iphone 13 Silicone Case', 4, 500),
    ('/SonyXperia1IIILeatherCase.jpg', 'Sony Xperia 1 III Leather Case', 4, 800),
    ('/JabraEliteActive75tCase.jpg', 'Jabra Elite Active 75t Case', 4, 700),
    ('/AnkerPowerline+USBCCable.jpg', 'Anker Powerline+ USB-C Cable', 4, 1000),
    ('/SamsungGalaxyBudsLiveCase.jpg', 'Samsung Galaxy Buds Live Case', 4, 600);

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