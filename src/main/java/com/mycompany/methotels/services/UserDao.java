/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.User;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public interface UserDao {

    public User checkUser(String username, String password);

    public User registerUser(User user);

    public boolean checkIfNameExists(String username);

    public User checkIfFbExists(String fcbkId);

}
