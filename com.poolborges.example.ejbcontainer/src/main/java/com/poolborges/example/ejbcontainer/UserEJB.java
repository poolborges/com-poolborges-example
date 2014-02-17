/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.ejbcontainer;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

import javax.ejb.Stateless;

/**
 *
 * @author Borges
 */
@Stateless
public class UserEJB {

    public List<UserBean> findAll() {
        List<UserBean> users = new ArrayList<UserBean>();
        UserBean user = new UserBean();
        user.setFirstName("Alfred");
        user.setLastName("Newman");
        user.setId(1l);

        UserBean anotherUser = new UserBean();
        anotherUser.setFirstName("Albert");
        anotherUser.setLastName("Einstein");
        anotherUser.setId(2l);

        users.add(user);
        users.add(anotherUser);
        return users;
    }
}