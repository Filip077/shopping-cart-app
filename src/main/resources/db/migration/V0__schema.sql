create table SHOPPING_CART
(
    ID               bigint    NOT NULL primary key AUTO_INCREMENT,
    QUANTITY         bigint NOT NULL default 0,
    SERIAL_NUM       varchar(256) NOT NULL,
    STATE varchar(256) NOT NULL DEFAULT 'OPEN'
);

create table PRODUCT
(
    ID               bigint    NOT NULL primary key AUTO_INCREMENT,
    SERIAL_NUM       varchar(256) NOT NULL,
    PRICE    bigint       NOT NULL,
    NAME     varchar(256) NOT NULL,
    SHOPPING_CART_ID   bigint default 0,
    foreign key (SHOPPING_CART_ID) references SHOPPING_CART (ID)
);
