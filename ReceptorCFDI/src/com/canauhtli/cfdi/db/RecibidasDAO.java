package com.canauhtli.cfdi.db;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.cfdi.utils.AppConfig;

public class RecibidasDAO {

	private static Logger log = LoggerFactory.getLogger(RecibidasDAO.class);
	private EntityManagerFactory factory;
	private boolean conectado;
	
	public RecibidasDAO() {
		String url = "jdbc:mysql://" + AppConfig.getUserVal("db.server") + "/" + AppConfig.getUserVal("db.name");
		HashMap<String, String> dbconfig = new HashMap<String, String>();
		dbconfig.put("javax.persistence.jdbc.url", url);
		dbconfig.put("javax.persistence.jdbc.user", AppConfig.getUserVal("db.usr"));
		dbconfig.put("javax.persistence.jdbc.password", AppConfig.getUserValEnc("db.pwd"));
		dbconfig.put("javax.persistence.jdbc.dirver", "com.mysql.jdbc.Driver");
		
		factory = Persistence.createEntityManagerFactory("cfdidb", dbconfig);
	}
	
	public RecibidasDAO(ResourceBundle props) {
		String url = "jdbc:mysql://" + props.getString("db.server") + "/" + props.getString("db.name");
		HashMap<String, String> dbconfig = new HashMap<String, String>();
		dbconfig.put("javax.persistence.jdbc.url", url);
		dbconfig.put("javax.persistence.jdbc.user", props.getString("db.usr"));
		dbconfig.put("javax.persistence.jdbc.password", props.getString("db.pwd"));
		dbconfig.put("javax.persistence.jdbc.dirver", "com.mysql.jdbc.Driver");
		
		factory = Persistence.createEntityManagerFactory("cfdidb", dbconfig);
	}
	
	public void conectar(String server, String name, String usr, String pwd) {
		String url = "jdbc:mysql://" + server + "/" + name;
		HashMap<String, String> dbconfig = new HashMap<String, String>();
		dbconfig.put("javax.persistence.jdbc.url", url);
		dbconfig.put("javax.persistence.jdbc.user", usr);
		dbconfig.put("javax.persistence.jdbc.password", pwd);
		dbconfig.put("javax.persistence.jdbc.dirver", "com.mysql.jdbc.Driver");
		
		factory = Persistence.createEntityManagerFactory("cfdidb", dbconfig);
		conectar();
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
	
	public void actualizaFactura(Factura factura) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(factura);
		em.getTransaction().commit();
		em.close();
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
	
	@SuppressWarnings("unchecked")
	public List<Factura> buscaPendientes() {
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("Factura.findPendientes");
		List<Factura> pendientes = query.getResultList();
		return pendientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Factura> buscaPorFecha(Date fechaIni, Date fechaFin) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("Factura.findByFecha");
		query.setParameter("fini", fechaIni);
		query.setParameter("ffin", fechaFin);
		List<Factura> facturas = query.getResultList();
		return facturas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Concepto> listaConceptos(int idFactura) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("Factura.findByFactura");
		query.setParameter("factura", idFactura);
		List<Concepto> conceptos = query.getResultList();
		return conceptos;
	}
	
	
	private static class RecibidasHolder {
		private static final RecibidasDAO INSTANCE = new RecibidasDAO();
	}
	
	public static RecibidasDAO getInstance() {
		return RecibidasHolder.INSTANCE;
	}
	
	
	
}
