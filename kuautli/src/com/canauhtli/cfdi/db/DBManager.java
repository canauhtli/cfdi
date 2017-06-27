package com.canauhtli.cfdi.db;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.config.AppConfig;

public class DBManager {

	private static Logger log = LoggerFactory.getLogger(DBManager.class);
	
	private EntityManagerFactory factory;
	private boolean conectado;
	
	public DBManager() {
		String url = "jdbc:mysql://" + AppConfig.getUserVal("dbServer") + "/" + AppConfig.getUserVal("dbName");
		HashMap<String, String> dbconfig = new HashMap<String, String>();
		dbconfig.put("javax.persistence.jdbc.url", url);
		dbconfig.put("javax.persistence.jdbc.user", AppConfig.getUserVal("dbUsr"));
		dbconfig.put("javax.persistence.jdbc.password", AppConfig.getUserValEnc("dbPwd"));
		dbconfig.put("javax.persistence.jdbc.dirver", "com.mysql.jdbc.Driver");
				
		factory = Persistence.createEntityManagerFactory("cfdidb", dbconfig);
		conectado = test();
	}
	
	public DBManager(String server, String dbname, String usr, String pwd) {
		String url = "jdbc:mysql://" + server + "/" + dbname;
		HashMap<String, String> dbconfig = new HashMap<String, String>();
		dbconfig.put("javax.persistence.jdbc.url", url);
		dbconfig.put("javax.persistence.jdbc.user", usr);
		dbconfig.put("javax.persistence.jdbc.password", pwd);
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
	
	public Periodo registraPeriodo(Periodo periodo) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(periodo);
		em.flush();
		em.getTransaction().commit();
		em.close();
		
		return periodo;
	}
	
	public void actualizaPeriodo(Periodo periodo) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		periodo.setFechaStatus(Timestamp.from(Instant.now()));
		em.merge(periodo);
		em.getTransaction().commit();
		em.close();
	}
	
	public int resetPeriodo(String periodo) {
		EntityManager em = factory.createEntityManager();
		String qtext = "UPDATE CFDI_PERIODO SET fecha_status = now(), status = ? WHERE periodo = ?";
		
		em.getTransaction().begin();
		Query query = em.createNativeQuery(qtext);
		query.setParameter(1, PeriodoStatus.DESPLAZADO.getStatus());
		query.setParameter(2, periodo);
		int upd = query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
		return upd;
	}
	
	public Periodo buscaPeriodoActivo(String periodo) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("Periodo.findByPeriodo");
		query.setParameter("periodo", periodo);
		query.setParameter("status", PeriodoStatus.DESPLAZADO.getStatus());
		
		Periodo  periodoRes = null;
		try {
			periodoRes = (Periodo) query.getSingleResult();
		} catch (NoResultException nre) {
			log.warn("No se encontro el periodo {}", periodo);
		}
		em.getTransaction().commit();
		return periodoRes;
	}
	
	public ReciboNomina registraRecibo(ReciboNomina rn) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(rn);
		em.flush();
		em.getTransaction().commit();
		em.close();
		return rn;
	}
	
	public ReciboNomina obtenReciboNomina(int idReciboNomina) {
		EntityManager em = factory.createEntityManager();
		ReciboNomina rn = new ReciboNomina();
		rn.setIdReciboNomina(idReciboNomina);
		rn = em.find(ReciboNomina.class, rn.getIdReciboNomina());
		em.close();
		
		return rn;
	}
	
	public void actualizaReciboNomina(ReciboNomina recibo) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(recibo);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<ReciboNomina> obtenRecibosPeriodo(int periodo) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("ReciboNomina.findByPeriodo");
		query.setParameter("periodo", periodo);
		List<ReciboNomina> listaRecibos = query.getResultList();
		em.getTransaction().commit();
		return listaRecibos;
	}
	
	public String buscaValorConfig(String campo) {
		String valor = "";
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("Config.findByCampo");
		query.setParameter("campo", campo);
		
		try {
			valor = (String) query.getSingleResult();
		} catch (NoResultException nre) {
			log.warn("No se encontro el campo {} en la configuracion", campo);
		}
		
		return valor;
	}
	
	@SuppressWarnings("unchecked")
	public List<Config> obtenConfiguracion() {
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("Config.findAll");
		List<Config> lst = query.getResultList();
		return lst;
	}
	
	@SuppressWarnings("unchecked")
	public List<Config> obtenConfiguracion(String grupo) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("Config.findByGrupo");
		query.setParameter(grupo, grupo + ".%");
		List<Config> lst = query.getResultList();
		return lst;
	}
	
	public void actualizaValorConfig(String campo, String valor) {
		EntityManager em = factory.createEntityManager();
		Config config = em.find(Config.class, campo);
		em.getTransaction().begin();
		config.setValor(valor);
		em.getTransaction().commit();
	}
}
