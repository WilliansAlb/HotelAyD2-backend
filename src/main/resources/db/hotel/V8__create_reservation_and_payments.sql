CREATE TABLE client_account
(
    account_id BIGINT NOT NULL,
    start_date DATE   NOT NULL,
    end_date   DATE,
    active     BOOLEAN,
    client_id  BIGINT,
    CONSTRAINT client_account_pk PRIMARY KEY (account_id)
);

ALTER TABLE client_account
    ADD CONSTRAINT client_account_htl_client_fk
        FOREIGN KEY (client_id)
            REFERENCES htl_client (client_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

CREATE TABLE payment
(
    payment_id  BIGINT         NOT NULL,
    account_id  BIGINT         NOT NULL,
    date        DATE           NOT NULL,
    total       NUMERIC(20, 6) NOT NULL,
    description VARCHAR(100)   NOT NULL,
    CONSTRAINT payment_pk PRIMARY KEY (payment_id)
);

ALTER TABLE payment
    ADD CONSTRAINT client_account_payment_fk
        FOREIGN KEY (account_id)
            REFERENCES client_account (account_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

CREATE TABLE payment_reservation
(
    reservation_id BIGINT NOT NULL
) INHERITS (payment);

ALTER TABLE payment_reservation
    ADD CONSTRAINT payment_reservation_fk
        FOREIGN KEY (reservation_id)
            REFERENCES htl_reservation (reservation_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

CREATE TABLE status_reservation
(
    status_id   INTEGER      NOT NULL,
    status_name VARCHAR(100) NOT NULL,
    CONSTRAINT status_reservation_pk PRIMARY KEY (status_id)
);

INSERT INTO status_reservation(status_id, status_name)
VALUES (0, 'CANCELADA');
INSERT INTO status_reservation(status_id, status_name)
VALUES (1, 'EN ESPERA');
INSERT INTO status_reservation(status_id, status_name)
VALUES (2, 'ACTIVA');
INSERT INTO status_reservation(status_id, status_name)
VALUES (3, 'TERMINADA');

ALTER TABLE htl_reservation
    ADD status INTEGER NOT NULL DEFAULT 1;

ALTER TABLE htl_reservation
    ADD price_reservation NUMERIC(20, 6) NOT NULL DEFAULT 0.00;

ALTER TABLE htl_reservation
    ADD CONSTRAINT htl_reservation_status_fk
        FOREIGN KEY (status)
            REFERENCES status_reservation (status_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

CREATE SEQUENCE SEQ_PAYMENT INCREMENT BY 1 START WITH 15000;
CREATE SEQUENCE SEQ_CLIENT_ACCOUNT INCREMENT BY 1 START WITH 15000;