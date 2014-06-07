/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.school;

import com.poolborges.example.school.domain.Professor;
import com.poolborges.example.school.service.ProfessorService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] a) throws Exception {
    JPAUtil util = new JPAUtil();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_SCHOOL");
    EntityManager em = emf.createEntityManager();
    ProfessorService service = new ProfessorService(em);

    em.getTransaction().begin();
    Professor emp = service.createProfessor(158, "John Doe", 45000);
    em.getTransaction().commit();
    System.out.println("Persisted " + emp);

    util.checkData("select * from Professor");

    em.close();
    emf.close();
  }
}
