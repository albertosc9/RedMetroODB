package es.redmetro.asc.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import es.redmetro.asc.dao.IRedMetro;
import es.redmetro.asc.utilidades.GestionEntityManager;
import es.redmetro.asc.vo.Linea;

public class LineaJpa implements IRedMetro<Linea>{

	private EntityManager em;
	
	@Override
	public void crear(Linea entidad) {
		// TODO Auto-generated method stub
		
	      
		 Linea linea = buscar(entidad.getCodigoLinea());
		 
		 if (linea==null) {
			 try {
				 em = GestionEntityManager.getEntityManager();
				 em.getTransaction().begin();
			     em.persist(entidad);
			     em.getTransaction().commit(); 
			     
			 }catch(javax.persistence.RollbackException e) {
				 	e.printStackTrace();
			 }
		 }
		
	       
	      
	        
	//      emf.close();
	        em.close();
	    
	}

	@Override
	public void borrar(Linea entidad) {
		// TODO Auto-generated method stub
	Linea linea = buscar(entidad.getCodigoLinea());
		
		if (linea!=null) {
			
			em = GestionEntityManager.getEntityManager();
			
			em.getTransaction().begin();
			 
			em.remove(linea);
			  
			em.getTransaction().commit();
			em.close();
		}
		


	}

	@Override
	public Linea buscar(int codigo) {
		Linea linea = new Linea();
		em= GestionEntityManager.getEntityManager();
		
		
		
		em.getTransaction().begin();
		
		linea = em.find(Linea.class,codigo);
	
		em.close();
		return linea;
	}

	@Override
	public List<Linea> getLista() {
		em = GestionEntityManager.getEntityManager();
		
		
		  
		
		        Query query = em.createQuery("select a from Linea a");

		        List<Linea> resutls = query.getResultList();
		        
		    
		        em.close();
		        
		return resutls;
	}

}
