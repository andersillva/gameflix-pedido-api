--liquibase formatted sql
				
--changeset andersillva:1
CREATE TABLE if not exists pedido (
	id_pedido			INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_usuario			INT NOT NULL,
	dt_pedido			DATE NOT NULL,
	tp_status			VARCHAR(1) NOT NULL
);
