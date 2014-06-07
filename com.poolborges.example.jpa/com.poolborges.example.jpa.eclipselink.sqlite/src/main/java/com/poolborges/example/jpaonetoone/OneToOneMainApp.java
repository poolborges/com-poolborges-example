/*
 * 
 */
package com.poolborges.example.jpaonetoone;

import com.poolborges.example.jpaonetoone.model.Employee;
import com.poolborges.example.jpaonetoone.model.EmployeeAddress;
import com.poolborges.example.jpaonetoone.model.UserEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Borges
 */
public class OneToOneMainApp {

    private final String PERSISTENCE_UNIT_NAME = "JPA_DERBY-Embedded";
    private final EntityManagerFactory factory;

    public OneToOneMainApp() {
        //EntityManager entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    }

    public static void main(String[] args) {
        OneToOneMainApp ts = new OneToOneMainApp();
        ts.userEntityTest();
        
        ts.employdTest();

    }

    public void userEntityTest() {
        UserEntity ut = new UserEntity();
        ut.setUsername("poolborges");
        ut.setPassword("Password");
        //ut.setUserDetailsEntity(new UserDetailsEntity("Paulo ", "Borges", "poolborges@ht.com"));

        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(ut);
            transaction.commit();
            System.out.println(ut);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }

    }

    public void employdTest() {
        Employee employee = new Employee();
        employee.setIsActive("True");
        employee.setName("Paulo Borges");

        EmployeeAddress employeeAddress = new EmployeeAddress();
        employeeAddress.setCity("Oliveira do Hospital");
        employeeAddress.setState("Coimbra");
        //employee.setAddress(employeeAddress);

        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
            employee = entityManager.find(Employee.class, new Long(1));
            System.out.println(employee);

            /*
            Query q = entityManager.createQuery("select rdr from EMPLOYEE rdr");
            List<Employee> riderList = q.getResultList();

            //loping trough riderList and print out rider
            for (Employee rider : riderList) {
                System.out.println(rider);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }
}