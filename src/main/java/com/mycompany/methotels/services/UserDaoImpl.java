/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.User;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class UserDaoImpl implements UserDao {

    @Inject
    private Session session;

    @Override
    public User checkUser(String username, String password) {
        try {
            User u = (User) session.createCriteria(User.class).add(Restrictions.eq("username",
                    username)).add(Restrictions.eq("userpassword", password)).uniqueResult();
            if (u != null) {
                return u;
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    @Override
    public User registerUser(User user) {
        return (User) session.merge(user);
    }

    @Override
    public boolean checkIfNameExists(String username) {
        Long rows = (Long) session.createCriteria(User.class).add(Restrictions.eq("username",
                username)).setProjection(Projections.rowCount()).uniqueResult();
        return (rows == 0) ? false : true;
    }

    @Override
    public User checkIfFbExists(String fcbkId) {
        try {
            User u = (User) session.createCriteria(User.class).add(Restrictions.eq("facebookId",
                    fcbkId)).uniqueResult();
            if (u != null) {
                return u;
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

}
