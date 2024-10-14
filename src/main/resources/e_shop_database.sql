--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2024-10-14 09:55:36

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS shop;
--
-- TOC entry 4901 (class 1262 OID 16680)
-- Name: shop; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE shop WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';


ALTER DATABASE shop OWNER TO postgres;

\connect shop

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16681)
-- Name: buy_tech; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.buy_tech (
    buy_tech_id bigint NOT NULL,
    product_id bigint NOT NULL,
    amount integer NOT NULL,
    cart_id integer NOT NULL,
    product_id_product_id integer
);


ALTER TABLE public.buy_tech OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16684)
-- Name: buy_tech_buy_tech_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.buy_tech ALTER COLUMN buy_tech_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.buy_tech_buy_tech_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 217 (class 1259 OID 16685)
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    category_id bigint NOT NULL,
    category_name character varying(100) NOT NULL
);


ALTER TABLE public.category OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16688)
-- Name: category_category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.category ALTER COLUMN category_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.category_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 219 (class 1259 OID 16689)
-- Name: category_product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category_product (
    product_id integer NOT NULL,
    category_id integer NOT NULL
);


ALTER TABLE public.category_product OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16692)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    customer_id bigint NOT NULL,
    name character varying(100) NOT NULL,
    surname character varying(100) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(500) NOT NULL
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16697)
-- Name: customer_customer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.customer ALTER COLUMN customer_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.customer_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 222 (class 1259 OID 16698)
-- Name: photo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.photo (
    url character varying(500) NOT NULL,
    product_id bigint,
    photo_id integer NOT NULL
);


ALTER TABLE public.photo OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16703)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    product_id bigint NOT NULL,
    product_name character varying(255) NOT NULL,
    description character varying(500) NOT NULL,
    amount integer NOT NULL,
    price bigint NOT NULL,
    sale integer NOT NULL,
    category_id bigint NOT NULL
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16708)
-- Name: product_product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.product ALTER COLUMN product_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.product_product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 225 (class 1259 OID 16709)
-- Name: shopping_cart; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shopping_cart (
    cart_id bigint NOT NULL,
    customer_id bigint NOT NULL,
    buy_tech_id bigint NOT NULL,
    total_count bigint NOT NULL
);


ALTER TABLE public.shopping_cart OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16712)
-- Name: shopping_cart_cart_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.shopping_cart ALTER COLUMN cart_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.shopping_cart_cart_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 4884 (class 0 OID 16681)
-- Dependencies: 215
-- Data for Name: buy_tech; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4886 (class 0 OID 16685)
-- Dependencies: 217
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.category (category_id, category_name) OVERRIDING SYSTEM VALUE VALUES (1, 'Смартфоны') ON CONFLICT DO NOTHING;
INSERT INTO public.category (category_id, category_name) OVERRIDING SYSTEM VALUE VALUES (2, 'Apple') ON CONFLICT DO NOTHING;
INSERT INTO public.category (category_id, category_name) OVERRIDING SYSTEM VALUE VALUES (3, 'Samsung') ON CONFLICT DO NOTHING;
INSERT INTO public.category (category_id, category_name) OVERRIDING SYSTEM VALUE VALUES (4, 'Сопутствующие товары') ON CONFLICT DO NOTHING;
INSERT INTO public.category (category_id, category_name) OVERRIDING SYSTEM VALUE VALUES (5, 'Наушники') ON CONFLICT DO NOTHING;
INSERT INTO public.category (category_id, category_name) OVERRIDING SYSTEM VALUE VALUES (6, 'Чехлы') ON CONFLICT DO NOTHING;
INSERT INTO public.category (category_id, category_name) OVERRIDING SYSTEM VALUE VALUES (7, 'Аудиотехника') ON CONFLICT DO NOTHING;
INSERT INTO public.category (category_id, category_name) OVERRIDING SYSTEM VALUE VALUES (8, 'Портативные колонки') ON CONFLICT DO NOTHING;
INSERT INTO public.category (category_id, category_name) OVERRIDING SYSTEM VALUE VALUES (9, 'Ноутбуки') ON CONFLICT DO NOTHING;
INSERT INTO public.category (category_id, category_name) OVERRIDING SYSTEM VALUE VALUES (10, 'MSI') ON CONFLICT DO NOTHING;
INSERT INTO public.category (category_id, category_name) OVERRIDING SYSTEM VALUE VALUES (11, 'Lenovo') ON CONFLICT DO NOTHING;


--
-- TOC entry 4888 (class 0 OID 16689)
-- Dependencies: 219
-- Data for Name: category_product; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4889 (class 0 OID 16692)
-- Dependencies: 220
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customer (customer_id, name, surname, email, password) OVERRIDING SYSTEM VALUE VALUES (1, 'Vasya', 'Pupkin', 'overlord2000@gmail.com', '1234567890') ON CONFLICT DO NOTHING;
INSERT INTO public.customer (customer_id, name, surname, email, password) OVERRIDING SYSTEM VALUE VALUES (2, 'Vova', 'Vovchikin', 'overlord20000@gmail.com', '$2a$10$h9vsldEQHJNU1nEEhEH/9ePITQ5JGUMwSn.axwaC9FR0T4Q49KE8q') ON CONFLICT DO NOTHING;
INSERT INTO public.customer (customer_id, name, surname, email, password) OVERRIDING SYSTEM VALUE VALUES (3, 'Alice', 'Seleznova', 'ThePlanet@space.sputnik', '$2a$10$ja/NTY0cdttoKXjAEPWu4exVxUgynGsQND8gWNTMRF4VX.fqFL1lW') ON CONFLICT DO NOTHING;
INSERT INTO public.customer (customer_id, name, surname, email, password) OVERRIDING SYSTEM VALUE VALUES (4, 'Vova', 'Ivanov', 'gg@gam.nub', '$2a$10$NbGoE7l2JDxO2UFuY3x9UO35P05U4sA9PdajoKgSHU6ubKaSVS0i.') ON CONFLICT DO NOTHING;
INSERT INTO public.customer (customer_id, name, surname, email, password) OVERRIDING SYSTEM VALUE VALUES (7, 'John', 'Doe', 'user@example.com', '$2a$10$0yKcWzDk80rtTmju6y5NeO3334kVDT3L3Ss5Vcdra.0b8WC/I9Uy6') ON CONFLICT DO NOTHING;


--
-- TOC entry 4891 (class 0 OID 16698)
-- Dependencies: 222
-- Data for Name: photo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4892 (class 0 OID 16703)
-- Dependencies: 223
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product (product_id, product_name, description, amount, price, sale, category_id) OVERRIDING SYSTEM VALUE VALUES (3, 'Samsung Galaxy S8', 'Samsung Galaxy S8 оснащен 5,8-дюймовым Infinity Display с Quad HD+ разрешением, обеспечивающим яркое и четкое изображение. Процессор Exynos 8895 (или Snapdragon 835) гарантирует высокую производительность. Камера 12 МП с двойным пикселем и улучшенной ночной съемкой делает отличные фото при любом освещении. Водонепроницаемый корпус (IP68) защищает от воды и пыли. Усовершенствованный сканер радужки глаза и распознавание лиц обеспечивают высокую безопасность. ', 20, 30000, 0, 3) ON CONFLICT DO NOTHING;
INSERT INTO public.product (product_id, product_name, description, amount, price, sale, category_id) OVERRIDING SYSTEM VALUE VALUES (4, 'Apple Airpods Pro', 'Apple AirPods Pro оснащены активным шумоподавлением для погружения в звук и режимом прозрачности для слышимости окружающего мира. Настраиваемые силиконовые вкладыши обеспечивают комфорт и надежную посадку. Чип H1 обеспечивает низкую задержку и качественное соединение. Водостойкость по стандарту IPX4 подходит для тренировок. Беспроводной зарядный футляр обеспечивает более 24 часов работы.', 1, 27999, 0, 5) ON CONFLICT DO NOTHING;
INSERT INTO public.product (product_id, product_name, description, amount, price, sale, category_id) OVERRIDING SYSTEM VALUE VALUES (5, 'Чехол Huawei P50', 'Селиконовый матовый чехол для смартфона', 4, 650, 0, 6) ON CONFLICT DO NOTHING;
INSERT INTO public.product (product_id, product_name, description, amount, price, sale, category_id) OVERRIDING SYSTEM VALUE VALUES (6, 'Huawei P50', 'Huawei P50 оснащен 6,5-дюймовым OLED дисплеем с высоким разрешением для ярких и четких изображений. Мощный процессор Kirin 9000E обеспечивает отличную производительность и энергоэффективность. Камера с тройным модулем 50 МП позволяет делать профессиональные фото и видео, включая ночные съемки. Поддержка 5G обеспечивает быстрый интернет. Водо- и пылезащита по стандарту IP68. ', 10, 8369, 0, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.product (product_id, product_name, description, amount, price, sale, category_id) OVERRIDING SYSTEM VALUE VALUES (7, 'Умная колонка Яндекс Станция', 'Умная колонка Яндекс Станция с Алисой обеспечивает управление умным домом, музыку, новости и погоду голосовыми командами. Высококачественный звук с поддержкой Dolby Audio. Подключение через Wi-Fi и Bluetooth. Поддержка потоковых сервисов, включая Яндекс.Музыка и КиноПоиск HD. Компактный дизайн подходит для любого интерьера. Встроенная система распознавания голоса и множество полезных функций для вашего комфорта.', 17, 7100, 0, 8) ON CONFLICT DO NOTHING;
INSERT INTO public.product (product_id, product_name, description, amount, price, sale, category_id) OVERRIDING SYSTEM VALUE VALUES (2, 'iPhone 13', 'iPhone 13 оснащен 6,1-дюймовым Super Retina XDR дисплеем, обеспечивающим яркое и четкое изображение.Новый чип A15 Bionic обеспечивает высокую производительность и энергоэффективность.Система с двойной камерой 12 МП с улучшенной ночной съемкой и фотостилями позволяет делать профессиональные фото и видео.Поддержка 5G для сверхбыстрого интернета.Увеличенное время работы батареи и водо- и пылезащита по стандарту IP68.', 5, 66000, 0, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.product (product_id, product_name, description, amount, price, sale, category_id) OVERRIDING SYSTEM VALUE VALUES (1, 'iPhone 14', 'iPhone 14 оснащен 6,1-дюймовым Super Retina XDR дисплеем для ярких и четких изображений.Его мощный чип A16 Bionic обеспечивает высокую производительность и энергоэффективность.Камера с двойным модулем 12 МП и улучшенной ночной съемкой позволяет делать потрясающие фото при любом освещении.Поддержка 5G обеспечивает быстрый интернет.Новый дизайн с улучшенной водо- и пылезащитой (IP68). Доступен в нескольких стильных цветах.', 10, 73700, 0, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.product (product_id, product_name, description, amount, price, sale, category_id) OVERRIDING SYSTEM VALUE VALUES (8, 'LENOVO 15.6 IdeaPad 1', 'Lenovo 15.6 IdeaPad 1 - это легкий и портативный ноутбук с 15.6-дюймовым HD-дисплеем для четкого и яркого изображения. Оснащен процессором Intel Celeron N4020, 4 ГБ оперативной памяти и 64 ГБ eMMC для выполнения повседневных задач. Встроенные динамики с Dolby Audio обеспечивают качественный звук. Длительное время автономной работы до 8 часов. Имеет все необходимые порты для подключения и расширения, включая USB и HDMI.', 3, 30000, 0, 11) ON CONFLICT DO NOTHING;
INSERT INTO public.product (product_id, product_name, description, amount, price, sale, category_id) OVERRIDING SYSTEM VALUE VALUES (9, 'Lenovo IdeaPad Slim 3', 'Lenovo IdeaPad Slim 3 оснащен 15.6-дюймовым Full HD-дисплеем для яркого и четкого изображения. Работает на процессоре Intel Core i5, с 8 ГБ оперативной памяти и SSD на 256 ГБ, обеспечивая быструю загрузку и отзывчивость. Тонкий и легкий корпус идеально подходит для мобильного использования. Встроенные динамики с Dolby Audio обеспечивают качественный звук. Длительное время работы от батареи и поддержка быстрой зарядки.', 22, 56500, 0, 11) ON CONFLICT DO NOTHING;
INSERT INTO public.product (product_id, product_name, description, amount, price, sale, category_id) OVERRIDING SYSTEM VALUE VALUES (10, 'MSI Katana 17', 'MSI Katana 17 оснащен 17.3-дюймовым Full HD-дисплеем с частотой обновления 144 Гц, обеспечивающим плавную и четкую графику. Работает на процессоре Intel Core i7 и видеокарте NVIDIA GeForce RTX 3060, что идеально для игр и тяжелых задач. Оперативная память 16 ГБ и SSD на 512 ГБ обеспечивают быструю загрузку и хранение данных. Эффективная система охлаждения предотвращает перегрев. Подсветка клавиатуры и стильный дизайн добавляют удобства и эстетики.', 60, 92699, 0, 10) ON CONFLICT DO NOTHING;
INSERT INTO public.product (product_id, product_name, description, amount, price, sale, category_id) OVERRIDING SYSTEM VALUE VALUES (11, 'MSI Modern 14', 'MSI Modern 14 оснащен 14-дюймовым Full HD-дисплеем для ярких и четких изображений. Работает на процессоре Intel Core i5, с 8 ГБ оперативной памяти и SSD на 512 ГБ, обеспечивая быструю загрузку и высокую производительность. Тонкий и легкий корпус весом всего 1.3 кг идеально подходит для мобильного использования. Встроенные динамики с качественным звуком и длительное время работы от батареи до 10 часов.', 1, 60000, 0, 10) ON CONFLICT DO NOTHING;


--
-- TOC entry 4894 (class 0 OID 16709)
-- Dependencies: 225
-- Data for Name: shopping_cart; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4902 (class 0 OID 0)
-- Dependencies: 216
-- Name: buy_tech_buy_tech_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.buy_tech_buy_tech_id_seq', 1, false);


--
-- TOC entry 4903 (class 0 OID 0)
-- Dependencies: 218
-- Name: category_category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.category_category_id_seq', 11, true);


--
-- TOC entry 4904 (class 0 OID 0)
-- Dependencies: 221
-- Name: customer_customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_customer_id_seq', 7, true);


--
-- TOC entry 4905 (class 0 OID 0)
-- Dependencies: 224
-- Name: product_product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_product_id_seq', 11, true);


--
-- TOC entry 4906 (class 0 OID 0)
-- Dependencies: 226
-- Name: shopping_cart_cart_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.shopping_cart_cart_id_seq', 1, false);


--
-- TOC entry 4717 (class 2606 OID 16714)
-- Name: buy_tech buy_tech_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buy_tech
    ADD CONSTRAINT buy_tech_pkey PRIMARY KEY (buy_tech_id);


--
-- TOC entry 4719 (class 2606 OID 16716)
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (category_id);


--
-- TOC entry 4721 (class 2606 OID 16718)
-- Name: category_product category_product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category_product
    ADD CONSTRAINT category_product_pkey PRIMARY KEY (product_id, category_id);


--
-- TOC entry 4723 (class 2606 OID 16720)
-- Name: customer customer_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_email_key UNIQUE (email);


--
-- TOC entry 4725 (class 2606 OID 16722)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);


--
-- TOC entry 4727 (class 2606 OID 16724)
-- Name: photo photo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photo_pkey PRIMARY KEY (url);


--
-- TOC entry 4729 (class 2606 OID 16726)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (product_id);


--
-- TOC entry 4731 (class 2606 OID 16728)
-- Name: shopping_cart shopping_cart_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shopping_cart
    ADD CONSTRAINT shopping_cart_pkey PRIMARY KEY (cart_id);


--
-- TOC entry 4732 (class 2606 OID 16729)
-- Name: buy_tech buy_tech_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buy_tech
    ADD CONSTRAINT buy_tech_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product(product_id) ON DELETE CASCADE;


--
-- TOC entry 4738 (class 2606 OID 16734)
-- Name: product cons_category_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT cons_category_id FOREIGN KEY (category_id) REFERENCES public.category(category_id) ON DELETE CASCADE;


--
-- TOC entry 4735 (class 2606 OID 16739)
-- Name: category_product fkfr6rjc04htbtc3xas2b9xmq7r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category_product
    ADD CONSTRAINT fkfr6rjc04htbtc3xas2b9xmq7r FOREIGN KEY (category_id) REFERENCES public.category(category_id);


--
-- TOC entry 4733 (class 2606 OID 16744)
-- Name: buy_tech fkl0m0ma00uu7d1cutykx093gv2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buy_tech
    ADD CONSTRAINT fkl0m0ma00uu7d1cutykx093gv2 FOREIGN KEY (product_id_product_id) REFERENCES public.product(product_id);


--
-- TOC entry 4734 (class 2606 OID 16749)
-- Name: buy_tech fkq9iufaekx4ho6iupmpmss4syg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buy_tech
    ADD CONSTRAINT fkq9iufaekx4ho6iupmpmss4syg FOREIGN KEY (cart_id) REFERENCES public.shopping_cart(cart_id);


--
-- TOC entry 4736 (class 2606 OID 16754)
-- Name: category_product fkssroqj2vyiaujfleklq1ifigj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category_product
    ADD CONSTRAINT fkssroqj2vyiaujfleklq1ifigj FOREIGN KEY (product_id) REFERENCES public.product(product_id);


--
-- TOC entry 4737 (class 2606 OID 16759)
-- Name: photo photo_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photo_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product(product_id) ON DELETE CASCADE;


--
-- TOC entry 4739 (class 2606 OID 16764)
-- Name: shopping_cart shopping_cart_buy_tech_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shopping_cart
    ADD CONSTRAINT shopping_cart_buy_tech_id_fkey FOREIGN KEY (buy_tech_id) REFERENCES public.buy_tech(buy_tech_id) ON DELETE CASCADE;


--
-- TOC entry 4740 (class 2606 OID 16769)
-- Name: shopping_cart shopping_cart_customer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shopping_cart
    ADD CONSTRAINT shopping_cart_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES public.customer(customer_id) ON DELETE CASCADE;


-- Completed on 2024-10-14 09:55:36

--
-- PostgreSQL database dump complete
--

