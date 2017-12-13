CREATE TABLE CFDI_Factura_Recibida (
  id_factura_recibida INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  numero_pedido VARCHAR(50) NOT NULL,
  archivo VARCHAR(100),
  serie VARCHAR(10),
  folio INT,
  fecha TIMESTAMP,
  subtotal DECIMAL(12,2),
  descuento DECIMAL(12,2),
  total DECIMAL(12,2),
  totalImpuestos DECIMAL(12,2),
  moneda VARCHAR(5),
  tipoCambio DECIMAL(6,2),
  rfcEmisor VARCHAR(18),
  UUID VARCHAR(40)
);

CREATE TABLE CFDI_Concepto_Recibida (
  id_concepto_recibida INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_factura_recibida INT NOT NULL,
  claveProdServ VARCHAR(50),
  numIdentificacion VARCHAR(50),
  cantidad DECIMAL(6,4),
  claveUnidad VARCHAR(50),
  unidad VARCHAR(50),
  descripcion VARCHAR(250),
  valorUnitario DECIMAL(12,2),
  importe DECIMAL(12,2),
  descuento DECIMAL(12,2),
  FOREIGN KEY (id_factura_recibida) REFERENCES CFDI_Factura_Recibida(id_factura_recibida) ON DELETE CASCADE
);