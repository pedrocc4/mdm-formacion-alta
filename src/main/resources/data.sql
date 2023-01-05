-- CLIENTES

INSERT INTO CLIENTE (rowid_object, nombre, tipo_documento, numero_documento, fc_nacimiento)
VALUES ('1', 'Pedro', 'DNI', '66666666S', '2010-04-04');

INSERT INTO CLIENTE (rowid_object, nombre, tipo_documento, numero_documento, fc_nacimiento)
VALUES ('2', 'Luis', 'DNI', '66666666S', '2010-04-04');

INSERT INTO CLIENTE (rowid_object, nombre, tipo_documento, numero_documento, fc_nacimiento)
VALUES ('3', 'Dani', 'DNI', '66666666S', '2010-04-04');

-- POLIZAS

INSERT INTO POLIZA (rowid_object, num_poliza)
VALUES ('1', '99S');

INSERT INTO POLIZA (rowid_object, num_poliza)
VALUES ('2', '99S');

INSERT INTO POLIZA (rowid_object, num_poliza)
VALUES ('3', '99S');

-- ROLES

INSERT INTO ROL (rowid_object, nombre_rol, cliente_rowid_object, poliza_rowid_object)
VALUES ('1', 'ADMIN', '1', '1');

INSERT INTO ROL (rowid_object, nombre_rol, cliente_rowid_object, poliza_rowid_object)
VALUES ('2', 'ADMIN', '2', '1');

INSERT INTO ROL (rowid_object, nombre_rol, cliente_rowid_object, poliza_rowid_object)
VALUES ('3', 'ADMIN', '3', '1');

-- INDICADORES LOPD

INSERT INTO LOPD (rowid_object, valor_publicidad, cliente_rowid_object)
VALUES ('1', '123', '1');

INSERT INTO LOPD (rowid_object, valor_publicidad, cliente_rowid_object)
VALUES ('2', '123', '2');

INSERT INTO LOPD (rowid_object, valor_publicidad, cliente_rowid_object)
VALUES ('3', '123', '3');