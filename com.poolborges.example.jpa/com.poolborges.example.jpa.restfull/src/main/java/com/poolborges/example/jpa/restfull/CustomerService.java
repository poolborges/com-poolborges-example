package com.poolborges.example.jpa.restfull;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
@Stateless
@LocalBean
@Path("/customers")
public class CustomerService {
 
    @PersistenceContext(unitName="CustomerService", 
                        type=PersistenceContextType.TRANSACTION)
    EntityManager entityManager;
 
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void create(Customer customer) {
        entityManager.persist(customer);
    }
 
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{id}")
    public Customer read(@PathParam("id") long id) {
        return entityManager.find(Customer.class, id);
    }
 
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void update(Customer customer) {
        entityManager.merge(customer);
    }
 
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
        Customer customer = read(id);
        if(null != customer) {
            entityManager.remove(customer);
        }
    }
 
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("findCustomersByCity/{city}")
    public List<Customer> findCustomersByCity(@PathParam("city") String city) {
        Query query = entityManager.createNamedQuery("findCustomersByCity");
        query.setParameter("city", city);
        return query.getResultList();
    }
 
}
