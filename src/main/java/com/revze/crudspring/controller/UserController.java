/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revze.crudspring.controller;

import com.revze.crudspring.domain.User;
import com.revze.crudspring.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author revze
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    
    @RequestMapping(value = "/loggedin",method = RequestMethod.GET)
    public User getUserLoggedIn(){
        return null;
    }
}
