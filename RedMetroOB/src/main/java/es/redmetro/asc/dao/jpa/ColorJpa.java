package es.redmetro.asc.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import es.redmetro.asc.dao.IRedMetro;
import es.redmetro.asc.utilidades.GestionEntityManager;
import es.redmetro.asc.vo.Color;
import es.redmetro.asc.vo.Linea;

public class ColorJpa implements IRedMetro<Color> {

	private EntityManager em;
	
	public void crear(Color entidad) {
		 em = GestionEntityManager.getEntityManager();
	      
		 try {
			 em.getTransaction().begin();
		     em.persist(entidad);
		     em.getTransaction().commit(); 
		     
		 }catch(javax.persistence.RollbackException e) {
			 	System.err.println("intento de introducir clave ya existente "+entidad.getCodigoColor());
		 }
	       
	      
	        
	//      emf.close();
	        em.close();
	    
		
	}

	public void borrar(Color entidad) {
		// TODO Auto-generated method stub
	
		EntityTransaction transaccion=null;
		try {
			em=GestionEntityManager.getEntityManager();
			transaccion=em.getTransaction();
			transaccion.begin();
			
			if (!em.contains(entidad))
				entidad = em.merge(entidad);

			em.remove(entidad);
            
            transaccion.commit();
        } catch (PersistenceException e) {
            if(transaccion != null)
            	transaccion.rollback();
           e.printStackTrace();      
        } finally {
        	if (em!=null)
        		em.close();
        }				
	}
		 
	

	public Color buscar(int codigo) {
	
		Color color = new Color();
		
		
		em= GestionEntityManager.getEntityManager();
		
		em.getTransaction().begin();
		
		color = em.find(Color.class,codigo);
		
		em.close();
		return color;
	}

	@Override
	public List<Color> getLista() {

		em = GestionEntityManager.getEntityManager();
		
		 Query query = em.createQuery("Select c from Color c");
	      List<Color> list=query.getResultList();

	   em.close();
	   
	   return list;
	   
	}
		@Override
		public void actualizar(Color entidad) {
			// TODO Auto-generated method stub
			EntityTransaction transaccion=null;
			try {
				em=GestionEntityManager.getEntityManager();
				transaccion=em.getTransaction();
				transaccion.begin();
				
				// Para poder actulizarse ha de encontarse en el ámbito del entityManager
				if (!em.contains(entidad))
					entidad=em.merge(entidad);

//				Se actualizará cualquier cambio existente entre el objeto que está en la base de datos y el que 
//				se maneja como entidad, siempre que esté entre el comienzo y la confirmación de una transacción. 
	            
	            transaccion.commit();
	        } catch (PersistenceException e) {
	            if(transaccion != null)
	            	transaccion.rollback();
	          e.printStackTrace();         
	        } finally {
	        	if (em!=null)
	        		em.close();
	        }				
		}		

		
	}
	
	
	


