/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.coenraets.cellar;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.developerworks.soccer.web.DaoHelper;

/**
 *
 * @author Borges
 */
public class JPAWineDAO implements WineDAO{
    
    private EntityManager mgr = DaoHelper.getInstance().getEntityManager();

    @Override
    public Wine create(Wine wine) {
      throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Wine> findAll() {
        TypedQuery<Wine> query = 
			mgr.createQuery("SELECT p FROM Wine p", Wine.class);
		return query.getResultList();
    }

    @Override
    public Wine findById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Wine> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Wine save(Wine wine) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Wine update(Wine wine) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}
