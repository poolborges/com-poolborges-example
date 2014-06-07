package com.poolborges.example.school.service;

import com.poolborges.example.school.domain.Professor;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProfessorService {
  protected EntityManager em;

  public ProfessorService(EntityManager em) {
    this.em = em;
  }

  public Professor createProfessor(int id, String name, long salary) {
    Professor emp = new Professor(id);
    emp.setName(name);
    emp.setSalary(salary);
    em.persist(emp);
    return emp;
  }

  public void removeProfessor(int id) {
    Professor emp = findProfessor(id);
    if (emp != null) {
      em.remove(emp);
    }
  }

  public Professor raiseProfessorSalary(int id, long raise) {
    Professor emp = em.find(Professor.class, id);
    if (emp != null) {
      emp.setSalary(emp.getSalary() + raise);
    }
    return emp;
  }

  public Professor findProfessor(int id) {
    return em.find(Professor.class, id);
  }

  public Collection<Professor> findAllProfessors() {
    Query query = em.createQuery("SELECT e FROM Professor e");
    //TypedQuery<Professor> q     = em.createQuery("SELECT u FROM Professor u", Professor.class);
    return (Collection<Professor>) query.getResultList();
  }
}
