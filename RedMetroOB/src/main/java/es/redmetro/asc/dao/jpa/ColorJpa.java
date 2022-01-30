package es.redmetro.asc.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import es.redmetro.asc.dao.IRedMetro;
import es.redmetro.asc.utilidades.GestionEntityManager;
import es.redmetro.asc.vo.Color;

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
	
		Color color = buscar(entidad.getCodigoColor());
		
		if (color!=null) {
			
			em = GestionEntityManager.getEntityManager();
			
			em.getTransaction().begin();
			 
			em.remove(color);
			  
			em.getTransaction().commit();
		}
		
		em.close();

		 
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
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
