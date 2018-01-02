CREATE TABLE CFDI_CONFIG (
	CAMPO VARCHAR(100),
	VALOR VARCHAR(250)
);

-- Valores iniciales
-- Emisor
INSERT INTO CFDI_CONFIG VALUES('emisor.razonSocial','Maquirent de Queretaro S.A. de C.V.');
INSERT INTO CFDI_CONFIG VALUES('emisor.rfc','MQU080723EC5');
INSERT INTO CFDI_CONFIG VALUES('emisor.calle','Blvd. de las Americas');
INSERT INTO CFDI_CONFIG VALUES('emisor.numeroExterior','20');
INSERT INTO CFDI_CONFIG VALUES('emisor.numeroInterior','PB');
INSERT INTO CFDI_CONFIG VALUES('emisor.colonia','Lomas de Queretaro');
INSERT INTO CFDI_CONFIG VALUES('emisor.municipio','Santiago de Queretaro');
INSERT INTO CFDI_CONFIG VALUES('emisor.cp','76138');
INSERT INTO CFDI_CONFIG VALUES('emisor.ciudad','');
INSERT INTO CFDI_CONFIG VALUES('emisor.estado','Queretaro');
INSERT INTO CFDI_CONFIG VALUES('emisor.pais','Mexico');
INSERT INTO CFDI_CONFIG VALUES('emisor.registroPatronal','12345678');
INSERT INTO CFDI_CONFIG VALUES('emisor.regimenFiscal','Regimen general de personas morales');
-- General
INSERT INTO CFDI_CONFIG VALUES('general.carpetaSalida','C:/Users/eduardo/proyectos/nomOut/comprobantes/');
INSERT INTO CFDI_CONFIG VALUES('general.generarPdf','1');
INSERT INTO CFDI_CONFIG VALUES('general.plantilla','C:/Users/eduardo/proyectos/facturacion/FacCFDI/configuracion/jdominguez.jasper');
INSERT INTO CFDI_CONFIG VALUES('general.logo','C:\\Users\\eduardo\\proyectos\\facturacion\\FacCFDI\\configuracion\\maqRentLogo.jpg');
INSERT INTO CFDI_CONFIG VALUES('general.iva','16');
INSERT INTO CFDI_CONFIG VALUES('general.imprimir','1');
INSERT INTO CFDI_CONFIG VALUES('general.copias','3');
INSERT INTO CFDI_CONFIG VALUES('general.impresora','default');

INSERT INTO CFDI_CONFIG VALUES('mail.enviarCorreo','1');
INSERT INTO CFDI_CONFIG VALUES('mail.server','gmail.com');
INSERT INTO CFDI_CONFIG VALUES('mail.puerto','21');
INSERT INTO CFDI_CONFIG VALUES('mail.remitente','juan@gmail.com');
INSERT INTO CFDI_CONFIG VALUES('mail.asunto','su recibo de nomina');
INSERT INTO CFDI_CONFIG VALUES('mail.mensaje','saludos');
INSERT INTO CFDI_CONFIG VALUES('mail.autenticar','1');
INSERT INTO CFDI_CONFIG VALUES('mail.usr','usuario');
INSERT INTO CFDI_CONFIG VALUES('mail.pwd','password');
-- Proveedor
INSERT INTO CFDI_CONFIG VALUES('proveedores','felmx,multipac');
INSERT INTO CFDI_CONFIG VALUES('proveedor','felmx');
INSERT INTO CFDI_CONFIG VALUES('felmx.servicio','com.canauhtli.facturacion.fel.FelWSClient');
INSERT INTO CFDI_CONFIG VALUES('felmx.url','https://www.fel.mx/ConexionRemotaCFDI32/ConexionRemota32.asmx');
INSERT INTO CFDI_CONFIG VALUES('felmx.productivo','0');
INSERT INTO CFDI_CONFIG VALUES('felmx.rfc','MQU080723EC5');
INSERT INTO CFDI_CONFIG VALUES('felmx.cuenta','MQU080723EC5');
INSERT INTO CFDI_CONFIG VALUES('felmx.password','Lupit@5&');
INSERT INTO CFDI_CONFIG VALUES('felmx.formato','xml');
INSERT INTO CFDI_CONFIG VALUES('multipac.servicio','com.canauhtli.facturacion.multipac.MultiPacWSClient');
INSERT INTO CFDI_CONFIG VALUES('multipac.url','http://facturaloplus.com/pruebas/system/ws/ws.facturaplus.php');
INSERT INTO CFDI_CONFIG VALUES('multipac.productivo','0');
INSERT INTO CFDI_CONFIG VALUES('multipac.usuario','AAA010101AAA');
INSERT INTO CFDI_CONFIG VALUES('multipac.password','12345678a');



CREATE TABLE CFDI_PERIODO (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	PERIODO VARCHAR(20) NOT NULL,
	ARCHIVO VARCHAR(500),
	STATUS INT,
	FECHA_CREACION TIMESTAMP DEFAULT NOW(),
	FECHA_STATUS TIMESTAMP DEFAULT NOW()
);

CREATE TABLE CFDI_RECIBO_NOMINA (
	ID_RECIBO_NOMINA INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ID_PERIODO INT,
	NUM_EMP VARCHAR(50),
	ESTATUS CHAR(1),
	COMPROBANTE_FISCAL TEXT,
	UUID VARCHAR(50),
	RECIBO TEXT,
	INDEX PER_IDX (ID_PERIODO),
	FOREIGN KEY (ID_PERIODO) REFERENCES CFDI_PERIODO(ID) ON DELETE CASCADE
);

CREATE TABLE CFDI_FACTURA (
	ID_FACTURA INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	CODIGO VARCHAR(50),
	CLIENTE INT,
	ESTATUS CHAR(1),
	FECHA_PROCESO TIMESTAMP DEFAULT NOW(),
	FECHA_STATUS TIMESTAMP DEFAULT NOW(),
	UUID VARCHAR(50),
	FACTURA TEXT,
	COMPROBANTE_FISCAL TEXT,
	INDEX FAC_IDX (ID_FACTURA),
	INDEX FAC_COD_IDX(CODIGO)
);



