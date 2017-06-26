package mx.com.canauhtli.pruebas;

import java.util.Properties;

public class SysProps {

	public static void main(String args[]) {
		Properties props = System.getProperties();
		props.list(System.out);
	}
}
