--liquibase formatted sql
				
--changeset andersillva:1
CREATE TABLE if not exists pedido_item (
	id_pedido_item			INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_pedido				INT NOT NULL,
	id_produto				INT NOT NULL
);

ALTER TABLE pedido_item ADD CONSTRAINT pedido_item_uk_prod_ped UNIQUE ( id_pedido, id_produto );

ALTER TABLE pedido_item
    ADD CONSTRAINT pedido_item_pedido_fk FOREIGN KEY ( id_pedido )
        REFERENCES pedido ( id_pedido );
