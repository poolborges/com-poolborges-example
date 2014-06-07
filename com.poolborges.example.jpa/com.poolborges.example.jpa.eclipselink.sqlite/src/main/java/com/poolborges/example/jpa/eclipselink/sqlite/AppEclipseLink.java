package com.poolborges.example.jpa.eclipselink.sqlite;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

 
/**
 *
 * @author Borges
 */
public class AppEclipseLink {
 
	private static final String PERSISTENCE_UNIT_NAME = "gere-contactos";
	private static EntityManagerFactory factory;
 
	public static void main(String[] args) {
 
		//Create entity manager, this step will connect to database, please check 
		//JDBC driver on classpath, jdbc URL, jdbc driver name on persistence.xml
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		//end
 
		// Query to existing data 
		TypedQuery<Contact> q = em.createQuery("select rdr from Contact rdr", Contact.class);
		List<Contact> riderList = q.getResultList();
 
		//loping trough riderList and print out rider
		for (Contact rider : riderList) {
			System.out.println(rider);
		}
 
		//Print number of rider
		System.out.println("Size befor insert: " + riderList.size());
 
		//start transaction with method begin()
		em.getTransaction().begin();
 
		//create around 10 rider with dummy data
		for (int i = 0; i < 10; i++) {
			Contact rider = new Contact();
			rider.setName("Contact-" + i);
			rider.setPhone("99008-" + i);
			rider.setDistance(i+100*i);
 
			//insert into database
			em.persist(rider);
		}
 
		//commit transaction commit();
		em.getTransaction().commit();
 
 
		riderList = q.getResultList();
		System.out.println("Size after insert: " + riderList.size());
 
 
		em.close();
 
	}
 
}
