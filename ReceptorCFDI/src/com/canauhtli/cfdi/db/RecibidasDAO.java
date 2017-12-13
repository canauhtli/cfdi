package com.canauhtli.cfdi.db;

import java.util.HashMap;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecibidasDAO {

	private static Logger log = LoggerFactory.getLogger(RecibidasDAO.class);
	private EntityManagerFactory factory;
	private boolean conectado;
	
	public RecibidasDAO(ResourceBundle props) {
		String url = "jdbc:mysql://" + props.getString("db.server") + "/" + props.getString("db.name");
		HashMap<String, String> dbconfig = new HashMap<String, String>();
		dbconfig.put("javax.persistence.jdbc.url", url);
		dbconfig.put("javax.persistence.jdbc.user", props.getString("db.usr"));
		dbconfig.put("javax.persistence.jdbc.password", props.getString("db.pwd"));
		dbconfig.put("javax.persistence.jdbc.dirver", "com.mysql.jdbc.Driver");
		
		factory = Persistence.createEntityManagerFactory("cfdidb", dbconfig);
	}
	
	public boolean test() {
		boolean open = false;
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			open = em.isOpen();
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
		return open;
	}
	
	public boolean isConectado() {
		return conectado;
	}
	
	public void conectar() {
		conectado = test();
	}
	
	public Factura registraFactura(Factura factura) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(factura);
		em.flush();
		em.getTransaction().commit();
		em.close();
		return factura;
	}
	
	public Factura buscaFactura(String pedido) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("Factura.findByPedido");
		query.setParameter("pedido", pedido);
		
		Factura factura = null;
		try {
			factura = (Factura) query.getSingleResult();
		} catch (NoResultException nre) {
			// Normal para la validacion de existencia previa de la factura.
		}
		em.getTransaction().commit();
		
		return factura;
	}
	
	public Concepto registraConcepto(Concepto concepto) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(concepto);
		em.flush();
		em.getTransaction().commit();
		em.close();
		return concepto;
	}
}
