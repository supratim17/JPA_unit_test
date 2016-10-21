package com.mindtree.client;

import static org.junit.Assert.*;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.mindtree.entity.Student;

public class AppMainTest {

	private static final String PERSISTENCE_UNIT_NAME = "EmployeeTest";
    private EntityManagerFactory factory;
    
    @Before
    public void setup(){
    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    	EntityManager entityManager = factory.createEntityManager();
    	entityManager.getTransaction().begin();
    	Query query = entityManager.createQuery("select m from Student m");
    	//Check if we already have results in db or not
    	boolean checkIfNull = (query.getResultList().size()==0);
    	//if db is empty
    	if(checkIfNull){
    		assertTrue(checkIfNull);
    		for(int i=0;i<5;i++)
    		{
    			Student std = new Student();
    			std.setName("S");
        		std.setRoll(9);
        		entityManager.persist(std);
    		}
    	}
    	entityManager.getTransaction().commit();
    	entityManager.close();
    }
	
	@Test
	public void studentTest() {
		EntityManager emManager = factory.createEntityManager();
		Query query = emManager.createQuery("select m from Student m");
		assertEquals(5,query.getResultList().size());
		emManager.close();
	}

}
