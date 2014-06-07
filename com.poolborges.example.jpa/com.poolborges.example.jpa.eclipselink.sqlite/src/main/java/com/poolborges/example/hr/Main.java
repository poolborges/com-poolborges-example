package com.poolborges.example.hr;

import com.poolborges.example.hr.domain.Department;
import com.poolborges.example.hr.domain.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main{

    private EntityManager manager;

    public Main(EntityManager manager) {
        this.manager = manager;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_HR");
        EntityManager manager = factory.createEntityManager();
        Main test = new Main(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            test.createEmployees();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        test.listEmployees();

        System.out.println(".. done");
    }

    private void createEmployees() {
        Query query = manager.createQuery("Select a From Employee a");
        int numOfEmployees = query.getResultList().size();
        if (numOfEmployees == 0) {
            Department dep_tec = new Department("Tecnico");
            Department dep_hr = new Department("Recursos Humanos");
            
            manager.persist(dep_tec);
            manager.persist(dep_hr);
            
            manager.persist(new Employee("Paulo Borges",dep_tec));
            manager.persist(new Employee("Andre Gomes",dep_tec));
            manager.persist(new Employee("João Semedo",dep_tec));
            manager.persist(new Employee("A Soares",dep_tec));
            
            manager.persist(new Employee("Hugo Gomes",dep_hr));
            manager.persist(new Employee("jose tavares",dep_hr));
        }
    }

    private void listEmployees() {
        //TypedQuery<Customer> query = em.createNamedQuery("Customer.findByName", Customer.class);
        Query query = manager.createQuery("Select a From Employee a");
        List<Employee> resultList = query.getResultList();
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }
    }


}