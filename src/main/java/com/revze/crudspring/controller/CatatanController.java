/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revze.crudspring.controller;

import com.revze.crudspring.domain.Catatan;
import com.revze.crudspring.service.CatatanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author revze
 */
@RestController
@RequestMapping("/api/catatan")
public class CatatanController {
    @Autowired
    private CatatanDao catatanDao;
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Catatan findCatatanById(@PathVariable String id)
    {
        return catatanDao.findOne(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Catatan c)
    {
        catatanDao.save(c);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Page<Catatan> findAll(Pageable pageable)
    {
        return catatanDao.findAll(pageable);
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable String id)
    {
        Catatan c = catatanDao.findOne(id);
        if (c != null) {
            catatanDao.delete(c);
        }
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void edit(@PathVariable String id, @RequestBody Catatan c)
    {
        Catatan catatan = catatanDao.findOne(id);
        if (catatan != null) {
            c.setId(id);
            catatanDao.save(c);
        }
    }
}
