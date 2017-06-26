package mx.com.canauhtli.pruebas;

import java.io.File;

public class MoverArchivo {

	public static void main(String[] args) {
		File archivo = new File("/users/eduardo/downloads/FP121305.TXT");
		System.out.println("archivo: " + archivo.isFile() + " - " + archivo.canRead());
		System.out.println("name: " + archivo.getName());
		System.out.println("parent: " + archivo.getParent());
		try {
			System.out.println("canonicalpath: " + archivo.getCanonicalPath());
			String nf = archivo.getParent() + File.separator  + "resp" + File.separator + archivo.getName();
			System.out.println("nuevo: " + nf);
			boolean exito = archivo.renameTo(new File(nf));
			System.out.println("Movido: " + exito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
