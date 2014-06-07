/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.coenraets.cellar;

import java.util.List;

/**
 *
 * @author Borges
 */
public interface WineDAO {

    Wine create(Wine wine);

    List<Wine> findAll();

    Wine findById(int id);

    List<Wine> findByName(String name);

    boolean remove(int id);

    Wine save(Wine wine);

    Wine update(Wine wine);
    
}
