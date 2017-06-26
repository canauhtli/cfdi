package mx.com.canauhtli.pruebas;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class FacturaPdf {

	private String plantilla;
	private HashMap<String, Object> params;
	private String nombre;
	
	public void generaPDF(List<Concepto> conceptos) {
		try {
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(conceptos);
			JasperPrint jp = JasperFillManager.fillReport(this.plantilla, this.params, ds);
			JasperExportManager.exportReportToPdfFile(jp, this.nombre);
			
		}
		catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void addParam(String k, Object v) {
		if (this.params == null) {
			this.params = new HashMap<String, Object>();
		}
		this.params.put(k, v);
	}
	
	public void parametrosGenerales() {
		addParam("receptor", "MORAN SEGOVIA DARIO ADOLFO");
		addParam("dir1", "HACIENDA LA LLAVE 217");
		addParam("dir2", "JARDINES DE LA HACIENDA");
		addParam("dir3", "SANTIAGO DE QUERETARO, QUERETARO");
		addParam("dir4", "MEXICO, C.P. 76180");
		addParam("rfc", "MOSD5601167F7");
		addParam("tipoCFD", "FACTURA");
		addParam("uuid", "8355AD13-3CFF-4AE7-ACF2-A071026FB31D");
		addParam("serie", "A");
		addParam("folio", "41458");
		addParam("cerSAT", "00001000000203220546");
		addParam("cerEmi", "00001000000300200063");
		addParam("fechaCert", "03/03/2016 13:21:23");
		addParam("fechaCfdi", "03/03/2016 13:22:32");
		addParam("subtotal", new BigDecimal(19940.61));
		addParam("tasaDesc", new BigDecimal("0.0"));
		addParam("tasaIva", new BigDecimal(16));
		addParam("iva", new BigDecimal(3190.50));
		addParam("total", new BigDecimal(23131.11));
		addParam("formaPago", "NO DEFINIDO");
		addParam("metodoPago", "NO DEFINIDO");
		addParam("importeLetra", "VEINTITRES MIL CIENTO TREINTA Y UN PESOS 11/CVS M.N.");
		addParam("observacion1", "PAGO EN UNA SOLA EXHIBICION");
		addParam("selloSAT", "paldsifnmwokdjfowikenmowie2342lfi2m3lgvn2kjfnb2k3lk2l3klgvk22lk32rl23kmn2lkn2ik32lkvo23rlskdxv9we843n928inv9s82jn39vi8293nmv9nsf82oind9v8u92n3kvjnw93uinvnm9283b9vnwkd8iu9wfn9e82lks8fvyu92kj3nv92jndvwlsjfgh");
		addParam("selloEmisor", "paldsifnmwokdjfowikenmowie2342lfi2m3lgvn2kjfnb2k3lk2l3klgvk22lk32rl23kmn2lkn2ik32lkvo23rlskdxv9we843n928inv9s82jn39vi8293nmv9nsf82oind9v8u92n3kvjnw93uinvnm9283b9vnwkd8iu9wfn9e82lks8fvyu92kj3nv92jndvwlsjfgh");
		addParam("cadenaOriginal", "||" + "1" + "|" + "8355AD13-3CFF-4AE7-ACF2-A071026FB31D" + "|" + "2016-03-03T13:22:32" + "|" + 
				"paldsifnmwokdjfowikenmowie2342lfi2m3lgvn2kjfnb2k3lk2l3klgvk22lk32rl23kmn2lkn2ik32lkvo23rlskdxv9we843n928inv9s82jn39vi8293nmv9nsf82oind9v8u92n3kvjnw93uinvnm9283b9vnwkd8iu9wfn9e82lks8fvyu92kj3nv92jndvwlsjfgh" + "|" + 
				"00001000000203220546" + "||");
		addParam("logo", "E:\\Proyectos\\facturacion\\FacCFDI\\configuracion\\maqRentLogo.jpg");

		addParam("pedido", "Q-380840");
		addParam("pedidoCliente", "");
		addParam("modelo", "");
		addParam("noserie", "");
		addParam("eco", "");
		try {
			String qrCode = "?re=" + "MQU080723EC5" + 
					"&rr=" + "MOSD5601067F7" + 
					"&tt=" + "23131.11" + 
					"&id=" + "8355AD13-3CFF-4AE7-ACF2-A071026FB31D";
			BufferedImage bi = MatrixToImageWriter.toBufferedImage(new QRCodeWriter().encode(qrCode, BarcodeFormat.QR_CODE, 125, 125));
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(bi, "gif", os);
			InputStream is = new ByteArrayInputStream(os.toByteArray());
			addParam("qrCode", is);
		} catch (WriterException we) {
			we.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public List<Concepto> generaConceptos(int num) {
		List<Concepto> conceptos = new ArrayList<Concepto>();
		for (int i=0; i<num; i++) {
			Concepto concepto = new Concepto();
			concepto.setCantidad(1);
			concepto.setCodigo("MC32758");
			concepto.setDescripcion("PRODUCTO GENERICO");
			concepto.setImporte(new BigDecimal(100));
			concepto.setPartida(i);
			concepto.setPrecioUnitario(new BigDecimal(100));
			concepto.setUnidad("PZ");
			conceptos.add(concepto);
		}
		return conceptos;
	}
	
	public static void main(String[] args) {

		FacturaPdf fact = new FacturaPdf();
		fact.setPlantilla("C:\\Users\\eduardo\\proyectos\\JasperSoft\\facturacion\\cfdi\\cfdPdf3.jasper");
		fact.setNombre("factura_100.pdf");
		fact.parametrosGenerales();
		
		List<Concepto> conceptos = fact.generaConceptos(100);
		fact.generaPDF(conceptos);
	}

}
