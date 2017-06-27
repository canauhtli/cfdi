package com.canauhtli.utils;

import java.util.ArrayList;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class PrintManager {

	public static List<String> listaImpresoras() {
		ArrayList<String> lst = new ArrayList<String>();
		PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);
		for (PrintService p : ps) {
			lst.add(p.getName());
		}
				
		return lst;
	}
	
	public static String impresoraDefault() {
		
		return PrintServiceLookup.lookupDefaultPrintService().getName();
		
	}
}
