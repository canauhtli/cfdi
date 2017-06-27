package com.canauhtli.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.cfdi.CFDIException;
import com.canauhtli.cfdi.nomina.ReciboCorreo;
import com.canauhtli.config.ConfigManager;

public class ClienteSMTP {

	private static Logger log = LoggerFactory.getLogger(ClienteSMTP.class);
	private ConfigManager cm;
	private ArrayList<ReciboCorreo> recibos = new ArrayList<ReciboCorreo>();
	private Session session;
	
	public ClienteSMTP(ConfigManager cm) {
		this.cm = cm;
		boolean autenticar = "1".equals(cm.getMailConfig("autenticar"));
		
		Properties props = new Properties();
		if (autenticar) {
			props.put("mail.smtp.auth", "true");
		}
        props.put("mail.smtp.host", cm.getMailConfig("server"));
        props.put("mail.smtp.port", cm.getMailConfig("puerto"));
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.ssl.trust", cm.getMailConfig("server"));
        
        if (autenticar) {
        	session = Session.getInstance(props, new Authenticator() {
        		protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(cm.getMailConfig("usr"), cm.getMailConfig("pwd"));
                }
        	});
        } else {
        	session = Session.getInstance(props);
        }
        
	}
	
	public void addRecibo(ReciboCorreo recibo) {
		recibos.add(recibo);
	}
	
	public void enviaCorreos() throws CFDIException {
		Transport transport = null;
		try {
			transport = session.getTransport();
			transport.connect();
			for (ReciboCorreo recibo : recibos) {
				MimeMessage message = new MimeMessage(session);
                try {
                	message.setFrom(new InternetAddress(cm.getMailConfig("remitente")));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recibo.getCorreo()));
                    message.setSubject(cm.getMailConfig("asunto"));
                    MimeBodyPart htmlPart = new MimeBodyPart();
                    htmlPart.setContent(recibo.getMsg(), "text/html");
                    MimeBodyPart pdfAttachment = new MimeBodyPart();
                    pdfAttachment.setFileName("recibo.pdf");
                    pdfAttachment.addHeader("Content-Type", "application/pdf");
					pdfAttachment.attachFile(recibo.getPathPdf());
					MimeBodyPart xmlAttachment = new MimeBodyPart();
	                xmlAttachment.setFileName("recibo.xml");
	                xmlAttachment.setContent(recibo.getXml(), "text/xml");
	                MimeMultipart mp = new MimeMultipart();
	                mp.addBodyPart(htmlPart);
	                mp.addBodyPart(pdfAttachment);
	                mp.addBodyPart(xmlAttachment);
	                message.setContent(mp);
	                transport.sendMessage(message, InternetAddress.parse(recibo.getCorreo()));
	                recibo.setEnviado(true);
				} catch (AddressException ae) {
                    recibo.setEnviado(false);
                    recibo.setError("Dirección de correo invalida");
                    log.error("Enviando correo a empleado " + recibo.getNumEmp() + ":" + recibo.getCorreo(), ae);
                } catch (MessagingException me) {
                    recibo.setEnviado(false);
                    recibo.setError("Problema para enviar correo");
                    log.error("Enviando correo a empleado " + recibo.getNumEmp(), me);
                } catch (IOException ioe) {
                    recibo.setEnviado(false);
                    recibo.setError("PDF o XML no encontrado");
                    log.error("PDF o XML no encontrado " + recibo.getNumEmp(), ioe);
                } catch (Exception e) {
                    recibo.setEnviado(false);
                    recibo.setError("Problema en el proceso de enviar correo");
                    log.error("Problema en el proceso de envio de correo " + recibo.getNumEmp(), e);
                }
			}
		} catch (NoSuchProviderException nspe) {
			log.error(nspe.getMessage(), nspe);
            throw new CFDIException("No pude conectarme con el servidor de correo");
		} catch (MessagingException me) {
			log.error(me.getMessage(), me);
            throw new CFDIException("No pude establecer comunicacion con el servidor de correo");
		} finally {
			try {
                if (transport != null) { transport.close(); }
            }
            catch (MessagingException me) {
                log.warn("cerrando transporte", me);
            }
		}
	}
	
	public ArrayList<ReciboCorreo> getRecibos() {
		return recibos;
	}
}
