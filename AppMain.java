package com.mindtree.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mindtree.entity.Student;

public class AppMain {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EmployeeTest");
		EntityManager entityManager = emFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		try{
			Student student1=new Student();
			student1.setName("Supratim");
			student1.setRoll(7);
			Student student2=new Student();
			student2.setName("Pritam");
			student2.setRoll(12);
			entityManager.persist(student1);
			entityManager.persist(student2);
			entityManager.getTransaction().commit();
		}catch(Exception e){
			entityManager.getTransaction().rollback();
		}
	}
}
