CREATE TABLE public.htl_menu (
    menu_id BIGINT NOT NULL,
    menu_name VARCHAR(100) NOT NULL,
    menu_description VARCHAR(500),
    menu_price NUMERIC(20, 6) NOT NULL,
    attachment_url VARCHAR(500),
    CONSTRAINT htl_menu_pk PRIMARY KEY (menu_id)
);

CREATE TABLE public.htl_food (
    food_id BIGINT NOT NULL,
    cat_food_type BIGINT NOT NULL,
    food_name VARCHAR(100) NOT NULL,
    food_description VARCHAR(500),
    food_price NUMERIC(20, 6) NOT NULL,
    food_ingredients VARCHAR(500) NULL,
    attachment_url VARCHAR(500),
    CONSTRAINT htl_food_pk PRIMARY KEY (food_id)
);

CREATE TABLE public.htl_menu_food (
    menu_food_id BIGINT NOT NULL,
    menu_id BIGINT NOT NULL,
    food_id BIGINT NOT NULL,
    CONSTRAINT htl_menu_food_pk PRIMARY KEY (menu_food_id)
);

CREATE SEQUENCE SEQ_HTL_MENU INCREMENT BY 1 START WITH 15000;
CREATE SEQUENCE SEQ_HTL_FOOD INCREMENT BY 1 START WITH 15000;
CREATE SEQUENCE SEQ_HTL_MENU_FOOD INCREMENT BY 1 START WITH 15000;
