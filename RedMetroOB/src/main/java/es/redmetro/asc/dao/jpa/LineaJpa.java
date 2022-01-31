package es.redmetro.asc.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
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

	@Override
	public Linea buscar(int codigo) {
		
		em= GestionEntityManager.getEntityManager();
		
//		
//		Query query =   em.createQuery(
//			    "SELECT l FROM Linea l WHERE c.codigoLinea = :custName")
//			    .setParameter("custName", codigo);
//			
//		Object linea = query.getSingleResult();
		
		
		em= GestionEntityManager.getEntityManager();
		
		
		
		em.getTransaction().begin();
		
		Linea linea = em.find(Linea.class,codigo);
//	
		em.close();
		return linea;
	}

	@Override
	public List<Linea> getLista() {
		
//		List<Linea> departamentos = null;
//	    try {
//			em=GestionEntityManager.getEntityManager();
//
//			String sentenciaJPQL="SELECT departamento FROM Departamento departamento";
//
//			TypedQuery<Departamento> query =entityManager.createQuery(sentenciaJPQL, Departamento.class);
//			
//			departamentos = query.getResultList();
//        }catch (NoResultException e) {
//        	departamentos =null;            
//        }catch (PersistenceException e) {
//            throw new  EmpresaException(EmpresaException.EXCEPCION_CONSULTAR, e);            
//        } finally {
//        	if (entityManager!=null)
//        		entityManager.close();
//        }		

		return null;
	}
	   
	

	@Override
	public void actualizar(Linea entidad) {
		EntityTransaction transaccion=null;
		try {
			em=GestionEntityManager.getEntityManager();
			transaccion=em.getTransaction();
			transaccion.begin();
			
			// Para poder actulizarse ha de encontarse en el ámbito del entityManager
			if (!em.contains(entidad))
				entidad=em.merge(entidad);

//			Se actualizará cualquier cambio existente entre el objeto que está en la base de datos y el que 
//			se maneja como entidad, siempre que esté entre el comienzo y la confirmación de una transacción. 
            
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
