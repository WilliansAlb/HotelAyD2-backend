CREATE TABLE public.htl_menu (
    menu_id BIGINT NOT NULL,
    menu_name VARCHAR(100) NOT NULL,
    menu_description VARCHAR(500),
    menu_price NUMERIC(20, 6) NOT NULL,
    attachment_url VARCHAR(500),
    CONSTRAINT htl_menu_pk PRIMARY KEY (menu_id)
);

CREATE TABLE public.htl_menu_item (
    menu_item_id BIGINT NOT NULL,
    cat_menu_item_type BIGINT NOT NULL,
    menu_id BIGINT,
    item_name VARCHAR(100) NOT NULL,
    item_description VARCHAR(500),
    item_price NUMERIC(20, 6) NOT NULL,
    item_ingredients VARCHAR(500) NULL,
    attachment_url VARCHAR(500),
    CONSTRAINT htl_menu_item_pk PRIMARY KEY (menu_item_id)
);

ALTER TABLE public.htl_menu_item
ADD CONSTRAINT htl_menu_htl_menu_item_fk
FOREIGN KEY (menu_id)
REFERENCES htl_menu (menu_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

CREATE SEQUENCE SEQ_HTL_MENU INCREMENT BY 1 START WITH 15000;
CREATE SEQUENCE SEQ_HTL_MENU_ITEM INCREMENT BY 1 START WITH 15000;
