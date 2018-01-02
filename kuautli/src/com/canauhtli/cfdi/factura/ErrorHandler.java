package com.canauhtli.cfdi.factura;

import org.beanio.BeanReaderErrorHandlerSupport;
import org.beanio.BeanReaderException;
import org.beanio.InvalidRecordException;
import org.beanio.MalformedRecordException;
import org.beanio.RecordContext;
import org.beanio.UnexpectedRecordException;
import org.beanio.UnidentifiedRecordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorHandler extends BeanReaderErrorHandlerSupport {

	private static Logger log = LoggerFactory.getLogger(ErrorHandler.class);
	
	public void invalidRecord(InvalidRecordException ex) {
		log.error("Registro incorrecto - {}", ex.getMessage());
		RecordContext rc = ex.getRecordContext();
		for (String f : rc.getFieldErrors().keySet()) {
			for (String err : rc.getFieldErrors(f)) {
				log.error("[{}] {}: {} - {}", rc.getLineNumber(), rc.getRecordName(), f, err);
			}
		}
		
	}
	
	public void malformedRecord(MalformedRecordException ex) {
		log.error("Registro mal formado - {}", ex.getMessage());
		RecordContext rc = ex.getRecordContext();
		for (String f : rc.getFieldErrors().keySet()) {
			for (String err : rc.getFieldErrors(f)) {
				log.error("[{}] {}: {} - {}", rc.getLineNumber(), rc.getRecordName(), f, err);
			}
		}
	}
	
	public void unexpectedRecord(UnexpectedRecordException ex) {
		log.error("Registro no esperado - {}", ex.getMessage());
		RecordContext rc  = ex.getRecordContext();
		for (String err : rc.getRecordErrors()) {
			log.error("[{}] {}", rc.getLineNumber(), err);
		}
	}
	
	public void unidentifiedRecord(UnidentifiedRecordException ex) {
		log.error("Registro no identificado - {}", ex.getMessage());
		RecordContext rc  = ex.getRecordContext();
		for (String err : rc.getRecordErrors()) {
			log.error("[{}] {}", rc.getLineNumber(), err);
		}
	}
	
	public void fatalError(BeanReaderException ex) {
		log.error("Error fatal - {}", ex.getMessage());
		RecordContext rc  = ex.getRecordContext();
		for (String err : rc.getRecordErrors()) {
			log.error("[{}] {}", rc.getLineNumber(), err);
		}
	}
	
}
