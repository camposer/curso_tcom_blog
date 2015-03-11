CREATE TABLE usuario(
	id INTEGER NOT NULL 
		GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre_usuario VARCHAR(20) NOT NULL,
	clave VARCHAR(50) NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT uq_nombre_usuario UNIQUE (nombre_usuario)
);

INSERT INTO usuario(nombre_usuario, clave) VALUES('admin', 'd033e22ae348aeb5660fc2140aec35850c4da997');
INSERT INTO usuario(nombre_usuario, clave) VALUES('usuario', 'b665e217b51994789b02b1838e730d6b93baa30f');