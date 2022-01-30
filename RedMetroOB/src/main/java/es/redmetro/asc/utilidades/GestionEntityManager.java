package es.redmetro.asc.utilidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestionEntityManager {

	

	private static EntityManagerFactory emf = null;
	
	
	public static EntityManager getEntityManager() {
		
		   EntityManager em = null;
		if (emf==null) {
			 emf=  Persistence.createEntityManagerFactory(GestorConfiguracion.getInfoConfiguracion("BBDD"));
			  
			    
		}
		
		em = emf.createEntityManager();
		
		return em;
	}
}
